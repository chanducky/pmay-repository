
package com.mcs.pmay.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.mcs.pmay.data.PmayUserData;

/**
 * @author chandrakumar
 *
 */
public interface PmayUserService {

	int isUesrExist(String mobileNo);

	boolean sendOtp(String mobileNo) throws IOException;

	boolean isValidOtp(Map<String, String> otpData);

	String generatePassword(String mobileNo);

	boolean checkUserExist(Map<String, String> loginData);

	boolean registerUser(PmayUserData pmayUserData) throws IOException;

	boolean approveUser(PmayUserData userData) throws IOException;

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
