package com.vomvos.communicator.services.user;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vomvos.communicator.models.user.User;
import com.vomvos.communicator.models.user.UserByEmail;
import com.vomvos.communicator.repositories.user.impl.UserRepositoryImpl;

@Service
public class UserService {
	private static List<User> userList;
	private static Map<UUID,User> onlineUsers;
	
	 private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepositoryImpl userRepository;
	
	public UserService(){
		onlineUsers = new Hashtable<UUID,User>();
	}
	
	public  User authenticate(User user){
		String username = user.getEmail();
		String password = user.getPassword();
		UUID id = user.getId();
		User authUser = userRepository.getUserByEmail(username);
		try {
			
			if(authUser != null && authUser.getEmail().equals(username) && authUser.getPassword().equals(password)) {
				onlineUsers.put(id,authUser);
				
				return authUser;
			}
		}catch(Exception e) {
			logger.info("Inside authenticate method od user service",e);
			System.out.println("Inside authenticate method od user service "+e.getMessage());
		}
		
		return null;
		
	}
	public boolean register(User user){
		try {
			userRepository.save(user);
			return true;
			
		}catch(Exception e) {
			logger.info("Inside register method of user service",e);
			System.out.println("Inside authenticate method od user service "+e.getMessage());
		}
		return false;
	}
	
	public boolean usernameAvailable(String username){
		Iterator it = userList.iterator();
		while(it.hasNext()){
			User temp =(User) it.next();
			if(temp.getEmail().equals(username)){
				return false;
			}
		}
		return true;
	}
	public static List<User> getUserList(){
		return userList;
	}
	public User getUser(UUID id) {
		
		try {
			User user = userRepository.findById(id);
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception inside getUser of UserUservice",e);
			e.printStackTrace();
		}
		return null;
	}
	public User getUserByEmail(String email) {
		
		try {
			User user = userRepository.getUserByEmail(email);
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception inside getUser of UserUservice",e);
			e.printStackTrace();
		}
		return null;
	}
}
