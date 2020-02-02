package com.server.models.response;

public class Response {

	protected String message;
	
	protected boolean succeded;
	
	public Response(String message, boolean succeded) {
		this.message = message;
		this.succeded = succeded;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isSucceded() {
		return succeded;
	}
	
	public void setSucceded(boolean succeded) {
		this.succeded = succeded;
	}
}