package com.vomvos.communicator.responses.user;

import java.util.UUID;

import com.vomvos.communicator.models.user.User;

public class UserResponse {
	private UUID id;
	private String email;
	private String error;
	
	public  UserResponse(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.error = "";
	}
	public  UserResponse(String error) {
		this.error = error;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

}
