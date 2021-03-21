package com.user.exception;

import java.util.Date;

public class CustomeErrorDetails {
	
	private Date timestamps;
	
	private String message;
	
	private String errorDetails;

	public CustomeErrorDetails(Date timestamps, String message, String errorDetails) {
		super();
		this.timestamps = timestamps;
		this.message = message;
		this.errorDetails = errorDetails;
	}

	public Date getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(Date timestamps) {
		this.timestamps = timestamps;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	
	

}
