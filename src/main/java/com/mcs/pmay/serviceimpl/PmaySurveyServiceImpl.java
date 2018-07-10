package com.mcs.pmay.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mcs.pmay.dao.PmaySurveyDao;
import com.mcs.pmay.data.PmayAddSurveyData;
import com.mcs.pmay.data.PmayBankData;
import com.mcs.pmay.data.PmayCasteData;
import com.mcs.pmay.data.PmayCityData;
import com.mcs.pmay.data.PmayDistWiseStats;
import com.mcs.pmay.data.PmayEmploymentData;
import com.mcs.pmay.data.PmayGenderData;
import com.mcs.pmay.data.PmayHfaAsstData;
import com.mcs.pmay.data.PmayHouseCategoryData;
import com.mcs.pmay.data.PmayHouseRoofData;
import com.mcs.pmay.data.PmayHouseWallData;
import com.mcs.pmay.data.PmayIdData;
import com.mcs.pmay.data.PmayMaritalData;
import com.mcs.pmay.data.PmayNoOfYearsPresentInCity;
import com.mcs.pmay.data.PmayOwnershipData;
import com.mcs.pmay.data.PmayRelationshipData;
import com.mcs.pmay.data.PmayReligionData;
import com.mcs.pmay.data.PmayReportDataForAdmins;
import com.mcs.pmay.data.PmayRequirementData;
import com.mcs.pmay.data.PmaySeachData;
import com.mcs.pmay.data.PmaySlumAddData;
import com.mcs.pmay.data.PmaySurveyReportData;
import com.mcs.pmay.data.PmayULBData;
import com.mcs.pmay.data.PmayUserData;
import com.mcs.pmay.data.PmayWardData;
import com.mcs.pmay.data.SlumNonSlumReportData;
import com.mcs.pmay.data.UlbWardDetailsData;
import com.mcs.pmay.service.PmaySurveyService;
import com.mcs.pmay.util.PmayDateUtil;

/**
 * @author chandrakumar
 *
 */
@Service("pmaySurveyService")
public class PmaySurveyServiceImpl implements PmaySurveyService {
	@Resource
	private PmaySurveyDao pmaySurveyDao;

	@Override
	public List<PmayCityData> getCitiesDetails() {
		return pmaySurveyDao.getCitiesDetails();
	}

