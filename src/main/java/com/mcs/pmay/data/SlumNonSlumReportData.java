package com.mcs.pmay.data;

public class SlumNonSlumReportData {
	private int noOfSlumSurvey;
	private int noOfNonSlumSurvey;
	private int totalSurvay;

	public int getNoOfSlumSurvey() {
		return noOfSlumSurvey;
	}

	public void setNoOfSlumSurvey(int noOfSlumSurvey) {
		this.noOfSlumSurvey = noOfSlumSurvey;
	}

	public int getNoOfNonSlumSurvey() {
		return noOfNonSlumSurvey;
	}

	public void setNoOfNonSlumSurvey(int noOfNonSlumSurvey) {
		this.noOfNonSlumSurvey = noOfNonSlumSurvey;
	}

	public int getTotalSurvay() {
		return totalSurvay;
	}

	public void setTotalSurvay(int totalSurvay) {
		this.totalSurvay = totalSurvay;
	}

	@Override
	public String toString() {
		return "SlumNonSlumReportData [noOfSlumSurvey=" + noOfSlumSurvey + ", noOfNonSlumSurvey=" + noOfNonSlumSurvey
				+ ", totalSurvay=" + totalSurvay + "]";
	}

}
