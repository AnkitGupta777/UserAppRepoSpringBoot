package com.user.model;

import java.util.List;

public class APIResponse {

	private String statusCode;
	private List<User> userDetails;
	private String message;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public List<User> getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(List<User> userDetails) {
		this.userDetails = userDetails;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
