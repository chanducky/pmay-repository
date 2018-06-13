package com.mcs.pmay.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.mcs.pmay.data.FilteredRowColumnData;
import com.mcs.pmay.data.PmayAddSurveyData;
import com.mcs.pmay.data.PmayBankData;
import com.mcs.pmay.data.PmayCasteData;
import com.mcs.pmay.data.PmayCityData;
import com.mcs.pmay.data.PmayData;
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
import com.mcs.pmay.data.PmaySurveyReportDownloadData;
import com.mcs.pmay.data.PmayULBData;
import com.mcs.pmay.data.PmayUserData;
import com.mcs.pmay.data.PmayWardData;
import com.mcs.pmay.data.SlumNonSlumReportData;
import com.mcs.pmay.data.UlbWardDetailsData;
import com.mcs.pmay.service.PmaySurveyService;
import com.mcs.pmay.util.PmayUtil;

/**
 * @author chandrakumar
 *
 */
@RestController
public class PmaySurveyController {
	@Resource
	private PmaySurveyService pmaySurveyService;

	@Resource
	private HttpSession httpSession;

	/**
	 * Gson Object creation globally
	 */
	Gson gson = new Gson();

	/**
	 * Logger Object creation globally
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @return dropDownData
	 */
	@RequestMapping(value = "/addsurveydropdowndata", method = RequestMethod.GET)
	@ResponseBody
	public String dropDownData() {

		PmayData pmayData = new PmayData();
		List<PmayReligionData> listReligionData = pmaySurveyService.getPmayReligionData();
		List<PmayCasteData> listCasteData = pmaySurveyService.getPmayCasteData();
		List<PmayIdData> listIdData = pmaySurveyService.getPmayIdData();
		List<PmayMaritalData> listMaritalData = pmaySurveyService.getPmayMaritalData();
		List<PmayOwnershipData> listOwnershipData = pmaySurveyService.getPmayOwnershipData();
		List<PmayHouseRoofData> listHouseRoofData = pmaySurveyService.getPmayHouseRoofData();
		List<PmayHouseWallData> listHouseWallData = pmaySurveyService.getPmayHouseWallData();
		List<PmayRequirementData> listRequirementData = pmaySurveyService.getPmayRequirementData();
		List<PmayEmploymentData> listEmploymentData = pmaySurveyService.getPmayEmploymentData();
		List<PmayRelationshipData> listRelationshipData = pmaySurveyService.getPmayRelationshipData();
		List<PmayGenderData> listGenderData = pmaySurveyService.getPmayGenderData();
		List<PmayHfaAsstData> listHfaAsstData = pmaySurveyService.getPmayHfaAsstData();
		List<PmayWardData> listWardData = pmaySurveyService.getPmayWardData();
		List<PmayCityData> listCityData = pmaySurveyService.getCitiesDetails();
		List<PmayHouseCategoryData> listHouseCategoryData = pmaySurveyService.getHouseCategoryData();
		List<PmayBankData> listBanks = pmaySurveyService.getBanksList();
		List<PmayNoOfYearsPresentInCity> listNoOfYearsPresent = pmaySurveyService.getNoOfYearsPresentList();
		List<PmayULBData> listULBData = pmaySurveyService.getUlbList();

		pmayData.setListReligionData(listReligionData);
		pmayData.setListCasteData(listCasteData);
		pmayData.setListIdData(listIdData);
		pmayData.setListMaritalData(listMaritalData);
		pmayData.setListOwnershipData(listOwnershipData);
		pmayData.setListHouseRoofData(listHouseRoofData);
		pmayData.setListHouseWallData(listHouseWallData);
		pmayData.setListRequirementData(listRequirementData);
		pmayData.setListEmploymentData(listEmploymentData);
		pmayData.setListRelationshipData(listRelationshipData);
		pmayData.setListGenderData(listGenderData);
		pmayData.setListHfaAsstData(listHfaAsstData);
		pmayData.setListWardData(listWardData);
		pmayData.setListCityData(listCityData);
		pmayData.setListHouseCategoryData(listHouseCategoryData);
		pmayData.setListBanks(listBanks);
		pmayData.setListNoOfYearsPresent(listNoOfYearsPresent);
		pmayData.setListUlbData(listULBData);

		return gson.toJson(pmayData);

	}

	/**
	 * @return SurveyReports
	 */
	@RequestMapping(value = "/getSuperUserSurveyReport", method = RequestMethod.GET)
	@ResponseBody
	public String getSurveyReport() {
		List<PmaySurveyReportData> surveyReportList = pmaySurveyService.getSuperUserSurveyReport();
		httpSession.setAttribute("surveyReportListForSuperUser", surveyReportList);
		logger.info("{}", surveyReportList);
		return gson.toJson(surveyReportList);
	}

	/**
	 * @return deletedSurveyReports
	 */
	@RequestMapping(value = "/deletedSurveyReports", method = RequestMethod.GET)
	@ResponseBody
	public String deletedSurveyReports() {
		List<PmaySurveyReportData> deletedSurveyReports = pmaySurveyService.getDeletedSurveyReports();
		return gson.toJson(deletedSurveyReports);
	}

