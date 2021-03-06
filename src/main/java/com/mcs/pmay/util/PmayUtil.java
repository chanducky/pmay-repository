package com.mcs.pmay.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

/**
 * @author chandrakumar
 *
 */
@Component
@Scope("singleton")
public class PmayUtil {
	private PmayUtil() {

	}

	private final static Logger logger = LoggerFactory.getLogger(PmayUtil.class);

	@SuppressWarnings("deprecation")
	public static boolean sendOtp(String mobileNo, String message) throws IOException {
		boolean flag = false;
		String username = "EAZYUCOM";
		// Your authentication key
		String authkey = "c9248054c1XX";
		// Multiple mobiles numbers separated by comma (max 200)
		// Sender ID,While using route4 sender id should be 6 characters long.
		String senderId = "CHOPMY";
		// define route
		String accusage = "1";

		// Prepare Url
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;

		// encoding message
		String encodedMessage = URLEncoder.encode(message);

		// Send SMS API
		String mainUrl = "http://mobicomm.dove-sms.com/mobicomm/submitsms.jsp?";

		// Prepare parameter string
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("user=" + username);
		sbPostData.append("&key=" + authkey);
		sbPostData.append("&mobile=" + mobileNo);
		sbPostData.append("&message=" + encodedMessage);
		sbPostData.append("&accusage=" + accusage);
		sbPostData.append("&senderid=" + senderId);
		mainUrl = sbPostData.toString();

		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response
			String response;
			while ((response = reader.readLine()) != null)
				// print response
				logger.info(response);

			// finally close connection
			reader.close();
			flag = true;
		} catch (IOException e) {
			logger.info("" + e);
		}
		return flag;
	}

	public static String chkNull(String strToCheck) {
		if ((null != strToCheck) && !strToCheck.equals("")) {
			return strToCheck;
		} else {
			return "";
		}
	}

	public static Object chkObjectNull(Object strToCheck) {
		if ((null != strToCheck) && !strToCheck.equals("")) {
			return strToCheck;
		} else {
			return "";
		}
	}

	public static Object chkObjectForSlum(Object strToCheck) {
		if ((null != strToCheck) && !strToCheck.equals("")) {
			return strToCheck;
		} else {
			return "S";
		}
	}

	public static Object chkObjectForNonSlum(Object strToCheck) {
		if ((null != strToCheck) && !strToCheck.equals("")) {
			return strToCheck;
		} else {
			return "N";
		}
	}


	public static String encryptPassword(String password) {
		String encryptedPasword = "";
		Argon2 argon2 = Argon2Factory.create();

		try {
			int n = 78925;
			int r = 2;
			int p = 1;
			encryptedPasword = argon2.hash(r, n, p, password);

		} finally {
			argon2 = null;
		}

		return encryptedPasword;
	}

	public static boolean decryptPassword(String hash, String password) {
		boolean validPassword = false;
		Argon2 argon2 = Argon2Factory.create();
		if (argon2.verify(hash, password)) {
			validPassword = true;
		}
		return validPassword;
	}

	public static String convertBlankToNull(String input)
	{
		if("".equals(input))
		{
			input =null;
		}
		return input;
	}

	public static Object chkCheckedRadioObjectNull(Object strToCheck) {
		if ((null != strToCheck) && !strToCheck.equals("")) {
			return strToCheck;
		} else {
			return "N";
		}
	}

	public static String getClientIpAddr(HttpServletRequest request) {  
		String ip = request.getHeader("X-Forwarded-For");  
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
			ip = request.getHeader("Proxy-Client-IP");  
		}  
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
			ip = request.getHeader("WL-Proxy-Client-IP");  
		}  
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
		}  
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
			ip = request.getHeader("HTTP_X_FORWARDED");  
		}  
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
			ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");  
		}  
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
			ip = request.getHeader("HTTP_CLIENT_IP");  
		}  
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
			ip = request.getHeader("HTTP_FORWARDED_FOR");  
		}  
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
			ip = request.getHeader("HTTP_FORWARDED");  
		}  
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
			ip = request.getHeader("HTTP_VIA");  
		}  
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
			ip = request.getHeader("REMOTE_ADDR");  
		}  
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
			ip = request.getRemoteAddr();  
		}  
		return ip;  
	}

	public static boolean sendOtpMsg91(String mobileNo, String message) throws IOException {
		boolean flag = false;
		
		// Your authentication key
		String authkey = "220605AWc3vGXoK3e5b229f1b";
		// Multiple mobiles numbers separated by comma (max 200)
		// Sender ID,While using route4 sender id should be 6 characters long.
		String sender = "CHPMAY";
		
		String route="4";

		// Prepare Url
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;

		// encoding message
		String encodedMessage = URLEncoder.encode(message);

		// Send SMS API
		String mainUrl = "http://api.msg91.com/api/sendhttp.php";

		// Prepare parameter string
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		
		String mobiles=null;
		if(mobileNo.length()==12 && mobileNo.startsWith("91")) {
			mobiles=mobileNo;
		}else if(mobileNo.length()==10){
			mobiles="91"+mobileNo;
		}else {
			return false;
		}
		
		sbPostData.append("?authkey=" + authkey);
		sbPostData.append("&mobiles=" + mobiles);
		sbPostData.append("&message=" + encodedMessage);
		sbPostData.append("&route=" + route);
		sbPostData.append("&sender=" + sender);
		sbPostData.append("&country=" + 91);
		mainUrl = sbPostData.toString();

		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response
			String response;
			while ((response = reader.readLine()) != null)
				// print response
				logger.info(response);
			System.out.println(" response =" + response);

			// finally close connection
			reader.close();
			flag = true;
		} catch (IOException e) {
			logger.info("" + e);
		}
		return flag;
	}
	
	public static void main(String[] args) throws IOException {
		//boolean status = PmayUtil.sendOtp("8652311521", "test otp");
		
		//boolean status = PmayUtil.sendOtpMsg91("8652311521", "test otp msg 91");
		
		String password = PmayUtil.encryptPassword("Super@4295");
		
		System.out.println(password);
		//System.out.println(" status = " + status);
	}
}
