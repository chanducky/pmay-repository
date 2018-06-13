package com.mcs.pmay.data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chandrakumar
 *
 */
@SuppressWarnings("serial")
public class PmayReportDataForAdmins implements Serializable {

	private String userSurveyId;
	private String userId;
	private String wardId;
	private String wardName;
	private String slumNonSlum;
	private String validationPendingNonSlum;
	private String eligibilityForScheme;
	private String familyHead;
	private String fatherOrHusbandName;
	private String photoAttachmentName;
	private String aadharCardNumber;
	private String reasonforAAdharNotAvailable;
	private String idTypeId;
	private String idTypeName;
	private String idNumber;
	private String idAttachmentName;
	private String contactNumber;
	private String genderId;
	private String genderName;
	private String dob;
	private String age;
	private String maritalStatusId;
	private String maritalStatusName;
	private String religionId;
	private String religionName;
	private String religionIfOther;
	private String casteId;
	private String casteName;
	private String reasonForNonEligibility;
	private String noOfYearsOfStayPresent;
	private String presentHouseFlatNo;
	private String presentNameOfStreet;
	private String presentCityId;
	private String presentCityName;
	private String presentMobNo;
	private String permanentSameAsPresent;
	private String noOfYearsOfStayPermanent;
	private String permanentHouseFlatNo;
	private String permanentNameOfStreet;
	private String permanentCityId;
	private String permanentCityName;
	private String permanentMobileNo;
	private String photoAttachmentInFrontOfHouse;
	private String houseOwnershipId;
	private String geoLatitude;
	private String geoLongitude;
	private String houseTypeRoofId;
	private String houseTypeRoofName;
	private String houseTypeWallId;
	private String houseTypeWallName;
	private String noOfRoomDwellingexceptKitchen;
	private String sizeOfDwellUnitCarpetArea;
	private String familyOwnHouseInIndia;
	private String indiaLocationDetailsAttachment;
	private String indiaLandInSquareMeter;
	private String landAttachmentName;
	private String houseRequirementId;
	private String houseRequirementName;
	private String nameOfPattadars;
	private String pattaNumber;
	private String dagNumber;
	private String landAreaAsInPatta;
	private String dimentionOfLandLength;
	private String dimensionOfLandbreadth;
	private String landAttachment1;
	private String landAttachment2;
	private String employementCategoryId;
	private String employementCategoryName;
	private String ifOtherCategoryName;
	private String incomeProofDocName;
	private String incomeProofAttachment;
	private String familyHaveBplCard;
	private String bplCardNumber;
	private String bplCardAttachment;
	private String familyHaveRationCard;
	private String rationCardNumber;
	private String rationCardAttachment;
	private String hfaCategoryId;
	private String hfaCategoryName;
	private String vehicleCategoryId;
	private String vehicleCategoryName;
	private String vehicleRegistrationNumber;
	private String vehicleRegistrationAttachment;
	private String bankAccountNo;
	private String bankName;
	private String otherBankName;
	private String bankId;
	private String branchName;
	private String branchIfscCode;
	private String signatureOfApplicant;
	private String submittedData;
	private String housingCategoryId;
	private String nameOfFamilyMember;
	private String relationshipId;
	private String relationshipName;
	private String familyGenderId;
	private String familyGenderName;
	private String ageOfFamilyMember;
	private String familyMemberIdCardNumber;
	private String surveyFamilyDetailId;
	private String editButtonDisable;
	private String landAddress;
	private String ulbNameId;
	private String ulbName;
	private String slumNonSlumStatus;
	private String eligibleStatus;
	private String validationPendingStatus;
	private String userRMN;
	private Date createdOn;
	
	

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUserRMN() {
		return userRMN;
	}

	public void setUserRMN(String userRMN) {
		this.userRMN = userRMN;
	}

	public String getValidationPendingStatus() {
		return validationPendingStatus;
	}

	public void setValidationPendingStatus(String validationPendingStatus) {
		this.validationPendingStatus = validationPendingStatus;
	}

	public String getUlbName() {
		return ulbName;
	}

	public void setUlbName(String ulbName) {
		this.ulbName = ulbName;
	}

	public String getLandAddress() {
		return landAddress;
	}

