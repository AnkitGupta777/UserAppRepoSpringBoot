package com.user.model;

import javax.validation.constraints.Size;

public class User {

	
	private String userId;
	private String emailId;
	private String name;
	private String dateOfBirth;
	private String address;
	private boolean isDeleted;
	private boolean isUserDuplicate;
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isUserDuplicate() {
		return isUserDuplicate;
	}

	public void setUserDuplicate(boolean isUserDuplicate) {
		this.isUserDuplicate = isUserDuplicate;
	}

}
