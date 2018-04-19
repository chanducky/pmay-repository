package com.mcs.pmay.data;

public class PmayStateData {
	private String stateId;
	private String stateName;

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "PmayStateData [stateId=" + stateId + ", stateName=" + stateName + "]";
	}

}
