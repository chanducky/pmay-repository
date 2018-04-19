/**
 * Created By: SRIBATSA
 * Created On: Feb 22, 20188:43:12 PM
 * File Name : PmayUserController.java
 * Last Modified By : Smruti Ranjan
 * Last Modified On :
 */
package com.mcs.pmay.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mcs.pmay.data.PmayUserData;
import com.mcs.pmay.service.PmayUserService;
import com.mcs.pmay.util.PmayUtil;

@RestController
public class PmayUserController {
	@Resource
	private PmayUserService pmayUserService;
	@Resource
	HttpSession session;
	Gson gson = new Gson();

	/**
	 * 
	 * @param mobileNo
	 * @return message in json format if otp is sent to the mobile or not
	 * @throws IOException
	 */
	@RequestMapping(value = "/forgetpassword", method = RequestMethod.POST)
	@ResponseBody
	public String forgetpassword(@RequestBody PmayUserData mobileNo) throws IOException {
		String json = null;
		int isUesrExist = pmayUserService.isUesrExist(mobileNo.getMobileNo());
		if (isUesrExist != 0) {
			if (pmayUserService.sendOtp(mobileNo.getMobileNo())) {
				json = gson.toJson("otp sent successfully.");
			} else {
				json = gson.toJson("otp can't be sent to this number.");
			}
		} else {
			json = gson.toJson("Sorry! No user is exist for this number");
		}
		return json;
	}

	/**
	 * 
	 * @param otpData
	 * @return is otp is valid / invalid
	 */
	@RequestMapping(value = "/validateOtp", method = RequestMethod.POST)
	@ResponseBody
	public String validateOtp(@RequestBody Map<String, String> otpData) {
		String json = null;
		if (pmayUserService.isValidOtp(otpData)) {
			json = gson.toJson("valid Otp.");
		} else {
			json = gson.toJson("Invalid Otp.");
		}
		return json;
	}

	/**
	 * 
	 * @param mobileNo
	 * @return message in json format if password is generated
	 * @throws IOException
	 */
	@RequestMapping(value = "/generatePassword", method = RequestMethod.POST)
	@ResponseBody
	public String generatePassword(@RequestBody PmayUserData mobileNo) throws IOException {
		String json = null;
		String password = pmayUserService.generatePassword(mobileNo.getMobileNo());
		if (!PmayUtil.chkNull(password).equals("")) {
			String message = "Hi,Your new generated password is :" + password;
			if (PmayUtil.sendOtp(mobileNo.getMobileNo(), message)) {
				pmayUserService.updateGeneratedPassword(password,mobileNo);
				json = gson.toJson("password is send to your mobile.");
			} else {
				json = gson.toJson("sorry we can't sent message to this number.");
			}
		} else {
			json = gson.toJson("Sorry!,we are unable to generate your password this time.");
		}
		return json;
	}

	/**
	 * 
	 * @param loginData
	 * @param req
	 * @return login request is valid or not
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody Map<String, String> loginData, HttpServletRequest req) {
		boolean status = pmayUserService.checkUserExist(loginData);
		HashMap<String, Object> hmap = new HashMap<>();
		if (status) {
			PmayUserData pmayUserData = pmayUserService.checkApprove(loginData);
			if (pmayUserData != null) {
				if(pmayUserData.getStatus().equals("A")){
				if (pmayUserData.isPasswordStatus()) {
					HttpSession session = req.getSession(true);
					String ipAddress = req.getHeader("X-FORWARDED-FOR");
					if (ipAddress == null) {
						ipAddress = req.getRemoteAddr();
					}
					pmayUserData.setUsrIp(ipAddress);
					if (session != null) {
						session.setAttribute("userDtls", pmayUserData);
						session.setAttribute("userId", pmayUserData.getUserId());
					}
					hmap.put("success", "true");
					hmap.put("userdtl", pmayUserData);
					return gson.toJson(hmap);
				} else {
					hmap.put("success", "pError");
					return gson.toJson(hmap);
				}
			}else{
				hmap.put("success", "aiError");
				return gson.toJson(hmap);
			}
			} else {
				hmap.put("success", "appError");
				return gson.toJson(hmap);
			}

		} else {
			hmap.put("success", "false");
			return gson.toJson(hmap);
		}
	}

	/**
	 * @param session
	 * @return hmap of user details of logged in user
	 */
	@RequestMapping(value = "/checkSession", method = RequestMethod.GET)
	@ResponseBody
	public String checkSession(HttpSession session) {
		HashMap<String, Object> hmap = new HashMap<>();
		if (session.getAttribute("userDtls") != null) {
			Object userdtl = session.getAttribute("userDtls");
			hmap.put("success", "true");
			hmap.put("data", userdtl);
			return gson.toJson(hmap);

		} else {
			hmap.put("success", "false");
			return gson.toJson(hmap);
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return logout message
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return gson.toJson("logout successfully");
	}

	/**
	 * 
	 * @param pmayUserData
	 * @return hmap of true / false value requested user for register
	 * @throws IOException
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String register(@RequestBody PmayUserData pmayUserData) throws IOException {
		HashMap<String, Object> hmap = new HashMap<>();
		int isUesrExist = pmayUserService.isUesrExist(pmayUserData.getMobileNo());
		if (isUesrExist == 0) {
			if (pmayUserService.registerUser(pmayUserData)) {
				hmap.put("success", "true");
				return gson.toJson(hmap);
			} else {
				hmap.put("success", "error");
				return gson.toJson(hmap);
			}
		} else {
			hmap.put("success", "false");
			return gson.toJson(hmap);
		}
	}

	/**
	 * 
	 * @param userData
	 * @return status of approved user
	 * @throws IOException
	 */
	@RequestMapping(value = "/approveUser", method = RequestMethod.POST)
	@ResponseBody
	public String approveUser(@RequestBody PmayUserData userData) throws IOException {
		boolean status = pmayUserService.approveUser(userData);
		return gson.toJson(status);
	}
	/**
	 * 
	 * @param userData
	 * @return status of approved user
	 * @throws IOException
	 */
	@RequestMapping(value = "/denyUser", method = RequestMethod.POST)
	@ResponseBody
	public String denyUser(@RequestBody PmayUserData userData) throws IOException {
		boolean status = pmayUserService.denyUser(userData);
		return gson.toJson(status);
	}
	
	@RequestMapping(value = "/updateUserStatus", method = RequestMethod.POST)
	@ResponseBody
	public String updateUserStatus(@RequestBody PmayUserData userData,HttpSession session ) throws IOException {
		Object adminId = session.getAttribute("userId");
		boolean status = pmayUserService.updateUserStatus(userData,adminId);
		return gson.toJson(status);
	}
	
	@RequestMapping(value = "/getUserDetails", method = RequestMethod.GET)
	@ResponseBody
	public String getUserDetails() {
		List<PmayUserData> pmayUserData = pmayUserService.getPmayUserData();
		return gson.toJson(pmayUserData);
	}
	
	@RequestMapping(value = "/getDetailsForSuperAdminMnagerProfile", method = RequestMethod.GET)
	@ResponseBody
	public String getDetailsForSuperAdminMnagerProfile() {
		List<PmayUserData> pmayUserData = pmayUserService.getPmayUserDataForSuperAdmin();
		return gson.toJson(pmayUserData);
	}
	
}
