package com.vomvos.communicator.responses.user;

import com.vomvos.communicator.models.user.User;

public class UserRegisterResponse extends UserResponse{
	
	private boolean isRegistered;

	public UserRegisterResponse(User user) {
		super(user);
		this.isRegistered = true;
	}
	
	public UserRegisterResponse(String error) {
		super(error);
		this.isRegistered = false;
	}
	
}
