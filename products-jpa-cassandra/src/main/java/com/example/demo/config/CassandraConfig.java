/**
 * 
 */
package com.example.demo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.cassandra.config.CassandraCqlClusterFactoryBean;
import org.springframework.cassandra.config.CassandraCqlSessionFactoryBean;
import org.springframework.cassandra.core.keyspace.CreateKeyspaceSpecification;
import org.springframework.cassandra.core.keyspace.KeyspaceOption;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * @author efoeakolly
 *
 */
@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {
	
	public static final String KEYSPACE = "product_key_space";
	
	public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS;
	}
	
	
	protected List<CreateKeyspaceSpecification> getKeySpaceCreation() {
		CreateKeyspaceSpecification spec = CreateKeyspaceSpecification.createKeyspace(KEYSPACE).with(KeyspaceOption.DURABLE_WRITES, true);
		return Arrays.asList(spec);
	}
	
	@Override
	protected String getKeyspaceName() {
		return KEYSPACE;
	}
	
	@Override
	public String[] getEntityBasePackages() {
		return new String[] {"com.example.demo.domain"};
	}
	
	/*
	   * Factory bean that creates the com.datastax.driver.core.Session instance
	   */
	  @Bean
	  public CassandraCqlClusterFactoryBean cluster() {

	    CassandraCqlClusterFactoryBean cluster = new CassandraCqlClusterFactoryBean();
	    cluster.setContactPoints("localhost");

	    return cluster;
	  }

	   /*
	    * Factory bean that creates the com.datastax.driver.core.Session instance
	    *
	   @Bean
	   public CassandraSessionFactoryBean session() {

	    CassandraCqlSessionFactoryBean session = new CassandraCqlSessionFactoryBean();
	    session.setCluster(cluster().getObject());
	    session.setKeyspaceName(KEYSPACE);

	    return (CassandraSessionFactoryBean) session;
	  }*/

}
