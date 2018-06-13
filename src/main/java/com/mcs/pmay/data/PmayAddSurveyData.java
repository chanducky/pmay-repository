
package com.mcs.pmay.data;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author chandrakumar
 *
 */
public class PmayAddSurveyData {

	private String userId;
	private String surveyId;
	private String formNo;
	private String surveyCity;
	private String slumRadio;
	private String validationPendingStatus;
	private String familyHeadName;
	private String fatherHusbandName;
	private String adharNo;
	private String adharReason;
	private String contactNo;
	private String maritalStatus;
	private String eligibleStatus;
	private String nonEligibleReason;
	private String genderId;
	private MultipartFile applicantPhoto;
	private String idType;
	private String idNo;
	private MultipartFile idPhoto;
	private String dob;
	private String religion;
	private String religionIfOther;
	private String caste;
	private String presentTown;
	private String presentHouseNo;
	private String presentStreetName;
	private String presentCity;
	private String presentMobileNo;
	private String isSameAsPresentAdd;
	private String permanentTown;
	private String permanentHouseNo;
	private String permanentStreetName;
	private String permanentCity;
	private String permanentMobileNo;

	private MultipartFile presentInfrontHousePic;
	private String houseRoofType;
	private String dwellinUnitRoom;
	private String ownsRadio;
	private MultipartFile locationDetailsPic;
	private String landAddress;
	private String landinSqm;
	private String ownershipHouse;
	private String houseWallType;
	private String sizeExistingDwelling;
	private MultipartFile landRecordPic;
	private String houseRequirementRadio;
	private String requirement;

	private String pattadarName;
	private String dagNo;
	private String pattaNo;
	private String landAreaPatta;
	private String landLength;
	private String landBreadth;
	private MultipartFile landPhoto1;
	private MultipartFile landPhoto2;
	private String employmentStatus;
	private String employmentStatusName;
	private String averageIncome;
	private String incomeProof;
	private MultipartFile incomeProofPhoto;
	private String bplRadio;
	private String bplNo;
	private MultipartFile bplPicture;
	private String rationRadio;
	private String rationCardNo;
	private String preferredAssistanceHfa;
	private String wardDetails;
	private MultipartFile rationCardPic;
	private String vehicleCategoryId;
	private String vehicleRegdNo;
	private MultipartFile vehiclePhoto;
	private String bankAccNo;
	private String bankId;
	private String bankName;
	private String bankBranchName;
	private String bankIfscCode;
	private MultipartFile applicantSignature;

	private String familyMemberName;
	private String familyMemberRelation;
	private String familyMemberGender;
	private String familyMemberAge;
	private String familyMemberIdCardNo;

	private String isSubmitted;
	private byte[] biometricDetails;
	private String ulbNameId;
	private String geoLongitude;
	private String geoLatitude;

	private String app;
	
	public byte[] getBiometricDetails() {
		return biometricDetails;
	}

	public void setBiometricDetails(byte[] biometricDetails) {
		this.biometricDetails = biometricDetails;
	}

	public String getLandAddress() {
		return landAddress;
	}

