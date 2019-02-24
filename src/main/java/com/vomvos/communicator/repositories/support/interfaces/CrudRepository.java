package com.vomvos.communicator.repositories.support.interfaces;

import java.io.IOException;
import java.util.UUID;

import org.springframework.messaging.MessagingException;

public interface CrudRepository<T> {

	T findById(UUID id);
	
	T save(T bo) throws IOException, MessagingException;
	
	T update(T bo);
	
	boolean delete(T bo);	
	
}
