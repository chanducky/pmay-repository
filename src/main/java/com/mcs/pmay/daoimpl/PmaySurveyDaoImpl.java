package com.mcs.pmay.daoimpl;

import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mcs.pmay.dao.PmaySurveyDao;
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
import com.mcs.pmay.util.ImageUpload;
import com.mcs.pmay.util.PmayMysqlQueries;
import com.mcs.pmay.util.PmayUtil;

@Repository("pmaySurveyDao")
@ConfigurationProperties("image.path")
public class PmaySurveyDaoImpl implements PmaySurveyDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	private String applicantPhoto;
	private String bplCardPhoto;
	private String idProofPhoto;
	private String incomeProofPhoto;
	private String landPhoto1;
	private String landPhoto2;
	private String pattaPhoto;
	private String presentHousePhoto;
	private String rationCardPhoto;
	private String signature;
	
	ByteArrayInputStream biometric = null;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setApplicantPhoto(String applicantPhoto) {
		this.applicantPhoto = applicantPhoto;
	}

	public void setBplCardPhoto(String bplCardPhoto) {
		this.bplCardPhoto = bplCardPhoto;
	}

	public void setIdProofPhoto(String idProofPhoto) {
		this.idProofPhoto = idProofPhoto;
	}

	public void setIncomeProofPhoto(String incomeProofPhoto) {
		this.incomeProofPhoto = incomeProofPhoto;
	}

	public void setLandPhoto1(String landPhoto1) {
		this.landPhoto1 = landPhoto1;
	}

	public void setLandPhoto2(String landPhoto2) {
		this.landPhoto2 = landPhoto2;
	}

	public void setPattaPhoto(String pattaPhoto) {
		this.pattaPhoto = pattaPhoto;
	}

	public void setPresentHousePhoto(String presentHousePhoto) {
		this.presentHousePhoto = presentHousePhoto;
	}

	public void setRationCardPhoto(String rationCardPhoto) {
		this.rationCardPhoto = rationCardPhoto;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	/*	public void setApplicantPhotoName(String applicantPhotoName) {
		this.applicantPhotoName = applicantPhotoName;
	}

	public void setBplPhotoName(String bplPhotoName) {
		this.bplPhotoName = bplPhotoName;
	}

	public void setIdPhotoName(String idPhotoName) {
		this.idPhotoName = idPhotoName;
	}

	public void setIncomeProofPhotoName(String incomeProofPhotoName) {
		this.incomeProofPhotoName = incomeProofPhotoName;
	}

	public void setLandPhoto1Name(String landPhoto1Name) {
		this.landPhoto1Name = landPhoto1Name;
	}

	public void setLandPhoto2Name(String landPhoto2Name) {
		this.landPhoto2Name = landPhoto2Name;
	}

	public void setLocationDetailPhotoName(String locationDetailPhotoName) {
		this.locationDetailPhotoName = locationDetailPhotoName;
	}

	public void setLandRecordPhotoName(String landRecordPhotoName) {
		this.landRecordPhotoName = landRecordPhotoName;
	}

	public void setPresentInfrontHousePhotoName(String presentInfrontHousePhotoName) {
		this.presentInfrontHousePhotoName = presentInfrontHousePhotoName;
	}

	public void setRationCardPhotoName(String rationCardPhotoName) {
		this.rationCardPhotoName = rationCardPhotoName;
	}

	public void setApplicantSignatureName(String applicantSignatureName) {
		this.applicantSignatureName = applicantSignatureName;
	}
	 */
/*	public void setSlumApplicantSignatureName(String slumApplicantSignatureName) {
		this.slumApplicantSignatureName = slumApplicantSignatureName;
	}

	public void setSlumLocationDetailsPicName(String slumLocationDetailsPicName) {
		this.slumLocationDetailsPicName = slumLocationDetailsPicName;
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getCitiesDetails()
	 */
	@Override
	public List<PmayCityData> getCitiesDetails() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_CITY_DETAILS_QUERY, new RowMapper<PmayCityData>() {

			@Override
			public PmayCityData mapRow(ResultSet rs, int rowNum) throws SQLException {
				PmayCityData cityData = new PmayCityData();
				cityData.setCityId(rs.getString(1));
				cityData.setCityName(rs.getString(2));
				cityData.setStateId(rs.getString(3));
				return cityData;
			}

		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getSurveyReport()
	 */
	@Override
	public List<PmaySurveyReportData> getSuperUserSurveyReport() {
		return jdbcTemplate.query(PmayMysqlQueries.QUERY_FOR_GET_SUPER_USER_REPORT,
				new RowMapper<PmaySurveyReportData>() {
			@Override
			public PmaySurveyReportData mapRow(ResultSet rs, int rowNum) throws SQLException {
				PmaySurveyReportData superUserReportData = new PmaySurveyReportData();
				superUserReportData.setUserSurveyId(rs.getString(1));
				System.out.println("SUPER USER:-"+rs.getString(1));
				if (rs.getString(3)!="" && rs.getString(3)!=null){
					superUserReportData.setUserId(rs.getString(2));
				}else{
					superUserReportData.setUserId("");
				}
				if (rs.getString(3)!="" && rs.getString(3)!=null){
					superUserReportData.setUserName(rs.getString(3));
				}else{
					superUserReportData.setUserName("");
				}
				if (rs.getString(4)!="" && rs.getString(4)!=null){
					superUserReportData.setUserFatherName(rs.getString(4));
				}else{
					superUserReportData.setUserFatherName("");
				}
				if (rs.getString(5)!="" && rs.getString(5)!=null){
					superUserReportData.setUserGender(rs.getString(5));
				}else{
					superUserReportData.setUserGender("");
				}
				if (rs.getString(6)!="" && rs.getString(6)!=null){
					superUserReportData.setUserAge(rs.getString(6));
				}else{
					superUserReportData.setUserAge("");
				}
				if (rs.getString(7)!="" && rs.getString(7)!=null){
					superUserReportData.setMaritalStatus(rs.getString(7));
				}else{
					superUserReportData.setMaritalStatus("");
				}
				if (rs.getString(8)!="" && rs.getString(8)!=null){
					superUserReportData.setReligion(rs.getString(8));
				}else{
					superUserReportData.setReligion("");
				}
				//superUserReportData.setCaste(rs.getString(9));
				if (rs.getString(9)!="" && rs.getString(9)!=null){
					superUserReportData.setAdharNumber(rs.getString(9));
				}else{
					superUserReportData.setAdharNumber("");
				}

				if (rs.getString(10)!="" && rs.getString(10)!=null){
					superUserReportData.setIdType(rs.getString(10));
				}else{
					superUserReportData.setIdType("");
				}

				if (rs.getString(11)!="" && rs.getString(11)!=null){						

					superUserReportData.setIdNumber(rs.getString(11));
				}else{
					superUserReportData.setIdNumber("");
				}


				if (rs.getString(12)!="" && rs.getString(12)!=null){
					superUserReportData.setSlumNonSlum(rs.getString(12));
				}else{
					superUserReportData.setSlumNonSlum("");
				}


				if (rs.getString(13)!="" && rs.getString(13)!=null){
					superUserReportData.setPresentMobNo(rs.getString(13));
				}else{
					superUserReportData.setPresentMobNo("");
				}

				if (rs.getString(14)!="" && rs.getString(14)!=null){
					superUserReportData.setWardName(rs.getString(14));
				}else{
					superUserReportData.setWardName("");
				}
				if (rs.getString(15)!="" && rs.getString(15)!=null){
					superUserReportData.setEligibilityForScheme(rs.getString(15));
				}else{
					superUserReportData.setEligibilityForScheme("");
				}
				if (rs.getString(16)!="" && rs.getString(16)!=null){
					superUserReportData.setReasonForNonEligibility(rs.getString(16));
				}else{
					superUserReportData.setReasonForNonEligibility("");
				}
				if (rs.getString(17)!="" && rs.getString(17)!=null){
					superUserReportData.setGeoLatitude(rs.getString(17));
				}else{
					superUserReportData.setGeoLatitude("");
				}
				if (rs.getString(18)!="" && rs.getString(18)!=null){
					superUserReportData.setGeoLongitude(rs.getString(18));
				}else{
					superUserReportData.setGeoLongitude("");
				}
				if (rs.getString(19)!="" && rs.getString(19)!=null){
					superUserReportData.setIdAttachmentName(rs.getString(19));
				}else{
					superUserReportData.setIdAttachmentName("");
				}
				if (rs.getString(20)!="" && rs.getString(20)!=null){
					superUserReportData.setSignatureOfApplicant(rs.getString(20));
				}else{
					superUserReportData.setSignatureOfApplicant("");
				}
				if (rs.getString(21)!="" && rs.getString(21)!=null){
					superUserReportData.setUlbName(rs.getString(21));
				}else{
					superUserReportData.setUlbName("");
				}
				return superUserReportData;
			}
			//ulbName
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getPmayReligionData()
	 */
	@Override
	public List<PmayReligionData> getPmayReligionData() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_RELIGION_DATA, new RowMapper<PmayReligionData>() {
			@Override
			public PmayReligionData mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayReligionData pmayReligionData = new PmayReligionData();
				pmayReligionData.setReligionId(rs.getString(1));
				pmayReligionData.setReligionName(rs.getString(2));
				return pmayReligionData;
			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getPmayCasteData()
	 */
	@Override
	public List<PmayCasteData> getPmayCasteData() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_CASTE_DATA, new RowMapper<PmayCasteData>() {
			@Override
			public PmayCasteData mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayCasteData pmayCasteData = new PmayCasteData();
				pmayCasteData.setCasteId(rs.getString(1));
				pmayCasteData.setCasteName(rs.getString(2));
				return pmayCasteData;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getPmayIdData()
	 */
	@Override
	public List<PmayIdData> getPmayIdData() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_ID_DATA, new RowMapper<PmayIdData>() {
			@Override
			public PmayIdData mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayIdData pmayIdData = new PmayIdData();
				pmayIdData.setIdTypeId(rs.getString(1));
				pmayIdData.setIdTypename(rs.getString(2));
				return pmayIdData;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getPmayMaritalData()
	 */
	@Override
	public List<PmayMaritalData> getPmayMaritalData() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_MARITAL_DATA, new RowMapper<PmayMaritalData>() {
			@Override
			public PmayMaritalData mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayMaritalData pmayMaritalData = new PmayMaritalData();
				pmayMaritalData.setMaritalStatusId(rs.getString(1));
				pmayMaritalData.setMaritalStatusName(rs.getString(2));
				return pmayMaritalData;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getPmayOwnershipData()
	 */
	@Override
	public List<PmayOwnershipData> getPmayOwnershipData() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_OWNERSHIP_DATA, new RowMapper<PmayOwnershipData>() {
			@Override
			public PmayOwnershipData mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayOwnershipData pmayOwnershipData = new PmayOwnershipData();
				pmayOwnershipData.setHouseOwnershipId(rs.getString(1));
				pmayOwnershipData.setHouseOwnershipName(rs.getString(2));
				return pmayOwnershipData;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getPmayHouseRoofData()
	 */
	@Override
	public List<PmayHouseRoofData> getPmayHouseRoofData() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_HOUSE_ROOF_DATA, new RowMapper<PmayHouseRoofData>() {
			@Override
			public PmayHouseRoofData mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayHouseRoofData pmayHouseRoofData = new PmayHouseRoofData();
				pmayHouseRoofData.setHouseTypeRoofId(rs.getString(1));
				pmayHouseRoofData.setHouseTypeRoofName(rs.getString(2));
				return pmayHouseRoofData;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getPmayHouseWallData()
	 */
	@Override
	public List<PmayHouseWallData> getPmayHouseWallData() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_HOUSE_WALL_DATA, new RowMapper<PmayHouseWallData>() {
			@Override
			public PmayHouseWallData mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayHouseWallData pmayHouseWallData = new PmayHouseWallData();
				pmayHouseWallData.setHouseTypeWallId(rs.getString(1));
				pmayHouseWallData.setHouseTypeWallName(rs.getString(2));
				return pmayHouseWallData;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getPmayRequirementData()
	 */
	@Override
	public List<PmayRequirementData> getPmayRequirementData() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_REQUIREMENT_DATA, new RowMapper<PmayRequirementData>() {
			@Override
			public PmayRequirementData mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayRequirementData pmayRequirementData = new PmayRequirementData();
				pmayRequirementData.setHouseRequirementId(rs.getString(1));
				pmayRequirementData.setHouseRequirementName(rs.getString(2));
				return pmayRequirementData;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getPmayEmploymentData()
	 */
	@Override
	public List<PmayEmploymentData> getPmayEmploymentData() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_EMPLOYMENT_DATA, new RowMapper<PmayEmploymentData>() {
			@Override
			public PmayEmploymentData mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayEmploymentData pmayEmploymentData = new PmayEmploymentData();
				pmayEmploymentData.setEmployementCategoryId(rs.getString(1));
				pmayEmploymentData.setEmployementCategoryName(rs.getString(2));
				return pmayEmploymentData;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getPmayRelationshipData()
	 */
	@Override
	public List<PmayRelationshipData> getPmayRelationshipData() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_RELATIONSHIP_DATA, new RowMapper<PmayRelationshipData>() {
			@Override
			public PmayRelationshipData mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayRelationshipData pmayRelationshipData = new PmayRelationshipData();
				pmayRelationshipData.setRelationshipId(rs.getString(1));
				pmayRelationshipData.setRelationshipName(rs.getString(2));
				return pmayRelationshipData;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getPmayGenderData()
	 */
	@Override
	public List<PmayGenderData> getPmayGenderData() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_GENDER_DATA, new RowMapper<PmayGenderData>() {
			@Override
			public PmayGenderData mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayGenderData pmayGenderData = new PmayGenderData();
				pmayGenderData.setGenderId(rs.getString(1));
				pmayGenderData.setGenderName(rs.getString(2));
				return pmayGenderData;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getPmayHfaAsstData()
	 */
	@Override
	public List<PmayHfaAsstData> getPmayHfaAsstData() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_HFA_ASST_DATA, new RowMapper<PmayHfaAsstData>() {
			@Override
			public PmayHfaAsstData mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayHfaAsstData pmayHfaAsstData = new PmayHfaAsstData();
				pmayHfaAsstData.setPreferredAssistanceHfaCategoryId(rs.getString(1));
				pmayHfaAsstData.setPreferredAssistanceHfaCategoryName(rs.getString(2));
				return pmayHfaAsstData;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getDeletedSurveyReports()
	 */
	@Override
	public List<PmaySurveyReportData> getDeletedSurveyReports() {
		return jdbcTemplate.query(PmayMysqlQueries.DELETED_SURVEY_QUERY, new RowMapper<PmaySurveyReportData>() {
			@Override
			public PmaySurveyReportData mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmaySurveyReportData surveyUserReport = new PmaySurveyReportData();
				surveyUserReport.setUserSurveyId(rs.getString(1));
				surveyUserReport.setUserId(rs.getString(2));
				surveyUserReport.setUserName(rs.getString(3));
				surveyUserReport.setUserFatherName(rs.getString(4));
				surveyUserReport.setUserGender(rs.getString(5));
				surveyUserReport.setUserAge(rs.getString(6));
				surveyUserReport.setMaritalStatus(rs.getString(7));
				surveyUserReport.setReligion(rs.getString(8));
				surveyUserReport.setCaste(rs.getString(9));
				surveyUserReport.setAdharNumber(rs.getString(10));
				surveyUserReport.setIdType(rs.getString(11));
				surveyUserReport.setIdNumber(rs.getString(12));
				return surveyUserReport;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#deleteServey(java.lang.String)
	 */
	@Override
	public boolean deleteServey(String userSurveyId) {
		int deleteStatus = 0;

		int deleteHouseStatus = jdbcTemplate.update(PmayMysqlQueries.DELETE_FEOM_HOUSING_ENHANCEMENT, userSurveyId);
		int deleteFamilyDetailsStatus = jdbcTemplate.update(PmayMysqlQueries.DELETE_FEOM_FAMILY_DETAILS, userSurveyId);
		if (deleteHouseStatus != 0 || deleteFamilyDetailsStatus != 0) {
			deleteStatus = jdbcTemplate.update(PmayMysqlQueries.DELETE_SURVEY_QUERY, userSurveyId);
		}
		return deleteStatus != 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getAdminsSurveyReports()
	 */
	@Override
	public List<PmayReportDataForAdmins> getAdminsSurveyReports() {
		return jdbcTemplate.query(PmayMysqlQueries.QUERY_FOR_GET_ADMINS_SURVEY_REPORT,
				new RowMapper<PmayReportDataForAdmins>() {
			@Override
			public PmayReportDataForAdmins mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayReportDataForAdmins surveyReportData = new PmayReportDataForAdmins();
				surveyReportData.setUserSurveyId(rs.getString(1));

				surveyReportData.setUserId(rs.getString(2));
				surveyReportData.setWardId(rs.getString(3));
				surveyReportData.setWardName(rs.getString(4));
				surveyReportData.setSlumNonSlum(rs.getString(5));
				surveyReportData.setValidationPendingNonSlum(rs.getString(6));
				surveyReportData.setEligibilityForScheme(rs.getString(7));
				surveyReportData.setFamilyHead(rs.getString(8));
				surveyReportData.setFatherOrHusbandName(rs.getString(9));
				surveyReportData.setPhotoAttachmentName(rs.getString(10));
				surveyReportData.setAadharCardNumber(rs.getString(11));
				surveyReportData.setReasonforAAdharNotAvailable(rs.getString(12));
				surveyReportData.setIdTypeId(rs.getString(13));
				surveyReportData.setIdTypeName(rs.getString(14));
				surveyReportData.setIdNumber(rs.getString(15));
				surveyReportData.setIdAttachmentName(rs.getString(16));
				surveyReportData.setGenderId(rs.getString(17));
				surveyReportData.setGenderName(rs.getString(18));
				surveyReportData.setDob(rs.getString(19));
				surveyReportData.setAge(rs.getString(20));
				surveyReportData.setMaritalStatusId(rs.getString(21));
				surveyReportData.setMaritalStatusName(rs.getString(22));
				surveyReportData.setReligionId(rs.getString(23));
				surveyReportData.setReligionName(rs.getString(24));
				surveyReportData.setReligionIfOther(rs.getString(25));
				surveyReportData.setCasteId(rs.getString(26));
				surveyReportData.setCasteName(rs.getString(27));
				surveyReportData.setReasonForNonEligibility(rs.getString(28));
				surveyReportData.setNoOfYearsOfStayPresent(rs.getString(29));
				surveyReportData.setPresentHouseFlatNo(rs.getString(30));
				surveyReportData.setPresentNameOfStreet(rs.getString(31));
				surveyReportData.setPresentCityId(rs.getString(32));
				surveyReportData.setPresentCityName(rs.getString(33));
				surveyReportData.setPresentMobNo(rs.getString(34));
				surveyReportData.setPermanentSameAsPresent(rs.getString(35));
				surveyReportData.setNoOfYearsOfStayPermanent(rs.getString(36));
				surveyReportData.setPermanentHouseFlatNo(rs.getString(37));
				surveyReportData.setPermanentNameOfStreet(rs.getString(38));
				surveyReportData.setPermanentCityId(rs.getString(39));
				surveyReportData.setPermanentCityName(rs.getString(40));
				surveyReportData.setPermanentMobileNo(rs.getString(41));
				surveyReportData.setPhotoAttachmentInFrontOfHouse(rs.getString(42));
				surveyReportData.setHouseOwnershipId(rs.getString(43));
				surveyReportData.setGeoLatitude(rs.getString(44));
				surveyReportData.setGeoLongitude(rs.getString(45));
				surveyReportData.setHouseTypeRoofId(rs.getString(46));
				surveyReportData.setHouseTypeRoofName(rs.getString(47));
				surveyReportData.setHouseTypeWallId(rs.getString(48));
				surveyReportData.setHouseTypeWallName(rs.getString(49));
				surveyReportData.setNoOfRoomDwellingexceptKitchen(rs.getString(50));
				surveyReportData.setSizeOfDwellUnitCarpetArea(rs.getString(51));
				surveyReportData.setFamilyOwnHouseInIndia(rs.getString(52));
				surveyReportData.setIndiaLocationDetailsAttachment(rs.getString(53));
				surveyReportData.setIndiaLandInSquareMeter(rs.getString(54));
				surveyReportData.setLandAttachmentName(rs.getString(55));
				surveyReportData.setHousingCategoryId(rs.getString(56));
				surveyReportData.setHouseRequirementName(rs.getString(57));
				surveyReportData.setNameOfPattadars(rs.getString(58));
				surveyReportData.setPattaNumber(rs.getString(59));
				surveyReportData.setDagNumber(rs.getString(60));
				surveyReportData.setLandAreaAsInPatta(rs.getString(61));
				surveyReportData.setDimentionOfLandLength(rs.getString(62));
				surveyReportData.setDimensionOfLandbreadth(rs.getString(63));
				surveyReportData.setLandAttachment1(rs.getString(64));
				surveyReportData.setLandAttachment2(rs.getString(65));
				surveyReportData.setEmployementCategoryId(rs.getString(66));
				surveyReportData.setEmployementCategoryName(rs.getString(67));
				surveyReportData.setIfOtherCategoryName(rs.getString(68));
				surveyReportData.setIncomeProofDocName(rs.getString(69));
				surveyReportData.setIncomeProofAttachment(rs.getString(70));
				surveyReportData.setFamilyHaveBplCard(rs.getString(71));
				surveyReportData.setBplCardNumber(rs.getString(72));
				surveyReportData.setBplCardAttachment(rs.getString(73));
				surveyReportData.setFamilyHaveRationCard(rs.getString(74));
				surveyReportData.setRationCardNumber(rs.getString(75));
				surveyReportData.setRationCardAttachment(rs.getString(76));
				surveyReportData.setHfaCategoryId(rs.getString(77));
				surveyReportData.setHfaCategoryName(rs.getString(78));
				surveyReportData.setBankAccountNo(rs.getString(79));
				surveyReportData.setBankName(rs.getString(80));
				surveyReportData.setBranchName(rs.getString(81));
				surveyReportData.setBranchIfscCode(rs.getString(82));
				surveyReportData.setSignatureOfApplicant(rs.getString(83));
				surveyReportData.setSubmittedData(rs.getString(84));
				surveyReportData.setNameOfFamilyMember(rs.getString(85));
				surveyReportData.setRelationshipId(rs.getString(86));
				surveyReportData.setRelationshipName(rs.getString(87));
				surveyReportData.setFamilyGenderId(rs.getString(88));
				surveyReportData.setFamilyGenderName(rs.getString(89));
				surveyReportData.setAgeOfFamilyMember(rs.getString(90));
				surveyReportData.setFamilyMemberIdCardNumber(rs.getString(91));
				surveyReportData.setBankId(rs.getString(93));
				surveyReportData.setOtherBankName(rs.getString(94));
				surveyReportData.setLandAddress(rs.getString(95));
				surveyReportData.setUlbNameId(rs.getString(96));
				surveyReportData.setUlbName(rs.getString(97));
				surveyReportData.setUserRMN(rs.getString(98));
				surveyReportData.setCreatedOn(rs.getDate(99));

				//System.out.println("DATE-PHUKU:-"+rs.getDate(99));
				if (PmayUtil.chkNull(surveyReportData.getSlumNonSlum()).equalsIgnoreCase("S")) {
					surveyReportData.setSlumNonSlumStatus("Slum");
				} else if (PmayUtil.chkNull(surveyReportData.getSlumNonSlum()).equalsIgnoreCase("N")) {
					surveyReportData.setSlumNonSlumStatus("Non-Slum");
				}

				if (PmayUtil.chkNull(surveyReportData.getEligibilityForScheme()).equalsIgnoreCase("Y")) {
					surveyReportData.setEligibleStatus("Eligible");
				} else if (PmayUtil.chkNull(surveyReportData.getEligibilityForScheme()).equalsIgnoreCase("N")) {
					surveyReportData.setEligibleStatus("Not-Eligible");
				}

				if (PmayUtil.chkNull(surveyReportData.getValidationPendingNonSlum()).equalsIgnoreCase("Y")) {
					surveyReportData.setValidationPendingStatus("Yes");
				} else if (PmayUtil.chkNull(surveyReportData.getValidationPendingNonSlum())
						.equalsIgnoreCase("N")) {
					surveyReportData.setValidationPendingStatus("No");
				}

				return surveyReportData;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getAllPendingUsers()
	 */
	@Override
	public List<PmayUserData> getAllPendingUsers() {
		return jdbcTemplate.query(PmayMysqlQueries.PENDING_USER_QUERY, new RowMapper<PmayUserData>() {
			@Override
			public PmayUserData mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayUserData pendingUserData = new PmayUserData();
				pendingUserData.setUserId(rs.getString(1));
				pendingUserData.setUlbName(rs.getString(2));
				pendingUserData.setUlbNo(rs.getString(3));
				pendingUserData.setFirstName(rs.getString(4));
				pendingUserData.setMiddleName(rs.getString(5));
				pendingUserData.setLastName(rs.getString(6));
				pendingUserData.setEmailId(rs.getString(7));
				pendingUserData.setMobileNo(rs.getString(8));
				pendingUserData.setLoginApproval(rs.getString(9));
				pendingUserData.setStatus(rs.getString(10));
				return pendingUserData;
			}
		});
	}

	@Override
	public boolean removeSurvey(String userSurveyId) {
		int status = jdbcTemplate.update(PmayMysqlQueries.REMOVE_SURVEY_QUERY, userSurveyId);
		return status != 0;
	}

	@Override
	public Map<String, String> addSurvey(PmayAddSurveyData surveyData) {

		HashMap<String, String> hmap = new HashMap<>();
		String status = "false";
		
		biometric =null;
		final String applicantPhotoName; 
		final String idPhotoName;
		final String presentInfrontHousePhotoName;
		final String landRecordPhotoName;
		
		final String bplPhotoName;
		final String incomeProofPhotoName;
		final String landPhoto1Name;
		final String landPhoto2Name;
		final String rationCardPhotoName;
		final String applicantSignatureName;
		
		if (PmayUtil.chkNull(surveyData.getSurveyId()).equalsIgnoreCase("0.0")
				|| surveyData.getSurveyId().equalsIgnoreCase("0")
				|| PmayUtil.chkNull(surveyData.getSurveyId()).equals("")) {
			

			
			System.out.println("In if block>>>>>>>>>>>>>>>>>>>");
			String maxId = "SELECT IF(MAX(user_survey_id) IS NULL,1,MAX(user_survey_id+1)) AS user_survey_id FROM p_user_survey";
			int nextUserSurveyid = jdbcTemplate.queryForObject(maxId, Integer.class);
			String imageName = Integer.toString(nextUserSurveyid) + "_";
			
			if(surveyData.getApplicantPhoto()!=null ) {
				applicantPhotoName = imageName + "applicantPhoto"
						+ surveyData.getApplicantPhoto().getOriginalFilename().substring(
								surveyData.getApplicantPhoto().getOriginalFilename().lastIndexOf('.'),
								surveyData.getApplicantPhoto().getOriginalFilename().length());
			}else {
					hmap.put("success", status);
					return hmap;
			}

			if (surveyData.getBplPicture() != null) {
				bplPhotoName = imageName + "bplPhoto"
						+ surveyData.getBplPicture().getOriginalFilename().substring(
								surveyData.getBplPicture().getOriginalFilename().lastIndexOf('.'),
								surveyData.getBplPicture().getOriginalFilename().length());
			}else {
				bplPhotoName ="";
			}
			
			if (surveyData.getIdPhoto() != null) {
				idPhotoName = imageName + "idPhoto"
						+ surveyData.getIdPhoto().getOriginalFilename().substring(
								surveyData.getIdPhoto().getOriginalFilename().lastIndexOf('.'),
								surveyData.getIdPhoto().getOriginalFilename().length());
			}else {
				idPhotoName="";
			}
			
			if (surveyData.getIncomeProofPhoto() != null) {
				incomeProofPhotoName = imageName + "incomeProofPhoto"
						+ surveyData.getIncomeProofPhoto().getOriginalFilename().substring(
								surveyData.getIncomeProofPhoto().getOriginalFilename().lastIndexOf('.'),
								surveyData.getIncomeProofPhoto().getOriginalFilename().length());
			}else {
				incomeProofPhotoName="";
			}
			if (surveyData.getLandPhoto1() != null) {
				landPhoto1Name = imageName + "landPhoto1"
						+ surveyData.getLandPhoto1().getOriginalFilename().substring(
								surveyData.getLandPhoto1().getOriginalFilename().lastIndexOf('.'),
								surveyData.getLandPhoto1().getOriginalFilename().length());
			}else {
				landPhoto1Name=null;
			}
				
			if (surveyData.getLandPhoto2() != null) {
				landPhoto2Name = imageName + "landPhoto2"
						+ surveyData.getLandPhoto2().getOriginalFilename().substring(
								surveyData.getLandPhoto2().getOriginalFilename().lastIndexOf('.'),
								surveyData.getLandPhoto2().getOriginalFilename().length());
			}else {
				landPhoto2Name=null;
			}
			if (surveyData.getLandRecordPic() != null) {
				landRecordPhotoName = imageName + "landRecordPhoto"
						+ surveyData.getLandRecordPic().getOriginalFilename().substring(
								surveyData.getLandRecordPic().getOriginalFilename().lastIndexOf('.'),
								surveyData.getLandRecordPic().getOriginalFilename().length());
			}else {
				landRecordPhotoName=null;
			}
			
			if (surveyData.getPresentInfrontHousePic() != null) {
				presentInfrontHousePhotoName = imageName + "presentInfrontHousePhoto"
						+ surveyData.getPresentInfrontHousePic().getOriginalFilename().substring(
								surveyData.getPresentInfrontHousePic().getOriginalFilename().lastIndexOf('.'),
								surveyData.getPresentInfrontHousePic().getOriginalFilename().length());
			}else {
				presentInfrontHousePhotoName="";
			}
				
			if (surveyData.getRationCardPic() != null) {
				rationCardPhotoName = imageName + "rationCardPhoto"
						+ surveyData.getRationCardPic().getOriginalFilename().substring(
								surveyData.getRationCardPic().getOriginalFilename().lastIndexOf('.'),
								surveyData.getRationCardPic().getOriginalFilename().length());
			}else {
				rationCardPhotoName =null;
			}
			
			if (surveyData.getApplicantSignature() != null) {
				applicantSignatureName = imageName + "applicantSignature"
						+ surveyData.getApplicantSignature().getOriginalFilename().substring(
								surveyData.getApplicantSignature().getOriginalFilename().lastIndexOf('.'),
								surveyData.getApplicantSignature().getOriginalFilename().length());

			}else {
				hmap.put("success", status);
				return hmap;
			}

			System.out.println("bio image" + surveyData.getBiometricDetails());
			if (surveyData.getBiometricDetails() != null) {
				biometric = new ByteArrayInputStream(surveyData.getBiometricDetails());
			}

			int saveSurveyStatus = jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(PmayMysqlQueries.SAVE_SURVEY_DATA);

				ps.setInt(1, nextUserSurveyid);
				ps.setString(2, surveyData.getUserId());
				ps.setString(3, PmayUtil.convertBlankToNull(surveyData.getWardDetails()));
				ps.setString(4, surveyData.getSlumRadio());
				ps.setString(5, surveyData.getValidationPendingStatus());

				ps.setString(6, surveyData.getEligibleStatus());
				ps.setString(7, surveyData.getFamilyHeadName());
				ps.setString(8, surveyData.getFatherHusbandName());
				ps.setString(9, applicantPhotoName);
				ps.setString(10, PmayUtil.convertBlankToNull(surveyData.getAdharNo()));

				ps.setString(11, surveyData.getAdharReason());
				ps.setString(12, PmayUtil.convertBlankToNull(surveyData.getIdType()));
				ps.setString(13, PmayUtil.convertBlankToNull(surveyData.getIdNo()));
				ps.setString(14, idPhotoName);

				ps.setString(15, PmayUtil.convertBlankToNull(surveyData.getGenderId()));
				ps.setString(16, PmayUtil.convertBlankToNull(surveyData.getDob()));
				ps.setString(17, PmayUtil.convertBlankToNull(surveyData.getMaritalStatus()));
				ps.setString(18, PmayUtil.convertBlankToNull(surveyData.getReligion()));
				ps.setString(19, PmayUtil.convertBlankToNull(surveyData.getReligionIfOther()));

				ps.setString(20, PmayUtil.convertBlankToNull(surveyData.getCaste()));
				ps.setString(21, surveyData.getNonEligibleReason());
				ps.setString(22, PmayUtil.convertBlankToNull(surveyData.getPresentTown()));
				ps.setString(23, PmayUtil.convertBlankToNull(surveyData.getPresentHouseNo()));
				ps.setString(24, surveyData.getPresentStreetName());

				ps.setString(25, PmayUtil.convertBlankToNull(surveyData.getPresentCity()));
				ps.setString(26, PmayUtil.convertBlankToNull(surveyData.getPresentMobileNo()));
				ps.setString(27, surveyData.getIsSameAsPresentAdd());
				ps.setString(28, PmayUtil.convertBlankToNull(surveyData.getPermanentTown()));
				ps.setString(29, PmayUtil.convertBlankToNull(surveyData.getPermanentHouseNo()));
				ps.setString(30, surveyData.getPermanentStreetName());
				ps.setString(31, PmayUtil.convertBlankToNull(surveyData.getPermanentCity()));
				ps.setString(32, PmayUtil.convertBlankToNull(surveyData.getPermanentMobileNo()));
				ps.setString(33, presentInfrontHousePhotoName);
				ps.setString(34, PmayUtil.convertBlankToNull(surveyData.getOwnershipHouse()));
				ps.setString(35, PmayUtil.convertBlankToNull(surveyData.getGeoLatitude())); // geo_lat
				ps.setString(36, PmayUtil.convertBlankToNull(surveyData.getGeoLongitude())); // geo_lon
				ps.setString(37, PmayUtil.convertBlankToNull(surveyData.getHouseRoofType()));
				ps.setString(38, PmayUtil.convertBlankToNull(surveyData.getHouseWallType()));
				ps.setString(39, PmayUtil.convertBlankToNull(surveyData.getDwellinUnitRoom()));

				ps.setString(40, surveyData.getSizeExistingDwelling());
				ps.setString(41, surveyData.getOwnsRadio());
				ps.setString(42, surveyData.getLandinSqm());
				ps.setString(43, landRecordPhotoName);

				ps.setString(44, PmayUtil.convertBlankToNull(surveyData.getHouseRequirementRadio()));
				ps.setString(45, surveyData.getPattadarName());
				ps.setString(46, surveyData.getPattaNo());
				ps.setString(47, surveyData.getDagNo());
				ps.setString(48, surveyData.getLandAreaPatta());

				ps.setString(49, surveyData.getLandLength());
				ps.setString(50, surveyData.getLandBreadth());
				ps.setString(51, landPhoto1Name);
				ps.setString(52, landPhoto2Name);
				ps.setString(53, PmayUtil.convertBlankToNull(surveyData.getEmploymentStatus()));

				ps.setString(54, surveyData.getEmploymentStatusName());
				ps.setString(55, surveyData.getIncomeProof());
				ps.setString(56, incomeProofPhotoName);
				ps.setString(57, PmayUtil.convertBlankToNull(surveyData.getBplRadio()));
				ps.setString(58, surveyData.getBplNo());

				ps.setString(59, bplPhotoName);
				ps.setString(60, PmayUtil.convertBlankToNull(surveyData.getRationRadio()));
				ps.setString(61, surveyData.getRationCardNo());
				ps.setString(62, rationCardPhotoName);
				ps.setString(63, PmayUtil.convertBlankToNull(surveyData.getPreferredAssistanceHfa()));
				ps.setString(64, PmayUtil.convertBlankToNull(surveyData.getBankAccNo()));
				ps.setString(65, PmayUtil.convertBlankToNull(surveyData.getBankId()));
				ps.setString(66, surveyData.getBankBranchName());
				ps.setString(67, surveyData.getBankIfscCode());
				ps.setString(68, applicantSignatureName);
				ps.setString(69, surveyData.getIsSubmitted()); // submitted_data
				ps.setString(70, "N"); // deleted_flag
				ps.setString(71, surveyData.getUserId()); // created_by
				ps.setString(72, surveyData.getBankName());
				ps.setBinaryStream(73, biometric);
				ps.setString(74, surveyData.getLandAddress());
				ps.setString(75, PmayUtil.convertBlankToNull(surveyData.getUlbNameId()));
				ps.setString(76, PmayUtil.convertBlankToNull(surveyData.getRequirement()));
				return ps;
			});
			int[] saveFamilyStatus = null;
			if (saveSurveyStatus != 0) {
				
				String[] familyMemberName = surveyData.getFamilyMemberName().split(",");
				String[] familyMemberRelation = surveyData.getFamilyMemberRelation().split(",");
				String[] familyMemberGender = surveyData.getFamilyMemberGender().split(",");
				String[] familyMemberAge = surveyData.getFamilyMemberAge().split(",");
				String[] familyMemberIdCardNo = surveyData.getFamilyMemberIdCardNo().split(",");
				saveFamilyStatus = jdbcTemplate.batchUpdate(PmayMysqlQueries.SAVE_FAMILY_RELATIONSHIP_QUERY,
						new BatchPreparedStatementSetter() {
					@Override
					public int getBatchSize() {
						return familyMemberName.length;
					}

					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setInt(1, nextUserSurveyid);
						ps.setString(2, familyMemberName[i]);
						ps.setString(3, PmayUtil.convertBlankToNull(familyMemberRelation[i]));
						ps.setString(4, PmayUtil.convertBlankToNull(familyMemberGender[i]));
						ps.setString(5, PmayUtil.convertBlankToNull(familyMemberAge[i]));
						ps.setString(6, PmayUtil.convertBlankToNull(familyMemberIdCardNo[i]));
						ps.setString(7, surveyData.getUserId());
					}
				});
			}

			/*********** code for return value **********/

			if (surveyData.getIsSubmitted() == "Y") {
				System.out.println("SUBMIT");
				if (saveSurveyStatus != 0 && saveFamilyStatus != null) {
					for (int i = 0; i <= saveFamilyStatus.length; i++) {
						if (saveFamilyStatus[i] != 0) {
							status = "true";
						} else {
							status = "false";
							break;
						}
					}
				} else {
					status = "false";
				}

			} else {
				System.out.println("SAVE");
				if (saveSurveyStatus != 0) {
					status = "true";
				}
			}

			int surveyId = 0;
			if (status.equalsIgnoreCase("true")) {
				surveyId = nextUserSurveyid;
			}
			
			hmap.put("success", status);
			hmap.put("surveyId", Integer.toString(surveyId));

			ImageUpload.SaveImage(surveyData.getApplicantPhoto(), applicantPhotoName, applicantPhoto);
			ImageUpload.SaveImage(surveyData.getBplPicture(), bplPhotoName, bplCardPhoto);
			ImageUpload.SaveImage(surveyData.getIdPhoto(), idPhotoName, idProofPhoto);
			ImageUpload.SaveImage(surveyData.getIncomeProofPhoto(), incomeProofPhotoName, incomeProofPhoto);
			ImageUpload.SaveImage(surveyData.getLandPhoto2(), landPhoto1Name, landPhoto1);
			ImageUpload.SaveImage(surveyData.getLandPhoto1(), landPhoto2Name, landPhoto2);
			ImageUpload.SaveImage(surveyData.getLandRecordPic(), landRecordPhotoName, pattaPhoto);
			ImageUpload.SaveImage(surveyData.getPresentInfrontHousePic(), presentInfrontHousePhotoName,
					presentHousePhoto);
			ImageUpload.SaveImage(surveyData.getRationCardPic(), rationCardPhotoName, rationCardPhoto);
			ImageUpload.SaveImage(surveyData.getApplicantSignature(), applicantSignatureName, signature);
			return hmap;

		} else {
			
			System.out.println("In else block>>>>>>>>>>>>>>>>>>>");

			if(surveyData.getUserId()==null ) {
				hmap.put("success", status);
				return hmap;
			}
			
			String imageName = surveyData.getSurveyId() + "_";
			
			if (surveyData.getApplicantPhoto() != null) {
				applicantPhotoName = imageName + "applicantPhoto"
						+ surveyData.getApplicantPhoto().getOriginalFilename().substring(
								surveyData.getApplicantPhoto().getOriginalFilename().lastIndexOf("."),
								surveyData.getApplicantPhoto().getOriginalFilename().length());
			}else {
				hmap.put("success", status);
				return hmap;
			}
			
			if (surveyData.getBplPicture() != null) {
				bplPhotoName = imageName + "bplPhoto"
						+ surveyData.getBplPicture().getOriginalFilename().substring(
								surveyData.getBplPicture().getOriginalFilename().lastIndexOf("."),
								surveyData.getBplPicture().getOriginalFilename().length());
			}else {
				bplPhotoName=null;
			}
				
			if (surveyData.getIdPhoto() != null) {

				idPhotoName = imageName + "idPhoto"
						+ surveyData.getIdPhoto().getOriginalFilename().substring(
								surveyData.getIdPhoto().getOriginalFilename().lastIndexOf("."),
								surveyData.getIdPhoto().getOriginalFilename().length());
			}else {
				idPhotoName=null;
			}
			
			if (surveyData.getIncomeProofPhoto() != null) {
				incomeProofPhotoName = imageName + "incomeProofPhoto"
						+ surveyData.getIncomeProofPhoto().getOriginalFilename().substring(
								surveyData.getIncomeProofPhoto().getOriginalFilename().lastIndexOf("."),
								surveyData.getIncomeProofPhoto().getOriginalFilename().length());
			}else {
				incomeProofPhotoName=null;
			}
				
			if (surveyData.getLandPhoto1() != null) {
				landPhoto1Name = imageName + "landPhoto1"
						+ surveyData.getLandPhoto1().getOriginalFilename().substring(
								surveyData.getLandPhoto1().getOriginalFilename().lastIndexOf("."),
								surveyData.getLandPhoto1().getOriginalFilename().length());
			}else {
				landPhoto1Name=null;
			}
			
			if (surveyData.getLandPhoto2() != null) {
				landPhoto2Name = imageName + "landPhoto2"
						+ surveyData.getLandPhoto2().getOriginalFilename().substring(
								surveyData.getLandPhoto2().getOriginalFilename().lastIndexOf("."),
								surveyData.getLandPhoto2().getOriginalFilename().length());
			}else {
				landPhoto2Name=null;
			}
			
			if (surveyData.getLandRecordPic() != null) {
				landRecordPhotoName = imageName + "landRecordPhoto"
						+ surveyData.getLandRecordPic().getOriginalFilename().substring(
								surveyData.getLandRecordPic().getOriginalFilename().lastIndexOf("."),
								surveyData.getLandRecordPic().getOriginalFilename().length());
			}else {
				landRecordPhotoName=null;
			}
			if (surveyData.getPresentInfrontHousePic() != null) {
				presentInfrontHousePhotoName = imageName + "presentInfrontHousePhoto"
						+ surveyData.getPresentInfrontHousePic().getOriginalFilename().substring(
								surveyData.getPresentInfrontHousePic().getOriginalFilename().lastIndexOf("."),
								surveyData.getPresentInfrontHousePic().getOriginalFilename().length());
			}else {
				presentInfrontHousePhotoName=null;
			}
			
			if (surveyData.getRationCardPic() != null) {
				rationCardPhotoName = imageName + "rationCardPhoto"
						+ surveyData.getRationCardPic().getOriginalFilename().substring(
								surveyData.getRationCardPic().getOriginalFilename().lastIndexOf("."),
								surveyData.getRationCardPic().getOriginalFilename().length());
			}else {
				rationCardPhotoName=null;	
			}
			if (surveyData.getApplicantSignature() != null) {
				applicantSignatureName = imageName + "applicantSignature"
						+ surveyData.getApplicantSignature().getOriginalFilename().substring(
								surveyData.getApplicantSignature().getOriginalFilename().lastIndexOf("."),
								surveyData.getApplicantSignature().getOriginalFilename().length());
			}else {
				hmap.put("success", status);
				return hmap;
			}
				
			if (surveyData.getBiometricDetails() != null) {
				biometric = new ByteArrayInputStream(surveyData.getBiometricDetails());
			}
			
			int saveSurveyStatus = jdbcTemplate.update(connection -> {
				
				String UPDATE_SURVEY_DATA = "UPDATE p_user_survey SET user_id = ? ";
				
				StringBuffer queryString = new StringBuffer(UPDATE_SURVEY_DATA);
				if(PmayUtil.convertBlankToNull(surveyData.getWardDetails())!=null) {
					queryString.append(", ward_id = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getSlumRadio())!=null) {
					queryString.append(", slum_nonslum = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getValidationPendingStatus())!=null) {
					queryString.append(", validation_pending_non_slum = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getEligibleStatus())!=null) {
					queryString.append(", eligibility_for_scheme = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getFamilyHeadName())!=null) {
					queryString.append(", family_head_name = ? ");
				}
				
				if(PmayUtil.convertBlankToNull(surveyData.getFatherHusbandName())!=null) {
					queryString.append(", father_husband_name = ? ");
				}
				if(PmayUtil.convertBlankToNull(applicantPhotoName)!=null) {
					queryString.append(", photo_attachment_name = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getAdharNo())!=null) {
					queryString.append(", aadhar_card_no = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getAdharReason())!=null) {
					queryString.append(", reason_for_aadhar_not_available = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getIdType())!=null) {
					queryString.append(", id_type_id = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getIdNo())!=null) {
					queryString.append(", id_number = ? ");
				}
				if(PmayUtil.convertBlankToNull(idPhotoName)!=null) {
					queryString.append(", id_attachment_name = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getGenderId())!=null) {
					queryString.append(", gender_id = ? ");
				}
				
				if(PmayUtil.convertBlankToNull(surveyData.getDob())!=null) {
					queryString.append(", date_of_birth = str_to_date(?,' %d/%m/%Y') ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getMaritalStatus())!=null) {
					queryString.append(", marital_status_id = ? ");
				}
				
				
				if(PmayUtil.convertBlankToNull(surveyData.getReligion())!=null) {
					queryString.append(", religion_id = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getReligionIfOther())!=null) {
					queryString.append(", religion_if_others = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getCaste())!=null) {
					queryString.append(", caste_id = ? ");
				}
				
				if(PmayUtil.convertBlankToNull(surveyData.getNonEligibleReason())!=null) {
					queryString.append(", reason_for_non_eligibility = ? ");
				}
				
				if(PmayUtil.convertBlankToNull(surveyData.getPresentTown())!=null) {
					queryString.append(", no_of_yrs_of_stay_present = ? ");
				}
				
				if(PmayUtil.convertBlankToNull(surveyData.getPresentHouseNo())!=null) {
					queryString.append(", present_house_flat_no = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPresentStreetName())!=null) {
					queryString.append(", present_name_of_street = ? ");
				}
				
				if(PmayUtil.convertBlankToNull(surveyData.getPresentCity())!=null) {
					queryString.append(", present_city_id = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPresentMobileNo())!=null) {
					queryString.append(", present_mobile_number = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getIsSameAsPresentAdd())!=null) {
					queryString.append(", permanent_same_as_present = ? ");
				}
				
				if(PmayUtil.convertBlankToNull(surveyData.getPermanentTown())!=null) {
					queryString.append(", perm_house_flat_no = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPermanentHouseNo())!=null) {
					queryString.append(", perm_name_of_street = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPermanentStreetName())!=null) {
					queryString.append(", perm_name_of_street = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPermanentCity())!=null) {
					queryString.append(", permanent_city_id = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPermanentMobileNo())!=null) {
					queryString.append(", perm_mobile_number = ? ");
				}
				
				if(PmayUtil.convertBlankToNull(presentInfrontHousePhotoName)!=null) {
					queryString.append(", photo_attachment_in_front_of_house = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getOwnershipHouse())!=null) {
					queryString.append(", house_ownership_id = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getGeoLatitude())!=null) {
					queryString.append(", geo_lat = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getGeoLongitude())!=null) {
					queryString.append(", geo_lon = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getHouseRoofType())!=null) {
					queryString.append(", house_type_roof_id = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getHouseWallType())!=null) {
					queryString.append(", house_type_wall_id = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getDwellinUnitRoom())!=null) {
					queryString.append(", no_room_dwelling_exc_kitchen = ? ");
				}
			
				if(PmayUtil.convertBlankToNull(surveyData.getSizeExistingDwelling())!=null) {
					queryString.append(", size_of_exist_dwell_unit_carpet_area = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getOwnsRadio())!=null) {
					queryString.append(", family_own_house_in_india = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getLandinSqm())!=null) {
					queryString.append(", if_yes_land_in_sq_m = ? ");
				}
				if(PmayUtil.convertBlankToNull(landRecordPhotoName)!=null) {
					queryString.append(", land_attachment_name = ? ");
				}
			
				
				if(PmayUtil.convertBlankToNull(surveyData.getHouseRequirementRadio())!=null) {
					queryString.append(", housing_category_id = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPattadarName())!=null) {
					queryString.append(", name_of_pattadars = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPattaNo())!=null) {
					queryString.append(", patta_number = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getDagNo())!=null) {
					queryString.append(", dag_number = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getLandAreaPatta())!=null) {
					queryString.append(", land_area_as_in_patta = ? ");
				}

				
				if(PmayUtil.convertBlankToNull(surveyData.getLandLength())!=null) {
					queryString.append(", dimension_of_land_length = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getLandBreadth())!=null) {
					queryString.append(", dimesnsion_of_land_breadth = ? ");
				}
				if(PmayUtil.convertBlankToNull(landPhoto1Name)!=null) {
					queryString.append(", land_attachment1 = ? ");
				}
				if(PmayUtil.convertBlankToNull(landPhoto2Name)!=null) {
					queryString.append(", land_attachment2 = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getEmploymentStatus())!=null) {
					queryString.append(", employement_category_id = ? ");
				}
				
				
				if(PmayUtil.convertBlankToNull(surveyData.getEmploymentStatusName())!=null) {
					queryString.append(", if_other_name = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getIncomeProof())!=null) {
					queryString.append(", average_monthly_income = ? ");
				}
				if(PmayUtil.convertBlankToNull(incomeProofPhotoName)!=null) {
					queryString.append(", income_proof_attachment = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getBplRadio())!=null) {
					queryString.append(", family_have_bpl_card = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getBplNo())!=null) {
					queryString.append(", if_yes_bpl_card_number = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getBplNo())!=null) {
					queryString.append(", if_yes_bpl_card_number = ? ");
				}
				
				if(PmayUtil.convertBlankToNull(bplPhotoName)!=null) {
					queryString.append(", bpl_card_attachment = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getRationRadio())!=null) {
					queryString.append(", family_have_ration_card = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getRationCardNo())!=null) {
					queryString.append(", if_yes_ration_card_number = ? ");
				}
				if(PmayUtil.convertBlankToNull(rationCardPhotoName)!=null) {
					queryString.append(", ration_card_attachment = ? ");
				}
			
				if(PmayUtil.convertBlankToNull(surveyData.getPreferredAssistanceHfa())!=null) {
					queryString.append(", preferred_assistance_hfa_category_id = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getBankAccNo())!=null) {
					queryString.append(", bank_account_number = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getBankId())!=null) {
					queryString.append(", bank_id = ? ");
				}
				
				if(PmayUtil.convertBlankToNull(surveyData.getBankBranchName())!=null) {
					queryString.append(", branch_name = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getBankIfscCode())!=null) {
					queryString.append(", branch_ifsc_code = ? ");
				}
				if(PmayUtil.convertBlankToNull(applicantSignatureName)!=null) {
					queryString.append(", signature_of_applicant = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getIsSubmitted())!=null) {
					queryString.append(", submitted_data = ? ");
				}
				queryString.append(", deleted_flag = ? ,last_updated_by = ?,last_updated_on = NOW()");
				
				if(PmayUtil.convertBlankToNull(surveyData.getBankName())!=null) {
					queryString.append(", bank_name = ? ");
				}
				if(PmayUtil.convertBlankToNull(surveyData.getLandAddress())!=null) {
					queryString.append(", if_yes_land_address = ? ");
				}
				
				if(biometric!=null) {
					queryString.append(", biometric_data = ? ");
				}
			
				if(PmayUtil.convertBlankToNull(surveyData.getUlbNameId())!=null) {
					queryString.append(", ulb_name_id = ? ");
				}

				if(PmayUtil.convertBlankToNull(surveyData.getLandAddress())!=null) {
					queryString.append(", if_yes_land_address = ? ");
				}

				if(PmayUtil.convertBlankToNull(surveyData.getRequirement())!=null) {
					queryString.append(", housing_requirement_name = ? ");
				}

				queryString.append(" where user_survey_id = ? ");
				
				// PreparedStatement ps = connection.prepareStatement(PmayMysqlQueries.UPDATE_SURVEY_DATA);
				PreparedStatement ps = connection.prepareStatement(queryString.toString());
				
				int col=0;
				
				ps.setString(++col, surveyData.getUserId());
				
				if(PmayUtil.convertBlankToNull(surveyData.getWardDetails())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getWardDetails()));	
				}
				
				if(PmayUtil.convertBlankToNull(surveyData.getSlumRadio())!=null) {
					ps.setString(++col, surveyData.getSlumRadio());
				}
				if(PmayUtil.convertBlankToNull(surveyData.getValidationPendingStatus())!=null) {
					ps.setString(++col, surveyData.getValidationPendingStatus());
				}
				if(PmayUtil.convertBlankToNull(surveyData.getEligibleStatus())!=null) {
					ps.setString(++col, surveyData.getEligibleStatus());
				}
				if(PmayUtil.convertBlankToNull(surveyData.getFamilyHeadName())!=null) {
					ps.setString(++col, surveyData.getFamilyHeadName());
				}
				if(PmayUtil.convertBlankToNull(surveyData.getFatherHusbandName())!=null) {
					ps.setString(++col, surveyData.getFatherHusbandName());	
				}
				if(PmayUtil.convertBlankToNull(applicantPhotoName)!=null) {
					ps.setString(++col, applicantPhotoName);
				}

				if(PmayUtil.convertBlankToNull(surveyData.getAdharNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getAdharNo()));
				}

				if(PmayUtil.convertBlankToNull(surveyData.getAdharReason())!=null) {
					ps.setString(++col, surveyData.getAdharReason());
				}
				if(PmayUtil.convertBlankToNull(surveyData.getIdType())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getIdType()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getIdNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getIdNo()));
				}
				if(PmayUtil.convertBlankToNull(idPhotoName)!=null) {
					ps.setString(++col, idPhotoName);
				}
				if(PmayUtil.convertBlankToNull(surveyData.getGenderId())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getGenderId()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getDob())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getDob()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getMaritalStatus())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getMaritalStatus()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getReligion())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getReligion()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getReligionIfOther())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getReligionIfOther()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getCaste())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getCaste()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getNonEligibleReason())!=null) {
					ps.setString(++col, surveyData.getNonEligibleReason());
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPresentTown())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getPresentTown()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPresentHouseNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getPresentHouseNo()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPresentStreetName())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getPresentStreetName()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPresentCity())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getPresentCity()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPresentMobileNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getPresentMobileNo()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getIsSameAsPresentAdd())!=null) {
					ps.setString(++col, surveyData.getIsSameAsPresentAdd());
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPermanentTown())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getPermanentTown()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPermanentHouseNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getPermanentHouseNo()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPermanentStreetName())!=null) {
					ps.setString(++col, surveyData.getPermanentStreetName());
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPermanentCity())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getPermanentCity()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPermanentMobileNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getPermanentMobileNo()));
				}
				if(PmayUtil.convertBlankToNull(presentInfrontHousePhotoName)!=null) {
					ps.setString(++col, presentInfrontHousePhotoName);
				}
				if(PmayUtil.convertBlankToNull(surveyData.getOwnershipHouse())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getOwnershipHouse()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getGeoLatitude())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getGeoLatitude())); // geo_lat
				}
				if(PmayUtil.convertBlankToNull(surveyData.getGeoLongitude())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getGeoLongitude())); // geo_lon
				}
				if(PmayUtil.convertBlankToNull(surveyData.getHouseRoofType())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getHouseRoofType()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getHouseWallType())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getHouseWallType()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getDwellinUnitRoom())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getDwellinUnitRoom()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getSizeExistingDwelling())!=null) {
					ps.setString(++col, surveyData.getSizeExistingDwelling());
				}
				if(PmayUtil.convertBlankToNull(surveyData.getOwnsRadio())!=null) {
					ps.setString(++col, surveyData.getOwnsRadio());
				}
				if(PmayUtil.convertBlankToNull(surveyData.getLandinSqm())!=null) {
					ps.setString(++col, surveyData.getLandinSqm());
				}
				if(PmayUtil.convertBlankToNull(landRecordPhotoName)!=null) {
					ps.setString(++col, landRecordPhotoName);
				}
				if(PmayUtil.convertBlankToNull(surveyData.getHouseRequirementRadio())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getHouseRequirementRadio()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPattadarName())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getPattadarName()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPattaNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getPattaNo()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getDagNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getDagNo()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getLandAreaPatta())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getLandAreaPatta()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getLandLength())!=null) {
					ps.setString(++col, surveyData.getLandLength());
				}
				if(PmayUtil.convertBlankToNull(surveyData.getLandBreadth())!=null) {
					ps.setString(++col, surveyData.getLandBreadth());
				}
				if(PmayUtil.convertBlankToNull(landPhoto1Name)!=null) {
					ps.setString(++col, landPhoto1Name);
				}
				if(PmayUtil.convertBlankToNull(landPhoto2Name)!=null) {
					ps.setString(++col, landPhoto2Name);
				}
				if(PmayUtil.convertBlankToNull(surveyData.getEmploymentStatus())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getEmploymentStatus()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getEmploymentStatusName())!=null) {
					ps.setString(++col, surveyData.getEmploymentStatusName());
				}
				if(PmayUtil.convertBlankToNull(surveyData.getIncomeProof())!=null) {
					ps.setString(++col, surveyData.getIncomeProof());
				}
				if(PmayUtil.convertBlankToNull(incomeProofPhotoName)!=null) {
					ps.setString(++col, incomeProofPhotoName);
				}
				if(PmayUtil.convertBlankToNull(surveyData.getBplRadio())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getBplRadio()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getBplNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getBplNo()));
				}
				if(PmayUtil.convertBlankToNull(bplPhotoName)!=null) {
					ps.setString(++col, bplPhotoName);
				}
				if(PmayUtil.convertBlankToNull(surveyData.getRationRadio())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getRationRadio()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getRationCardNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getRationCardNo()));
				}
				if(PmayUtil.convertBlankToNull(rationCardPhotoName)!=null) {
					ps.setString(++col, rationCardPhotoName);
				}
				if(PmayUtil.convertBlankToNull(surveyData.getPreferredAssistanceHfa())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getPreferredAssistanceHfa()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getBankAccNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getBankAccNo()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getBankId())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getBankId()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getBankBranchName())!=null) {
					ps.setString(++col, surveyData.getBankBranchName());
				}
				if(PmayUtil.convertBlankToNull(surveyData.getBankIfscCode())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getBankIfscCode()));
				}
				if(PmayUtil.convertBlankToNull(applicantSignatureName)!=null) {
					ps.setString(++col, applicantSignatureName);
				}
				if(PmayUtil.convertBlankToNull(surveyData.getIsSubmitted())!=null) {
					ps.setString(++col, surveyData.getIsSubmitted()); // submitted_data
				}
				
				ps.setString(++col, "N"); // deleted_flag
				ps.setString(++col, surveyData.getUserId()); // created_by
				
				if(PmayUtil.convertBlankToNull(surveyData.getBankName())!=null) {
					ps.setString(++col, surveyData.getBankName());
				}
				if(PmayUtil.convertBlankToNull(surveyData.getLandAddress())!=null) {
					ps.setString(++col, surveyData.getLandAddress());
				}
				if(biometric != null) {
					ps.setBinaryStream(++col, biometric);
				}
				if(PmayUtil.convertBlankToNull(surveyData.getUlbNameId())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getUlbNameId()));
				}
				if(PmayUtil.convertBlankToNull(surveyData.getRequirement())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(surveyData.getRequirement()));
				}
				
				ps.setString(++col, surveyData.getSurveyId());

				return ps;
			});
			int[] saveFamilyStatus = null;
			
			String[] familyMemberName = surveyData.getFamilyMemberName().split(",");
			String[] familyMemberRelation = surveyData.getFamilyMemberRelation().split(",");
			String[] familyMemberGender = surveyData.getFamilyMemberGender().split(",");
			String[] familyMemberAge = surveyData.getFamilyMemberAge().split(",");
			String[] familyMemberIdCardNo = surveyData.getFamilyMemberIdCardNo().split(",");
			jdbcTemplate.update(PmayMysqlQueries.DELETE_FAMILY_RELATIONSHIP_QUERY, surveyData.getSurveyId());

			saveFamilyStatus = jdbcTemplate.batchUpdate(PmayMysqlQueries.SAVE_FAMILY_RELATIONSHIP_QUERY,
					new BatchPreparedStatementSetter() {
				@Override
				public int getBatchSize() {
					return familyMemberName.length;
				}

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setString(1, surveyData.getSurveyId());
					ps.setString(2, PmayUtil.convertBlankToNull(familyMemberName[i]));
					ps.setString(3, PmayUtil.convertBlankToNull(familyMemberRelation[i]));
					ps.setString(4, PmayUtil.convertBlankToNull(familyMemberGender[i]));
					ps.setString(5, PmayUtil.convertBlankToNull(familyMemberAge[i]));
					ps.setString(6, PmayUtil.convertBlankToNull(familyMemberIdCardNo[i]));
					ps.setString(7, surveyData.getUserId());
				}
			});

			/*********** code for return value **********/

			if (surveyData.getIsSubmitted() == "Y") {
				if (saveSurveyStatus != 0 && saveFamilyStatus != null) {
					for (int i = 0; i <= saveFamilyStatus.length; i++) {
						if (saveFamilyStatus[i] != 0) {
							status = "true";
						} else {
							status = "false";
							break;
						}
					}
				} else {
					status = "false";
				}

			} else {
				if (saveSurveyStatus != 0) {
					status = "true";
				}
			}

			hmap.put("success", status);
			hmap.put("surveyId", surveyData.getSurveyId());

			ImageUpload.SaveImage(surveyData.getApplicantPhoto(), applicantPhotoName, applicantPhoto);
			ImageUpload.SaveImage(surveyData.getBplPicture(), bplPhotoName, bplCardPhoto);
			ImageUpload.SaveImage(surveyData.getIdPhoto(), idPhotoName, idProofPhoto);
			ImageUpload.SaveImage(surveyData.getIncomeProofPhoto(), incomeProofPhotoName, incomeProofPhoto);
			ImageUpload.SaveImage(surveyData.getLandPhoto2(), landPhoto1Name, landPhoto1);
			ImageUpload.SaveImage(surveyData.getLandPhoto1(), landPhoto2Name, landPhoto2);
			ImageUpload.SaveImage(surveyData.getLandRecordPic(), landRecordPhotoName, pattaPhoto);
			ImageUpload.SaveImage(surveyData.getPresentInfrontHousePic(), presentInfrontHousePhotoName,
					presentHousePhoto);
			ImageUpload.SaveImage(surveyData.getRationCardPic(), rationCardPhotoName, rationCardPhoto);
			ImageUpload.SaveImage(surveyData.getApplicantSignature(), applicantSignatureName, signature);
			return hmap;
		}
	}

	@Override
	public List<PmayWardData> getPmayWardData() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_WARD_DETAILS_QUERY, new RowMapper<PmayWardData>() {

			@Override
			public PmayWardData mapRow(ResultSet rs, int rowNum) throws SQLException {
				PmayWardData pmayWardData = new PmayWardData();
				pmayWardData.setWardId(rs.getString(1));
				pmayWardData.setWardName(rs.getString(2));
				return pmayWardData;
			}
		});
	}

	@Override
	public List<PmayReportDataForAdmins> getSurveyUserReport(String userId) {
		return jdbcTemplate.query(PmayMysqlQueries.QUERY_FOR_GET_SURVEY_USER_REPORT,
				new RowMapper<PmayReportDataForAdmins>() {
			@Override
			public PmayReportDataForAdmins mapRow(ResultSet rs, int rowNum) throws SQLException {
				PmayReportDataForAdmins surveyReportData = new PmayReportDataForAdmins();
				surveyReportData.setUserSurveyId(rs.getString(1));
				surveyReportData.setUserId(rs.getString(2));
				surveyReportData.setWardId(rs.getString(3));
				surveyReportData.setWardName(rs.getString(4));
				surveyReportData.setSlumNonSlum(rs.getString(5));
				surveyReportData.setValidationPendingNonSlum(rs.getString(6));
				surveyReportData.setEligibilityForScheme(rs.getString(7));
				surveyReportData.setFamilyHead(rs.getString(8));
				surveyReportData.setFatherOrHusbandName(rs.getString(9));
				surveyReportData.setPhotoAttachmentName(rs.getString(10));
				surveyReportData.setAadharCardNumber(rs.getString(11));
				surveyReportData.setReasonforAAdharNotAvailable(rs.getString(12));
				surveyReportData.setIdTypeId(rs.getString(13));
				surveyReportData.setIdTypeName(rs.getString(14));
				surveyReportData.setIdNumber(rs.getString(15));
				surveyReportData.setIdAttachmentName(rs.getString(16));
				surveyReportData.setGenderId(rs.getString(17));
				surveyReportData.setGenderName(rs.getString(18));
				surveyReportData.setDob(rs.getString(19));
				surveyReportData.setAge(rs.getString(20));
				surveyReportData.setMaritalStatusId(rs.getString(21));
				surveyReportData.setMaritalStatusName(rs.getString(22));
				surveyReportData.setReligionId(rs.getString(23));
				surveyReportData.setReligionName(rs.getString(24));
				surveyReportData.setReligionIfOther(rs.getString(25));
				surveyReportData.setCasteId(rs.getString(26));
				surveyReportData.setCasteName(rs.getString(27));
				surveyReportData.setReasonForNonEligibility(rs.getString(28));
				surveyReportData.setNoOfYearsOfStayPresent(rs.getString(29));
				surveyReportData.setPresentHouseFlatNo(rs.getString(30));
				surveyReportData.setPresentNameOfStreet(rs.getString(31));
				surveyReportData.setPresentCityId(rs.getString(32));
				surveyReportData.setPresentCityName(rs.getString(33));
				surveyReportData.setPresentMobNo(rs.getString(34));
				surveyReportData.setPermanentSameAsPresent(rs.getString(35));
				surveyReportData.setNoOfYearsOfStayPermanent(rs.getString(36));
				surveyReportData.setPermanentHouseFlatNo(rs.getString(37));
				surveyReportData.setPermanentNameOfStreet(rs.getString(38));
				surveyReportData.setPermanentCityId(rs.getString(39));
				surveyReportData.setPermanentCityName(rs.getString(40));
				surveyReportData.setPermanentMobileNo(rs.getString(41));
				surveyReportData.setPhotoAttachmentInFrontOfHouse(rs.getString(42));
				surveyReportData.setHouseOwnershipId(rs.getString(43));
				surveyReportData.setGeoLatitude(rs.getString(44));
				surveyReportData.setGeoLongitude(rs.getString(45));
				surveyReportData.setHouseTypeRoofId(rs.getString(46));
				surveyReportData.setHouseTypeRoofName(rs.getString(47));
				surveyReportData.setHouseTypeWallId(rs.getString(48));
				surveyReportData.setHouseTypeWallName(rs.getString(49));
				surveyReportData.setNoOfRoomDwellingexceptKitchen(rs.getString(50));
				surveyReportData.setSizeOfDwellUnitCarpetArea(rs.getString(51));
				surveyReportData.setFamilyOwnHouseInIndia(rs.getString(52));
				surveyReportData.setIndiaLocationDetailsAttachment(rs.getString(53));
				surveyReportData.setIndiaLandInSquareMeter(rs.getString(54));
				surveyReportData.setLandAttachmentName(rs.getString(55));
				surveyReportData.setHousingCategoryId(rs.getString(56));
				surveyReportData.setHouseRequirementName(rs.getString(57));
				surveyReportData.setNameOfPattadars(rs.getString(58));
				surveyReportData.setPattaNumber(rs.getString(59));
				surveyReportData.setDagNumber(rs.getString(60));
				surveyReportData.setLandAreaAsInPatta(rs.getString(61));
				surveyReportData.setDimentionOfLandLength(rs.getString(62));
				surveyReportData.setDimensionOfLandbreadth(rs.getString(63));
				surveyReportData.setLandAttachment1(rs.getString(64));
				surveyReportData.setLandAttachment2(rs.getString(65));
				surveyReportData.setEmployementCategoryId(rs.getString(66));
				surveyReportData.setEmployementCategoryName(rs.getString(67));
				surveyReportData.setIfOtherCategoryName(rs.getString(68));
				surveyReportData.setIncomeProofDocName(rs.getString(69));
				surveyReportData.setIncomeProofAttachment(rs.getString(70));
				surveyReportData.setFamilyHaveBplCard(rs.getString(71));
				surveyReportData.setBplCardNumber(rs.getString(72));
				surveyReportData.setBplCardAttachment(rs.getString(73));
				surveyReportData.setFamilyHaveRationCard(rs.getString(74));
				surveyReportData.setRationCardNumber(rs.getString(75));
				surveyReportData.setRationCardAttachment(rs.getString(76));
				surveyReportData.setHfaCategoryId(rs.getString(77));
				surveyReportData.setHfaCategoryName(rs.getString(78));
				surveyReportData.setBankAccountNo(rs.getString(79));
				surveyReportData.setBankName(rs.getString(80));
				surveyReportData.setBranchName(rs.getString(81));
				surveyReportData.setBranchIfscCode(rs.getString(82));
				surveyReportData.setSignatureOfApplicant(rs.getString(83));
				surveyReportData.setSubmittedData(rs.getString(84));
				surveyReportData.setNameOfFamilyMember(rs.getString(85));
				surveyReportData.setRelationshipId(rs.getString(86));
				surveyReportData.setRelationshipName(rs.getString(87));
				surveyReportData.setFamilyGenderId(rs.getString(88));
				surveyReportData.setFamilyGenderName(rs.getString(89));
				surveyReportData.setAgeOfFamilyMember(rs.getString(90));
				surveyReportData.setFamilyMemberIdCardNumber(rs.getString(91));
				surveyReportData.setBankId(rs.getString(93));
				surveyReportData.setOtherBankName(rs.getString(94));
				surveyReportData.setLandAddress(rs.getString(95));
				surveyReportData.setUlbNameId(rs.getString(96));
				surveyReportData.setUlbName(rs.getString(97));
				surveyReportData.setUserRMN(rs.getString(98));

				if (PmayUtil.chkNull(surveyReportData.getSlumNonSlum()).equalsIgnoreCase("S")) {
					surveyReportData.setSlumNonSlumStatus("Slum");
				} else if (PmayUtil.chkNull(surveyReportData.getSlumNonSlum()).equalsIgnoreCase("N")) {
					surveyReportData.setSlumNonSlumStatus("Non-Slum");
				}

				if (PmayUtil.chkNull(surveyReportData.getEligibilityForScheme()).equalsIgnoreCase("Y")) {
					surveyReportData.setEligibleStatus("Eligible");
				} else if (PmayUtil.chkNull(surveyReportData.getEligibilityForScheme()).equalsIgnoreCase("N")) {
					surveyReportData.setEligibleStatus("Not-Eligible");
				}

				if (PmayUtil.chkNull(surveyReportData.getValidationPendingNonSlum()).equalsIgnoreCase("Y")) {
					surveyReportData.setValidationPendingStatus("Yes");
				} else if (PmayUtil.chkNull(surveyReportData.getValidationPendingNonSlum())
						.equalsIgnoreCase("N")) {
					surveyReportData.setValidationPendingStatus("No");
				}

				return surveyReportData;
			}
		}, userId);
	}

	@Override
	public List<PmayHouseCategoryData> getHouseCategoryData() {
		return jdbcTemplate.query(PmayMysqlQueries.HOUSE_CATEGORY_DETAILS_QUERY,
				new RowMapper<PmayHouseCategoryData>() {

			@Override
			public PmayHouseCategoryData mapRow(ResultSet rs, int rowNum) throws SQLException {
				PmayHouseCategoryData pmayHouseCategoryData = new PmayHouseCategoryData();
				pmayHouseCategoryData.setHouseCategoryId(rs.getString(1));
				pmayHouseCategoryData.setHouseCategoryName(rs.getString(2));
				return pmayHouseCategoryData;
			}
		});
	}

	private static boolean isNotSpace(String input) {
		return !input.equals("");
	}

	@Override
	public List<PmayReportDataForAdmins> getFilteredReportBySearchForAdmins(PmaySeachData seachDetails) {
		StringBuilder queryToGetAdminReportBySearchData = new StringBuilder(
				PmayMysqlQueries.QUERY_FOR_GET_ADMINS_SURVEY_REPORT.replace(" GROUP BY pus.user_survey_id", ""));

		if (seachDetails.getSearchName() != null && isNotSpace(seachDetails.getSearchName())) {
			queryToGetAdminReportBySearchData
			.append(" and pus.family_head_name like '" + seachDetails.getSearchName() + "%'");
		}

		if (seachDetails.getAadharOrIdNumber() != null && isNotSpace(seachDetails.getAadharOrIdNumber())) {
			queryToGetAdminReportBySearchData
			.append(" and '" + seachDetails.getAadharOrIdNumber() + "' in (pus.aadhar_card_no, pus.id_number)");
		}
		if (seachDetails.getUlbName() != null && isNotSpace(seachDetails.getUlbName())) {
			queryToGetAdminReportBySearchData.append(" and pun.ulb_name like '" + seachDetails.getUlbName() + "%'");
		}
		if (seachDetails.getFatherSpouseName() != null && isNotSpace(seachDetails.getFatherSpouseName())) {
			queryToGetAdminReportBySearchData
			.append(" and pus.father_husband_name like '" + seachDetails.getFatherSpouseName() + "%'");
		}
		if (seachDetails.getBankAccountNo() != null && isNotSpace(seachDetails.getBankAccountNo())) {
			queryToGetAdminReportBySearchData
			.append(" and pus.bank_account_number = '" + seachDetails.getBankAccountNo() + "'");
		}

		if (seachDetails.getSearchScopeName() != null && seachDetails.getSearchScopeValue() != null
				&& isNotSpace(seachDetails.getSearchScopeValue())) {
			queryToGetAdminReportBySearchData.append(
					" and " + seachDetails.getSearchScopeName() + " = '" + seachDetails.getSearchScopeValue() + "'");
		}

		queryToGetAdminReportBySearchData.append(" GROUP BY pus.user_survey_id");

		return jdbcTemplate.query(queryToGetAdminReportBySearchData.toString(),
				new RowMapper<PmayReportDataForAdmins>() {
			@Override
			public PmayReportDataForAdmins mapRow(ResultSet rs, int rownumber) throws SQLException {
				PmayReportDataForAdmins surveyReportData = new PmayReportDataForAdmins();
				surveyReportData.setUserSurveyId(rs.getString(1));
				surveyReportData.setUserId(rs.getString(2));
				surveyReportData.setWardId(rs.getString(3));
				surveyReportData.setWardName(rs.getString(4));
				surveyReportData.setSlumNonSlum(rs.getString(5));
				surveyReportData.setValidationPendingNonSlum(rs.getString(6));
				surveyReportData.setEligibilityForScheme(rs.getString(7));
				surveyReportData.setFamilyHead(rs.getString(8));
				surveyReportData.setFatherOrHusbandName(rs.getString(9));
				surveyReportData.setPhotoAttachmentName(rs.getString(10));
				surveyReportData.setAadharCardNumber(rs.getString(11));
				surveyReportData.setReasonforAAdharNotAvailable(rs.getString(12));
				surveyReportData.setIdTypeId(rs.getString(13));
				surveyReportData.setIdTypeName(rs.getString(14));
				surveyReportData.setIdNumber(rs.getString(15));
				surveyReportData.setIdAttachmentName(rs.getString(16));
				surveyReportData.setGenderId(rs.getString(17));
				surveyReportData.setGenderName(rs.getString(18));
				surveyReportData.setDob(rs.getString(19));
				surveyReportData.setAge(rs.getString(20));
				surveyReportData.setMaritalStatusId(rs.getString(21));
				surveyReportData.setMaritalStatusName(rs.getString(22));
				surveyReportData.setReligionId(rs.getString(23));
				surveyReportData.setReligionName(rs.getString(24));
				surveyReportData.setReligionIfOther(rs.getString(25));
				surveyReportData.setCasteId(rs.getString(26));
				surveyReportData.setCasteName(rs.getString(27));
				surveyReportData.setReasonForNonEligibility(rs.getString(28));
				surveyReportData.setNoOfYearsOfStayPresent(rs.getString(29));
				surveyReportData.setPresentHouseFlatNo(rs.getString(30));
				surveyReportData.setPresentNameOfStreet(rs.getString(31));
				surveyReportData.setPresentCityId(rs.getString(32));
				surveyReportData.setPresentCityName(rs.getString(33));
				surveyReportData.setPresentMobNo(rs.getString(34));
				surveyReportData.setPermanentSameAsPresent(rs.getString(35));
				surveyReportData.setNoOfYearsOfStayPermanent(rs.getString(36));
				surveyReportData.setPermanentHouseFlatNo(rs.getString(37));
				surveyReportData.setPermanentNameOfStreet(rs.getString(38));
				surveyReportData.setPermanentCityId(rs.getString(39));
				surveyReportData.setPermanentCityName(rs.getString(40));
				surveyReportData.setPermanentMobileNo(rs.getString(41));
				surveyReportData.setPhotoAttachmentInFrontOfHouse(rs.getString(42));
				surveyReportData.setHouseOwnershipId(rs.getString(43));
				surveyReportData.setGeoLatitude(rs.getString(44));
				surveyReportData.setGeoLongitude(rs.getString(45));
				surveyReportData.setHouseTypeRoofId(rs.getString(46));
				surveyReportData.setHouseTypeRoofName(rs.getString(47));
				surveyReportData.setHouseTypeWallId(rs.getString(48));
				surveyReportData.setHouseTypeWallName(rs.getString(49));
				surveyReportData.setNoOfRoomDwellingexceptKitchen(rs.getString(50));
				surveyReportData.setSizeOfDwellUnitCarpetArea(rs.getString(51));
				surveyReportData.setFamilyOwnHouseInIndia(rs.getString(52));
				surveyReportData.setIndiaLocationDetailsAttachment(rs.getString(53));
				surveyReportData.setIndiaLandInSquareMeter(rs.getString(54));
				surveyReportData.setLandAttachmentName(rs.getString(55));
				surveyReportData.setHousingCategoryId(rs.getString(56));
				surveyReportData.setHouseRequirementName(rs.getString(57));
				surveyReportData.setNameOfPattadars(rs.getString(58));
				surveyReportData.setPattaNumber(rs.getString(59));
				surveyReportData.setDagNumber(rs.getString(60));
				surveyReportData.setLandAreaAsInPatta(rs.getString(61));
				surveyReportData.setDimentionOfLandLength(rs.getString(62));
				surveyReportData.setDimensionOfLandbreadth(rs.getString(63));
				surveyReportData.setLandAttachment1(rs.getString(64));
				surveyReportData.setLandAttachment2(rs.getString(65));
				surveyReportData.setEmployementCategoryId(rs.getString(66));
				surveyReportData.setEmployementCategoryName(rs.getString(67));
				surveyReportData.setIfOtherCategoryName(rs.getString(68));
				surveyReportData.setIncomeProofDocName(rs.getString(69));
				surveyReportData.setIncomeProofAttachment(rs.getString(70));
				surveyReportData.setFamilyHaveBplCard(rs.getString(71));
				surveyReportData.setBplCardNumber(rs.getString(72));
				surveyReportData.setBplCardAttachment(rs.getString(73));
				surveyReportData.setFamilyHaveRationCard(rs.getString(74));
				surveyReportData.setRationCardNumber(rs.getString(75));
				surveyReportData.setRationCardAttachment(rs.getString(76));
				surveyReportData.setHfaCategoryId(rs.getString(77));
				surveyReportData.setHfaCategoryName(rs.getString(78));
				surveyReportData.setBankAccountNo(rs.getString(79));
				surveyReportData.setBankName(rs.getString(80));
				surveyReportData.setBranchName(rs.getString(81));
				surveyReportData.setBranchIfscCode(rs.getString(82));
				surveyReportData.setSignatureOfApplicant(rs.getString(83));
				surveyReportData.setSubmittedData(rs.getString(84));
				surveyReportData.setNameOfFamilyMember(rs.getString(85));
				surveyReportData.setRelationshipId(rs.getString(86));
				surveyReportData.setRelationshipName(rs.getString(87));
				surveyReportData.setFamilyGenderId(rs.getString(88));
				surveyReportData.setFamilyGenderName(rs.getString(89));
				surveyReportData.setAgeOfFamilyMember(rs.getString(90));
				surveyReportData.setFamilyMemberIdCardNumber(rs.getString(91));
				surveyReportData.setBankId(rs.getString(93));
				surveyReportData.setOtherBankName(rs.getString(94));
				surveyReportData.setLandAddress(rs.getString(95));
				surveyReportData.setUlbNameId(rs.getString(96));
				surveyReportData.setUlbName(rs.getString(97));
				surveyReportData.setUserRMN(rs.getString(98));

				if (PmayUtil.chkNull(surveyReportData.getSlumNonSlum()).equalsIgnoreCase("S")) {
					surveyReportData.setSlumNonSlumStatus("Slum");
				} else if (PmayUtil.chkNull(surveyReportData.getSlumNonSlum()).equalsIgnoreCase("N")) {
					surveyReportData.setSlumNonSlumStatus("Non-Slum");
				}

				if (PmayUtil.chkNull(surveyReportData.getEligibilityForScheme()).equalsIgnoreCase("Y")) {
					surveyReportData.setEligibleStatus("Eligible");
				} else if (PmayUtil.chkNull(surveyReportData.getEligibilityForScheme()).equalsIgnoreCase("N")) {
					surveyReportData.setEligibleStatus("Not-Eligible");
				}

				if (PmayUtil.chkNull(surveyReportData.getValidationPendingNonSlum()).equalsIgnoreCase("Y")) {
					surveyReportData.setValidationPendingStatus("Yes");
				} else if (PmayUtil.chkNull(surveyReportData.getValidationPendingNonSlum())
						.equalsIgnoreCase("N")) {
					surveyReportData.setValidationPendingStatus("No");
				}

				return surveyReportData;
			}
		});

	}

	@Override
	public List<PmaySurveyReportData> getFilteredReportForSuperUser(PmaySeachData seachDetails) {
		StringBuilder queryToGetSuperUserReportBySearchData = new StringBuilder(
				PmayMysqlQueries.QUERY_FOR_GET_SUPER_USER_REPORT);

		if (seachDetails.getSeachCity() != null) {
			queryToGetSuperUserReportBySearchData.append(" and pus.present_city_id =" + seachDetails.getSeachCity());
		}
		if (seachDetails.getAadharOrIdNumber() != null) {
			queryToGetSuperUserReportBySearchData
			.append(" and pus.aadhar_card_no =" + seachDetails.getAadharOrIdNumber());
		}
		if (seachDetails.getMobileNumber() != null) {
			queryToGetSuperUserReportBySearchData.append(" and pus.contact_number =" + seachDetails.getMobileNumber());
		}
		if (seachDetails.getSearchName() != null) {
			queryToGetSuperUserReportBySearchData
			.append(" and pus.family_head_name like '" + seachDetails.getSearchName() + "%'");
		}
		if (seachDetails.getSearchWard() != null) {
			queryToGetSuperUserReportBySearchData.append(" and pus.ward_id =" + seachDetails.getSearchWard());
		}
		if (seachDetails.getSearchMissionComponent() != null) {
			queryToGetSuperUserReportBySearchData.append(
					" and pus.preferred_assistance_hfa_category_id =" + seachDetails.getSearchMissionComponent());
		}
		if (seachDetails.getBankId() != null) {
			queryToGetSuperUserReportBySearchData.append(" and pus.bank_id =" + seachDetails.getBankId());
		}

		return jdbcTemplate.query(queryToGetSuperUserReportBySearchData.toString(),
				new RowMapper<PmaySurveyReportData>() {
			@Override
			public PmaySurveyReportData mapRow(ResultSet rs, int rowNum) throws SQLException {
				PmaySurveyReportData superUserReportData = new PmaySurveyReportData();
				superUserReportData.setUserSurveyId(rs.getString(1));
				superUserReportData.setUserId(rs.getString(2));
				superUserReportData.setUserName(rs.getString(3));
				superUserReportData.setUserFatherName(rs.getString(4));
				superUserReportData.setUserGender(rs.getString(5));
				superUserReportData.setUserAge(rs.getString(6));
				superUserReportData.setMaritalStatus(rs.getString(7));
				superUserReportData.setReligion(rs.getString(8));
				superUserReportData.setCaste(rs.getString(9));
				superUserReportData.setAdharNumber(rs.getString(10));
				superUserReportData.setIdType(rs.getString(11));
				superUserReportData.setIdNumber(rs.getString(12));

				return superUserReportData;
			}

		});

	}

	@Override
	public List<PmayReportDataForAdmins> getFilteredReportForsurveyorUser(PmaySeachData seachDetails) {
		StringBuilder queryToGetsurveyorUserReportBySearchData = new StringBuilder(
				PmayMysqlQueries.QUERY_FOR_GET_SURVEY_USER_REPORT.replace(" GROUP BY pus.user_survey_id", ""));

		if(seachDetails!=null) {
			if (seachDetails.getSearchName() != null && isNotSpace(seachDetails.getSearchName())) {
				queryToGetsurveyorUserReportBySearchData
				.append(" and pus.family_head_name like '" + seachDetails.getSearchName() + "%'");
			}

			if (seachDetails.getAadharOrIdNumber() != null && isNotSpace(seachDetails.getAadharOrIdNumber())) {
				queryToGetsurveyorUserReportBySearchData
				.append(" and '" + seachDetails.getAadharOrIdNumber() + "' in (pus.aadhar_card_no, pus.id_number)");
			}
			if (seachDetails.getUlbName() != null && isNotSpace(seachDetails.getUlbName())) {
				queryToGetsurveyorUserReportBySearchData
				.append(" and pun.ulb_name like '" + seachDetails.getUlbName() + "%'");
			}
			if (seachDetails.getFatherSpouseName() != null && isNotSpace(seachDetails.getFatherSpouseName())) {
				queryToGetsurveyorUserReportBySearchData
				.append(" and pus.father_husband_name like '" + seachDetails.getFatherSpouseName() + "%'");
			}
			if (seachDetails.getBankAccountNo() != null && isNotSpace(seachDetails.getBankAccountNo())) {
				queryToGetsurveyorUserReportBySearchData
				.append(" and pus.bank_account_number = '" + seachDetails.getBankAccountNo() + "'");
			}

			if (seachDetails.getSearchScopeName() != null && seachDetails.getSearchScopeValue() != null
					&& isNotSpace(seachDetails.getSearchScopeValue())) {
				queryToGetsurveyorUserReportBySearchData.append(
						" and " + seachDetails.getSearchScopeName() + " = '" + seachDetails.getSearchScopeValue() + "'");
			}
		}
		queryToGetsurveyorUserReportBySearchData.append(" GROUP BY pus.user_survey_id");

		return jdbcTemplate.query(queryToGetsurveyorUserReportBySearchData.toString(),
				new RowMapper<PmayReportDataForAdmins>() {
			@Override
			public PmayReportDataForAdmins mapRow(ResultSet rs, int rowNum) throws SQLException {
				PmayReportDataForAdmins surveyReportData = new PmayReportDataForAdmins();
				surveyReportData.setUserSurveyId(rs.getString(1));
				surveyReportData.setUserId(rs.getString(2));
				surveyReportData.setWardId(rs.getString(3));
				surveyReportData.setWardName(rs.getString(4));
				surveyReportData.setSlumNonSlum(rs.getString(5));
				surveyReportData.setValidationPendingNonSlum(rs.getString(6));
				surveyReportData.setEligibilityForScheme(rs.getString(7));
				surveyReportData.setFamilyHead(rs.getString(8));
				surveyReportData.setFatherOrHusbandName(rs.getString(9));
				surveyReportData.setPhotoAttachmentName(rs.getString(10));
				surveyReportData.setAadharCardNumber(rs.getString(11));
				surveyReportData.setReasonforAAdharNotAvailable(rs.getString(12));
				surveyReportData.setIdTypeId(rs.getString(13));
				surveyReportData.setIdTypeName(rs.getString(14));
				surveyReportData.setIdNumber(rs.getString(15));
				surveyReportData.setIdAttachmentName(rs.getString(16));
				surveyReportData.setGenderId(rs.getString(17));
				surveyReportData.setGenderName(rs.getString(18));
				surveyReportData.setDob(rs.getString(19));
				surveyReportData.setAge(rs.getString(20));
				surveyReportData.setMaritalStatusId(rs.getString(21));
				surveyReportData.setMaritalStatusName(rs.getString(22));
				surveyReportData.setReligionId(rs.getString(23));
				surveyReportData.setReligionName(rs.getString(24));
				surveyReportData.setReligionIfOther(rs.getString(25));
				surveyReportData.setCasteId(rs.getString(26));
				surveyReportData.setCasteName(rs.getString(27));
				surveyReportData.setReasonForNonEligibility(rs.getString(28));
				surveyReportData.setNoOfYearsOfStayPresent(rs.getString(29));
				surveyReportData.setPresentHouseFlatNo(rs.getString(30));
				surveyReportData.setPresentNameOfStreet(rs.getString(31));
				surveyReportData.setPresentCityId(rs.getString(32));
				surveyReportData.setPresentCityName(rs.getString(33));
				surveyReportData.setPresentMobNo(rs.getString(34));
				surveyReportData.setPermanentSameAsPresent(rs.getString(35));
				surveyReportData.setNoOfYearsOfStayPermanent(rs.getString(36));
				surveyReportData.setPermanentHouseFlatNo(rs.getString(37));
				surveyReportData.setPermanentNameOfStreet(rs.getString(38));
				surveyReportData.setPermanentCityId(rs.getString(39));
				surveyReportData.setPermanentCityName(rs.getString(40));
				surveyReportData.setPermanentMobileNo(rs.getString(41));
				surveyReportData.setPhotoAttachmentInFrontOfHouse(rs.getString(42));
				surveyReportData.setHouseOwnershipId(rs.getString(43));
				surveyReportData.setGeoLatitude(rs.getString(44));
				surveyReportData.setGeoLongitude(rs.getString(45));
				surveyReportData.setHouseTypeRoofId(rs.getString(46));
				surveyReportData.setHouseTypeRoofName(rs.getString(47));
				surveyReportData.setHouseTypeWallId(rs.getString(48));
				surveyReportData.setHouseTypeWallName(rs.getString(49));
				surveyReportData.setNoOfRoomDwellingexceptKitchen(rs.getString(50));
				surveyReportData.setSizeOfDwellUnitCarpetArea(rs.getString(51));
				surveyReportData.setFamilyOwnHouseInIndia(rs.getString(52));
				surveyReportData.setIndiaLocationDetailsAttachment(rs.getString(53));
				surveyReportData.setIndiaLandInSquareMeter(rs.getString(54));
				surveyReportData.setLandAttachmentName(rs.getString(55));
				surveyReportData.setHousingCategoryId(rs.getString(56));
				surveyReportData.setHouseRequirementName(rs.getString(57));
				surveyReportData.setNameOfPattadars(rs.getString(58));
				surveyReportData.setPattaNumber(rs.getString(59));
				surveyReportData.setDagNumber(rs.getString(60));
				surveyReportData.setLandAreaAsInPatta(rs.getString(61));
				surveyReportData.setDimentionOfLandLength(rs.getString(62));
				surveyReportData.setDimensionOfLandbreadth(rs.getString(63));
				surveyReportData.setLandAttachment1(rs.getString(64));
				surveyReportData.setLandAttachment2(rs.getString(65));
				surveyReportData.setEmployementCategoryId(rs.getString(66));
				surveyReportData.setEmployementCategoryName(rs.getString(67));
				surveyReportData.setIfOtherCategoryName(rs.getString(68));
				surveyReportData.setIncomeProofDocName(rs.getString(69));
				surveyReportData.setIncomeProofAttachment(rs.getString(70));
				surveyReportData.setFamilyHaveBplCard(rs.getString(71));
				surveyReportData.setBplCardNumber(rs.getString(72));
				surveyReportData.setBplCardAttachment(rs.getString(73));
				surveyReportData.setFamilyHaveRationCard(rs.getString(74));
				surveyReportData.setRationCardNumber(rs.getString(75));
				surveyReportData.setRationCardAttachment(rs.getString(76));
				surveyReportData.setHfaCategoryId(rs.getString(77));
				surveyReportData.setHfaCategoryName(rs.getString(78));
				surveyReportData.setBankAccountNo(rs.getString(79));
				surveyReportData.setBankName(rs.getString(80));
				surveyReportData.setBranchName(rs.getString(81));
				surveyReportData.setBranchIfscCode(rs.getString(82));
				surveyReportData.setSignatureOfApplicant(rs.getString(83));
				surveyReportData.setSubmittedData(rs.getString(84));
				surveyReportData.setNameOfFamilyMember(rs.getString(85));
				surveyReportData.setRelationshipId(rs.getString(86));
				surveyReportData.setRelationshipName(rs.getString(87));
				surveyReportData.setFamilyGenderId(rs.getString(88));
				surveyReportData.setFamilyGenderName(rs.getString(89));
				surveyReportData.setAgeOfFamilyMember(rs.getString(90));
				surveyReportData.setFamilyMemberIdCardNumber(rs.getString(91));
				surveyReportData.setBankId(rs.getString(93));
				surveyReportData.setOtherBankName(rs.getString(94));
				surveyReportData.setLandAddress(rs.getString(95));
				surveyReportData.setUlbNameId(rs.getString(96));
				surveyReportData.setUlbName(rs.getString(97));
				surveyReportData.setUserRMN(rs.getString(98));

				if (PmayUtil.chkNull(surveyReportData.getSlumNonSlum()).equalsIgnoreCase("S")) {
					surveyReportData.setSlumNonSlumStatus("Slum");
				} else if (PmayUtil.chkNull(surveyReportData.getSlumNonSlum()).equalsIgnoreCase("N")) {
					surveyReportData.setSlumNonSlumStatus("Non-Slum");
				}

				if (PmayUtil.chkNull(surveyReportData.getEligibilityForScheme()).equalsIgnoreCase("Y")) {
					surveyReportData.setEligibleStatus("Eligible");
				} else if (PmayUtil.chkNull(surveyReportData.getEligibilityForScheme()).equalsIgnoreCase("N")) {
					surveyReportData.setEligibleStatus("Not-Eligible");
				}

				if (PmayUtil.chkNull(surveyReportData.getValidationPendingNonSlum()).equalsIgnoreCase("Y")) {
					surveyReportData.setValidationPendingStatus("Yes");
				} else if (PmayUtil.chkNull(surveyReportData.getValidationPendingNonSlum())
						.equalsIgnoreCase("N")) {
					surveyReportData.setValidationPendingStatus("No");
				}
				return surveyReportData;

			}

		}, seachDetails.getUserId());
	}

	/*****************************
	 * slum add survey data
	 *******************************/
	@Override
	public Map<String, String> addSlumSurvey(PmaySlumAddData pmayAddSurveyData) {
		final String slumApplicantSignatureName;
		final String slumLocationDetailsPicName;
		final String slumIdProofPhoto;
		final String slumApplicantPhoto;
		biometric =null;

		String status = "false";
		HashMap<String, String> hmap = new HashMap<>();
		
		System.out.println("familynamedaoimpl>>>" + pmayAddSurveyData.getFamilyMemberName());
		if (PmayUtil.chkNull(pmayAddSurveyData.getSurveyId()).equalsIgnoreCase("0.0")
				|| pmayAddSurveyData.getSurveyId().equalsIgnoreCase("0")
				|| PmayUtil.chkNull(pmayAddSurveyData.getSurveyId()).equals("")) {
			
			String maxId = "SELECT IF(MAX(user_survey_id) IS NULL,1,MAX(user_survey_id+1)) AS user_survey_id FROM p_user_survey";
			int nextUserSurveyid = jdbcTemplate.queryForObject(maxId, Integer.class);
			String imageName = Integer.toString(nextUserSurveyid) + "_";

			if (pmayAddSurveyData.getSlumApplicantSignature() != null) {
				slumApplicantSignatureName = imageName + "applicantSignature"
						+ pmayAddSurveyData.getSlumApplicantSignature().getOriginalFilename().substring(
								pmayAddSurveyData.getSlumApplicantSignature().getOriginalFilename().lastIndexOf("."),
								pmayAddSurveyData.getSlumApplicantSignature().getOriginalFilename().length());
			}else {
				hmap.put("message","Applicant Signature Name is missing");
				hmap.put("success", status);
				return hmap;
			}
				
			if (pmayAddSurveyData.getSlumLocationDetailsPic() != null) {
				slumLocationDetailsPicName = imageName + "landRecordPhoto"
						+ pmayAddSurveyData.getSlumLocationDetailsPic().getOriginalFilename().substring(
								pmayAddSurveyData.getSlumLocationDetailsPic().getOriginalFilename().lastIndexOf("."),
								pmayAddSurveyData.getSlumLocationDetailsPic().getOriginalFilename().length());
			}else {
				slumLocationDetailsPicName=null;
			}
				
			if (pmayAddSurveyData.getSlumBiometricDetails() != null) {
				biometric = new ByteArrayInputStream(pmayAddSurveyData.getSlumBiometricDetails());
			}
			if (pmayAddSurveyData.getSlumIdImage() != null) {
				slumIdProofPhoto = imageName + "idProofPhoto"
						+ pmayAddSurveyData.getSlumIdImage().getOriginalFilename().substring(
								pmayAddSurveyData.getSlumIdImage().getOriginalFilename().lastIndexOf("."),
								pmayAddSurveyData.getSlumIdImage().getOriginalFilename().length());
			}else {
				slumIdProofPhoto=null;
			}
			
			if (pmayAddSurveyData.getSlumApplicantPhoto() != null) {
				slumApplicantPhoto = imageName + "slumApplicantPhoto"
						+ pmayAddSurveyData.getSlumApplicantPhoto().getOriginalFilename().substring(
								pmayAddSurveyData.getSlumApplicantPhoto().getOriginalFilename().lastIndexOf("."),
								pmayAddSurveyData.getSlumApplicantPhoto().getOriginalFilename().length());
			}else {
				hmap.put("message","Applicant Photo is missing");
				hmap.put("success", status);
				return hmap;
			}

			int saveSlumStatus = jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(PmayMysqlQueries.SAVE_SLUM_SURVEY_REPORT);

				ps.setInt(1, nextUserSurveyid);
				ps.setString(2, pmayAddSurveyData.getUserId());
				ps.setString(3, PmayUtil.convertBlankToNull(pmayAddSurveyData.getChckSlumRadio()));
				ps.setString(4, pmayAddSurveyData.getSlumFamilyHeadName());
				ps.setString(5, pmayAddSurveyData.getSlumFatherHusbandName());
				ps.setString(6, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumAdharNo()));
				ps.setString(7, pmayAddSurveyData.getSlumAdharReason());
				ps.setString(8, PmayUtil.convertBlankToNull(pmayAddSurveyData.getGenderValue()));

				ps.setString(9, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPresentTown()));
				ps.setString(10, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPresentHouseNo()));
				ps.setString(11, pmayAddSurveyData.getSlumPresentStreetName());
				ps.setString(12, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPresentCity()));
				ps.setString(13, PmayUtil.convertBlankToNull(pmayAddSurveyData.getPresentMobileNo()));
				ps.setString(14, pmayAddSurveyData.getSlumIsSameAsPresentAdd());
				ps.setString(15, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentTown()));
				ps.setString(16, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentHouseNo()));
				ps.setString(17, pmayAddSurveyData.getSlumPermanentStreetName());
				ps.setString(18, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentCity()));
				ps.setString(19, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentMobileNo()));

				ps.setString(20, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumReligion()));
				ps.setString(21, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumCaste()));
				ps.setString(22, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumOwnsRadio()));
				ps.setString(23, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumLandinSqm()));
				ps.setString(24, slumApplicantSignatureName);
				ps.setString(25, slumLocationDetailsPicName);
				ps.setString(26, PmayUtil.convertBlankToNull(pmayAddSurveyData.getEligibleStatus()));
				ps.setString(27, pmayAddSurveyData.getNonEligibleReason());
				ps.setString(28, PmayUtil.convertBlankToNull(pmayAddSurveyData.getWardDetails()));
				ps.setString(29, "N");
				ps.setString(30, "N");
				ps.setString(31, pmayAddSurveyData.getIsSubmittedFlag());
				ps.setString(32, "N");
				ps.setString(33, pmayAddSurveyData.getUserId());
				ps.setString(35, pmayAddSurveyData.getSlumLandAddress());
				ps.setBinaryStream(34, biometric);
				ps.setString(35, pmayAddSurveyData.getSlumLandAddress());
				ps.setString(36, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumIdProof()));
				ps.setString(37, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumIdProofNo()));
				ps.setString(38, slumIdProofPhoto);
				ps.setString(39, PmayUtil.convertBlankToNull(pmayAddSurveyData.getUlbNameId()));
				ps.setString(40, PmayUtil.convertBlankToNull(pmayAddSurveyData.getMaritalStatus()));
				ps.setString(41, PmayUtil.convertBlankToNull(pmayAddSurveyData.getReligionIfOther()));
				ps.setString(42, PmayUtil.convertBlankToNull(pmayAddSurveyData.getDob()));
				ps.setString(43, PmayUtil.convertBlankToNull(pmayAddSurveyData.getGeoLongitude()));
				ps.setString(44, PmayUtil.convertBlankToNull(pmayAddSurveyData.getGeoLatitude()));
				ps.setString(45, slumApplicantPhoto);
				return ps;
			});

			String[] familyMemberName = pmayAddSurveyData.getFamilyMemberName().split(",");
			String[] familyMemberRelation = pmayAddSurveyData.getFamilyMemberRelation().split(",");
			String[] familyMemberGender = pmayAddSurveyData.getFamilyMemberGender().split(",");
			String[] familyMemberAge = pmayAddSurveyData.getFamilyMemberAge().split(",");
			String[] familyMemberIdCardNo = pmayAddSurveyData.getFamilyMemberIdCardNo().split(",");

			int[] saveFamilyStatus = null;
			if (saveSlumStatus != 0) {
				saveFamilyStatus = jdbcTemplate.batchUpdate(PmayMysqlQueries.SAVE_FAMILY_RELATIONSHIP_QUERY,
						new BatchPreparedStatementSetter() {
					@Override
					public int getBatchSize() {
						return familyMemberName.length;
					}

					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setInt(1, nextUserSurveyid);
						ps.setString(2, PmayUtil.convertBlankToNull(familyMemberName[i]));
						ps.setString(3, PmayUtil.convertBlankToNull(familyMemberRelation[i]));
						ps.setString(4, PmayUtil.convertBlankToNull(familyMemberGender[i]));
						ps.setString(5, PmayUtil.convertBlankToNull(familyMemberAge[i]));
						ps.setString(6, PmayUtil.convertBlankToNull(familyMemberIdCardNo[i]));
						ps.setString(7, pmayAddSurveyData.getUserId());
					}
				});
			}

			if (pmayAddSurveyData.getIsSubmittedFlag() == "Y") {
				System.out.println("SUBMIT");
				if (saveSlumStatus != 0 && saveFamilyStatus != null) {
					for (int i = 0; i <= saveFamilyStatus.length; i++) {
						if (saveFamilyStatus[i] != 0) {
							status = "true";
						} else {
							status = "false";
							break;
						}
					}
				} else {
					status = "false";
				}

			} else {
				System.out.println("SAVE");
				if (saveSlumStatus != 0) {
					status = "true";
				}
			}
			int surveyId = 0;
			if (status.equalsIgnoreCase("true")) {
				surveyId = nextUserSurveyid;
			}
			
			hmap.put("success", status);
			hmap.put("surveyId", Integer.toString(surveyId));

			ImageUpload.SaveImage(pmayAddSurveyData.getSlumApplicantSignature(), slumApplicantSignatureName, signature);
			ImageUpload.SaveImage(pmayAddSurveyData.getSlumLocationDetailsPic(), slumLocationDetailsPicName, pattaPhoto);
			ImageUpload.SaveImage(pmayAddSurveyData.getSlumIdImage(), slumIdProofPhoto, idProofPhoto);
			ImageUpload.SaveImage(pmayAddSurveyData.getSlumApplicantPhoto(), slumApplicantPhoto, applicantPhoto);
			return hmap;

		} else {
			
			String imageName = pmayAddSurveyData.getSurveyId() + "_";

			if (pmayAddSurveyData.getSlumApplicantSignature() != null) {
				slumApplicantSignatureName = imageName + "applicantSignature"
						+ pmayAddSurveyData.getSlumApplicantSignature().getOriginalFilename().substring(
								pmayAddSurveyData.getSlumApplicantSignature().getOriginalFilename().lastIndexOf('.'),
								pmayAddSurveyData.getSlumApplicantSignature().getOriginalFilename().length());
			}else {
				slumApplicantSignatureName=null;
			}
				
			if (pmayAddSurveyData.getSlumLocationDetailsPic() != null) {
				slumLocationDetailsPicName = imageName + "landRecordPhoto"
						+ pmayAddSurveyData.getSlumLocationDetailsPic().getOriginalFilename().substring(
								pmayAddSurveyData.getSlumLocationDetailsPic().getOriginalFilename().lastIndexOf('.'),
								pmayAddSurveyData.getSlumLocationDetailsPic().getOriginalFilename().length());
			}else {
				slumLocationDetailsPicName=null;
			}
				
			if (pmayAddSurveyData.getSlumIdImage() != null) {
				slumIdProofPhoto = imageName + "idProofPhoto"
						+ pmayAddSurveyData.getSlumIdImage().getOriginalFilename().substring(
								pmayAddSurveyData.getSlumIdImage().getOriginalFilename().lastIndexOf("."),
								pmayAddSurveyData.getSlumIdImage().getOriginalFilename().length());
			}else {
				slumIdProofPhoto=null;
			}
			if (pmayAddSurveyData.getSlumApplicantPhoto() != null) {
				slumApplicantPhoto = imageName + "slumApplicantPhoto"
						+ pmayAddSurveyData.getSlumApplicantPhoto().getOriginalFilename().substring(
								pmayAddSurveyData.getSlumApplicantPhoto().getOriginalFilename().lastIndexOf("."),
								pmayAddSurveyData.getSlumApplicantPhoto().getOriginalFilename().length());
			}else {
				slumApplicantPhoto=null;
			}
			if (pmayAddSurveyData.getSlumBiometricDetails() != null) {
				biometric = new ByteArrayInputStream(pmayAddSurveyData.getSlumBiometricDetails());
			}

			int saveSlumStatus = jdbcTemplate.update(connection -> {
				
				StringBuffer queryString  = new StringBuffer(" update p_user_survey set user_id=? ");
				
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getChckSlumRadio())!=null) {
					queryString.append(",slum_nonslum=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumFamilyHeadName())!=null) {
					queryString.append(",family_head_name=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumFatherHusbandName())!=null) {
					queryString.append(",father_husband_name=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumAdharNo())!=null) {
					queryString.append(",aadhar_card_no=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumAdharReason())!=null) {
					queryString.append(",reason_for_aadhar_not_available=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getGenderValue())!=null) {
					queryString.append(",gender_id=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPresentTown())!=null) {
					queryString.append(",no_of_yrs_of_stay_present=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPresentHouseNo())!=null) {
					queryString.append(",present_house_flat_no=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPresentStreetName())!=null) {
					queryString.append(",present_name_of_street=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPresentCity())!=null) {
					queryString.append(",present_city_id=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getPresentMobileNo())!=null) {
					queryString.append(",present_mobile_number=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumIsSameAsPresentAdd())!=null) {
					queryString.append(",permanent_same_as_present=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentTown())!=null) {
					queryString.append(",no_of_yrs_of_stay_permanent=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentHouseNo())!=null) {
					queryString.append(",perm_house_flat_no=?");	
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentStreetName())!=null) {
					queryString.append(",perm_name_of_street=?");	
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentCity())!=null) {
					queryString.append(",permanent_city_id=?");	
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentMobileNo())!=null) {
					queryString.append(",perm_mobile_number=?");	
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumReligion())!=null) {
					queryString.append(",religion_id=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumCaste())!=null) {
					queryString.append(",caste_id=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumOwnsRadio())!=null) {
					queryString.append(",family_own_house_in_india=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumLandinSqm())!=null) {
					queryString.append(",if_yes_land_in_sq_m=?");
				}
				if(slumApplicantSignatureName!=null) {
					queryString.append(",signature_of_applicant=?");
				}
				if(slumLocationDetailsPicName!=null) {
					queryString.append(",land_attachment_name=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getEligibleStatus())!=null) {
					queryString.append(",eligibility_for_scheme=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getNonEligibleReason())!=null) {
					queryString.append(",reason_for_non_eligibility=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getWardDetails())!=null) {
					queryString.append(",ward_id=?");
				}
				
				queryString.append(",family_have_bpl_card=?,family_have_ration_card=?");
				
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getIsSubmittedFlag())!=null) {
					queryString.append(",submitted_data=?");
				}
				queryString.append(",deleted_flag=?");
				queryString.append(",last_updated_by=?");
				
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumLandAddress())!=null) {
					queryString.append(",if_yes_land_address=?");
				}
				queryString.append(",last_updated_on=NOW() ");
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumIdProof())!=null) {
					queryString.append(",id_type_id=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumIdProofNo())!=null) {
					queryString.append(",id_number=?");
				}
				if(slumIdProofPhoto!=null) {
					queryString.append(",id_attachment_name=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getUlbNameId())!=null) {
					queryString.append(",ulb_name_id=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getMaritalStatus())!=null) {
					queryString.append(",marital_status_id=?");
				}
				
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getReligionIfOther())!=null) {
					queryString.append(",religion_if_others=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getDob())!=null) {
					queryString.append(",date_of_birth = str_to_date(?,' %d/%m/%Y') ");
				}
				if(biometric!=null) {
					queryString.append(",biometric_data=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getGeoLongitude())!=null) {
					queryString.append(",geo_lon=?");
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getGeoLatitude())!=null) {
					queryString.append(",geo_lat=?");
				}
				if(slumApplicantPhoto!=null) {
					queryString.append(",photo_attachment_name=?");
				}
				queryString.append(" where user_survey_id = ? ");
				
				//PreparedStatement ps = connection.prepareStatement(PmayMysqlQueries.UPDATE_SLUM_SURVEY_REPORT);
				
				PreparedStatement ps = connection.prepareStatement(queryString.toString());
				
				int col=0;
				ps.setString(++col, pmayAddSurveyData.getUserId());
				
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getChckSlumRadio())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getChckSlumRadio()));	
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumFamilyHeadName())!=null) {
					ps.setString(++col, pmayAddSurveyData.getSlumFamilyHeadName());	
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumFatherHusbandName())!=null) {
					ps.setString(++col, pmayAddSurveyData.getSlumFatherHusbandName());
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumAdharNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumAdharNo()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumAdharReason())!=null) {
					ps.setString(++col, pmayAddSurveyData.getSlumAdharReason());
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getGenderValue())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getGenderValue()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPresentTown())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPresentTown()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPresentHouseNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPresentHouseNo()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPresentStreetName())!=null) {
					ps.setString(++col, pmayAddSurveyData.getSlumPresentStreetName());
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPresentCity())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPresentCity()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getPresentMobileNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getPresentMobileNo()));
				}				
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumIsSameAsPresentAdd())!=null) {
					ps.setString(++col, pmayAddSurveyData.getSlumIsSameAsPresentAdd());
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentTown())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentTown()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentHouseNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentHouseNo()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentStreetName())!=null) {
					ps.setString(++col, pmayAddSurveyData.getSlumPermanentStreetName());
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentCity())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentCity()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentMobileNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumPermanentMobileNo()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumReligion())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumReligion()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumCaste())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumCaste()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumOwnsRadio())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumOwnsRadio()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumLandinSqm())!=null) {
					ps.setString(++col, pmayAddSurveyData.getSlumLandinSqm());
				}
				if(slumApplicantSignatureName!=null) {
					ps.setString(++col, slumApplicantSignatureName);
				}
				if(slumLocationDetailsPicName!=null) {
					ps.setString(++col, slumLocationDetailsPicName);
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getEligibleStatus())!=null) {
					ps.setString(++col, pmayAddSurveyData.getEligibleStatus());
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getNonEligibleReason())!=null) {
					ps.setString(++col, pmayAddSurveyData.getNonEligibleReason());
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getWardDetails())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getWardDetails()));
				}
				ps.setString(++col, "N");
				ps.setString(++col, "N");
				
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getIsSubmittedFlag())!=null) {
					ps.setString(++col, pmayAddSurveyData.getIsSubmittedFlag());
				}
				
				ps.setString(++col, "N");
				ps.setString(++col, pmayAddSurveyData.getUserId());
				
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumLandAddress())!=null) {
					ps.setString(++col, pmayAddSurveyData.getSlumLandAddress());
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumIdProof())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumIdProof()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumIdProofNo())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getSlumIdProofNo()));
				}
				if(slumIdProofPhoto!=null) {
					ps.setString(++col, slumIdProofPhoto);
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getUlbNameId())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getUlbNameId()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getMaritalStatus())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getMaritalStatus()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getReligionIfOther())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getReligionIfOther()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getDob())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getDob()));
				}
				if(biometric!=null) {
					ps.setBinaryStream(++col, biometric);
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getGeoLongitude())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getGeoLongitude()));
				}
				if(PmayUtil.convertBlankToNull(pmayAddSurveyData.getGeoLatitude())!=null) {
					ps.setString(++col, PmayUtil.convertBlankToNull(pmayAddSurveyData.getGeoLatitude()));
				}
				if(slumApplicantPhoto!=null) {
					ps.setString(++col, slumApplicantPhoto);	
				}
				
				ps.setString(++col, pmayAddSurveyData.getSurveyId());

				return ps;
			});

			String[] familyMemberName = pmayAddSurveyData.getFamilyMemberName().split(",");
			String[] familyMemberRelation = pmayAddSurveyData.getFamilyMemberRelation().split(",");
			String[] familyMemberGender = pmayAddSurveyData.getFamilyMemberGender().split(",");
			String[] familyMemberAge = pmayAddSurveyData.getFamilyMemberAge().split(",");
			String[] familyMemberIdCardNo = pmayAddSurveyData.getFamilyMemberIdCardNo().split(",");

			jdbcTemplate.update(PmayMysqlQueries.DELETE_FAMILY_RELATIONSHIP_QUERY, pmayAddSurveyData.getSurveyId());

			int[] saveFamilyStatus = jdbcTemplate.batchUpdate(PmayMysqlQueries.SAVE_FAMILY_RELATIONSHIP_QUERY,
					new BatchPreparedStatementSetter() {
				@Override
				public int getBatchSize() {
					return familyMemberName.length;
				}

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setString(1, pmayAddSurveyData.getSurveyId());
					ps.setString(2, PmayUtil.convertBlankToNull(familyMemberName[i]));
					ps.setString(3, PmayUtil.convertBlankToNull(familyMemberRelation[i]));
					ps.setString(4, PmayUtil.convertBlankToNull(familyMemberGender[i]));
					ps.setString(5, PmayUtil.convertBlankToNull(familyMemberAge[i]));
					ps.setString(6, PmayUtil.convertBlankToNull(familyMemberIdCardNo[i]));
					ps.setString(7, PmayUtil.convertBlankToNull(pmayAddSurveyData.getUserId()));
				}
			});

			if (pmayAddSurveyData.getIsSubmittedFlag() == "Y") {
				System.out.println("SUBMIT");
				if (saveSlumStatus != 0) {
					for (int i = 0; i <= saveFamilyStatus.length; i++) {
						if (saveFamilyStatus[i] != 0) {
							status = "true";
						} else {
							status = "false";
							break;
						}
					}
				} else {
					status = "false";
				}

			} else {
				System.out.println("SAVE");
				if (saveSlumStatus != 0) {
					status = "true";
				}
			}
			
			hmap.put("success", status);
			hmap.put("surveyId", pmayAddSurveyData.getSurveyId());
			ImageUpload.SaveImage(pmayAddSurveyData.getSlumApplicantSignature(), slumApplicantSignatureName, signature);
			ImageUpload.SaveImage(pmayAddSurveyData.getSlumLocationDetailsPic(), slumLocationDetailsPicName,
					pattaPhoto);
			ImageUpload.SaveImage(pmayAddSurveyData.getSlumIdImage(), slumIdProofPhoto, idProofPhoto);
			ImageUpload.SaveImage(pmayAddSurveyData.getSlumApplicantPhoto(), slumApplicantPhoto, applicantPhoto);
			return hmap;
		}
	}

	@Override
	public List<PmayBankData> getBanksList() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_BANK_DATA, new RowMapper<PmayBankData>() {

			@Override
			public PmayBankData mapRow(ResultSet rs, int rowNum) throws SQLException {
				PmayBankData bankData = new PmayBankData();
				bankData.setBankId(rs.getString(1));
				bankData.setBankName(rs.getString(2));

				return bankData;
			}

		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getNoOfYearsPresentList()
	 */
	@Override
	public List<PmayNoOfYearsPresentInCity> getNoOfYearsPresentList() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_NO_OF_YEARS_PRESENT_DATA,
				new RowMapper<PmayNoOfYearsPresentInCity>() {

			@Override
			public PmayNoOfYearsPresentInCity mapRow(ResultSet rs, int rowNum) throws SQLException {
				PmayNoOfYearsPresentInCity pmayNoOfYearsPresentInCity = new PmayNoOfYearsPresentInCity();
				pmayNoOfYearsPresentInCity.setNoOfyearsPresentId(rs.getString(1));
				pmayNoOfYearsPresentInCity.setNoOfYearsPresent(rs.getString(2));

				return pmayNoOfYearsPresentInCity;
			}

		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getUlbList()
	 */
	@Override
	public List<PmayULBData> getUlbList() {
		return jdbcTemplate.query(PmayMysqlQueries.GET_ULB_DATA, new RowMapper<PmayULBData>() {

			@Override
			public PmayULBData mapRow(ResultSet rs, int rowNum) throws SQLException {
				PmayULBData ulbData = new PmayULBData();
				ulbData.setUlbNameId(rs.getString(1));
				ulbData.setUlbName(rs.getString(2));
				return ulbData;
			}

		});
	}

	/*****************************
	 * slum add survey data
	 *******************************/
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#checkAdharIsExist(java.lang.String)
	 */
	@Override
	public boolean checkAdharIsExist(String adharNo) {
		int isAdharExists = jdbcTemplate.queryForObject(PmayMysqlQueries.IS_ADHAR_EXIST_QUERY, Integer.class, adharNo);
		return isAdharExists != 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#checkIdProofNoIsExist(java.util.Map)
	 */
	@Override
	public boolean checkIdProofNoIsExist(Map<String, String> data) {
		int isAdharExists = jdbcTemplate.queryForObject(PmayMysqlQueries.IS_ID_PROOF_EXIST_QUERY, Integer.class,
				data.get("IdProofNo"));
		return isAdharExists != 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mcs.pmay.dao.PmaySurveyDao#getTodaySurveyReportForSlumNonSlum()
	 */
	@Override
	public SlumNonSlumReportData getTodaySurveyReportForSlumNonSlum() {
		return jdbcTemplate.queryForObject(PmayMysqlQueries.GET_TODAY_SLUM_NONSLUM_SURVEY_REPORT,
				new RowMapper<SlumNonSlumReportData>() {

			@Override
			public SlumNonSlumReportData mapRow(ResultSet rs, int rowNum) throws SQLException {
				SlumNonSlumReportData data = new SlumNonSlumReportData();
				data.setNoOfSlumSurvey(rs.getInt(1));
				data.setNoOfNonSlumSurvey(rs.getInt(2));
				data.setTotalSurvay(rs.getInt(3));
				return data;
			}
		});
	}

	@Override
	public SlumNonSlumReportData getTotalSurveyReportForSlumNonSlum() {
		return jdbcTemplate.queryForObject(PmayMysqlQueries.GET_TOTAL_SLUM_NONSLUM_SURVEY_REPORT,
				new RowMapper<SlumNonSlumReportData>() {

			@Override
			public SlumNonSlumReportData mapRow(ResultSet rs, int rowNum) throws SQLException {
				SlumNonSlumReportData data = new SlumNonSlumReportData();
				data.setNoOfSlumSurvey(rs.getInt(1));
				data.setNoOfNonSlumSurvey(rs.getInt(2));
				data.setTotalSurvay(rs.getInt(3));
				return data;
			}
		});
	}

	//Start 12th April2018
	@Override
	public SlumNonSlumReportData getUlbSurveyReportForSlumNonSlum(String ulbNo) {
		String rsQuery ="SELECT (SELECT COUNT(*) FROM p_user_survey WHERE slum_nonslum = 'S' AND ulb_name_id= ? ) slum, (SELECT COUNT(*) FROM p_user_survey WHERE slum_nonslum = 'N' AND ulb_name_id= ?) nonslum, (SELECT COUNT(*) FROM p_user_survey WHERE slum_nonslum in('S','N') AND ulb_name_id= ?) total";
		StringBuffer sb= new StringBuffer(rsQuery);
		return jdbcTemplate.queryForObject(sb.toString(), 
				new RowMapper<SlumNonSlumReportData>() {

			@Override
			public SlumNonSlumReportData mapRow(ResultSet rs, int rowNum) throws SQLException {
				SlumNonSlumReportData data = null;
				data = new SlumNonSlumReportData();
				data.setNoOfSlumSurvey(rs.getInt(1));
				data.setNoOfNonSlumSurvey(rs.getInt(2));
				data.setTotalSurvay(rs.getInt(3));
				return data;
			}
		},ulbNo,ulbNo,ulbNo);
	}

	//End 12th April2018
	//Start 12th April2018
	@Override
	public SlumNonSlumReportData getTodayUlbSurveyReportForSlumNonSlum(String ulbNo) {
		String rsQuery ="SELECT (SELECT COUNT(*) FROM pmay.p_user_survey WHERE slum_nonslum = 'S' AND ulb_name_id = ? AND created_on >= DATE(NOW()) - INTERVAL 1 DAY) slum, (SELECT COUNT(*) FROM pmay.p_user_survey WHERE slum_nonslum = 'N' AND ulb_name_id = ? AND created_on >= DATE(NOW()) - INTERVAL 1 DAY) nonslum, (SELECT COUNT(*) FROM pmay.p_user_survey WHERE slum_nonslum in('S','N') AND ulb_name_id= ? AND created_on >= DATE(NOW()) - INTERVAL 1 DAY) total";
		StringBuffer sb= new StringBuffer(rsQuery);
		return jdbcTemplate.queryForObject(sb.toString(), 
				new RowMapper<SlumNonSlumReportData>() {

			@Override
			public SlumNonSlumReportData mapRow(ResultSet rs, int rowNum) throws SQLException {
				SlumNonSlumReportData data = null;
				data = new SlumNonSlumReportData();
				data.setNoOfSlumSurvey(rs.getInt(1));
				data.setNoOfNonSlumSurvey(rs.getInt(2));
				data.setTotalSurvay(rs.getInt(3));
				return data;
			}
		},ulbNo,ulbNo,ulbNo);
	}

	//End 12th April2018
	@Override
	public List<UlbWardDetailsData> getUlbWardDetails(String searchData) {
		StringBuilder getUlbWardDetailsQuery = new StringBuilder("SELECT IFNULL(pun.ulb_name, 'Others'),group_concat(distinct pus.ward_id SEPARATOR ', ') as ward_name FROM p_user_survey pus LEFT OUTER JOIN p_ulb_name pun ON pus.ulb_name_id = pun.ulb_name_id ");
		System.out.println("Search Data" + searchData);

		if (searchData.equalsIgnoreCase("slum")) {
			getUlbWardDetailsQuery.append("WHERE slum_nonslum = 'S' GROUP BY ulb_name ORDER BY ulb_name asc");
		} else if (searchData.equalsIgnoreCase("nonSlum")) {
			getUlbWardDetailsQuery.append("WHERE slum_nonslum = 'N' GROUP BY ulb_name ORDER BY ulb_name asc");
		} else if (searchData.equalsIgnoreCase("todayReport")) {
			getUlbWardDetailsQuery.append(
					"WHERE pus.created_on >= DATE(NOW()) - INTERVAL 1 DAY GROUP BY ulb_name ORDER BY ulb_name asc");
		} else {
			getUlbWardDetailsQuery.append("GROUP BY ulb_name ORDER BY ulb_name asc");
		}

		return jdbcTemplate.query(getUlbWardDetailsQuery.toString(), new RowMapper<UlbWardDetailsData>() {

			@Override
			public UlbWardDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException {
				UlbWardDetailsData ulbWardDetailsData = new UlbWardDetailsData();
				ulbWardDetailsData.setUlbName(rs.getString(1));
				ulbWardDetailsData.setWardNames(rs.getString(2));

				return ulbWardDetailsData;
			}

		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mcs.pmay.dao.PmaySurveyDao#getAdminUlbWardDetails(java.lang.String)
	 */
	@Override
	public List<UlbWardDetailsData> getAdminUlbWardDetails(String searchData) {
		StringBuilder getUlbWardDetailsQuery = new StringBuilder("select count(*) as total_survey_count,IFNULL(pun.ulb_name, 'Others'),group_concat(distinct pus.ward_id SEPARATOR ', ') as ward_name, pus.ulb_name_id from p_user_survey pus left outer join p_ulb_name pun on pus.ulb_name_id = pun.ulb_name_id ");
		System.out.println("Search Data" + searchData);
		if (searchData.equalsIgnoreCase("savedSurvey")) {
			getUlbWardDetailsQuery
			.append("WHERE pus.submitted_data = 'N' GROUP BY pus.ulb_name_id ORDER BY ulb_name asc");
		} else if (searchData.equalsIgnoreCase("submittedSurvey")) {
			getUlbWardDetailsQuery
			.append("WHERE pus.submitted_data = 'Y' GROUP BY pus.ulb_name_id ORDER BY ulb_name asc");
		} else if (searchData.equalsIgnoreCase("slum")) {
			getUlbWardDetailsQuery
			.append("WHERE pus.slum_nonslum = 'S' GROUP BY pus.ulb_name_id ORDER BY ulb_name asc");
		} else if (searchData.equalsIgnoreCase("nonSlum")) {
			getUlbWardDetailsQuery
			.append("WHERE pus.slum_nonslum = 'N' GROUP BY pus.ulb_name_id ORDER BY ulb_name asc");
		} else if (searchData.equalsIgnoreCase("todayReport")) {
			getUlbWardDetailsQuery.append(
					"WHERE pus.created_on >= DATE(NOW()) - INTERVAL 1 DAY GROUP BY pus.ulb_name_id ORDER BY ulb_name asc");
		} else if (searchData.equalsIgnoreCase("pendingReport")) {
			getUlbWardDetailsQuery.append(
					"WHERE pus.validation_pending_non_slum = 'Y' GROUP BY pus.ulb_name_id ORDER BY ulb_name asc");
		} else {
			getUlbWardDetailsQuery.append("GROUP BY pus.ulb_name_id ORDER BY ulb_name asc");
		}

		return jdbcTemplate.query(getUlbWardDetailsQuery.toString(), new RowMapper<UlbWardDetailsData>() {

			@Override
			public UlbWardDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException {
				UlbWardDetailsData ulbWardDetailsData = new UlbWardDetailsData();
				ulbWardDetailsData.setTotalNoOfSurvey(rs.getString(1));
				ulbWardDetailsData.setUlbName(rs.getString(2));
				ulbWardDetailsData.setWardNames(rs.getString(3));

				return ulbWardDetailsData;
			}

		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mcs.pmay.dao.PmaySurveyDao#getSurveyerUserUlbWardDetails(java.lang.
	 * String)
	 */
	@Override
	public List<UlbWardDetailsData> getSurveyerUserUlbWardDetails(String searchData, String userId) {
		StringBuilder getUlbWardDetailsQuery = new StringBuilder("select count(*) as total_survey_count, IFNULL(pun.ulb_name, 'Others'),group_concat(distinct pus.ward_id SEPARATOR ', ') as ward_name, pus.ulb_name_id from p_user_survey pus left outer join p_ulb_name pun on pus.ulb_name_id = pun.ulb_name_id ");
		System.out.println("Search Data" + searchData);
		if (searchData.equalsIgnoreCase("savedSurvey")) {
			getUlbWardDetailsQuery.append("WHERE pus.submitted_data = 'N' and pus.user_id = " + userId
					+ " GROUP BY pus.ulb_name_id ORDER BY ulb_name asc");
		} else if (searchData.equalsIgnoreCase("submittedSurvey")) {
			getUlbWardDetailsQuery.append("WHERE pus.submitted_data = 'Y' and pus.user_id = " + userId
					+ " GROUP BY pus.ulb_name_id ORDER BY ulb_name asc");
		} else if (searchData.equalsIgnoreCase("slum")) {
			getUlbWardDetailsQuery.append("WHERE pus.slum_nonslum = 'S' and pus.user_id = " + userId
					+ " GROUP BY pus.ulb_name_id ORDER BY ulb_name asc");
		} else if (searchData.equalsIgnoreCase("nonSlum")) {
			getUlbWardDetailsQuery.append("WHERE pus.slum_nonslum = 'N' and pus.user_id = " + userId
					+ " GROUP BY pus.ulb_name_id ORDER BY ulb_name asc");
		} else if (searchData.equalsIgnoreCase("todayReport")) {
			getUlbWardDetailsQuery.append("WHERE pus.created_on >= DATE(NOW()) - INTERVAL 1 DAY and pus.user_id = "
					+ userId + " GROUP BY pus.ulb_name_id ORDER BY ulb_name asc");
		} else if (searchData.equalsIgnoreCase("pendingReport")) {
			getUlbWardDetailsQuery.append("WHERE pus.validation_pending_non_slum = 'Y' and pus.user_id = " + userId
					+ " GROUP BY pus.ulb_name_id ORDER BY ulb_name asc");
		} else {
			getUlbWardDetailsQuery
			.append("WHERE pus.user_id = " + userId + " GROUP BY pus.ulb_name_id ORDER BY ulb_name asc");
		}

		return jdbcTemplate.query(getUlbWardDetailsQuery.toString(), new RowMapper<UlbWardDetailsData>() {

			@Override
			public UlbWardDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException {
				UlbWardDetailsData ulbWardDetailsData = new UlbWardDetailsData();
				ulbWardDetailsData.setTotalNoOfSurvey(rs.getString(1));
				ulbWardDetailsData.setUlbName(rs.getString(2));
				ulbWardDetailsData.setWardNames(rs.getString(3));

				return ulbWardDetailsData;
			}

		});
	}

	@Override
	public boolean deleteMultipleRecord(Map<String, String[]> userSurveyIds) {
		String[] markedSurveyIds = userSurveyIds.get("markedSurveyIds");
		int[] deleteStatus = null;
		System.out.println(markedSurveyIds.length);

		deleteStatus = jdbcTemplate.batchUpdate(PmayMysqlQueries.DELETE_MULTIPLE_FROM_SURVEY_REPORT,
				new BatchPreparedStatementSetter() {

			@Override
			public int getBatchSize() {
				return markedSurveyIds.length;
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, markedSurveyIds[i]);
			}

		});

		boolean status = false;
		if (deleteStatus.length != 0) {
			for (int i = 0; i < deleteStatus.length; i++) {
				if (deleteStatus[i] != 0) {
					status = true;
				} else {
					status = false;
					break;
				}
				System.out.println("delete status" + status);
			}
		}

		return status;
	}


	@Override
	public List<PmayReportDataForAdmins> getSurveyReportForSuperUser() {
		StringBuilder queryToGetsurveyorUserReportBySearchData = new StringBuilder(
				PmayMysqlQueries.QUERY_FOR_GET_SURVEY_SUPER_USER_REPORT);

		return jdbcTemplate.query(queryToGetsurveyorUserReportBySearchData.toString(),
				new RowMapper<PmayReportDataForAdmins>() {
			@Override
			public PmayReportDataForAdmins mapRow(ResultSet rs, int rowNum) throws SQLException {
				PmayReportDataForAdmins surveyReportData = new PmayReportDataForAdmins();
				surveyReportData.setUserSurveyId(rs.getString(1));
				surveyReportData.setUserId(rs.getString(2));
				surveyReportData.setWardId(rs.getString(3));
				surveyReportData.setWardName(rs.getString(4));
				surveyReportData.setSlumNonSlum(rs.getString(5));
				surveyReportData.setValidationPendingNonSlum(rs.getString(6));
				surveyReportData.setEligibilityForScheme(rs.getString(7));
				surveyReportData.setFamilyHead(rs.getString(8));
				surveyReportData.setFatherOrHusbandName(rs.getString(9));
				surveyReportData.setPhotoAttachmentName(rs.getString(10));
				surveyReportData.setAadharCardNumber(rs.getString(11));
				surveyReportData.setReasonforAAdharNotAvailable(rs.getString(12));
				surveyReportData.setIdTypeId(rs.getString(13));
				surveyReportData.setIdTypeName(rs.getString(14));
				surveyReportData.setIdNumber(rs.getString(15));
				surveyReportData.setIdAttachmentName(rs.getString(16));
				surveyReportData.setGenderId(rs.getString(17));
				surveyReportData.setGenderName(rs.getString(18));
				surveyReportData.setDob(rs.getString(19));
				surveyReportData.setAge(rs.getString(20));
				surveyReportData.setMaritalStatusId(rs.getString(21));
				surveyReportData.setMaritalStatusName(rs.getString(22));
				surveyReportData.setReligionId(rs.getString(23));
				surveyReportData.setReligionName(rs.getString(24));
				surveyReportData.setReligionIfOther(rs.getString(25));
				surveyReportData.setCasteId(rs.getString(26));
				surveyReportData.setCasteName(rs.getString(27));
				surveyReportData.setReasonForNonEligibility(rs.getString(28));
				surveyReportData.setNoOfYearsOfStayPresent(rs.getString(29));
				surveyReportData.setPresentHouseFlatNo(rs.getString(30));
				surveyReportData.setPresentNameOfStreet(rs.getString(31));
				surveyReportData.setPresentCityId(rs.getString(32));
				surveyReportData.setPresentCityName(rs.getString(33));
				surveyReportData.setPresentMobNo(rs.getString(34));
				surveyReportData.setPermanentSameAsPresent(rs.getString(35));
				surveyReportData.setNoOfYearsOfStayPermanent(rs.getString(36));
				surveyReportData.setPermanentHouseFlatNo(rs.getString(37));
				surveyReportData.setPermanentNameOfStreet(rs.getString(38));
				surveyReportData.setPermanentCityId(rs.getString(39));
				surveyReportData.setPermanentCityName(rs.getString(40));
				surveyReportData.setPermanentMobileNo(rs.getString(41));
				surveyReportData.setPhotoAttachmentInFrontOfHouse(rs.getString(42));
				surveyReportData.setHouseOwnershipId(rs.getString(43));
				surveyReportData.setGeoLatitude(rs.getString(44));
				surveyReportData.setGeoLongitude(rs.getString(45));
				surveyReportData.setHouseTypeRoofId(rs.getString(46));
				surveyReportData.setHouseTypeRoofName(rs.getString(47));
				surveyReportData.setHouseTypeWallId(rs.getString(48));
				surveyReportData.setHouseTypeWallName(rs.getString(49));
				surveyReportData.setNoOfRoomDwellingexceptKitchen(rs.getString(50));
				surveyReportData.setSizeOfDwellUnitCarpetArea(rs.getString(51));
				surveyReportData.setFamilyOwnHouseInIndia(rs.getString(52));
				surveyReportData.setIndiaLocationDetailsAttachment(rs.getString(53));
				surveyReportData.setIndiaLandInSquareMeter(rs.getString(54));
				surveyReportData.setLandAttachmentName(rs.getString(55));
				surveyReportData.setHousingCategoryId(rs.getString(56));
				surveyReportData.setHouseRequirementName(rs.getString(57));
				surveyReportData.setNameOfPattadars(rs.getString(58));
				surveyReportData.setPattaNumber(rs.getString(59));
				surveyReportData.setDagNumber(rs.getString(60));
				surveyReportData.setLandAreaAsInPatta(rs.getString(61));
				surveyReportData.setDimentionOfLandLength(rs.getString(62));
				surveyReportData.setDimensionOfLandbreadth(rs.getString(63));
				surveyReportData.setLandAttachment1(rs.getString(64));
				surveyReportData.setLandAttachment2(rs.getString(65));
				surveyReportData.setEmployementCategoryId(rs.getString(66));
				surveyReportData.setEmployementCategoryName(rs.getString(67));
				surveyReportData.setIfOtherCategoryName(rs.getString(68));
				surveyReportData.setIncomeProofDocName(rs.getString(69));
				surveyReportData.setIncomeProofAttachment(rs.getString(70));
				surveyReportData.setFamilyHaveBplCard(rs.getString(71));
				surveyReportData.setBplCardNumber(rs.getString(72));
				surveyReportData.setBplCardAttachment(rs.getString(73));
				surveyReportData.setFamilyHaveRationCard(rs.getString(74));
				surveyReportData.setRationCardNumber(rs.getString(75));
				surveyReportData.setRationCardAttachment(rs.getString(76));
				surveyReportData.setHfaCategoryId(rs.getString(77));
				surveyReportData.setHfaCategoryName(rs.getString(78));
				surveyReportData.setBankAccountNo(rs.getString(79));
				surveyReportData.setBankName(rs.getString(80));
				surveyReportData.setBranchName(rs.getString(81));
				surveyReportData.setBranchIfscCode(rs.getString(82));
				surveyReportData.setSignatureOfApplicant(rs.getString(83));
				surveyReportData.setSubmittedData(rs.getString(84));
				surveyReportData.setNameOfFamilyMember(rs.getString(85));
				surveyReportData.setRelationshipId(rs.getString(86));
				surveyReportData.setRelationshipName(rs.getString(87));
				surveyReportData.setFamilyGenderId(rs.getString(88));
				surveyReportData.setFamilyGenderName(rs.getString(89));
				surveyReportData.setAgeOfFamilyMember(rs.getString(90));
				surveyReportData.setFamilyMemberIdCardNumber(rs.getString(91));
				surveyReportData.setBankId(rs.getString(93));
				surveyReportData.setOtherBankName(rs.getString(94));
				surveyReportData.setLandAddress(rs.getString(95));
				surveyReportData.setUlbNameId(rs.getString(96));
				surveyReportData.setUlbName(rs.getString(97));
				surveyReportData.setUserRMN(rs.getString(98));

				if (PmayUtil.chkNull(surveyReportData.getSlumNonSlum()).equalsIgnoreCase("S")) {
					surveyReportData.setSlumNonSlumStatus("Slum");
				} else if (PmayUtil.chkNull(surveyReportData.getSlumNonSlum()).equalsIgnoreCase("N")) {
					surveyReportData.setSlumNonSlumStatus("Non-Slum");
				}

				if (PmayUtil.chkNull(surveyReportData.getEligibilityForScheme()).equalsIgnoreCase("Y")) {
					surveyReportData.setEligibleStatus("Eligible");
				} else if (PmayUtil.chkNull(surveyReportData.getEligibilityForScheme()).equalsIgnoreCase("N")) {
					surveyReportData.setEligibleStatus("Not-Eligible");
				}

				if (PmayUtil.chkNull(surveyReportData.getValidationPendingNonSlum()).equalsIgnoreCase("Y")) {
					surveyReportData.setValidationPendingStatus("Yes");
				} else if (PmayUtil.chkNull(surveyReportData.getValidationPendingNonSlum())
						.equalsIgnoreCase("N")) {
					surveyReportData.setValidationPendingStatus("No");
				}
				return surveyReportData;

			}

		});
	}


	/*public static void main(String[] args) {

		PmayReportDataForAdmins surveyReportData = new PmayReportDataForAdmins();
		List<PmayReportDataForAdmins> ls=new ArrayList<PmayReportDataForAdmins>();

		PmaySurveyDaoImpl pm=new PmaySurveyDaoImpl();
		ls=pm.getAdminsSurveyReports();

	}*/
}
