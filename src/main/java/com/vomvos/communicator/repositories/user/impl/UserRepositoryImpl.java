package com.vomvos.communicator.repositories.user.impl;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.vomvos.communicator.config.constants.TableNames;
import com.vomvos.communicator.models.user.User;
import com.vomvos.communicator.models.user.UserByEmail;
import com.vomvos.communicator.repositories.support.impl.CrudRepositoryImpl;
import com.vomvos.communicator.repositories.user.interfaces.IUserRepository;

@Repository
public class UserRepositoryImpl extends CrudRepositoryImpl<User> implements IUserRepository{

	@Autowired
	CassandraTemplate cassandraTemplate;

	
	@Override
	public User save(User user) throws IOException,  MessagingException{
		try {

			cassandraTemplate.insert(user);
			cassandraTemplate.insert(new UserByEmail(user));

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	

	@Override
	public User findById(UUID id) {
		try {
			Select select = QueryBuilder.select().from(TableNames.USERS);
			select.where(QueryBuilder.eq("id", id));//..			
			return  cassandraTemplate.selectOne(select, User.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public User getUserByEmail(String email) {
		try {
			Select select = QueryBuilder.select().from(TableNames.USERS_BY_EMAIL);
			select.where(QueryBuilder.eq("email", email));//..			
			return  cassandraTemplate.selectOne(select, User.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