	/**
	 * @param rowColumnData
	 * @param req
	 * @return strore status for super user
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/storeFilteredRowColumnDetailsForSuperUser", method = RequestMethod.POST)
	@ResponseBody
	public String storeColumnNameDetails(@RequestBody FilteredRowColumnData rowColumnData, HttpServletRequest req) {
		HttpSession session = req.getSession();
		List<PmaySurveyReportData> filteredSurveyReportData = new ArrayList<>();
		List<PmaySurveyReportData> listSurveyReportData = (List<PmaySurveyReportData>) httpSession
				.getAttribute("surveyReportListForSuperUser");

		String[] surveyId = rowColumnData.getSelectedsurveyId();
		if (rowColumnData.getSelectedsurveyId().length != 0) {

			for (int i = 0; i < surveyId.length; i++) {
				for (PmaySurveyReportData surveyReportData : listSurveyReportData) {
					if (surveyReportData.getUserSurveyId().equalsIgnoreCase(surveyId[i])) {
						filteredSurveyReportData.add(surveyReportData);
					}
				}
			}
		} else {
			return gson.toJson("Please Select Rows for Download");
		}
		session.setAttribute("filteredSurveyReport", filteredSurveyReportData);
		session.setAttribute("columnData", rowColumnData);
		return gson.toJson("true");
	}

	/**
	 * @param req
	 * @return DesiredRowColumnForDownload
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getDesiredDataForDownload", method = RequestMethod.GET)
	@ResponseBody
	public String getDesiredRowColumnForDownload(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		FilteredRowColumnData columnNameData = (FilteredRowColumnData) session.getAttribute("columnData");
		List<PmaySurveyReportData> filteredSurveyReportData = (List<PmaySurveyReportData>) session
				.getAttribute("filteredSurveyReport");
		PmaySurveyReportDownloadData downloadData = new PmaySurveyReportDownloadData();

		downloadData.setColumnData(columnNameData);
		downloadData.setListSurveyData(filteredSurveyReportData);

		return gson.toJson(downloadData);
	}

	/**
	 * @param userSurveyId
	 * @return
	 */
	@RequestMapping(value = "/deleteServey", method = RequestMethod.POST)
	@ResponseBody
	public String deleteServey(@RequestBody String userSurveyId) {
		boolean status = pmaySurveyService.deleteServey(userSurveyId);
		return gson.toJson(status);
	}

	/**
	 * @return surveyReports
	 */
	@RequestMapping(value = "/getAdminsSurveyReports", method = RequestMethod.GET)
	@ResponseBody
	public String getAdminsSurveyReports() {
		List<PmayReportDataForAdmins> surveyReports = pmaySurveyService.getAdminsSurveyReports();
		
		httpSession.setAttribute("surveyReportList", surveyReports);
		return gson.toJson(surveyReports);

	}

	/**
	 * @param rowColumnData
	 * @param req
	 * @return strore status for admin
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/storeFilteredRowColumnDetailsForAdmins", method = RequestMethod.POST)
	@ResponseBody
	public String storeColumnNameDetailsForAdmin(@RequestBody FilteredRowColumnData rowColumnData,HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		List<PmayReportDataForAdmins> filteredSurveyReportData = new ArrayList<>();
		List<PmayReportDataForAdmins> listSurveyReportData = (List<PmayReportDataForAdmins>) httpSession
				.getAttribute("surveyReportList");

		String[] surveyId = rowColumnData.getSelectedsurveyId();
		if (rowColumnData.getSelectedsurveyId().length != 0) {

			for (int i = 0; i < surveyId.length; i++) {
				for (PmayReportDataForAdmins surveyReportData : listSurveyReportData) {
					if (surveyReportData.getUserSurveyId().equalsIgnoreCase(surveyId[i])) {
						filteredSurveyReportData.add(surveyReportData);
					}
				}	
			}
		} else {
			return gson.toJson("Please Select Rows for Download");
		}
		session.setAttribute("filteredSurveyReport", filteredSurveyReportData);
		session.setAttribute("columnData", rowColumnData);

		return gson.toJson("true");
	}

	/**
	 * @param req
	 * @return DesiredRowColumnForDownload
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getDesiredDataForAdminDownload", method = RequestMethod.GET)
	@ResponseBody
	public String getDesiredRowColumnForAdminsDownload(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		FilteredRowColumnData columnNameData = (FilteredRowColumnData) session.getAttribute("columnData");
		List<PmayReportDataForAdmins> filteredSurveyReportData = (List<PmayReportDataForAdmins>) session
				.getAttribute("filteredSurveyReport");

		PmaySurveyReportDownloadData downloadData = new PmaySurveyReportDownloadData();
		downloadData.setColumnData(columnNameData);
		downloadData.setListAdminsData(filteredSurveyReportData);

		
		return gson.toJson(downloadData);
	}

	/**
	 * @return listPendingUsers
	 */
	@RequestMapping(value = "/getAllPendingUsers", method = RequestMethod.GET)
	@ResponseBody
	public String getAllPendingUsers() {
		List<PmayUserData> listPendingUsers = pmaySurveyService.getAllPendingUsers();
		return gson.toJson(listPendingUsers);
	}

	/**
	 * @param userSurveyId
	 * @return
	 */
	@RequestMapping(value = "/removeSurvey", method = RequestMethod.POST)
	@ResponseBody
	public String removeSurvey(@RequestBody String userSurveyId) {
		boolean status = pmaySurveyService.removeSurvey(userSurveyId);
		return gson.toJson(status);
	}