	public void setLandAddress(String landAddress) {
		this.landAddress = landAddress;
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public String getFamilyMemberName() {
		return familyMemberName;
	}

	public void setFamilyMemberName(String familyMemberName) {
		this.familyMemberName = familyMemberName;
	}

	public String getFamilyMemberRelation() {
		return familyMemberRelation;
	}

	public void setFamilyMemberRelation(String familyMemberRelation) {
		this.familyMemberRelation = familyMemberRelation;
	}

	public String getFamilyMemberGender() {
		return familyMemberGender;
	}

	public void setFamilyMemberGender(String familyMemberGender) {
		this.familyMemberGender = familyMemberGender;
	}

	public String getFamilyMemberAge() {
		return familyMemberAge;
	}

	public void setFamilyMemberAge(String familyMemberAge) {
		this.familyMemberAge = familyMemberAge;
	}

	public String getFamilyMemberIdCardNo() {
		return familyMemberIdCardNo;
	}

	public void setFamilyMemberIdCardNo(String familyMemberIdCardNo) {
		this.familyMemberIdCardNo = familyMemberIdCardNo;
	}

	public String getFormNo() {
		return formNo;
	}

	public void setFormNo(String formNo) {
		this.formNo = formNo;
	}

	public String getSurveyCity() {
		return surveyCity;
	}

	public void setSurveyCity(String surveyCity) {
		this.surveyCity = surveyCity;
	}

	public String getSlumRadio() {
		return slumRadio;
	}

	public void setSlumRadio(String slumRadio) {
		this.slumRadio = slumRadio;
	}

	public String getValidationPendingStatus() {
		return validationPendingStatus;
	}

	public void setValidationPendingStatus(String validationPendingStatus) {
		this.validationPendingStatus = validationPendingStatus;
	}

	public String getFamilyHeadName() {
		return familyHeadName;
	}

	public void setFamilyHeadName(String familyHeadName) {
		this.familyHeadName = familyHeadName;
	}

	public String getFatherHusbandName() {
		return fatherHusbandName;
	}

	public void setFatherHusbandName(String fatherHusbandName) {
		this.fatherHusbandName = fatherHusbandName;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public String getAdharReason() {
		return adharReason;
	}

	public void setAdharReason(String adharReason) {
		this.adharReason = adharReason;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getEligibleStatus() {
		return eligibleStatus;
	}

	public void setEligibleStatus(String eligibleStatus) {
		this.eligibleStatus = eligibleStatus;
	}

	public String getNonEligibleReason() {
		return nonEligibleReason;
	}

	public void setNonEligibleReason(String nonEligibleReason) {
		this.nonEligibleReason = nonEligibleReason;
	}

	public String getGenderId() {
		return genderId;
	}

	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getReligionIfOther() {
		return religionIfOther;
	}

	public void setReligionIfOther(String religionIfOther) {
		this.religionIfOther = religionIfOther;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getPresentTown() {
		return presentTown;
	}

	public void setPresentTown(String presentTown) {
		this.presentTown = presentTown;
	}

	public String getPresentHouseNo() {
		return presentHouseNo;
	}

	public void setPresentHouseNo(String presentHouseNo) {
		this.presentHouseNo = presentHouseNo;
	}

	public String getPresentStreetName() {
		return presentStreetName;
	}

	public void setPresentStreetName(String presentStreetName) {
		this.presentStreetName = presentStreetName;
	}

	public String getPresentCity() {
		return presentCity;
	}

	public void setPresentCity(String presentCity) {
		this.presentCity = presentCity;
	}

	public String getPresentMobileNo() {
		return presentMobileNo;
	}

	public void setPresentMobileNo(String presentMobileNo) {
		this.presentMobileNo = presentMobileNo;
	}

	public String getIsSameAsPresentAdd() {
		return isSameAsPresentAdd;
	}

	public void setIsSameAsPresentAdd(String isSameAsPresentAdd) {
		this.isSameAsPresentAdd = isSameAsPresentAdd;
	}

	public String getPermanentTown() {
		return permanentTown;
	}

	public void setPermanentTown(String permanentTown) {
		this.permanentTown = permanentTown;
	}

	public String getPermanentHouseNo() {
		return permanentHouseNo;
	}

	public void setPermanentHouseNo(String permanentHouseNo) {
		this.permanentHouseNo = permanentHouseNo;
	}

	public String getPermanentStreetName() {
		return permanentStreetName;
	}

	public void setPermanentStreetName(String permanentStreetName) {
		this.permanentStreetName = permanentStreetName;
	}

	public String getPermanentCity() {
		return permanentCity;
	}

	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}

	public String getPermanentMobileNo() {
		return permanentMobileNo;
	}

	public void setPermanentMobileNo(String permanentMobileNo) {
		this.permanentMobileNo = permanentMobileNo;
	}

	public String getHouseRoofType() {
		return houseRoofType;
	}

	public void setHouseRoofType(String houseRoofType) {
		this.houseRoofType = houseRoofType;
	}

	public String getOwnsRadio() {
		return ownsRadio;
	}

	public void setOwnsRadio(String ownsRadio) {
		this.ownsRadio = ownsRadio;
	}

	public String getLandinSqm() {
		return landinSqm;
	}

	public void setLandinSqm(String landinSqm) {
		this.landinSqm = landinSqm;
	}

	public String getOwnershipHouse() {
		return ownershipHouse;
	}

	public void setOwnershipHouse(String ownershipHouse) {
		this.ownershipHouse = ownershipHouse;
	}

	public String getHouseWallType() {
		return houseWallType;
	}

	public void setHouseWallType(String houseWallType) {
		this.houseWallType = houseWallType;
	}

	public String getSizeExistingDwelling() {
		return sizeExistingDwelling;
	}

	public void setSizeExistingDwelling(String sizeExistingDwelling) {
		this.sizeExistingDwelling = sizeExistingDwelling;
	}

	public String getHouseRequirementRadio() {
		return houseRequirementRadio;
	}

	public void setHouseRequirementRadio(String houseRequirementRadio) {
		this.houseRequirementRadio = houseRequirementRadio;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getPattadarName() {
		return pattadarName;
	}

	public void setPattadarName(String pattadarName) {
		this.pattadarName = pattadarName;
	}

	public String getDagNo() {
		return dagNo;
	}

	public void setDagNo(String dagNo) {
		this.dagNo = dagNo;
	}

	public String getPattaNo() {
		return pattaNo;
	}

	public void setPattaNo(String pattaNo) {
		this.pattaNo = pattaNo;
	}

	public String getLandAreaPatta() {
		return landAreaPatta;
	}

	public void setLandAreaPatta(String landAreaPatta) {
		this.landAreaPatta = landAreaPatta;
	}

	public String getLandLength() {
		return landLength;
	}

	public void setLandLength(String landLength) {
		this.landLength = landLength;
	}

	public String getLandBreadth() {
		return landBreadth;
	}

	public void setLandBreadth(String landBreadth) {
		this.landBreadth = landBreadth;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getEmploymentStatusName() {
		return employmentStatusName;
	}

	public void setEmploymentStatusName(String employmentStatusName) {
		this.employmentStatusName = employmentStatusName;
	}

	public String getAverageIncome() {
		return averageIncome;
	}

	public void setAverageIncome(String averageIncome) {
		this.averageIncome = averageIncome;
	}

	public String getIncomeProof() {
		return incomeProof;
	}

	public void setIncomeProof(String incomeProof) {
		this.incomeProof = incomeProof;
	}

	public MultipartFile getIncomeProofPhoto() {
		return incomeProofPhoto;
	}

	public void setIncomeProofPhoto(MultipartFile incomeProofPhoto) {
		this.incomeProofPhoto = incomeProofPhoto;
	}

	public String getBplRadio() {
		return bplRadio;
	}

	public void setBplRadio(String bplRadio) {
		this.bplRadio = bplRadio;
	}

	public String getBplNo() {
		return bplNo;
	}

	public void setBplNo(String bplNo) {
		this.bplNo = bplNo;
	}

	public String getRationRadio() {
		return rationRadio;
	}

	public void setRationRadio(String rationRadio) {
		this.rationRadio = rationRadio;
	}

	public String getRationCardNo() {
		return rationCardNo;
	}

	public void setRationCardNo(String rationCardNo) {
		this.rationCardNo = rationCardNo;
	}

	public String getPreferredAssistanceHfa() {
		return preferredAssistanceHfa;
	}

	public void setPreferredAssistanceHfa(String preferredAssistanceHfa) {
		this.preferredAssistanceHfa = preferredAssistanceHfa;
	}

	public String getWardDetails() {
		return wardDetails;
	}

	public void setWardDetails(String wardDetails) {
		this.wardDetails = wardDetails;
	}

	public String getVehicleCategoryId() {
		return vehicleCategoryId;
	}

	public void setVehicleCategoryId(String vehicleCategoryId) {
		this.vehicleCategoryId = vehicleCategoryId;
	}

	public String getVehicleRegdNo() {
		return vehicleRegdNo;
	}

	public void setVehicleRegdNo(String vehicleRegdNo) {
		this.vehicleRegdNo = vehicleRegdNo;
	}

	public String getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranchName() {
		return bankBranchName;
	}

	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}

	public String getBankIfscCode() {
		return bankIfscCode;
	}

	public void setBankIfscCode(String bankIfscCode) {
		this.bankIfscCode = bankIfscCode;
	}

	public MultipartFile getApplicantPhoto() {
		return applicantPhoto;
	}

	public void setApplicantPhoto(MultipartFile applicantPhoto) {
		this.applicantPhoto = applicantPhoto;
	}

	public MultipartFile getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(MultipartFile idPhoto) {
		this.idPhoto = idPhoto;
	}

	public MultipartFile getPresentInfrontHousePic() {
		return presentInfrontHousePic;
	}

	public void setPresentInfrontHousePic(MultipartFile presentInfrontHousePic) {
		this.presentInfrontHousePic = presentInfrontHousePic;
	}

	public String getDwellinUnitRoom() {
		return dwellinUnitRoom;
	}

	public void setDwellinUnitRoom(String dwellinUnitRoom) {
		this.dwellinUnitRoom = dwellinUnitRoom;
	}

	public MultipartFile getLocationDetailsPic() {
		return locationDetailsPic;
	}

	public void setLocationDetailsPic(MultipartFile locationDetailsPic) {
		this.locationDetailsPic = locationDetailsPic;
	}

	public MultipartFile getLandRecordPic() {
		return landRecordPic;
	}

	public void setLandRecordPic(MultipartFile landRecordPic) {
		this.landRecordPic = landRecordPic;
	}

	public MultipartFile getLandPhoto1() {
		return landPhoto1;
	}

	public void setLandPhoto1(MultipartFile landPhoto1) {
		this.landPhoto1 = landPhoto1;
	}

	public MultipartFile getLandPhoto2() {
		return landPhoto2;
	}

	public void setLandPhoto2(MultipartFile landPhoto2) {
		this.landPhoto2 = landPhoto2;
	}

	public MultipartFile getBplPicture() {
		return bplPicture;
	}

	public void setBplPicture(MultipartFile bplPicture) {
		this.bplPicture = bplPicture;
	}

	public MultipartFile getRationCardPic() {
		return rationCardPic;
	}

	public void setRationCardPic(MultipartFile rationCardPic) {
		this.rationCardPic = rationCardPic;
	}

	public MultipartFile getVehiclePhoto() {
		return vehiclePhoto;
	}

	public void setVehiclePhoto(MultipartFile vehiclePhoto) {
		this.vehiclePhoto = vehiclePhoto;
	}

	public MultipartFile getApplicantSignature() {
		return applicantSignature;
	}

	public void setApplicantSignature(MultipartFile applicantSignature) {
		this.applicantSignature = applicantSignature;
	}	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PmayAddSurveyData [userId=" + userId + ", surveyId=" + surveyId + ", formNo=" + formNo + ", surveyCity="
				+ surveyCity + ", slumRadio=" + slumRadio + ", validationPendingStatus=" + validationPendingStatus
				+ ", familyHeadName=" + familyHeadName + ", fatherHusbandName=" + fatherHusbandName + ", adharNo="
				+ adharNo + ", adharReason=" + adharReason + ", contactNo=" + contactNo + ", maritalStatus="
				+ maritalStatus + ", eligibleStatus=" + eligibleStatus + ", nonEligibleReason=" + nonEligibleReason
				+ ", genderId=" + genderId + ", applicantPhoto=" + applicantPhoto + ", idType=" + idType + ", idNo="
				+ idNo + ", idPhoto=" + idPhoto + ", dob=" + dob + ", religion=" + religion + ", religionIfOther="
				+ religionIfOther + ", caste=" + caste + ", presentTown=" + presentTown + ", presentHouseNo="
				+ presentHouseNo + ", presentStreetName=" + presentStreetName + ", presentCity=" + presentCity
				+ ", presentMobileNo=" + presentMobileNo + ", isSameAsPresentAdd=" + isSameAsPresentAdd
				+ ", permanentTown=" + permanentTown + ", permanentHouseNo=" + permanentHouseNo
				+ ", permanentStreetName=" + permanentStreetName + ", permanentCity=" + permanentCity
				+ ", permanentMobileNo=" + permanentMobileNo + ", presentInfrontHousePic=" + presentInfrontHousePic
				+ ", houseRoofType=" + houseRoofType + ", dwellinUnitRoom=" + dwellinUnitRoom + ", ownsRadio="
				+ ownsRadio + ", locationDetailsPic=" + locationDetailsPic + ", landinSqm=" + landinSqm
				+ ", ownershipHouse=" + ownershipHouse + ", houseWallType=" + houseWallType + ", sizeExistingDwelling="
				+ sizeExistingDwelling + ", landRecordPic=" + landRecordPic + ", houseRequirementRadio="
				+ houseRequirementRadio + ", requirement=" + requirement + ", pattadarName=" + pattadarName + ", dagNo="
				+ dagNo + ", pattaNo=" + pattaNo + ", landAreaPatta=" + landAreaPatta + ", landLength=" + landLength
				+ ", landBreadth=" + landBreadth + ", landPhoto1=" + landPhoto1 + ", landPhoto2=" + landPhoto2
				+ ", employmentStatus=" + employmentStatus + ", employmentStatusName=" + employmentStatusName
				+ ", averageIncome=" + averageIncome + ", incomeProof=" + incomeProof + ", incomeProofPhoto="
				+ incomeProofPhoto + ", bplRadio=" + bplRadio + ", bplNo=" + bplNo + ", bplPicture=" + bplPicture
				+ ", rationRadio=" + rationRadio + ", rationCardNo=" + rationCardNo + ", preferredAssistanceHfa="
				+ preferredAssistanceHfa + ", wardDetails=" + wardDetails + ", rationCardPic=" + rationCardPic
				+ ", vehicleCategoryId=" + vehicleCategoryId + ", vehicleRegdNo=" + vehicleRegdNo + ", vehiclePhoto="
				+ vehiclePhoto + ", bankAccNo=" + bankAccNo + ", bankId=" + bankId + ", bankName=" + bankName
				+ ", bankBranchName=" + bankBranchName + ", bankIfscCode=" + bankIfscCode + ", applicantSignature="
				+ applicantSignature + ", familyMemberName=" + familyMemberName + ", familyMemberRelation="
				+ familyMemberRelation + ", familyMemberGender=" + familyMemberGender + ", familyMemberAge="
				+ familyMemberAge + ", familyMemberIdCardNo=" + familyMemberIdCardNo + ", isSubmitted=" + isSubmitted
				+ ", biometricDetails=" + Arrays.toString(biometricDetails) + "]";
	}

	/**
	 * @return the isSubmitted
	 */
	public String getIsSubmitted() {
		return isSubmitted;
	}

	/**
	 * @param isSubmitted
	 *            the isSubmitted to set
	 */
	public void setIsSubmitted(String isSubmitted) {
		this.isSubmitted = isSubmitted;
	}

	/**
	 * @return the bankId
	 */
	public String getBankId() {
		return bankId;
	}

	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getUlbNameId() {
		return ulbNameId;
	}

	public void setUlbNameId(String ulbNameId) {
		this.ulbNameId = ulbNameId;
	}

	public String getGeoLongitude() {
		return geoLongitude;
	}

	public void setGeoLongitude(String geoLongitude) {
		this.geoLongitude = geoLongitude;
	}

	public String getGeoLatitude() {
		return geoLatitude;
	}

	public void setGeoLatitude(String geoLatitude) {
		this.geoLatitude = geoLatitude;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}
	
}
