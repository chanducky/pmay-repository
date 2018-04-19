package com.mcs.pmay.data;

public class PmayBankData {
	private String bankId;
	private String bankName;

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "PmayBankData [bankId=" + bankId + ", bankName=" + bankName + "]";
	}

}
