package com.forsys.revmantra.model;

public class SfQuoteLineExceptions {
	private String sfQuoteLineID;
	
	private String exceptionMsg;
	
	public SfQuoteLineExceptions(String sfQuoteLineID, String exceptionMsg) {
		this.sfQuoteLineID = sfQuoteLineID;
		this.exceptionMsg = exceptionMsg;
	}
	
	public String getSfQuoteLineID() {
		return sfQuoteLineID;
	}
	public void setSfQuoteLineID(String sfQuoteLineID) {
		this.sfQuoteLineID = sfQuoteLineID;
	}
	public String getExceptionMsg() {
		return exceptionMsg;
	}
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	
	
}
