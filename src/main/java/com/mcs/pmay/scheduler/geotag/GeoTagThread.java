package com.mcs.pmay.scheduler.geotag;

import java.io.File;
import java.util.HashMap;

import com.mcs.pmay.config.ApplicationContextProvider;
import com.mcs.pmay.dao.PmayUserDao;
import com.mcs.pmay.data.PmaySurveyReportData;


public class GeoTagThread implements Runnable{


	private PmaySurveyReportData surveyData;
	HashMap<String,String> imageDirMap = null;

	public GeoTagThread(HashMap<String,String> imageDirMap,PmaySurveyReportData surveyData) {
		super();
		this.surveyData=surveyData;
		this.imageDirMap=imageDirMap;
	}

	@Override
	public void run() {
		try {


			PmayUserDao pmayUserDao = (PmayUserDao) ApplicationContextProvider.getBean(PmayUserDao.class);

			boolean found=false;
			GeoTagImage geoImage =null;
			double[] gps =null;
			
			String imagePath=null;
			if("S".equalsIgnoreCase(surveyData.getSlumNonSlum())) {

				imagePath = imageDirMap.get("applicantPhoto")+File.separator+surveyData.getUserSurveyId()+"_"+"slumApplicantPhoto.jpg";
				gps =getGeoLocation(imagePath);
				System.out.println(" imagePath = " + imagePath);
				if(gps!=null && gps[0]!=0.0 && gps[1]!=0.0) {
					found=true;
				}
				if(! found) {
					imagePath = imageDirMap.get("presentHousePhoto")+File.separator+surveyData.getUserSurveyId()+"_"+"presentInfrontHousePhoto.jpg";
					gps =getGeoLocation(imagePath);
					if(gps!=null && gps[0]!=0.0 && gps[1]!=0.0) {
						found=true;
					}
					System.out.println(" imagePath = " + imagePath);
				}
			}else{
				imagePath = imageDirMap.get("applicantPhoto")+File.separator+surveyData.getUserSurveyId()+"_"+"applicantPhoto.jpg";
				System.out.println(" imagePath = " + imagePath);
				gps =getGeoLocation(imagePath);
				if(gps!=null && gps[0]!=0.0 && gps[1]!=0.0) {
					found=true;
				}
			}
			
			if(!found) {
				imagePath = imageDirMap.get("signature")+File.separator+surveyData.getUserSurveyId()+"_"+"applicantSignature.jpg";
				System.out.println(" imagePath = " + imagePath);
				gps =getGeoLocation(imagePath);
				if(gps!=null && gps[0]!=0.0 && gps[1]!=0.0) {
					found=true;
				}
			}

			if(found) {
				geoImage =new GeoTagImage(Long.valueOf(surveyData.getUserSurveyId()),gps);
				pmayUserDao.saveGeoTagData(geoImage);
			}

		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private double[] getGeoLocation(String imagePath){
		double[] gps = null;
		try {
			File file  = new File(imagePath);
			if(file.exists() && ! file.isDirectory()) { 
				javaxt.io.Image image = new javaxt.io.Image(imagePath);
				gps = image.getGPSCoordinate();
			}

		}catch(Exception ex) {
			ex.printStackTrace();
		}

		return gps;
	}
}