	public void setLandAddress(String landAddress) {
		this.landAddress = landAddress;
	}

	public String getEditButtonDisable() {
		return editButtonDisable;
	}

	public void setEditButtonDisable(String editButtonDisable) {
		this.editButtonDisable = editButtonDisable;
	}

	public String getSurveyFamilyDetailId() {
		return surveyFamilyDetailId;
	}

	public void setSurveyFamilyDetailId(String surveyFamilyDetailId) {
		this.surveyFamilyDetailId = surveyFamilyDetailId;
	}

	public String getRelationshipName() {
		return relationshipName;
	}

	public void setRelationshipName(String relationshipName) {
		this.relationshipName = relationshipName;
	}

	public String getFamilyGenderName() {
		return familyGenderName;
	}

	public void setFamilyGenderName(String familyGenderName) {
		this.familyGenderName = familyGenderName;
	}

	public String getFamilyMemberIdCardNumber() {
		return familyMemberIdCardNumber;
	}

	public void setFamilyMemberIdCardNumber(String familyMemberIdCardNumber) {
		this.familyMemberIdCardNumber = familyMemberIdCardNumber;
	}

	public String getNameOfFamilyMember() {
		return nameOfFamilyMember;
	}

	public void setNameOfFamilyMember(String nameOfFamilyMember) {
		this.nameOfFamilyMember = nameOfFamilyMember;
	}

	public String getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(String relationshipId) {
		this.relationshipId = relationshipId;
	}

	public String getFamilyGenderId() {
		return familyGenderId;
	}

	public void setFamilyGenderId(String familyGenderId) {
		this.familyGenderId = familyGenderId;
	}

	public String getAgeOfFamilyMember() {
		return ageOfFamilyMember;
	}

	public void setAgeOfFamilyMember(String ageOfFamilyMember) {
		this.ageOfFamilyMember = ageOfFamilyMember;
	}

	public String getHousingCategoryId() {
		return housingCategoryId;
	}

	public void setHousingCategoryId(String housingCategoryId) {
		this.housingCategoryId = housingCategoryId;
	}

	public String getUserSurveyId() {
		return userSurveyId;
	}

