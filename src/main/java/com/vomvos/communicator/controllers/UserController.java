package com.vomvos.communicator.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessagingException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vomvos.communicator.models.user.User;
import com.vomvos.communicator.responses.user.UserLoginResponse;
import com.vomvos.communicator.responses.user.UserRegisterResponse;
import com.vomvos.communicator.responses.user.UserResponse;
import com.vomvos.communicator.services.user.UserService;

@RestController
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService  userService;
	
	@RequestMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody User user) {
		try {
			User loginUser = userService.authenticate(user);
			if(loginUser != null) {
				UserLoginResponse reponse = new UserLoginResponse(loginUser);
				return new ResponseEntity(reponse,HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.info("Unknown Exception at loginUser in UserController",e);
			e.printStackTrace();
		}
		UserLoginResponse responseWithError = new UserLoginResponse("Invalid Username or Password");
		return new ResponseEntity(responseWithError,HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping("/register")
	public ResponseEntity<UserResponse> registerUser(@RequestBody User user){
		
		try {
			boolean isRegistered = userService.register(user);
			if(isRegistered == true) {
				UserRegisterResponse response = new UserRegisterResponse(user);
				return new ResponseEntity(response,HttpStatus.CREATED);
			}
		} catch (MessagingException e) {
			logger.info("MessagingException Inside method registerUser of UserController",e);
			e.printStackTrace();
		}
		UserRegisterResponse userWithError = new UserRegisterResponse("Unexpected Error");
		return new ResponseEntity(userWithError,HttpStatus.BAD_REQUEST);
	}
}
