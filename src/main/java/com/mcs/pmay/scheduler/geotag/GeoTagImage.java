package com.mcs.pmay.scheduler.geotag;

import java.util.Date;

public class GeoTagImage {
	
	private Long userSurveyId;
	private double latitude;
	private double longitude;
	private String path;
	private String slumNonSlum;
	private Date datetime;

	public GeoTagImage(Long userSurveyId,double[]gps) {
		super();
		this.userSurveyId=userSurveyId;
		this.latitude=gps[0];
		this.longitude=gps[1];
	}

	public Long getUserSurveyId() {
		return userSurveyId;
	}

	public void setUserSurveyId(Long userSurveyId) {
		this.userSurveyId = userSurveyId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSlumNonSlum() {
		return slumNonSlum;
	}

	public void setSlumNonSlum(String slumNonSlum) {
		this.slumNonSlum = slumNonSlum;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
}