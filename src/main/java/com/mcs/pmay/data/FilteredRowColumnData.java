package com.mcs.pmay.data;

import java.io.Serializable;
import java.util.Arrays;

@SuppressWarnings("serial")
public class FilteredRowColumnData implements Serializable {
	private String mobileNo;
	private String uniqueId;
	private String aadharNo;
	private String name;
	private String fatherName;
	private String sex;
	private String dob;
	private String slumNonSlum;
	private String ulbName;
	private String wardNo;
	private String missionComponent;
	private String eligibleStatus;
	private String remarksForNonEligibility;
	private String longLat;
	private String validationPending;
	private String[] selectedsurveyId;

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSlumNonSlum() {
		return slumNonSlum;
	}

	public void setSlumNonSlum(String slumNonSlum) {
		this.slumNonSlum = slumNonSlum;
	}

	public String getUlbName() {
		return ulbName;
	}

	public void setUlbName(String ulbName) {
		this.ulbName = ulbName;
	}

	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public String getMissionComponent() {
		return missionComponent;
	}

	public void setMissionComponent(String missionComponent) {
		this.missionComponent = missionComponent;
	}

	public String getEligibleStatus() {
		return eligibleStatus;
	}

	public void setEligibleStatus(String eligibleStatus) {
		this.eligibleStatus = eligibleStatus;
	}

	public String getRemarksForNonEligibility() {
		return remarksForNonEligibility;
	}

	public void setRemarksForNonEligibility(String remarksForNonEligibility) {
		this.remarksForNonEligibility = remarksForNonEligibility;
	}

	public String getLongLat() {
		return longLat;
	}

	public void setLongLat(String longLat) {
		this.longLat = longLat;
	}

	public String getValidationPending() {
		return validationPending;
	}

	public void setValidationPending(String validationPending) {
		this.validationPending = validationPending;
	}

	public String[] getSelectedsurveyId() {
		return selectedsurveyId;
	}

	public void setSelectedsurveyId(String[] selectedsurveyId) {
		this.selectedsurveyId = selectedsurveyId;
	}

	@Override
	public String toString() {
		return "FilteredRowColumnData [mobileNo=" + mobileNo + ", uniqueId=" + uniqueId + ", aadharNo=" + aadharNo
				+ ", name=" + name + ", fatherName=" + fatherName + ", sex=" + sex + ", dob=" + dob + ", slumNonSlum="
				+ slumNonSlum + ", ulbName=" + ulbName + ", wardNo=" + wardNo + ", missionComponent=" + missionComponent
				+ ", eligibleStatus=" + eligibleStatus + ", remarksForNonEligibility=" + remarksForNonEligibility
				+ ", longLat=" + longLat + ", validationPending=" + validationPending + ", selectedsurveyId="
				+ Arrays.toString(selectedsurveyId) + "]";
	}

}
