package com.mcs.pmay.scheduler;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import com.mcs.pmay.dao.PmayUserDao;
import com.mcs.pmay.data.PmaySurveyReportData;
import com.mcs.pmay.scheduler.geotag.GeoTagThread;


@Configuration
@ConfigurationProperties("image.path")
public class PmayGeoTagReaderTask {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@NotEmpty
	private String applicantPhoto;

	@NotEmpty
	private String signature;

	@NotEmpty
	private String presentHousePhoto;

	private String startSurveyId;

	@Autowired
	PmayUserDao pmayUserDao;

	private long lastSurveyId=-1;

	@Scheduled(fixedRate = (10*60000))
	public void processJob() {
		
		if(startSurveyId!=null) {
			HashMap<String,String> imageDirMap = new HashMap<>();

			imageDirMap.put("applicantPhoto", applicantPhoto);
			imageDirMap.put("signature",signature);
			imageDirMap.put("presentHousePhoto", presentHousePhoto);

			if(lastSurveyId<0 && startSurveyId!=null) {
				lastSurveyId=Long.valueOf(startSurveyId);
			}

			List<PmaySurveyReportData> surveyDatas = pmayUserDao.getSurveyDataForGeoTag(lastSurveyId);

			ExecutorService executor = Executors.newFixedThreadPool(2);

			if(surveyDatas!=null) {
				lastSurveyId = Long.valueOf(surveyDatas.get(surveyDatas.size()-1).getUserSurveyId());
				for(PmaySurveyReportData data: surveyDatas) {
					GeoTagThread geoTagThread = new GeoTagThread(imageDirMap,data);
					executor.execute(geoTagThread);
				}
			}
			System.out.println(" geo tag finished till lastSurveyId="+lastSurveyId);
			executor.shutdown();
			while (!executor.isTerminated()) {
			}
			
		}
	}

	public String getApplicantPhoto() {
		return applicantPhoto;
	}

	public void setApplicantPhoto(String applicantPhoto) {
		this.applicantPhoto = applicantPhoto;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getPresentHousePhoto() {
		return presentHousePhoto;
	}

	public void setPresentHousePhoto(String presentHousePhoto) {
		this.presentHousePhoto = presentHousePhoto;
	}

	public String getStartSurveyId() {
		return startSurveyId;
	}

	public void setStartSurveyId(String startSurveyId) {
		this.startSurveyId = startSurveyId;
	}

	public PmayUserDao getPmayUserDao() {
		return pmayUserDao;
	}

	public void setPmayUserDao(PmayUserDao pmayUserDao) {
		this.pmayUserDao = pmayUserDao;
	}

	public long getLastSurveyId() {
		return lastSurveyId;
	}

	public void setLastSurveyId(long lastSurveyId) {
		this.lastSurveyId = lastSurveyId;
	}



}
