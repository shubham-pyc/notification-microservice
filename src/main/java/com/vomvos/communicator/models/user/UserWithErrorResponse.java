package com.vomvos.communicator.models.user;

public class UserWithErrorResponse extends User{
	String error;
	public UserWithErrorResponse(String error) {
		super();
		this.error = error;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
}
