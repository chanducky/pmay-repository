package com.mcs.pmay.data;

import java.util.List;

/**
 * @author chandrakumar
 *
 */
public class PmayStateCityData {
	private List<PmayStateData> listStateData;
	private List<PmayCityData> listCityData;

	public List<PmayStateData> getListStateData() {
		return listStateData;
	}

	public void setListStateData(List<PmayStateData> listStateData) {
		this.listStateData = listStateData;
	}

	public List<PmayCityData> getListCityData() {
		return listCityData;
	}

	public void setListCityData(List<PmayCityData> listCityData) {
		this.listCityData = listCityData;
	}

	@Override
	public String toString() {
		return "PmayStateCityData [listStateData=" + listStateData + ", listCityData=" + listCityData + "]";
	}

}