	/**
	 * @param serveyData
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/addSurvey", method = RequestMethod.POST)
	@ResponseBody
	public String addSurvey(@RequestParam(value = "applicantPhoto", required = false) MultipartFile applicantPhoto,
			@RequestParam(value = "idPhoto", required = false) MultipartFile idPhoto,
			@RequestParam(value = "presentInfrontHousePic", required = false) MultipartFile presentInfrontHousePic,
			@RequestParam(value = "landRecordPic", required = false) MultipartFile landRecordPic,
			@RequestParam(value = "landPhoto1", required = false) MultipartFile landPhoto1,
			@RequestParam(value = "landPhoto2", required = false) MultipartFile landPhoto2,
			@RequestParam(value = "bplPicture", required = false) MultipartFile bplPicture,
			@RequestParam(value = "rationCardPic", required = false) MultipartFile rationCardPic,
			@RequestParam(value = "applicantSignature", required = false) MultipartFile applicantSignature,
			@RequestParam(value = "incomeProofPhoto", required = false) MultipartFile incomeProofPhoto,
			@RequestParam(value = "surveyData") String surveyData,
			@RequestParam(value = "biometricDetails", required = false) byte[] biometricDetails) {
		
		Map surveyDetailsData = new Gson().fromJson(surveyData, Map.class);
		PmayAddSurveyData pmayAddSurveyData = new PmayAddSurveyData();
		
		pmayAddSurveyData.setApp(PmayUtil.chkObjectNull(surveyDetailsData.get("APP")).toString());
		
		pmayAddSurveyData.setUserId(PmayUtil.chkObjectNull(surveyDetailsData.get("userId")).toString());
		pmayAddSurveyData.setSurveyId(PmayUtil.chkObjectNull(surveyDetailsData.get("surveyId")).toString());
		pmayAddSurveyData.setSlumRadio(PmayUtil.chkObjectForNonSlum(surveyDetailsData.get("slumRadio")).toString());
		pmayAddSurveyData.setValidationPendingStatus(
				PmayUtil.chkCheckedRadioObjectNull(surveyDetailsData.get("validationPendingStatus")).toString());
		pmayAddSurveyData.setFamilyHeadName(PmayUtil.chkObjectNull(surveyDetailsData.get("familyHeadName")).toString());
		pmayAddSurveyData
				.setFatherHusbandName(PmayUtil.chkObjectNull(surveyDetailsData.get("fatherHusbandName")).toString());
		pmayAddSurveyData.setAdharNo(PmayUtil.chkObjectNull(surveyDetailsData.get("adharNo")).toString());
		pmayAddSurveyData.setAdharReason(PmayUtil.chkObjectNull(surveyDetailsData.get("adharReason")).toString());
		pmayAddSurveyData.setMaritalStatus(PmayUtil.chkObjectNull(surveyDetailsData.get("maritalStatus")).toString());
		pmayAddSurveyData.setEligibleStatus(PmayUtil.chkCheckedRadioObjectNull(surveyDetailsData.get("eligibleStatus")).toString());
		pmayAddSurveyData
				.setNonEligibleReason(PmayUtil.chkObjectNull(surveyDetailsData.get("nonEligibleReason")).toString());
		pmayAddSurveyData.setGenderId(PmayUtil.chkObjectNull(surveyDetailsData.get("genderId")).toString());
		pmayAddSurveyData.setIdType(PmayUtil.chkObjectNull(surveyDetailsData.get("idType")).toString());
		pmayAddSurveyData.setIdNo(PmayUtil.chkObjectNull(surveyDetailsData.get("idNo")).toString());
		pmayAddSurveyData.setDob(PmayUtil.chkObjectNull(surveyDetailsData.get("dob")).toString());
		pmayAddSurveyData.setReligion(PmayUtil.chkObjectNull(surveyDetailsData.get("religion")).toString());
		pmayAddSurveyData
				.setReligionIfOther(PmayUtil.chkObjectNull(surveyDetailsData.get("religionIfOther")).toString());
		pmayAddSurveyData.setCaste(PmayUtil.chkObjectNull(surveyDetailsData.get("caste")).toString());
		pmayAddSurveyData.setPresentTown(PmayUtil.chkCheckedRadioObjectNull(surveyDetailsData.get("presentTown")).toString());
		pmayAddSurveyData.setPresentHouseNo(PmayUtil.chkObjectNull(surveyDetailsData.get("presentHouseNo")).toString());
		pmayAddSurveyData
				.setPresentStreetName(PmayUtil.chkObjectNull(surveyDetailsData.get("presentStreetName")).toString());
		pmayAddSurveyData.setPresentCity(PmayUtil.chkObjectNull(surveyDetailsData.get("presentCity")).toString());
		pmayAddSurveyData
				.setPresentMobileNo(PmayUtil.chkObjectNull(surveyDetailsData.get("presentMobileNo")).toString());
		pmayAddSurveyData
				.setIsSameAsPresentAdd(PmayUtil.chkCheckedRadioObjectNull(surveyDetailsData.get("isSameAsPresentAdd")).toString());
		pmayAddSurveyData.setPermanentTown(PmayUtil.chkCheckedRadioObjectNull(surveyDetailsData.get("permanentTown")).toString());
		
		pmayAddSurveyData
				.setPermanentHouseNo(PmayUtil.chkObjectNull(surveyDetailsData.get("permanentHouseNo")).toString());
		pmayAddSurveyData.setPermanentStreetName(
				PmayUtil.chkObjectNull(surveyDetailsData.get("permanentStreetName")).toString());
		pmayAddSurveyData.setPermanentCity(PmayUtil.chkObjectNull(surveyDetailsData.get("permanentCity")).toString());
		pmayAddSurveyData
				.setPermanentMobileNo(PmayUtil.chkObjectNull(surveyDetailsData.get("permanentMobileNo")).toString());
		pmayAddSurveyData.setHouseRoofType(PmayUtil.chkObjectNull(surveyDetailsData.get("houseRoofType")).toString());
		pmayAddSurveyData.setOwnsRadio(PmayUtil.chkCheckedRadioObjectNull(surveyDetailsData.get("ownsRadio")).toString());
		pmayAddSurveyData.setLandAddress(PmayUtil.chkObjectNull(surveyDetailsData.get("landAddress")).toString());
		pmayAddSurveyData.setLandinSqm(PmayUtil.chkObjectNull(surveyDetailsData.get("landinSqm")).toString());
		pmayAddSurveyData.setOwnershipHouse(PmayUtil.chkObjectNull(surveyDetailsData.get("ownershipHouse")).toString());
		pmayAddSurveyData.setHouseWallType(PmayUtil.chkObjectNull(surveyDetailsData.get("houseWallType")).toString());
		pmayAddSurveyData
				.setDwellinUnitRoom(PmayUtil.chkObjectNull(surveyDetailsData.get("dwellinUnitRoom")).toString());
		pmayAddSurveyData.setSizeExistingDwelling(
				PmayUtil.chkObjectNull(surveyDetailsData.get("sizeExistingDwelling")).toString());
		pmayAddSurveyData.setHouseRequirementRadio(
				PmayUtil.chkObjectNull(surveyDetailsData.get("houseRequirementRadio")).toString());
		pmayAddSurveyData.setRequirement(PmayUtil.chkObjectNull(surveyDetailsData.get("requirement")).toString());
		pmayAddSurveyData.setPattadarName(PmayUtil.chkObjectNull(surveyDetailsData.get("pattadarName")).toString());
		pmayAddSurveyData.setDagNo(PmayUtil.chkObjectNull(surveyDetailsData.get("dagNo")).toString());
		pmayAddSurveyData.setPattaNo(PmayUtil.chkObjectNull(surveyDetailsData.get("pattaNo")).toString());
		pmayAddSurveyData.setLandAreaPatta(PmayUtil.chkObjectNull(surveyDetailsData.get("landAreaPatta")).toString());
		pmayAddSurveyData.setLandLength(PmayUtil.chkObjectNull(surveyDetailsData.get("landLength")).toString());
		pmayAddSurveyData.setLandBreadth(PmayUtil.chkObjectNull(surveyDetailsData.get("landBreadth")).toString());
		pmayAddSurveyData
				.setEmploymentStatus(PmayUtil.chkObjectNull(surveyDetailsData.get("employmentStatus")).toString());
		pmayAddSurveyData.setEmploymentStatusName(
				PmayUtil.chkObjectNull(surveyDetailsData.get("employmentStatusName")).toString());
		pmayAddSurveyData.setAverageIncome(PmayUtil.chkObjectNull(surveyDetailsData.get("averageIncome")).toString());
		pmayAddSurveyData.setIncomeProof(PmayUtil.chkObjectNull(surveyDetailsData.get("incomeProof")).toString());
		pmayAddSurveyData.setBplRadio(PmayUtil.chkCheckedRadioObjectNull(surveyDetailsData.get("bplRadio")).toString());
		pmayAddSurveyData.setBplNo(PmayUtil.chkObjectNull(surveyDetailsData.get("bplNo")).toString());

		pmayAddSurveyData.setRationRadio(PmayUtil.chkCheckedRadioObjectNull(surveyDetailsData.get("rationRadio")).toString());
		pmayAddSurveyData.setRationCardNo(PmayUtil.chkObjectNull(surveyDetailsData.get("rationCardNo")).toString());
		pmayAddSurveyData.setPreferredAssistanceHfa(
				PmayUtil.chkObjectNull(surveyDetailsData.get("preferredAssistanceHfa")).toString());
		pmayAddSurveyData.setWardDetails(PmayUtil.chkObjectNull(surveyDetailsData.get("wardDetails")).toString());
		pmayAddSurveyData.setUlbNameId(PmayUtil.chkObjectNull(surveyDetailsData.get("ulbNameId")).toString());
		pmayAddSurveyData.setBankAccNo(PmayUtil.chkObjectNull(surveyDetailsData.get("bankAccNo")).toString());
		pmayAddSurveyData.setBankId(PmayUtil.chkObjectNull(surveyDetailsData.get("bankId")).toString());
		pmayAddSurveyData.setBankName(PmayUtil.chkObjectNull(surveyDetailsData.get("bankName")).toString());
		pmayAddSurveyData.setBankBranchName(PmayUtil.chkObjectNull(surveyDetailsData.get("bankBranchName")).toString());
		pmayAddSurveyData.setBankIfscCode(PmayUtil.chkObjectNull(surveyDetailsData.get("bankIfscCode")).toString());

		pmayAddSurveyData
				.setFamilyMemberName(PmayUtil.chkObjectNull(surveyDetailsData.get("familyMemberName")).toString());
		pmayAddSurveyData.setFamilyMemberRelation(
				PmayUtil.chkObjectNull(surveyDetailsData.get("familyMemberRelation")).toString());
		pmayAddSurveyData
				.setFamilyMemberGender(PmayUtil.chkObjectNull(surveyDetailsData.get("familyMemberGender")).toString());
		pmayAddSurveyData
				.setFamilyMemberAge(PmayUtil.chkObjectNull(surveyDetailsData.get("familyMemberAge")).toString());
		pmayAddSurveyData.setFamilyMemberIdCardNo(
				PmayUtil.chkObjectNull(surveyDetailsData.get("familyMemberIdCardNo")).toString());
		pmayAddSurveyData.setIsSubmitted((PmayUtil.chkObjectNull(surveyDetailsData.get("isSubmitted")).toString()));
		pmayAddSurveyData.setGeoLongitude(PmayUtil.chkObjectNull(surveyDetailsData.get("geoLongitude")).toString());
		pmayAddSurveyData.setGeoLatitude(PmayUtil.chkObjectNull(surveyDetailsData.get("geoLatitude")).toString());
		
		pmayAddSurveyData.setApplicantPhoto(applicantPhoto);
		pmayAddSurveyData.setIdPhoto(idPhoto);
		pmayAddSurveyData.setIncomeProofPhoto(incomeProofPhoto);
		pmayAddSurveyData.setPresentInfrontHousePic(presentInfrontHousePic);
		/* pmayAddSurveyData.setLocationDetailsPic(locationDetailsPic); */
		pmayAddSurveyData.setLandRecordPic(landRecordPic);
		pmayAddSurveyData.setLandPhoto1(landPhoto1);
		pmayAddSurveyData.setLandPhoto2(landPhoto1);
		pmayAddSurveyData.setBplPicture(bplPicture);
		pmayAddSurveyData.setRationCardPic(rationCardPic);
		pmayAddSurveyData.setApplicantSignature(applicantSignature);
		pmayAddSurveyData.setBiometricDetails(biometricDetails);
		Map<String, String> addSurveystatus = pmaySurveyService.addSurvey(pmayAddSurveyData);

