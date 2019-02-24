package com.vomvos.communicator.config;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;

@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {
  
  @Value("${cassandra.contactpoints}")
  private String contactPoints;
    
  @Value("${cassandra.port}")	
  private int port;
    
  @Value("${cassandra.keyspace}")
  private String keySpace;
    
  @Value("${cassandra.basePackages}")
  private String basePackages;
	  
	@Override
	public SchemaAction getSchemaAction() {
	    return SchemaAction.CREATE_IF_NOT_EXISTS;
	}
	
	@Override
	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
	    CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(keySpace);	
	    return Arrays.asList(specification);
	}
	
	@Override
	protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
	    return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(keySpace));
	}
	
	@Override
	protected String getKeyspaceName() {
	    return keySpace;
	}
	
	@Override
	public String[] getEntityBasePackages() {
	    return new String[]{basePackages};
	}
	
	@Bean
	public CassandraClusterFactoryBean cluster() {
	    CassandraClusterFactoryBean cluster = 
	      new CassandraClusterFactoryBean();
	    cluster.setContactPoints(contactPoints);
	    cluster.setPort(port);
	    return cluster;
	}
}