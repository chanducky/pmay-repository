package com.mcs.pmay.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

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
		if(input.equals(""))
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
	
	
}
