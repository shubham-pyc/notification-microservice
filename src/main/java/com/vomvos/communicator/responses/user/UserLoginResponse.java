package com.vomvos.communicator.responses.user;

import java.util.UUID;

import com.vomvos.communicator.models.user.User;

public class UserLoginResponse extends UserResponse {
	
	private boolean isAuthenticated;
	
	
	public  UserLoginResponse(User user) {
		super(user);
		this.isAuthenticated = true;
	}
	public UserLoginResponse(String error) {
		super(error);
		this.isAuthenticated = false;
	}
	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	
	
	
}
