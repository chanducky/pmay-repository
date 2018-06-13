package com.mcs.pmay.data;

/**
 * @author chandrakumar
 *
 */
public class UlbWardDetailsData {
	private String ulbName;
	private String wardNames;
	private String totalNoOfSurvey;

	public String getTotalNoOfSurvey() {
		return totalNoOfSurvey;
	}

	public void setTotalNoOfSurvey(String totalNoOfSurvey) {
		this.totalNoOfSurvey = totalNoOfSurvey;
	}

	public String getUlbName() {
		return ulbName;
	}

	public void setUlbName(String ulbName) {
		this.ulbName = ulbName;
	}

	public String getWardNames() {
		return wardNames;
	}

	public void setWardNames(String wardNames) {
		this.wardNames = wardNames;
	}

	@Override
	public String toString() {
		return "UlbWardDetailsData [ulbName=" + ulbName + ", wardNames=" + wardNames + "]";
	}

}
