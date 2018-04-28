package com.mcs.pmay.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PmayDateUtil {
	public static final String DATE_FORMAT_DDMMYYYY="dd/MM/yyyy";
	public static final String DATE_FORMAT_YYYY_MM_DD="yyyy-MM-dd";
	
	public static String  convertFormat(String dateString) {
		SimpleDateFormat sdf  = new SimpleDateFormat(DATE_FORMAT_DDMMYYYY);
		SimpleDateFormat sdfTo  = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		
		Date formatedDate = null;
		try {
			formatedDate = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String foratedDateSting = sdfTo.format(formatedDate);
		
		return foratedDateSting;
		
	}
	

	public static String  convertFormat(Date date) {
		SimpleDateFormat sdfTo  = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		String foratedDateSting = sdfTo.format(date);
		return foratedDateSting;
		
	}
	
}
