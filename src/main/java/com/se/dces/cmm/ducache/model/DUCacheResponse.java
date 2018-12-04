package com.se.dces.cmm.ducache.model;

public class DUCacheResponse {
	
	private int status;
	
	private String message;
	
	public DUCacheResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
}
