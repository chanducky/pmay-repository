
package com.mcs.pmay.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mcs.pmay.dao.PmayUserDao;
import com.mcs.pmay.data.PmayUserData;
import com.mcs.pmay.service.PmayUserService;
import com.mcs.pmay.util.PmayUtil;

/**
 * @author chandrakumar
 *
 */
@Service("pmayUserService")
public class PmayUserServiceImpl implements PmayUserService {
	@Resource
	public PmayUserDao pmayUserDao;

	@Override
	public int isUesrExist(String mobileNo) {
		return pmayUserDao.isUesrExist(mobileNo);
	}

	@Override
	public boolean sendOtp(String mobileNo) throws IOException {
		boolean status = false;
		int otp = generateOtp();
		if (pmayUserDao.insertOtp(mobileNo, otp)) {
			String message = "Your OTP is confidential.PMAY never calls u asking for OTP.Sharing it with anyone gives them full access 2 ur account"
					+ " " + otp + " " + "is ur login OTP";
			if (PmayUtil.sendOtp(mobileNo, message)) {
				status = true;
			}
		}
		return status;
	}

	private int generateOtp() {
		return 100000 + new Random().nextInt(900000);
	}

	@Override
	public boolean isValidOtp(Map<String, String> otpData) {
		return pmayUserDao.isValidOtp(otpData);
	}

	@Override
	public String generatePassword(String mobileNo) {
		return pmayUserDao.generatePassword(mobileNo);
	}

	@Override
	public boolean checkUserExist(Map<String, String> loginData) {
		return pmayUserDao.checkUserExist(loginData);
	}

	@Override
	public boolean registerUser(PmayUserData pmayUserData) throws IOException {
		return pmayUserDao.registerUser(pmayUserData);

	}

	@Override
	public boolean approveUser(PmayUserData userData) throws IOException {
		String password = pmayUserDao.approveUser(userData);
		String message = "Hi " + userData.getFirstName() + ",Your request is approved,you can login by using password:"
				+ password;
		return PmayUtil.sendOtp(userData.getMobileNo(), message);
	}

	@Override
	public PmayUserData checkApprove(Map<String, String> loginData) {
		return pmayUserDao.checkApprove(loginData);
	}

	/* (non-Javadoc)
	 * @see com.mcs.pmay.service.PmayUserService#updateGeneratedPassword(java.lang.String, com.mcs.pmay.data.PmayUserData)
	 */
	@Override
	public void updateGeneratedPassword(String password, PmayUserData mobileNo) {
		pmayUserDao.updateGeneratedPassword(password,mobileNo);
	}

	/* (non-Javadoc)
	 * @see com.mcs.pmay.service.PmayUserService#denyUser(com.mcs.pmay.data.PmayUserData)
	 */
	@Override
	public boolean denyUser(PmayUserData userData) {
		return pmayUserDao.denyUser(userData);
	}

	@Override
	public boolean updateUserStatus(PmayUserData userData, Object adminId) {
		return pmayUserDao.updateUserStatus(userData,adminId);
	}

	/* (non-Javadoc)
	 * @see com.mcs.pmay.service.PmayUserService#getPmayUserData()
	 */
	@Override
	public List<PmayUserData> getPmayUserData() {
		return pmayUserDao.getPmayUserData();
	}

	@Override
	public List<PmayUserData> getPmayUserDataForSuperAdmin() {
		return pmayUserDao.getPmayUserDataForSuperAdmin();
	}

	@Override
	public boolean saveLoggedinHistory(PmayUserData pmayUserData) {
		return pmayUserDao.saveLoggedinHistory(pmayUserData);
	}
	
	@Override
	public List<PmayUserData> getUsersLoggedinHistory(){
		return pmayUserDao.getUsersLoggedinHistory();
	}
}