	public void setUserSurveyId(String userSurveyId) {
		this.userSurveyId = userSurveyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getWardId() {
		return wardId;
	}

	public String getSlumNonSlumStatus() {
		return slumNonSlumStatus;
	}

	public void setSlumNonSlumStatus(String slumNonSlumStatus) {
		this.slumNonSlumStatus = slumNonSlumStatus;
	}

	public String getEligibleStatus() {
		return eligibleStatus;
	}

	public void setEligibleStatus(String eligibleStatus) {
		this.eligibleStatus = eligibleStatus;
	}

	public void setWardId(String wardId) {
		this.wardId = wardId;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public String getSlumNonSlum() {
		return slumNonSlum;
	}

	public void setSlumNonSlum(String slumNonSlum) {
		this.slumNonSlum = slumNonSlum;
	}

	public String getValidationPendingNonSlum() {
		return validationPendingNonSlum;
	}

	public void setValidationPendingNonSlum(String validationPendingNonSlum) {
		this.validationPendingNonSlum = validationPendingNonSlum;
	}

	public String getEligibilityForScheme() {
		return eligibilityForScheme;
	}

	public void setEligibilityForScheme(String eligibilityForScheme) {
		this.eligibilityForScheme = eligibilityForScheme;
	}

	public String getFamilyHead() {
		return familyHead;
	}

	public void setFamilyHead(String familyHead) {
		this.familyHead = familyHead;
	}

	public String getFatherOrHusbandName() {
		return fatherOrHusbandName;
	}

	public void setFatherOrHusbandName(String fatherOrHusbandName) {
		this.fatherOrHusbandName = fatherOrHusbandName;
	}

	public String getPhotoAttachmentName() {
		return photoAttachmentName;
	}

	public void setPhotoAttachmentName(String photoAttachmentName) {
		this.photoAttachmentName = photoAttachmentName;
	}

	public String getAadharCardNumber() {
		return aadharCardNumber;
	}

	public void setAadharCardNumber(String aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}

	public String getReasonforAAdharNotAvailable() {
		return reasonforAAdharNotAvailable;
	}

	public void setReasonforAAdharNotAvailable(String reasonforAAdharNotAvailable) {
		this.reasonforAAdharNotAvailable = reasonforAAdharNotAvailable;
	}

	public String getIdTypeId() {
		return idTypeId;
	}

	public void setIdTypeId(String idTypeId) {
		this.idTypeId = idTypeId;
	}

	public String getIdTypeName() {
		return idTypeName;
	}

	public void setIdTypeName(String idTypeName) {
		this.idTypeName = idTypeName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getIdAttachmentName() {
		return idAttachmentName;
	}

	public void setIdAttachmentName(String idAttachmentName) {
		this.idAttachmentName = idAttachmentName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getGenderId() {
		return genderId;
	}

	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(String maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public String getMaritalStatusName() {
		return maritalStatusName;
	}

	public void setMaritalStatusName(String maritalStatusName) {
		this.maritalStatusName = maritalStatusName;
	}

	public String getReligionId() {
		return religionId;
	}

	public void setReligionId(String religionId) {
		this.religionId = religionId;
	}

	public String getReligionName() {
		return religionName;
	}

	public void setReligionName(String religionName) {
		this.religionName = religionName;
	}

	public String getReligionIfOther() {
		return religionIfOther;
	}

	public void setReligionIfOther(String religionIfOther) {
		this.religionIfOther = religionIfOther;
	}

	public String getCasteId() {
		return casteId;
	}

	public void setCasteId(String casteId) {
		this.casteId = casteId;
	}

	public String getCasteName() {
		return casteName;
	}

	public void setCasteName(String casteName) {
		this.casteName = casteName;
	}

	public String getReasonForNonEligibility() {
		return reasonForNonEligibility;
	}

	public void setReasonForNonEligibility(String reasonForNonEligibility) {
		this.reasonForNonEligibility = reasonForNonEligibility;
	}

	public String getNoOfYearsOfStayPresent() {
		return noOfYearsOfStayPresent;
	}

	public void setNoOfYearsOfStayPresent(String noOfYearsOfStayPresent) {
		this.noOfYearsOfStayPresent = noOfYearsOfStayPresent;
	}

	public String getPresentHouseFlatNo() {
		return presentHouseFlatNo;
	}

	public void setPresentHouseFlatNo(String presentHouseFlatNo) {
		this.presentHouseFlatNo = presentHouseFlatNo;
	}

	public String getPresentNameOfStreet() {
		return presentNameOfStreet;
	}

	public void setPresentNameOfStreet(String presentNameOfStreet) {
		this.presentNameOfStreet = presentNameOfStreet;
	}

	public String getPresentCityId() {
		return presentCityId;
	}

	public void setPresentCityId(String presentCityId) {
		this.presentCityId = presentCityId;
	}

	public String getPresentCityName() {
		return presentCityName;
	}

	public void setPresentCityName(String presentCityName) {
		this.presentCityName = presentCityName;
	}

	public String getPresentMobNo() {
		return presentMobNo;
	}

	public void setPresentMobNo(String presentMobNo) {
		this.presentMobNo = presentMobNo;
	}

	public String getPermanentSameAsPresent() {
		return permanentSameAsPresent;
	}

	public void setPermanentSameAsPresent(String permanentSameAsPresent) {
		this.permanentSameAsPresent = permanentSameAsPresent;
	}

	public String getNoOfYearsOfStayPermanent() {
		return noOfYearsOfStayPermanent;
	}

	public void setNoOfYearsOfStayPermanent(String noOfYearsOfStayPermanent) {
		this.noOfYearsOfStayPermanent = noOfYearsOfStayPermanent;
	}

	public String getPermanentHouseFlatNo() {
		return permanentHouseFlatNo;
	}

	public void setPermanentHouseFlatNo(String permanentHouseFlatNo) {
		this.permanentHouseFlatNo = permanentHouseFlatNo;
	}

	public String getPermanentNameOfStreet() {
		return permanentNameOfStreet;
	}

	public void setPermanentNameOfStreet(String permanentNameOfStreet) {
		this.permanentNameOfStreet = permanentNameOfStreet;
	}

	public String getPermanentCityId() {
		return permanentCityId;
	}

	public void setPermanentCityId(String permanentCityId) {
		this.permanentCityId = permanentCityId;
	}

	public String getPermanentCityName() {
		return permanentCityName;
	}

	public void setPermanentCityName(String permanentCityName) {
		this.permanentCityName = permanentCityName;
	}

	public String getPermanentMobileNo() {
		return permanentMobileNo;
	}

	public void setPermanentMobileNo(String permanentMobileNo) {
		this.permanentMobileNo = permanentMobileNo;
	}

	public String getPhotoAttachmentInFrontOfHouse() {
		return photoAttachmentInFrontOfHouse;
	}

	public void setPhotoAttachmentInFrontOfHouse(String photoAttachmentInFrontOfHouse) {
		this.photoAttachmentInFrontOfHouse = photoAttachmentInFrontOfHouse;
	}

	public String getHouseOwnershipId() {
		return houseOwnershipId;
	}

	public void setHouseOwnershipId(String houseOwnershipId) {
		this.houseOwnershipId = houseOwnershipId;
	}

	public String getGeoLatitude() {
		return geoLatitude;
	}

	public void setGeoLatitude(String geoLatitude) {
		this.geoLatitude = geoLatitude;
	}

	public String getGeoLongitude() {
		return geoLongitude;
	}

	public void setGeoLongitude(String geoLongitude) {
		this.geoLongitude = geoLongitude;
	}

	public String getHouseTypeRoofId() {
		return houseTypeRoofId;
	}

	public void setHouseTypeRoofId(String houseTypeRoofId) {
		this.houseTypeRoofId = houseTypeRoofId;
	}

	public String getHouseTypeRoofName() {
		return houseTypeRoofName;
	}

	public void setHouseTypeRoofName(String houseTypeRoofName) {
		this.houseTypeRoofName = houseTypeRoofName;
	}

	public String getHouseTypeWallId() {
		return houseTypeWallId;
	}

	public void setHouseTypeWallId(String houseTypeWallId) {
		this.houseTypeWallId = houseTypeWallId;
	}

	public String getHouseTypeWallName() {
		return houseTypeWallName;
	}

	public void setHouseTypeWallName(String houseTypeWallName) {
		this.houseTypeWallName = houseTypeWallName;
	}

	public String getNoOfRoomDwellingexceptKitchen() {
		return noOfRoomDwellingexceptKitchen;
	}

	public void setNoOfRoomDwellingexceptKitchen(String noOfRoomDwellingexceptKitchen) {
		this.noOfRoomDwellingexceptKitchen = noOfRoomDwellingexceptKitchen;
	}

	public String getSizeOfDwellUnitCarpetArea() {
		return sizeOfDwellUnitCarpetArea;
	}

	public void setSizeOfDwellUnitCarpetArea(String sizeOfDwellUnitCarpetArea) {
		this.sizeOfDwellUnitCarpetArea = sizeOfDwellUnitCarpetArea;
	}

	public String getFamilyOwnHouseInIndia() {
		return familyOwnHouseInIndia;
	}

	public void setFamilyOwnHouseInIndia(String familyOwnHouseInIndia) {
		this.familyOwnHouseInIndia = familyOwnHouseInIndia;
	}

	public String getIndiaLocationDetailsAttachment() {
		return indiaLocationDetailsAttachment;
	}

	public void setIndiaLocationDetailsAttachment(String indiaLocationDetailsAttachment) {
		this.indiaLocationDetailsAttachment = indiaLocationDetailsAttachment;
	}

	public String getIndiaLandInSquareMeter() {
		return indiaLandInSquareMeter;
	}

	public void setIndiaLandInSquareMeter(String indiaLandInSquareMeter) {
		this.indiaLandInSquareMeter = indiaLandInSquareMeter;
	}

	public String getLandAttachmentName() {
		return landAttachmentName;
	}

	public void setLandAttachmentName(String landAttachmentName) {
		this.landAttachmentName = landAttachmentName;
	}

	public String getHouseRequirementId() {
		return houseRequirementId;
	}

	public void setHouseRequirementId(String houseRequirementId) {
		this.houseRequirementId = houseRequirementId;
	}

	public String getHouseRequirementName() {
		return houseRequirementName;
	}

	public void setHouseRequirementName(String houseRequirementName) {
		this.houseRequirementName = houseRequirementName;
	}

	public String getNameOfPattadars() {
		return nameOfPattadars;
	}

	public void setNameOfPattadars(String nameOfPattadars) {
		this.nameOfPattadars = nameOfPattadars;
	}

	public String getPattaNumber() {
		return pattaNumber;
	}

	public void setPattaNumber(String pattaNumber) {
		this.pattaNumber = pattaNumber;
	}

	public String getDagNumber() {
		return dagNumber;
	}

	public void setDagNumber(String dagNumber) {
		this.dagNumber = dagNumber;
	}

	public String getLandAreaAsInPatta() {
		return landAreaAsInPatta;
	}

	public void setLandAreaAsInPatta(String landAreaAsInPatta) {
		this.landAreaAsInPatta = landAreaAsInPatta;
	}

	public String getDimentionOfLandLength() {
		return dimentionOfLandLength;
	}

	public void setDimentionOfLandLength(String dimentionOfLandLength) {
		this.dimentionOfLandLength = dimentionOfLandLength;
	}

	public String getDimensionOfLandbreadth() {
		return dimensionOfLandbreadth;
	}

	public void setDimensionOfLandbreadth(String dimensionOfLandbreadth) {
		this.dimensionOfLandbreadth = dimensionOfLandbreadth;
	}

	public String getLandAttachment1() {
		return landAttachment1;
	}

	public void setLandAttachment1(String landAttachment1) {
		this.landAttachment1 = landAttachment1;
	}

	public String getLandAttachment2() {
		return landAttachment2;
	}

	public void setLandAttachment2(String landAttachment2) {
		this.landAttachment2 = landAttachment2;
	}

	public String getEmployementCategoryId() {
		return employementCategoryId;
	}

	public void setEmployementCategoryId(String employementCategoryId) {
		this.employementCategoryId = employementCategoryId;
	}

	public String getEmployementCategoryName() {
		return employementCategoryName;
	}

	public void setEmployementCategoryName(String employementCategoryName) {
		this.employementCategoryName = employementCategoryName;
	}

	public String getIfOtherCategoryName() {
		return ifOtherCategoryName;
	}

	public void setIfOtherCategoryName(String ifOtherCategoryName) {
		this.ifOtherCategoryName = ifOtherCategoryName;
	}

	public String getIncomeProofDocName() {
		return incomeProofDocName;
	}

	public void setIncomeProofDocName(String incomeProofDocName) {
		this.incomeProofDocName = incomeProofDocName;
	}

	public String getIncomeProofAttachment() {
		return incomeProofAttachment;
	}

	public void setIncomeProofAttachment(String incomeProofAttachment) {
		this.incomeProofAttachment = incomeProofAttachment;
	}

	public String getFamilyHaveBplCard() {
		return familyHaveBplCard;
	}

	public void setFamilyHaveBplCard(String familyHaveBplCard) {
		this.familyHaveBplCard = familyHaveBplCard;
	}

	public String getBplCardNumber() {
		return bplCardNumber;
	}

	public void setBplCardNumber(String bplCardNumber) {
		this.bplCardNumber = bplCardNumber;
	}

	public String getBplCardAttachment() {
		return bplCardAttachment;
	}

	public void setBplCardAttachment(String bplCardAttachment) {
		this.bplCardAttachment = bplCardAttachment;
	}

	public String getFamilyHaveRationCard() {
		return familyHaveRationCard;
	}

	public void setFamilyHaveRationCard(String familyHaveRationCard) {
		this.familyHaveRationCard = familyHaveRationCard;
	}

	public String getRationCardNumber() {
		return rationCardNumber;
	}

	public void setRationCardNumber(String rationCardNumber) {
		this.rationCardNumber = rationCardNumber;
	}

	public String getRationCardAttachment() {
		return rationCardAttachment;
	}

	public void setRationCardAttachment(String rationCardAttachment) {
		this.rationCardAttachment = rationCardAttachment;
	}

	public String getHfaCategoryId() {
		return hfaCategoryId;
	}

	public void setHfaCategoryId(String hfaCategoryId) {
		this.hfaCategoryId = hfaCategoryId;
	}

	public String getHfaCategoryName() {
		return hfaCategoryName;
	}

	public void setHfaCategoryName(String hfaCategoryName) {
		this.hfaCategoryName = hfaCategoryName;
	}

	public String getVehicleCategoryId() {
		return vehicleCategoryId;
	}

	public void setVehicleCategoryId(String vehicleCategoryId) {
		this.vehicleCategoryId = vehicleCategoryId;
	}

	public String getVehicleCategoryName() {
		return vehicleCategoryName;
	}

	public void setVehicleCategoryName(String vehicleCategoryName) {
		this.vehicleCategoryName = vehicleCategoryName;
	}

	public String getVehicleRegistrationNumber() {
		return vehicleRegistrationNumber;
	}

	public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
	}

	public String getVehicleRegistrationAttachment() {
		return vehicleRegistrationAttachment;
	}

	public void setVehicleRegistrationAttachment(String vehicleRegistrationAttachment) {
		this.vehicleRegistrationAttachment = vehicleRegistrationAttachment;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchIfscCode() {
		return branchIfscCode;
	}

	public void setBranchIfscCode(String branchIfscCode) {
		this.branchIfscCode = branchIfscCode;
	}

	public String getSignatureOfApplicant() {
		return signatureOfApplicant;
	}

	public void setSignatureOfApplicant(String signatureOfApplicant) {
		this.signatureOfApplicant = signatureOfApplicant;
	}

	public String getSubmittedData() {
		return submittedData;
	}

	public void setSubmittedData(String submittedData) {
		this.submittedData = submittedData;
	}

	@Override
	public String toString() {
		return "PmayReportDataForAdmins [userSurveyId=" + userSurveyId + ", userId=" + userId + ", wardId=" + wardId
				+ ", wardName=" + wardName + ", slumNonSlum=" + slumNonSlum + ", validationPendingNonSlum="
				+ validationPendingNonSlum + ", eligibilityForScheme=" + eligibilityForScheme + ", familyHead="
				+ familyHead + ", fatherOrHusbandName=" + fatherOrHusbandName + ", photoAttachmentName="
				+ photoAttachmentName + ", aadharCardNumber=" + aadharCardNumber + ", reasonforAAdharNotAvailable="
				+ reasonforAAdharNotAvailable + ", idTypeId=" + idTypeId + ", idTypeName=" + idTypeName + ", idNumber="
				+ idNumber + ", idAttachmentName=" + idAttachmentName + ", contactNumber=" + contactNumber
				+ ", genderId=" + genderId + ", genderName=" + genderName + ", dob=" + dob + ", age=" + age
				+ ", maritalStatusId=" + maritalStatusId + ", maritalStatusName=" + maritalStatusName + ", religionId="
				+ religionId + ", religionName=" + religionName + ", religionIfOther=" + religionIfOther + ", casteId="
				+ casteId + ", casteName=" + casteName + ", reasonForNonEligibility=" + reasonForNonEligibility
				+ ", noOfYearsOfStayPresent=" + noOfYearsOfStayPresent + ", presentHouseFlatNo=" + presentHouseFlatNo
				+ ", presentNameOfStreet=" + presentNameOfStreet + ", presentCityId=" + presentCityId
				+ ", presentCityName=" + presentCityName + ", presentMobNo=" + presentMobNo
				+ ", permanentSameAsPresent=" + permanentSameAsPresent + ", noOfYearsOfStayPermanent="
				+ noOfYearsOfStayPermanent + ", permanentHouseFlatNo=" + permanentHouseFlatNo
				+ ", permanentNameOfStreet=" + permanentNameOfStreet + ", permanentCityId=" + permanentCityId
				+ ", permanentCityName=" + permanentCityName + ", permanentMobileNo=" + permanentMobileNo
				+ ", photoAttachmentInFrontOfHouse=" + photoAttachmentInFrontOfHouse + ", houseOwnershipId="
				+ houseOwnershipId + ", geoLatitude=" + geoLatitude + ", geoLongitude=" + geoLongitude
				+ ", houseTypeRoofId=" + houseTypeRoofId + ", houseTypeRoofName=" + houseTypeRoofName
				+ ", houseTypeWallId=" + houseTypeWallId + ", houseTypeWallName=" + houseTypeWallName
				+ ", noOfRoomDwellingexceptKitchen=" + noOfRoomDwellingexceptKitchen + ", sizeOfDwellUnitCarpetArea="
				+ sizeOfDwellUnitCarpetArea + ", familyOwnHouseInIndia=" + familyOwnHouseInIndia
				+ ", indiaLocationDetailsAttachment=" + indiaLocationDetailsAttachment + ", indiaLandInSquareMeter="
				+ indiaLandInSquareMeter + ", landAttachmentName=" + landAttachmentName + ", houseRequirementId="
				+ houseRequirementId + ", houseRequirementName=" + houseRequirementName + ", nameOfPattadars="
				+ nameOfPattadars + ", pattaNumber=" + pattaNumber + ", dagNumber=" + dagNumber + ", landAreaAsInPatta="
				+ landAreaAsInPatta + ", dimentionOfLandLength=" + dimentionOfLandLength + ", dimensionOfLandbreadth="
				+ dimensionOfLandbreadth + ", landAttachment1=" + landAttachment1 + ", landAttachment2="
				+ landAttachment2 + ", employementCategoryId=" + employementCategoryId + ", employementCategoryName="
				+ employementCategoryName + ", ifOtherCategoryName=" + ifOtherCategoryName + ", incomeProofDocName="
				+ incomeProofDocName + ", incomeProofAttachment=" + incomeProofAttachment + ", familyHaveBplCard="
				+ familyHaveBplCard + ", bplCardNumber=" + bplCardNumber + ", bplCardAttachment=" + bplCardAttachment
				+ ", familyHaveRationCard=" + familyHaveRationCard + ", rationCardNumber=" + rationCardNumber
				+ ", rationCardAttachment=" + rationCardAttachment + ", hfaCategoryId=" + hfaCategoryId
				+ ", hfaCategoryName=" + hfaCategoryName + ", vehicleCategoryId=" + vehicleCategoryId
				+ ", vehicleCategoryName=" + vehicleCategoryName + ", vehicleRegistrationNumber="
				+ vehicleRegistrationNumber + ", vehicleRegistrationAttachment=" + vehicleRegistrationAttachment
				+ ", bankAccountNo=" + bankAccountNo + ", bankName=" + bankName + ", otherBankName=" + otherBankName
				+ ", bankId=" + bankId + ", branchName=" + branchName + ", branchIfscCode=" + branchIfscCode
				+ ", signatureOfApplicant=" + signatureOfApplicant + ", submittedData=" + submittedData
				+ ", housingCategoryId=" + housingCategoryId + ", nameOfFamilyMember=" + nameOfFamilyMember
				+ ", relationshipId=" + relationshipId + ", relationshipName=" + relationshipName + ", familyGenderId="
				+ familyGenderId + ", familyGenderName=" + familyGenderName + ", ageOfFamilyMember=" + ageOfFamilyMember
				+ ", familyMemberIdCardNumber=" + familyMemberIdCardNumber + ", surveyFamilyDetailId="
				+ surveyFamilyDetailId + ", editButtonDisable=" + editButtonDisable + ", landAddress=" + landAddress
				+ ", ulbNameId=" + ulbNameId + ", ulbName=" + ulbName + ", slumNonSlumStatus=" + slumNonSlumStatus
				+ ", eligibleStatus=" + eligibleStatus + ", validationPendingStatus=" + validationPendingStatus
				+ ", userRMN=" + userRMN + "]";
	}

	/**
	 * @return the bankId
	 */
	public String getBankId() {
		return bankId;
	}

	/**
	 * @param bankId
	 *            the bankId to set
	 */
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the otherBankName
	 */
	public String getOtherBankName() {
		return otherBankName;
	}

	/**
	 * @param otherBankName
	 *            the otherBankName to set
	 */
	public void setOtherBankName(String otherBankName) {
		this.otherBankName = otherBankName;
	}

	public String getUlbNameId() {
		return ulbNameId;
	}

	public void setUlbNameId(String ulbNameId) {
		this.ulbNameId = ulbNameId;
	}

}
