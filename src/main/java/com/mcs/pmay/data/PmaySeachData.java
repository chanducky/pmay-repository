package com.mcs.pmay.data;

/**
 * @author chandrakumar
 *
 */
public class PmaySeachData {
	private String seachCity;
	private String searchName;
	private String searchWard;
	private String searchMissionComponent;
	private String userId;
	private String mobileNumber;
	private String aadharOrIdNumber;
	private String bankId;
	private String bankAccountNo;
	private String ulbName;
	private String fatherSpouseName;
	private String searchScopeName;
	private String searchScopeValue;

	public String getSeachCity() {
		return seachCity;
	}

	public void setSeachCity(String seachCity) {
		this.seachCity = seachCity;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchWard() {
		return searchWard;
	}

	public void setSearchWard(String searchWard) {
		this.searchWard = searchWard;
	}

	public String getSearchMissionComponent() {
		return searchMissionComponent;
	}

	public void setSearchMissionComponent(String searchMissionComponent) {
		this.searchMissionComponent = searchMissionComponent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String string) {
		this.userId = string;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAadharOrIdNumber() {
		return aadharOrIdNumber;
	}

	public void setAadharOrIdNumber(String aadharOrIdNumber) {
		this.aadharOrIdNumber = aadharOrIdNumber;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getUlbName() {
		return ulbName;
	}

	public void setUlbName(String ulbName) {
		this.ulbName = ulbName;
	}

	public String getFatherSpouseName() {
		return fatherSpouseName;
	}

	public void setFatherSpouseName(String fatherSpouseName) {
		this.fatherSpouseName = fatherSpouseName;
	}

	public String getSearchScopeName() {
		return searchScopeName;
	}

	public void setSearchScopeName(String searchScopeName) {
		this.searchScopeName = searchScopeName;
	}

	public String getSearchScopeValue() {
		return searchScopeValue;
	}

	public void setSearchScopeValue(String searchScopeValue) {
		this.searchScopeValue = searchScopeValue;
	}

	@Override
	public String toString() {
		return "PmaySeachData [seachCity=" + seachCity + ", searchName=" + searchName + ", searchWard=" + searchWard
				+ ", searchMissionComponent=" + searchMissionComponent + ", userId=" + userId + ", mobileNumber="
				+ mobileNumber + ", aadharOrIdNumber=" + aadharOrIdNumber + ", bankId=" + bankId + ", bankAccountNo="
				+ bankAccountNo + ", ulbName=" + ulbName + ", fatherSpouseName=" + fatherSpouseName
				+ ", searchScopeName=" + searchScopeName + ", searchScopeValue=" + searchScopeValue + "]";
	}

}
