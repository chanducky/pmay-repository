package com.mcs.pmay.data;

import java.util.List;

/**
 * @author chandrakumar
 *
 */
public class PmaySurveyReportDownloadData {
	private List<PmaySurveyReportData> listSurveyData;
	private List<PmayReportDataForAdmins> listAdminsData;
	private FilteredRowColumnData columnData;

	public List<PmaySurveyReportData> getListSurveyData() {
		return listSurveyData;
	}

	public void setListSurveyData(List<PmaySurveyReportData> listSurveyData) {
		this.listSurveyData = listSurveyData;
	}

	public List<PmayReportDataForAdmins> getListAdminsData() {
		return listAdminsData;
	}

	public void setListAdminsData(List<PmayReportDataForAdmins> listAdminsData) {
		this.listAdminsData = listAdminsData;
	}

	public FilteredRowColumnData getColumnData() {
		return columnData;
	}

	public void setColumnData(FilteredRowColumnData columnData) {
		this.columnData = columnData;
	}

	@Override
	public String toString() {
		return "PmaySurveyReportDownloadData [listSurveyData=" + listSurveyData + ", listAdminsData=" + listAdminsData
				+ ", columnData=" + columnData + "]";
	}

}
