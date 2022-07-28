package com.forsys.revmantra.exceptions;

import java.sql.Timestamp;

public class ApiError {
	private int code;
	private String message;
	private Timestamp eDate;
	public ApiError(int code, String message) {
		super();
		this.code = code;
		this.message = message;
		this.eDate = new Timestamp(System.currentTimeMillis());
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp geteDate() {
		return eDate;
	}
	public void seteDate(Timestamp eDate) {
		this.eDate = eDate;
	}
	
	
	
	
}
