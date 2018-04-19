package com.mcs.pmay.data;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class PmaySlumAddData {

	private String surveyId;
	private String userId;
	private String chckSlumRadio;
	private String slumFamilyHeadName;
	private String slumFatherHusbandName;
	private String slumAdharNo;
	private String slumAdharReason;
	private String genderValue;
	private String slumIdProof;
	private String slumIdProofNo;
	private MultipartFile slumIdImage;

	private String slumPresentTown;
	private String slumPresentHouseNo;
	private String slumPresentStreetName;
	private String slumPresentCity;
	private String presentMobileNo;
	private String slumIsSameAsPresentAdd;
	private String slumPermanentTown;
	private String slumPermanentHouseNo;
	private String slumPermanentStreetName;
	private String slumPermanentCity;
	private String slumPermanentMobileNo;

	private String familyMemberName;
	private String familyMemberRelation;
	private String familyMemberGender;
	private String familyMemberAge;
	private String familyMemberIdCardNo;

	private String slumReligion;
	private String slumCaste;
	private String slumOwnsRadio;
	private String slumLandAddress;
	private String slumLandinSqm;
	private MultipartFile slumApplicantSignature;
	private MultipartFile slumLocationDetailsPic;

	private String isSubmittedFlag;

	private String nonEligibleReason;
	private String eligibleStatus;
	private String wardDetails;
	private byte[] slumBiometricDetails;
	private String ulbNameId;
	private String maritalStatus;
	private String religionIfOther;
	private String dob;
	private String geoLongitude;
	private String geoLatitude;
	private MultipartFile slumApplicantPhoto;

	public MultipartFile getSlumApplicantPhoto() {
		return slumApplicantPhoto;
	}

	public void setSlumApplicantPhoto(MultipartFile slumApplicantPhoto) {
		this.slumApplicantPhoto = slumApplicantPhoto;
	}

	public String getSlumIdProof() {
		return slumIdProof;
	}

	public void setSlumIdProof(String slumIdProof) {
		this.slumIdProof = slumIdProof;
	}

	public String getSlumIdProofNo() {
		return slumIdProofNo;
	}

	public void setSlumIdProofNo(String slumIdProofNo) {
		this.slumIdProofNo = slumIdProofNo;
	}

	public MultipartFile getSlumIdImage() {
		return slumIdImage;
	}

	public void setSlumIdImage(MultipartFile slumIdImage) {
		this.slumIdImage = slumIdImage;
	}

	public byte[] getSlumBiometricDetails() {
		return slumBiometricDetails;
	}

	public void setSlumBiometricDetails(byte[] slumBiometricDetails) {
		this.slumBiometricDetails = slumBiometricDetails;
	}

	public String getSlumLandAddress() {
		return slumLandAddress;
	}

	public void setSlumLandAddress(String slumLandAddress) {
		this.slumLandAddress = slumLandAddress;
	}

	public String getNonEligibleReason() {
		return nonEligibleReason;
	}

	public void setNonEligibleReason(String nonEligibleReason) {
		this.nonEligibleReason = nonEligibleReason;
	}

	public String getEligibleStatus() {
		return eligibleStatus;
	}

	public void setEligibleStatus(String eligibleStatus) {
		this.eligibleStatus = eligibleStatus;
	}

	public String getWardDetails() {
		return wardDetails;
	}

	public void setWardDetails(String wardDetails) {
		this.wardDetails = wardDetails;
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getChckSlumRadio() {
		return chckSlumRadio;
	}

	public void setChckSlumRadio(String chckSlumRadio) {
		this.chckSlumRadio = chckSlumRadio;
	}

	public String getSlumFamilyHeadName() {
		return slumFamilyHeadName;
	}

	public void setSlumFamilyHeadName(String slumFamilyHeadName) {
		this.slumFamilyHeadName = slumFamilyHeadName;
	}

	public String getSlumFatherHusbandName() {
		return slumFatherHusbandName;
	}

	public void setSlumFatherHusbandName(String slumFatherHusbandName) {
		this.slumFatherHusbandName = slumFatherHusbandName;
	}

	public String getSlumAdharNo() {
		return slumAdharNo;
	}

	public void setSlumAdharNo(String slumAdharNo) {
		this.slumAdharNo = slumAdharNo;
	}

	public String getSlumAdharReason() {
		return slumAdharReason;
	}

	public void setSlumAdharReason(String slumAdharReason) {
		this.slumAdharReason = slumAdharReason;
	}

	public String getGenderValue() {
		return genderValue;
	}

	public void setGenderValue(String genderValue) {
		this.genderValue = genderValue;
	}

	public String getSlumPresentTown() {
		return slumPresentTown;
	}

	public void setSlumPresentTown(String slumPresentTown) {
		this.slumPresentTown = slumPresentTown;
	}

	public String getSlumPresentHouseNo() {
		return slumPresentHouseNo;
	}

	public void setSlumPresentHouseNo(String slumPresentHouseNo) {
		this.slumPresentHouseNo = slumPresentHouseNo;
	}

	public String getSlumPresentStreetName() {
		return slumPresentStreetName;
	}

	public void setSlumPresentStreetName(String slumPresentStreetName) {
		this.slumPresentStreetName = slumPresentStreetName;
	}

	public String getSlumPresentCity() {
		return slumPresentCity;
	}

	public void setSlumPresentCity(String slumPresentCity) {
		this.slumPresentCity = slumPresentCity;
	}

	public String getPresentMobileNo() {
		return presentMobileNo;
	}

	public void setPresentMobileNo(String presentMobileNo) {
		this.presentMobileNo = presentMobileNo;
	}

	public String getSlumIsSameAsPresentAdd() {
		return slumIsSameAsPresentAdd;
	}

	public void setSlumIsSameAsPresentAdd(String slumIsSameAsPresentAdd) {
		this.slumIsSameAsPresentAdd = slumIsSameAsPresentAdd;
	}

	public String getSlumPermanentTown() {
		return slumPermanentTown;
	}

	public void setSlumPermanentTown(String slumPermanentTown) {
		this.slumPermanentTown = slumPermanentTown;
	}

	public String getSlumPermanentHouseNo() {
		return slumPermanentHouseNo;
	}

	public void setSlumPermanentHouseNo(String slumPermanentHouseNo) {
		this.slumPermanentHouseNo = slumPermanentHouseNo;
	}

	public String getSlumPermanentStreetName() {
		return slumPermanentStreetName;
	}

	public void setSlumPermanentStreetName(String slumPermanentStreetName) {
		this.slumPermanentStreetName = slumPermanentStreetName;
	}

	public String getSlumPermanentCity() {
		return slumPermanentCity;
	}

	public void setSlumPermanentCity(String slumPermanentCity) {
		this.slumPermanentCity = slumPermanentCity;
	}

	public String getSlumPermanentMobileNo() {
		return slumPermanentMobileNo;
	}

	public void setSlumPermanentMobileNo(String slumPermanentMobileNo) {
		this.slumPermanentMobileNo = slumPermanentMobileNo;
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

	public String getSlumReligion() {
		return slumReligion;
	}

	public void setSlumReligion(String slumReligion) {
		this.slumReligion = slumReligion;
	}

	public String getSlumCaste() {
		return slumCaste;
	}

	public void setSlumCaste(String slumCaste) {
		this.slumCaste = slumCaste;
	}

	public String getSlumOwnsRadio() {
		return slumOwnsRadio;
	}

	public void setSlumOwnsRadio(String slumOwnsRadio) {
		this.slumOwnsRadio = slumOwnsRadio;
	}

	public String getSlumLandinSqm() {
		return slumLandinSqm;
	}

	public void setSlumLandinSqm(String slumLandinSqm) {
		this.slumLandinSqm = slumLandinSqm;
	}

	public String getIsSubmittedFlag() {
		return isSubmittedFlag;
	}

	public void setIsSubmittedFlag(String isSubmittedFlag) {
		this.isSubmittedFlag = isSubmittedFlag;
	}

	public MultipartFile getSlumApplicantSignature() {
		return slumApplicantSignature;
	}

	public void setSlumApplicantSignature(MultipartFile slumApplicantSignature) {
		this.slumApplicantSignature = slumApplicantSignature;
	}

	public MultipartFile getSlumLocationDetailsPic() {
		return slumLocationDetailsPic;
	}

	public void setSlumLocationDetailsPic(MultipartFile slumLocationDetailsPic) {
		this.slumLocationDetailsPic = slumLocationDetailsPic;
	}

	public String getUlbNameId() {
		return ulbNameId;
	}

	public void setUlbNameId(String ulbNameId) {
		this.ulbNameId = ulbNameId;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getReligionIfOther() {
		return religionIfOther;
	}

	public void setReligionIfOther(String religionIfOther) {
		this.religionIfOther = religionIfOther;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	@Override
	public String toString() {
		return "PmaySlumAddData [surveyId=" + surveyId + ", userId=" + userId + ", chckSlumRadio=" + chckSlumRadio
				+ ", slumFamilyHeadName=" + slumFamilyHeadName + ", slumFatherHusbandName=" + slumFatherHusbandName
				+ ", slumAdharNo=" + slumAdharNo + ", slumAdharReason=" + slumAdharReason + ", genderValue="
				+ genderValue + ", slumIdProof=" + slumIdProof + ", slumIdProofNo=" + slumIdProofNo + ", slumIdImage="
				+ slumIdImage + ", slumPresentTown=" + slumPresentTown + ", slumPresentHouseNo=" + slumPresentHouseNo
				+ ", slumPresentStreetName=" + slumPresentStreetName + ", slumPresentCity=" + slumPresentCity
				+ ", presentMobileNo=" + presentMobileNo + ", slumIsSameAsPresentAdd=" + slumIsSameAsPresentAdd
				+ ", slumPermanentTown=" + slumPermanentTown + ", slumPermanentHouseNo=" + slumPermanentHouseNo
				+ ", slumPermanentStreetName=" + slumPermanentStreetName + ", slumPermanentCity=" + slumPermanentCity
				+ ", slumPermanentMobileNo=" + slumPermanentMobileNo + ", familyMemberName=" + familyMemberName
				+ ", familyMemberRelation=" + familyMemberRelation + ", familyMemberGender=" + familyMemberGender
				+ ", familyMemberAge=" + familyMemberAge + ", familyMemberIdCardNo=" + familyMemberIdCardNo
				+ ", slumReligion=" + slumReligion + ", slumCaste=" + slumCaste + ", slumOwnsRadio=" + slumOwnsRadio
				+ ", slumLandAddress=" + slumLandAddress + ", slumLandinSqm=" + slumLandinSqm
				+ ", slumApplicantSignature=" + slumApplicantSignature + ", slumLocationDetailsPic="
				+ slumLocationDetailsPic + ", isSubmittedFlag=" + isSubmittedFlag + ", nonEligibleReason="
				+ nonEligibleReason + ", eligibleStatus=" + eligibleStatus + ", wardDetails=" + wardDetails
				+ ", slumBiometricDetails=" + Arrays.toString(slumBiometricDetails) + ", ulbNameId=" + ulbNameId
				+ ", maritalStatus=" + maritalStatus + ", religionIfOther=" + religionIfOther + ", dob=" + dob
				+ ", geoLongitude=" + geoLongitude + ", geoLatitude=" + geoLatitude + ", slumApplicantPhoto="
				+ slumApplicantPhoto + "]";
	}
}