		return gson.toJson(addSurveystatus);
	}

	/**
	 * @param surveyData
	 * @return
	 */
	@RequestMapping(value = "/getSurveyUserReport", method = RequestMethod.POST)
	@ResponseBody
	public String getSurveyUserReport(@RequestBody Map<String,String> userDetails, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String userId = null;
		
		if(userDetails.get("userId") != null) {
			userId =userDetails.get("userId");
		}
		else if((String) session.getAttribute("userId") != null){
			userId = (String) session.getAttribute("userId");
		}
		
		List<PmayReportDataForAdmins> surveyUserReport = pmaySurveyService
				.getSurveyUserReport(userId);

		if (surveyUserReport != null) {
			for (PmayReportDataForAdmins surveyReport : surveyUserReport) {
				if (surveyReport.getSubmittedData().equals("Y")) {
					surveyReport.setEditButtonDisable("true");
				} else {
					surveyReport.setEditButtonDisable("false");
				}

			}
		}

		httpSession.setAttribute("surveyReportList", surveyUserReport);
		
		return gson.toJson(surveyUserReport);
	}

	/**
	 * @param seachDetails
	 * @return FilteredReportBySearch for Admin and Super-Admin
	 */
	@RequestMapping(value = "/getFilteredReportBySearch", method = RequestMethod.POST)
	@ResponseBody
	public String getFilteredReportBySearch(@RequestBody PmaySeachData seachDetails) {
		List<PmayReportDataForAdmins> surveyReports = pmaySurveyService.getFilteredReportBySearchForAdmins(seachDetails);
		return gson.toJson(surveyReports);
	}

	/**
	 * @param seachDetails
	 * @return
	 */
	@RequestMapping(value = "/getFilteredReportForSuperUser", method = RequestMethod.POST)
	@ResponseBody
	public String getFilteredReportForSuperUser(@RequestBody PmaySeachData seachDetails) {
		List<PmaySurveyReportData> surveyReports = pmaySurveyService.getFilteredReportForSuperUser(seachDetails);
		
		return gson.toJson(surveyReports);
	}

	/**
	 * @param seachDetails
	 * @return
	 */
	@RequestMapping(value = "/getFilteredReportForSurveyUser", method = RequestMethod.POST)
	@ResponseBody
	public String getFilteredReportForSurveyorUser(@RequestBody PmaySeachData seachDetails, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		seachDetails.setUserId((String) session.getAttribute("userId"));
		List<PmayReportDataForAdmins> surveyReports = pmaySurveyService.getFilteredReportForsurveyorUser(seachDetails);
		if (surveyReports != null) {
			for (PmayReportDataForAdmins surveyReport : surveyReports) {
				if (surveyReport.getSubmittedData().equals("Y")) {
					surveyReport.setEditButtonDisable("true");
				} else {
					surveyReport.setEditButtonDisable("false");
				}

			}
		}
		
		return gson.toJson(surveyReports);
	}

	/************************************************************
	 * Add Slum Servey Data
	 ***********************************************************************/
	/**
	 * @param slumServeyData
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/addSlumSurvey", method = RequestMethod.POST)
	@ResponseBody
	public String addSlumSurvey(
			@RequestParam(value = "applicantSignature", required = false) MultipartFile applicantSignature,
			@RequestParam(value = "locationDetailsPic", required = false) MultipartFile locationDetailsPic,
			@RequestParam(value = "slumIdImage", required = false) MultipartFile slumIdImage,
			@RequestParam(value = "surveyData") String surveyData,
			@RequestParam(value = "slumBiometricDetails", required = false) byte[] slumBiometricDetails,
			@RequestParam(value = "applicantPhoto", required = false) MultipartFile applicantPhoto) {
		
		Map surveyDetailsData = new Gson().fromJson(surveyData, Map.class);
		PmaySlumAddData pmayAddSurveyData = new PmaySlumAddData();
		pmayAddSurveyData.setApp(PmayUtil.chkObjectNull(surveyDetailsData.get("APP")).toString());
		
		pmayAddSurveyData.setUserId(PmayUtil.chkObjectNull(surveyDetailsData.get("userId")).toString());
		pmayAddSurveyData.setSurveyId(PmayUtil.chkObjectNull(surveyDetailsData.get("surveyId")).toString());
		pmayAddSurveyData.setChckSlumRadio(PmayUtil.chkObjectForSlum(surveyDetailsData.get("chckSlumRadio")).toString());
		pmayAddSurveyData
				.setSlumFamilyHeadName(PmayUtil.chkObjectNull(surveyDetailsData.get("slumFamilyHeadName")).toString());
		pmayAddSurveyData.setSlumFatherHusbandName(
				PmayUtil.chkObjectNull(surveyDetailsData.get("slumFatherHusbandName")).toString());
		pmayAddSurveyData.setSlumAdharNo(PmayUtil.chkObjectNull(surveyDetailsData.get("slumAdharNo")).toString());
		pmayAddSurveyData
				.setSlumAdharReason(PmayUtil.chkObjectNull(surveyDetailsData.get("slumAdharReason")).toString());
		pmayAddSurveyData.setGenderValue(PmayUtil.chkObjectNull(surveyDetailsData.get("genderValue")).toString());

		pmayAddSurveyData
				.setSlumPresentTown(PmayUtil.chkCheckedRadioObjectNull(surveyDetailsData.get("slumPresentTown")).toString());
		pmayAddSurveyData
				.setSlumPresentHouseNo(PmayUtil.chkObjectNull(surveyDetailsData.get("slumPresentHouseNo")).toString());
		pmayAddSurveyData.setSlumPresentStreetName(
				PmayUtil.chkObjectNull(surveyDetailsData.get("slumPresentStreetName")).toString());
		pmayAddSurveyData
				.setSlumPresentCity(PmayUtil.chkObjectNull(surveyDetailsData.get("slumPresentCity")).toString());
		pmayAddSurveyData
				.setPresentMobileNo(PmayUtil.chkObjectNull(surveyDetailsData.get("presentMobileNo")).toString());
		pmayAddSurveyData.setSlumIsSameAsPresentAdd(
				PmayUtil.chkCheckedRadioObjectNull(surveyDetailsData.get("slumIsSameAsPresentAdd")).toString());
		pmayAddSurveyData
				.setSlumPermanentTown(PmayUtil.chkCheckedRadioObjectNull(surveyDetailsData.get("slumPermanentTown")).toString());
		pmayAddSurveyData.setSlumPermanentHouseNo(
				PmayUtil.chkObjectNull(surveyDetailsData.get("slumPermanentHouseNo")).toString());
		pmayAddSurveyData.setSlumPermanentStreetName(
				PmayUtil.chkObjectNull(surveyDetailsData.get("slumPermanentStreetName")).toString());
		pmayAddSurveyData
				.setSlumPermanentCity(PmayUtil.chkObjectNull(surveyDetailsData.get("slumPermanentCity")).toString());
		pmayAddSurveyData.setSlumPermanentMobileNo(
				PmayUtil.chkObjectNull(surveyDetailsData.get("slumPermanentMobileNo")).toString());
		pmayAddSurveyData.setSlumIdProof(
				PmayUtil.chkObjectNull(surveyDetailsData.get("idType")).toString());
		pmayAddSurveyData.setSlumIdProofNo(
				PmayUtil.chkObjectNull(surveyDetailsData.get("idNo")).toString());

		pmayAddSurveyData.setSlumOwnsRadio(PmayUtil.chkCheckedRadioObjectNull(surveyDetailsData.get("slumOwnsRadio")).toString());
		pmayAddSurveyData.setSlumLandAddress(PmayUtil.chkObjectNull(surveyDetailsData.get("slumLandAddress")).toString());
		pmayAddSurveyData.setSlumLandinSqm(PmayUtil.chkObjectNull(surveyDetailsData.get("slumLandinSqm")).toString());
		pmayAddSurveyData.setSlumReligion(PmayUtil.chkObjectNull(surveyDetailsData.get("slumReligion")).toString());
		pmayAddSurveyData.setSlumCaste(PmayUtil.chkObjectNull(surveyDetailsData.get("slumCaste")).toString());

		pmayAddSurveyData
				.setFamilyMemberName(PmayUtil.chkObjectNull(surveyDetailsData.get("familyMemberName")).toString());
		pmayAddSurveyData.setFamilyMemberRelation(
				PmayUtil.chkObjectNull(surveyDetailsData.get("familyMemberRelation")).toString());
		pmayAddSurveyData
				.setFamilyMemberGender(PmayUtil.chkObjectNull(surveyDetailsData.get("familyMemberGender")).toString());
		pmayAddSurveyData
				.setFamilyMemberAge(PmayUtil.chkObjectNull(surveyDetailsData.get("familyMemberAge")).toString());
		pmayAddSurveyData.setFamilyMemberIdCardNo(
				PmayUtil.chkObjectNull(surveyDetailsData.get("familyMemberIdCardNo")).toString());
		pmayAddSurveyData.setIsSubmittedFlag(PmayUtil.chkObjectNull(surveyDetailsData.get("isSubmittedFlag")).toString());

		pmayAddSurveyData
				.setNonEligibleReason(PmayUtil.chkObjectNull(surveyDetailsData.get("nonEligibleReason")).toString());
		pmayAddSurveyData.setEligibleStatus(PmayUtil.chkCheckedRadioObjectNull(surveyDetailsData.get("eligibleStatus")).toString());
		pmayAddSurveyData.setWardDetails(PmayUtil.chkObjectNull(surveyDetailsData.get("slumWardDetails")).toString());
		pmayAddSurveyData.setUlbNameId(PmayUtil.chkObjectNull(surveyDetailsData.get("slumUlbNameId")).toString());
		pmayAddSurveyData.setMaritalStatus(PmayUtil.chkObjectNull(surveyDetailsData.get("maritalStatus")).toString());
		pmayAddSurveyData.setReligionIfOther(PmayUtil.chkObjectNull(surveyDetailsData.get("religionIfOther")).toString());
		pmayAddSurveyData.setDob(PmayUtil.chkObjectNull(surveyDetailsData.get("dob")).toString());
		pmayAddSurveyData.setGeoLongitude(PmayUtil.chkObjectNull(surveyDetailsData.get("geoLongitude")).toString());
		pmayAddSurveyData.setGeoLatitude(PmayUtil.chkObjectNull(surveyDetailsData.get("geoLatitude")).toString());
		pmayAddSurveyData.setSlumApplicantSignature(applicantSignature);
		pmayAddSurveyData.setSlumLocationDetailsPic(locationDetailsPic);
		pmayAddSurveyData.setSlumBiometricDetails(slumBiometricDetails);
		pmayAddSurveyData.setSlumIdImage(slumIdImage);
		pmayAddSurveyData.setSlumApplicantPhoto(applicantPhoto);
		Map<String, String> addSlumSurveystatus = pmaySurveyService.addSlumSurvey(pmayAddSurveyData);
		
		return gson.toJson(addSlumSurveystatus);
	}

	/************************************************************
	 * End of Add Slum Servey Data
	 ***********************************************************************/
	/**
	 * @param data
	 * @return checkAdharIsExist
	 */
	@RequestMapping(value = "/checkAdharIsExist", method = RequestMethod.POST)
	@ResponseBody
	public String checkAdharIsExist(@RequestBody Map<String,String> data) {
		boolean isExist = pmaySurveyService.checkAdharIsExist(data.get("adharNo"));
		return gson.toJson(isExist);
	}
	
	/**
	 * @param data
	 * @return checkIdProofNoIsExist
	 */
	@RequestMapping(value = "/checkIdProofNoIsExist", method = RequestMethod.POST)
	@ResponseBody
	public String checkIdProofNoIsExist(@RequestBody Map<String,String> data) {
		boolean isExist = pmaySurveyService.checkIdProofNoIsExist(data);
		return gson.toJson(isExist);
	}
	
	/**
	 * @return TodaySurveyReportForSlumNonSlum
	 */
	@RequestMapping(value = "/getTodaySurveyReportForSlumNonSlum", method = RequestMethod.GET)
	@ResponseBody
	public String getTodaySurveyReportForSlumNonSlum() {
		SlumNonSlumReportData slumNonSlumReportData = pmaySurveyService.getTodaySurveyReportForSlumNonSlum();
		return gson.toJson(slumNonSlumReportData);
	}
	
	/**
	 * @return TotalSurveyReportForSlumNonSlum
	 */
	@RequestMapping(value = "/getTotalSurveyReportForSlumNonSlum", method = RequestMethod.GET)
	@ResponseBody
	public String getTotalSurveyReportForSlumNonSlum() {
		SlumNonSlumReportData slumNonSlumReportData = pmaySurveyService.getTotalSurveyReportForSlumNonSlum();
		System.out.println(gson.toJson(slumNonSlumReportData));
		return gson.toJson(slumNonSlumReportData);
	}
	
	/**
	 * Start 12th April2018 
	 */
	@RequestMapping(value= "/getUlbSurveyReportForSlumNonSlum", method = RequestMethod.GET)
	@ResponseBody
	public String getTotalSurveyReportForUlbSlumNonSlum(String ulbNo) {
		SlumNonSlumReportData slumNonSlumReportData = pmaySurveyService.getUlbSurveyReportForSlumNonSlum(ulbNo);
		
		return gson.toJson(slumNonSlumReportData);
	}
	
	/**
	 * End 12th April2018 
	 */
	//getTodayUlbSurveyReportForSlumNonSlum
	@RequestMapping(value= "/getTodayUlbSurveyReportForSlumNonSlum", method = RequestMethod.GET)
	@ResponseBody
	public String getTodaySurveyReportForUlbSlumNonSlum(String ulbNo,String surveyDate) {
		SlumNonSlumReportData slumNonSlumReportData = pmaySurveyService.getTodayUlbSurveyReportForSlumNonSlum(ulbNo,surveyDate);
		
		return gson.toJson(slumNonSlumReportData);
	}
	
	/**
	 * End 12th April2018 
	 */
	@RequestMapping(value = "/getUlbWardDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getUlbWardDetails(@RequestBody Map<String,String> data) {
		List<UlbWardDetailsData>ulbWardDetailsData = pmaySurveyService.getUlbWardDetails(data.get("searchData"));
		
		return gson.toJson(ulbWardDetailsData);
	}
	
	@RequestMapping(value = "/getAdminUlbWardDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getAdminUlbWardDetails(@RequestBody Map<String,String> data) {
		List<UlbWardDetailsData>getAdminUlbWardDetails = pmaySurveyService.getAdminUlbWardDetails(data.get("searchData"));
		
		return gson.toJson(getAdminUlbWardDetails);
	}
	
	@RequestMapping(value = "/getSurveyerUserUlbWardDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getSurveyerUserUlbWardDetails(@RequestBody Map<String,String> data,HttpSession session) {
		String userId = session.getAttribute("userId").toString();
		List<UlbWardDetailsData>getSurveyerUserUlbWardDetails = pmaySurveyService.getSurveyerUserUlbWardDetails(data.get("searchData"),userId);
		
		return gson.toJson(getSurveyerUserUlbWardDetails);
	}
	
	@RequestMapping(value = "/deleteMultipleRecord", method = RequestMethod.POST)
	@ResponseBody
	public String deleteMultipleRecord(@RequestBody Map<String, String[]> userSurveyIds) {
		boolean status = pmaySurveyService.deleteMultipleRecord(userSurveyIds);
		return gson.toJson(status);
	}
	
	/**
	 * @param seachDetails
	 * @return
	 */
	@RequestMapping(value = "/getSuperUserSurveyReportFilterd", method = RequestMethod.POST)
	@ResponseBody
	public String getSuperUserSurveyReportFilterd(@RequestBody PmaySeachData seachDetails) {
		List<PmaySurveyReportData> surveyReports = pmaySurveyService.getSuperUserSurveyReportFilterd(seachDetails);
		return gson.toJson(surveyReports);
	}

	/**
	 * @return surveyReports
	 */
	@ResponseBody
	@RequestMapping(value = "/getAdminsSurveyReportsPaging/{pageSize}/{pageNo}", method = RequestMethod.GET)
	public String getAdminsSurveyReportsPaging(@PathVariable(value="pageSize")Integer pageSize,@PathVariable(value="pageNo")Integer pageNo) {
		
		List<PmayReportDataForAdmins> surveyReports = pmaySurveyService.getFilteredReportBySearchForAdminsWithPaging(null,pageSize,pageNo);

		Integer total_count =  pmaySurveyService.getTotalCountFilteredReportBySearchForAdmins(null);
		if(total_count!=null) {
			total_count =   (int) Math.ceil(total_count.doubleValue()/pageSize); // convert no of record to no of pages
		}
		
		HashMap<String,Object> data = new HashMap<>();
		data.put("surveyReport", surveyReports);
		data.put("total_count", total_count);
		
		return gson.toJson(data);
		
	}
	
	@RequestMapping(value = "/getFilteredReportBySearchPaging/{pageSize}/{pageNo}", method = RequestMethod.POST)
	@ResponseBody
	public String getFilteredReportBySearchWithPaging(@RequestBody PmaySeachData seachDetails,@PathVariable("pageSize")Integer itemsPerPage,@PathVariable("pageNo")Integer pageno) {
		List<PmayReportDataForAdmins> surveyReports = pmaySurveyService.getFilteredReportBySearchForAdminsWithPaging(seachDetails,itemsPerPage,pageno);

		Integer total_count =  pmaySurveyService.getTotalCountFilteredReportBySearchForAdmins(seachDetails);
		
		if(total_count!=null) {
			total_count =   (int) Math.ceil(total_count.doubleValue()/itemsPerPage); // convert no of record to no of pages
		}
		
		HashMap<String,Object> data = new HashMap<>();
		data.put("surveyReport", surveyReports);
		data.put("total_count", total_count);
		
		return gson.toJson(data);
	}
	

	/**
	 * @return SurveyReports
	 */
	@RequestMapping(value = "/getSuperUserSurveyReportPaging/{pageSize}/{pageNo}", method = RequestMethod.GET)
	@ResponseBody
	public String getSurveyReportPaging(@PathVariable(value="pageSize")Integer pageSize,@PathVariable(value="pageNo")Integer pageNo) {
		List<PmaySurveyReportData> surveyReportList = pmaySurveyService.getSuperUserSurveyReportFilterdPaging(null,pageSize,pageNo);
		
		Integer total_count = pmaySurveyService.getTotalCountSuperUserSurveyReportFilterd(null);
		
		if(total_count!=null) {
			total_count =   (int) Math.ceil(total_count.doubleValue()/pageSize); // convert no of record to no of pages
		}
		
		HashMap<String,Object> data = new HashMap<>();
		data.put("surveyReport", surveyReportList);
		data.put("total_count", total_count);
		
		return gson.toJson(data);
	}

	/**
	 * @param seachDetails
	 * @return
	 */
	@RequestMapping(value = "/getSuperUserSurveyReportFilterdPaging/{pageSize}/{pageNo}", method = RequestMethod.POST)
	@ResponseBody
	public String getSuperUserSurveyReportFilterd_paging(@RequestBody PmaySeachData seachDetails,@PathVariable(value="pageSize")Integer pageSize,@PathVariable(value="pageNo")Integer pageNo) {
		List<PmaySurveyReportData> surveyReports = pmaySurveyService.getSuperUserSurveyReportFilterdPaging(seachDetails,pageSize,pageNo);
		
		Integer total_count = pmaySurveyService.getTotalCountSuperUserSurveyReportFilterd(seachDetails);
		
		if(total_count!=null) {
			total_count =   (int) Math.ceil(total_count.doubleValue()/pageSize); // convert no of record to no of pages
		}
		
		HashMap<String,Object> data = new HashMap<>();
		data.put("surveyReport", surveyReports);
		data.put("total_count", total_count);
		
		return gson.toJson(data);
	}
	
}
