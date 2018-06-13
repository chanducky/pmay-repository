package com.mcs.pmay.dao;

import java.util.List;
import java.util.Map;

import com.mcs.pmay.data.PmayAddSurveyData;
import com.mcs.pmay.data.PmayBankData;
import com.mcs.pmay.data.PmayCasteData;
import com.mcs.pmay.data.PmayCityData;
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

/**
 * @author chandrakumar
 *
 */
public interface PmaySurveyDao {

	/**
	 * @return religion data
	 */
	List<PmayReligionData> getPmayReligionData();

	/**
	 * @return caste data
	 */
	List<PmayCasteData> getPmayCasteData();

	/**
	 * @return id data
	 */
	List<PmayIdData> getPmayIdData();

	/**
	 * @return marital data
	 */
	List<PmayMaritalData> getPmayMaritalData();

	/**
	 * @return ownership data
	 */
	List<PmayOwnershipData> getPmayOwnershipData();

	/**
	 * @return
	 */
	List<PmayHouseRoofData> getPmayHouseRoofData();

	/**
	 * @return
	 */
	List<PmayHouseWallData> getPmayHouseWallData();

	/**
	 * @return requirement data
	 */
	List<PmayRequirementData> getPmayRequirementData();

	/**
	 * @return employment data
	 */
	List<PmayEmploymentData> getPmayEmploymentData();

	/**
	 * @return relationship data
	 */
	List<PmayRelationshipData> getPmayRelationshipData();

	/**
	 * @return gender data
	 */
	List<PmayGenderData> getPmayGenderData();

	/**
	 * @return hfa asst data
	 */
	List<PmayHfaAsstData> getPmayHfaAsstData();

	public List<PmayCityData> getCitiesDetails();

	public List<PmaySurveyReportData> getSuperUserSurveyReport();

	List<PmaySurveyReportData> getDeletedSurveyReports();

	boolean deleteServey(String userSurveyId);

	List<PmayReportDataForAdmins> getAdminsSurveyReports();

	List<PmayUserData> getAllPendingUsers();

	boolean removeSurvey(String userSurveyId);

	Map<String, String> addSurvey(PmayAddSurveyData surveyData);

	List<PmayWardData> getPmayWardData();

	List<PmayReportDataForAdmins> getSurveyUserReport(String userId);

	List<PmayHouseCategoryData> getHouseCategoryData();

	List<PmayReportDataForAdmins> getFilteredReportBySearchForAdmins(PmaySeachData seachDetails);

	List<PmaySurveyReportData> getFilteredReportForSuperUser(PmaySeachData seachDetails);

	List<PmayReportDataForAdmins> getFilteredReportForsurveyorUser(PmaySeachData seachDetails);

	Map<String, String> addSlumSurvey(PmaySlumAddData pmayAddSurveyData);

	List<PmayBankData> getBanksList();

	boolean checkAdharIsExist(String adharNo);

	/**
	 * @return
	 */
	List<PmayNoOfYearsPresentInCity> getNoOfYearsPresentList();
	
	List<PmayULBData> getUlbList();

	boolean checkIdProofNoIsExist(Map<String, String> data);

	public SlumNonSlumReportData getTodaySurveyReportForSlumNonSlum();

	public SlumNonSlumReportData getTotalSurveyReportForSlumNonSlum();
	
	//Start 12th April2018
	public SlumNonSlumReportData getUlbSurveyReportForSlumNonSlum(String ulbNo);
	//End 12th April2018
	
	//Start 12th April2018
		public SlumNonSlumReportData getTodayUlbSurveyReportForSlumNonSlum(String ulbNo,String surveyDate);
		//End 12th April2018
	
	//Start 12th April2018
	//public SlumNonSlumReportData getUlbTodaySurveyReportForSlumNonSlum(String ulbNo);
	//End 12th April2018

	public List<UlbWardDetailsData> getUlbWardDetails(String searchData);

	/**
	 * @param searchData
	 * @return
	 */
	List<UlbWardDetailsData> getAdminUlbWardDetails(String searchData);

	/**
	 * @param searchData
	 * @param userId 
	 * @return
	 */
	List<UlbWardDetailsData> getSurveyerUserUlbWardDetails(String searchData, String userId);

	/**
	 * @param userSurveyIds
	 * @return status
	 */
	boolean deleteMultipleRecord(Map<String, String[]> userSurveyIds);

	List<PmayReportDataForAdmins> getSurveyReportForSuperUser();
	

	List<PmayReportDataForAdmins> getFilteredReportBySearchForAdminsWithPaging(PmaySeachData seachDetails,Integer itemsPerPage, Integer pageno);

	Integer getTotalCountFilteredReportBySearchForAdmins(PmaySeachData seachDetails);

	List<PmaySurveyReportData> getSuperUserSurveyReportFilterd(PmaySeachData seachDetails);

	Integer getTotalCountSuperUserSurveyReportFilterd(PmaySeachData seachDetails);

	List<PmaySurveyReportData> getSuperUserSurveyReportFilterdPaging(PmaySeachData seachDetails, Integer itemsPerPage,Integer pageno);

	
}