	@Override
	public List<PmaySurveyReportData> getSuperUserSurveyReport() {
		return pmaySurveyDao.getSuperUserSurveyReport();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getPmayReligionData()
	 */
	@Override
	public List<PmayReligionData> getPmayReligionData() {
		return pmaySurveyDao.getPmayReligionData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getPmayCasteData()
	 */
	@Override
	public List<PmayCasteData> getPmayCasteData() {
		return pmaySurveyDao.getPmayCasteData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getPmayIdData()
	 */
	@Override
	public List<PmayIdData> getPmayIdData() {
		return pmaySurveyDao.getPmayIdData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getPmayMaritalData()
	 */
	@Override
	public List<PmayMaritalData> getPmayMaritalData() {
		return pmaySurveyDao.getPmayMaritalData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getPmayOwnershipData()
	 */
	@Override
	public List<PmayOwnershipData> getPmayOwnershipData() {
		return pmaySurveyDao.getPmayOwnershipData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getPmayHouseRoofData()
	 */
	@Override
	public List<PmayHouseRoofData> getPmayHouseRoofData() {
		return pmaySurveyDao.getPmayHouseRoofData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getPmayHouseWallData()
	 */
	@Override
	public List<PmayHouseWallData> getPmayHouseWallData() {
		return pmaySurveyDao.getPmayHouseWallData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getPmayRequirementData()
	 */
	@Override
	public List<PmayRequirementData> getPmayRequirementData() {
		return pmaySurveyDao.getPmayRequirementData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getPmayEmploymentData()
	 */
	@Override
	public List<PmayEmploymentData> getPmayEmploymentData() {
		return pmaySurveyDao.getPmayEmploymentData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getPmayRelationshipData()
	 */
	@Override
	public List<PmayRelationshipData> getPmayRelationshipData() {
		return pmaySurveyDao.getPmayRelationshipData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getPmayGenderData()
	 */
	@Override
	public List<PmayGenderData> getPmayGenderData() {
		return pmaySurveyDao.getPmayGenderData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getPmayHfaAsstData()
	 */
	@Override
	public List<PmayHfaAsstData> getPmayHfaAsstData() {
		return pmaySurveyDao.getPmayHfaAsstData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getDeletedSurveyReports()
	 */
	@Override
	public List<PmaySurveyReportData> getDeletedSurveyReports() {
		return pmaySurveyDao.getDeletedSurveyReports();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mcs.pmay.service.PmaySurveyService#deleteServey(java.lang.String)
	 */
	@Override
	public boolean deleteServey(String userSurveyId) {
		return pmaySurveyDao.deleteServey(userSurveyId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getSurveyReports()
	 */
	@Override
	public List<PmayReportDataForAdmins> getAdminsSurveyReports() {
		return pmaySurveyDao.getAdminsSurveyReports();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.service.PmaySurveyService#getAllPendingUsers()
	 */
	@Override
	public List<PmayUserData> getAllPendingUsers() {
		List<PmayUserData> listOfPendingRequestData = pmaySurveyDao.getAllPendingUsers();
		
		List<PmayUserData> pendingList = new LinkedList<PmayUserData>();
		List<PmayUserData> approvedList = new LinkedList<PmayUserData>();
		
		for (int i = 0; i < listOfPendingRequestData.size(); i++) {
			if (listOfPendingRequestData.get(i).getLoginApproval().equals("0")) {
				pendingList.add(listOfPendingRequestData.get(i));
				listOfPendingRequestData.get(i).setApproveButtonText("Pending");
				listOfPendingRequestData.get(i).setApproveButtonColor("aprv-btnred");
				listOfPendingRequestData.get(i).setApproveButtonDisable("false");
				listOfPendingRequestData.get(i).setDenyButtonDisable("false");
			}else{
				approvedList.add(listOfPendingRequestData.get(i));
				listOfPendingRequestData.get(i).setApproveButtonText("Approved");
				listOfPendingRequestData.get(i).setApproveButtonColor("aprv-btn");
				listOfPendingRequestData.get(i).setApproveButtonDisable("true");
				listOfPendingRequestData.get(i).setDenyButtonDisable("true");
			}
			
			if(listOfPendingRequestData.get(i).getStatus().equals("A")){
				listOfPendingRequestData.get(i).setStatusText("De-Activate");
				listOfPendingRequestData.get(i).setStatusButtonColor("aprv-btnred");
			}else{
				listOfPendingRequestData.get(i).setStatusText("Activate");
				listOfPendingRequestData.get(i).setStatusButtonColor("aprv-btn");
			}
		}
		
		pendingList.addAll(approvedList);
		return pendingList;
	}

	@Override
	public boolean removeSurvey(String userSurveyId) {
		return pmaySurveyDao.removeSurvey(userSurveyId);
	}

	@Override
	public Map<String, String> addSurvey(PmayAddSurveyData surveyData) {
		return pmaySurveyDao.addSurvey(surveyData);
	}

	@Override
	public List<PmayWardData> getPmayWardData() {
		return pmaySurveyDao.getPmayWardData();
	}

	@Override
	public List<PmayReportDataForAdmins> getSurveyUserReport(String userId) {
		return pmaySurveyDao.getSurveyUserReport(userId);
	}

	@Override
	public List<PmayHouseCategoryData> getHouseCategoryData() {
		return pmaySurveyDao.getHouseCategoryData();
	}

	@Override
	public List<PmayReportDataForAdmins> getFilteredReportBySearchForAdmins(PmaySeachData seachDetails) {
		return pmaySurveyDao.getFilteredReportBySearchForAdmins(seachDetails);
	}

	@Override
	public List<PmaySurveyReportData> getFilteredReportForSuperUser(PmaySeachData seachDetails) {
		return pmaySurveyDao.getFilteredReportForSuperUser(seachDetails);
	}

	@Override
	public List<PmayReportDataForAdmins> getFilteredReportForsurveyorUser(PmaySeachData seachDetails) {
		return pmaySurveyDao.getFilteredReportForsurveyorUser(seachDetails);
	}

	@Override
	public Map<String, String> addSlumSurvey(PmaySlumAddData pmayAddSurveyData) {
		return pmaySurveyDao.addSlumSurvey(pmayAddSurveyData);
	}

	@Override
	public List<PmayBankData> getBanksList() {
		return pmaySurveyDao.getBanksList();
	}

	@Override
	public boolean checkAdharIsExist(String adharNo) {
		return pmaySurveyDao.checkAdharIsExist(adharNo);
	}

	/* (non-Javadoc)
	 * @see com.mcs.pmay.service.PmaySurveyService#getNoOfYearsPresentList()
	 */
	@Override
	public List<PmayNoOfYearsPresentInCity> getNoOfYearsPresentList() {
		return pmaySurveyDao.getNoOfYearsPresentList();
	}
	
	@Override
	public List<PmayULBData> getUlbList() {
		return pmaySurveyDao.getUlbList();
	}

	@Override
	public boolean checkIdProofNoIsExist(Map<String, String> data) {
		return pmaySurveyDao.checkIdProofNoIsExist(data);
	}

	@Override
	public SlumNonSlumReportData getTodaySurveyReportForSlumNonSlum() {
		return pmaySurveyDao.getTodaySurveyReportForSlumNonSlum();
	}

	@Override
	public SlumNonSlumReportData getTotalSurveyReportForSlumNonSlum() {
		return pmaySurveyDao.getTotalSurveyReportForSlumNonSlum();
	}
	
	//Start 12th April2018
	@Override
	public SlumNonSlumReportData getUlbSurveyReportForSlumNonSlum(String ulbNo) {
		return pmaySurveyDao.getUlbSurveyReportForSlumNonSlum(ulbNo);
	}
	@Override
	public SlumNonSlumReportData getTodayUlbSurveyReportForSlumNonSlum(String ulbNo,String surveyDate) {
		
		if(surveyDate!=null && !surveyDate.isEmpty()) {
			surveyDate = PmayDateUtil.convertFormat(surveyDate);
		}else {
			surveyDate = PmayDateUtil.convertFormat(new Date());
		}
		
		return pmaySurveyDao.getTodayUlbSurveyReportForSlumNonSlum(ulbNo,surveyDate);
	}
	//End 12th April2018

	@Override
	public List<UlbWardDetailsData> getUlbWardDetails(String searchData) {
		return pmaySurveyDao.getUlbWardDetails(searchData);
	}

	/* (non-Javadoc)
	 * @see com.mcs.pmay.service.PmaySurveyService#getAdminUlbWardDetails(java.lang.String)
	 */
	@Override
	public List<UlbWardDetailsData> getAdminUlbWardDetails(String searchData) {
		return pmaySurveyDao.getAdminUlbWardDetails(searchData);
	}

	/* (non-Javadoc)
	 * @see com.mcs.pmay.service.PmaySurveyService#getSurveyerUserUlbWardDetails(java.lang.String)
	 */
	@Override
	public List<UlbWardDetailsData> getSurveyerUserUlbWardDetails(String searchData, String userId) {
		return pmaySurveyDao.getSurveyerUserUlbWardDetails(searchData,userId);
	}

	@Override
	public boolean deleteMultipleRecord(Map<String, String[]> userSurveyIds) {
		return pmaySurveyDao.deleteMultipleRecord(userSurveyIds);
	}

	@Override
	public List<PmayReportDataForAdmins> getSurveyReportForSuperUser() {
		return pmaySurveyDao.getSurveyReportForSuperUser();
	}
	
	@Override
	public List<PmayReportDataForAdmins> getFilteredReportBySearchForAdminsWithPaging(PmaySeachData seachDetails,Integer itemsPerPage, Integer pageno){
		return pmaySurveyDao.getFilteredReportBySearchForAdminsWithPaging(seachDetails,itemsPerPage, pageno);
	}
	
	@Override
	public Integer getTotalCountFilteredReportBySearchForAdmins(PmaySeachData seachDetails) {
		return pmaySurveyDao.getTotalCountFilteredReportBySearchForAdmins(seachDetails);
	}
	
	@Override
	public List<PmaySurveyReportData> getSuperUserSurveyReportFilterd(PmaySeachData seachDetails){
		return pmaySurveyDao.getSuperUserSurveyReportFilterd(seachDetails);
	}
	
	@Override
	public Integer getTotalCountSuperUserSurveyReportFilterd(PmaySeachData seachDetails) {
		return pmaySurveyDao.getTotalCountSuperUserSurveyReportFilterd(seachDetails);
	}
	
	@Override
	public List<PmaySurveyReportData> getSuperUserSurveyReportFilterdPaging(PmaySeachData seachDetails, Integer itemsPerPage,Integer pageno){
		return pmaySurveyDao.getSuperUserSurveyReportFilterdPaging(seachDetails,itemsPerPage,pageno);
	}

	@Override
	public List<PmayDistWiseStats> getDistWiseStats() {
		
		LinkedHashMap<String,PmayDistWiseStats> mapData = new LinkedHashMap<>();
		List<PmayDistWiseStats> list = pmaySurveyDao.getDistWiseStats();
		if(list!=null) {
			for(PmayDistWiseStats pdw: list) {
				if(mapData.containsKey(pdw.getDistName())) {
					PmayDistWiseStats stored = mapData.get(pdw.getDistName());
					if(pdw.getSlum() > 0) {
						stored.setSlum(pdw.getSlum());
					}else {
						stored.setNonSlum(pdw.getNonSlum());
					}
				}else {
					mapData.put(pdw.getDistName(), pdw);
				}
			}
		}
		
		List<PmayDistWiseStats> finalStats = new LinkedList<>();
		for(PmayDistWiseStats mData: mapData.values()) {
			finalStats.add(mData);
		}
		
		return finalStats;
	}
	
	@Override
	public List<PmayDistWiseStats> getPKGWiseStats() {
		
		LinkedHashMap<String,PmayDistWiseStats> mapData = new LinkedHashMap<>();
		List<PmayDistWiseStats> list = pmaySurveyDao.getPKGWiseStats();
		
		int totalPkg1=0;
		int totalPkg4=0;
		
		if(list!=null) {
			for(PmayDistWiseStats pdw: list) {
				if(mapData.containsKey(pdw.getSlumType())) {
					PmayDistWiseStats stored = mapData.get(pdw.getSlumType());
					if(pdw.getPkg1() > 0) {
						stored.setPkg1(pdw.getPkg1());
					}else {
						stored.setPkg4(pdw.getPkg4());
					}
					
					totalPkg1+=stored.getPkg1();
					totalPkg4+=stored.getPkg4();
					
				}else {
					mapData.put(pdw.getSlumType(), pdw);
				}
			}
			
			PmayDistWiseStats calTotal = new PmayDistWiseStats();
			calTotal.setSlumType("Total");
			calTotal.setPkg1(totalPkg1);
			calTotal.setPkg4(totalPkg4);
			
			mapData.put(calTotal.getSlumType(), calTotal);
			
		}
		
		List<PmayDistWiseStats> finalStats = new LinkedList<>();
		for(PmayDistWiseStats mData: mapData.values()) {
			finalStats.add(mData);
		}
		
		return finalStats;
	}
}
