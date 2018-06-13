package com.mcs.pmay.data;

/**
 * @author chandrakumar
 *
 */
public class PmayCityData {
	private String cityId;
	private String cityName;
	private String stateId;

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "PmayCityData [cityId=" + cityId + ", cityName=" + cityName + ", stateId=" + stateId + "]";
	}

}
