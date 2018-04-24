/**
 * Created By: SRIBATSA
 * Created On: Feb 22, 20188:45:07 PM
 * File Name : PmayUserDao.java
 * Last Modified By :
 * Last Modified On :
 */
package com.mcs.pmay.dao;

import java.util.List;
import java.util.Map;

import com.mcs.pmay.data.PmayUserData;

public interface PmayUserDao {

	int isUesrExist(String mobileNo);

	boolean insertOtp(String mobileNo, int otp);

	boolean isValidOtp(Map<String, String> otpData);

	String generatePassword(String mobileNo);

	boolean checkUserExist(Map<String, String> loginData);

	boolean registerUser(PmayUserData pmayUserData);

	String approveUser(PmayUserData userData);

	PmayUserData checkApprove(Map<String, String> loginData);

	/**
	 * @param password
	 * @param mobileNo
	 */
	void updateGeneratedPassword(String password, PmayUserData mobileNo);

	/**
	 * @param userData
	 * @return
	 */
	boolean denyUser(PmayUserData userData);

	boolean updateUserStatus(PmayUserData userData, Object adminId);

	/**
	 * @return
	 */
	List<PmayUserData> getPmayUserData();

	List<PmayUserData> getPmayUserDataForSuperAdmin();

	boolean saveLoggedinHistory(PmayUserData pmayUserData);

	List<PmayUserData> getUsersLoggedinHistory();

}
