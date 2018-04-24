package com.mcs.pmay.data;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PmayUserData implements Serializable {
	private String userId;
	private int roleId;
	private String roleName;
	private String ulbName;
	private String ulbNo;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private String mobileNo;
	private String password;
	private String adharCardNo;
	private String usrIp;
	private String loginApproval;
	private String approveButtonText;
	private String approveButtonColor;
	private String status;
	private String statusText;
	private String statusButtonColor;
	private String approveButtonDisable;
	private boolean passwordStatus;
	private boolean approvalStatus;
	private String denyButtonDisable;
	private String createdOn;

	public String getApproveButtonDisable() {
		return approveButtonDisable;
	}

	public void setApproveButtonDisable(String approveButtonDisable) {
		this.approveButtonDisable = approveButtonDisable;
	}

	public String getApproveButtonColor() {
		return approveButtonColor;
	}

	public void setApproveButtonColor(String approveButtonColor) {
		this.approveButtonColor = approveButtonColor;
	}

	public String getStatusButtonColor() {
		return statusButtonColor;
	}

	public void setStatusButtonColor(String statusButtonColor) {
		this.statusButtonColor = statusButtonColor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getApproveButtonText() {
		return approveButtonText;
	}

	public void setApproveButtonText(String approveButtonText) {
		this.approveButtonText = approveButtonText;
	}

	public String getLoginApproval() {
		return loginApproval;
	}

	public void setLoginApproval(String loginApproval) {
		this.loginApproval = loginApproval;
	}

	public int getRoleId() {
		return roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUlbName() {
		return ulbName;
	}

	public void setUlbName(String ulbName) {
		this.ulbName = ulbName;
	}

	public String getUlbNo() {
		return ulbNo;
	}

	public void setUlbNo(String ulbNo) {
		this.ulbNo = ulbNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdharCardNo() {
		return adharCardNo;
	}

	public void setAdharCardNo(String adharCardNo) {
		this.adharCardNo = adharCardNo;
	}

	public String getUsrIp() {
		return usrIp;
	}

	public void setUsrIp(String usrIp) {
		this.usrIp = usrIp;
	}

	public boolean isPasswordStatus() {
		return passwordStatus;
	}

	public void setPasswordStatus(boolean passwordStatus) {
		this.passwordStatus = passwordStatus;
	}

	public boolean isApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	/**
	 * @return the denyButtonDisable
	 */
	public String getDenyButtonDisable() {
		return denyButtonDisable;
	}

	/**
	 * @param denyButtonDisable the denyButtonDisable to set
	 */
	public void setDenyButtonDisable(String denyButtonDisable) {
		this.denyButtonDisable = denyButtonDisable;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	
}
