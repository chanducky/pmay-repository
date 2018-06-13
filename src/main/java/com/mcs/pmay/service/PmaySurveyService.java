package com.mcs.pmay.service;

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
public interface PmaySurveyService {

	public List<PmayCityData> getCitiesDetails();

	public List<PmaySurveyReportData> getSuperUserSurveyReport();

	/**
	 * @return religion data
	 */
	List<PmayReligionData> getPmayReligionData();

	/**
	 * @return caste data
	 */
	List<PmayCasteData> getPmayCasteData();

	/**
	 * @return pmay Id
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
	 * @return house roof data
	 */
	List<PmayHouseRoofData> getPmayHouseRoofData();

	/**
	 * @return house wall data
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
	 * @return hfs asst data
	 */
	List<PmayHfaAsstData> getPmayHfaAsstData();

	/**
	 * @return vehicle data
	 */
	/**
	 * @return
	 */
	 List<PmayNoOfYearsPresentInCity> getNoOfYearsPresentList();
	 
	public List<PmaySurveyReportData> getDeletedSurveyReports();

	public boolean deleteServey(String userSurveyId);

	public List<PmayReportDataForAdmins> getAdminsSurveyReports();

	public List<PmayUserData> getAllPendingUsers();

	public boolean removeSurvey(String userSurveyId);

	public Map<String, String> addSurvey(PmayAddSurveyData surveyData);

	public List<PmayWardData> getPmayWardData();

	public List<PmayReportDataForAdmins> getSurveyUserReport(String userId);

	public List<PmayHouseCategoryData> getHouseCategoryData();

	public List<PmayReportDataForAdmins> getFilteredReportBySearchForAdmins(PmaySeachData seachDetails);

	public List<PmaySurveyReportData> getFilteredReportForSuperUser(PmaySeachData seachDetails);

	public List<PmayReportDataForAdmins> getFilteredReportForsurveyorUser(PmaySeachData seachDetails);

	public Map<String, String> addSlumSurvey(PmaySlumAddData pmayAddSurveyData);

	public List<PmayBankData> getBanksList();

	public boolean checkAdharIsExist(String adharNo);

	public List<PmayULBData> getUlbList();

	public boolean checkIdProofNoIsExist(Map<String, String> data);

	public SlumNonSlumReportData getTodaySurveyReportForSlumNonSlum();

	public SlumNonSlumReportData getTotalSurveyReportForSlumNonSlum();
	
	//Start 12th April2018
	public SlumNonSlumReportData getUlbSurveyReportForSlumNonSlum(String ulbNo);
	//End 12th April2018
	//Start 12th April2018
		public SlumNonSlumReportData getTodayUlbSurveyReportForSlumNonSlum(String ulbNo,String surveyDate);
		//End 12th April2018

	public List<UlbWardDetailsData> getUlbWardDetails(String searchData);

	/**
	 * @param string
	 * @return
	 */
	public List<UlbWardDetailsData> getAdminUlbWardDetails(String string);

	/**
	 * @param string
	 * @param object 
	 * @return
	 */
	public List<UlbWardDetailsData> getSurveyerUserUlbWardDetails(String string, String userId);

	public boolean deleteMultipleRecord(Map<String, String[]> userSurveyIds);

	List<PmayReportDataForAdmins> getSurveyReportForSuperUser();

	List<PmayReportDataForAdmins> getFilteredReportBySearchForAdminsWithPaging(PmaySeachData seachDetails,Integer itemsPerPage, Integer pageno);

	Integer getTotalCountFilteredReportBySearchForAdmins(PmaySeachData seachDetails);

	List<PmaySurveyReportData> getSuperUserSurveyReportFilterd(PmaySeachData seachDetails);

	Integer getTotalCountSuperUserSurveyReportFilterd(PmaySeachData seachDetails);

	List<PmaySurveyReportData> getSuperUserSurveyReportFilterdPaging(PmaySeachData seachDetails, Integer itemsPerPage,Integer pageno);
	

}
