package com.vomvos.communicator.repositories.user.interfaces;

import com.vomvos.communicator.models.user.User;
import com.vomvos.communicator.models.user.UserByEmail;
import com.vomvos.communicator.repositories.support.interfaces.CrudRepository;

public interface IUserRepository extends CrudRepository<User>{
	public User getUserByEmail(String email);
}
