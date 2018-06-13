package com.mcs.pmay.data;

import java.io.Serializable;

/**
 * @author chandrakumar
 *
 */
@SuppressWarnings("serial")
public class PmaySurveyReportData implements Serializable {
	private String userId;
	private String userSurveyId;
	private String userName;
	private String userFatherName;
	private String userGender;
	private String userAge;
	private String maritalStatus;
	private String religion;
	private String caste;
	private String adharNumber;
	private String adharStatus;
	private String idType;
	private String idNumber;
	
	//Added by Phuku
	private String slumNonSlum;
	private String presentMobNo;
	private String wardName;
	private String eligibilityForScheme;
	private String reasonForNonEligibility;
	private String geoLatitude;
	private String geoLongitude;
	private String idAttachmentName;
	private String ulbName;
	
	private String photoAttachmentName;
	private String signatureOfApplicant;
	private String photoAttachmentInFrontOfHouse;
	
	//Ended Here

	
	public String getUlbName() {
		return ulbName;
	}

	public void setUlbName(String ulbName) {
		this.ulbName = ulbName;
	}

	/**
	 * @return the presentMobNo
	 */
	public String getPresentMobNo() {
		return presentMobNo;
	}

	/**
	 * @return the slumNonSlum
	 */
	public String getSlumNonSlum() {
		return slumNonSlum;
	}

	/**
	 * @param slumNonSlum the slumNonSlum to set
	 */
	public void setSlumNonSlum(String slumNonSlum) {
		this.slumNonSlum = slumNonSlum;
	}

	/**
	 * @param presentMobNo the presentMobNo to set
	 */
	public void setPresentMobNo(String presentMobNo) {
		this.presentMobNo = presentMobNo;
	}

	/**
	 * @return the wardName
	 */
	public String getWardName() {
		return wardName;
	}

	/**
	 * @param wardName the wardName to set
	 */
	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	/**
	 * @return the eligibilityForScheme
	 */
	public String getEligibilityForScheme() {
		return eligibilityForScheme;
	}

	/**
	 * @param eligibilityForScheme the eligibilityForScheme to set
	 */
	public void setEligibilityForScheme(String eligibilityForScheme) {
		this.eligibilityForScheme = eligibilityForScheme;
	}

	/**
	 * @return the reasonForNonEligibility
	 */
	public String getReasonForNonEligibility() {
		return reasonForNonEligibility;
	}

	/**
	 * @param reasonForNonEligibility the reasonForNonEligibility to set
	 */
	public void setReasonForNonEligibility(String reasonForNonEligibility) {
		this.reasonForNonEligibility = reasonForNonEligibility;
	}

	/**
	 * @return the geoLatitude
	 */
	public String getGeoLatitude() {
		return geoLatitude;
	}

	/**
	 * @param geoLatitude the geoLatitude to set
	 */
	public void setGeoLatitude(String geoLatitude) {
		this.geoLatitude = geoLatitude;
	}

	/**
	 * @return the geoLongitude
	 */
	public String getGeoLongitude() {
		return geoLongitude;
	}

	/**
	 * @param geoLongitude the geoLongitude to set
	 */
	public void setGeoLongitude(String geoLongitude) {
		this.geoLongitude = geoLongitude;
	}

	/**
	 * @return the idAttachmentName
	 */
	public String getIdAttachmentName() {
		return idAttachmentName;
	}

	/**
	 * @param idAttachmentName the idAttachmentName to set
	 */
	public void setIdAttachmentName(String idAttachmentName) {
		this.idAttachmentName = idAttachmentName;
	}

	/**
	 * @return the signatureOfApplicant
	 */
	public String getSignatureOfApplicant() {
		return signatureOfApplicant;
	}

	/**
	 * @param signatureOfApplicant the signatureOfApplicant to set
	 */
	public void setSignatureOfApplicant(String signatureOfApplicant) {
		this.signatureOfApplicant = signatureOfApplicant;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserSurveyId() {
		return userSurveyId;
	}

	public void setUserSurveyId(String userSurveyId) {
		this.userSurveyId = userSurveyId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFatherName() {
		return userFatherName;
	}

	public void setUserFatherName(String userFatherName) {
		this.userFatherName = userFatherName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getAdharStatus() {
		return adharStatus;
	}

	public void setAdharStatus(String adharStatus) {
		this.adharStatus = adharStatus;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	public String getPhotoAttachmentName() {
		return photoAttachmentName;
	}

	public void setPhotoAttachmentName(String photoAttachmentName) {
		this.photoAttachmentName = photoAttachmentName;
	}

	public String getPhotoAttachmentInFrontOfHouse() {
		return photoAttachmentInFrontOfHouse;
	}

	public void setPhotoAttachmentInFrontOfHouse(String photoAttachmentInFrontOfHouse) {
		this.photoAttachmentInFrontOfHouse = photoAttachmentInFrontOfHouse;
	}

	@Override
	public String toString() {
		return "PmaySurveyReportData [userId=" + userId + ",userName=" + userName + ", userFatherName=" + userFatherName
				+ ", userGender=" + userGender + ", userAge=" + userAge + ", maritalStatus=" + maritalStatus
				+ ", religion=" + religion + ", caste=" + caste + ", adharNumber=" + adharNumber + ", adharStatus="
				+ adharStatus + ", idType=" + idType + ", idNumber=" + idNumber + "]";
	}

}
