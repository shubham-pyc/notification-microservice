package com.vomvos.communicator.repositories.support.impl;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.messaging.MessagingException;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.vomvos.communicator.models.support.IdBoSupport;
import com.vomvos.communicator.repositories.support.interfaces.CrudRepository;

public abstract class CrudRepositoryImpl<T extends IdBoSupport> implements CrudRepository<T>{

	@Autowired
	protected CassandraTemplate cassandraTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(CrudRepositoryImpl.class);
	
	protected Class<? extends IdBoSupport> type = IdBoSupport.class;
	
	
	public CrudRepositoryImpl() {}
	
	public CrudRepositoryImpl(Class<T> typeParameterClass){
		this.type = typeParameterClass;
	}
	
	
	@Override
	public T save(T bo) throws IOException, MessagingException {
		
			//bo.setCreatedOn(System.currentTimeMillis());
			cassandraTemplate.insert(bo);
			//log.info(childClass.toString()+" Created Successfully ", bo.getId());
		
		return bo;
	}

	@Override
	public T update(T bo) {
		try {
			//bo.setUpdatedOn(System.currentTimeMillis());
			cassandraTemplate.insert(bo);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	@Override
	public boolean delete(T bo) {
		try {
			cassandraTemplate.delete(bo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
