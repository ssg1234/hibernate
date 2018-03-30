package com.hexa.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.hexa")
@PropertySource("classpath:hexa.properties")
public class JdbcConfig {

	@Autowired
	private Environment env;
	
	@Bean(name="jdbctemp")
	@Autowired
	@Qualifier("mydatasource")
	public JdbcTemplate getJdbcTemplate(DriverManagerDataSource ds){
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(ds);
		return jt;
	}
	
	@Bean(name="mydatasource")
	public DriverManagerDataSource getDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("jdriver"));
		ds.setUrl(env.getProperty("jurl"));
		ds.setUsername(env.getProperty("uname"));
		ds.setPassword(env.getProperty("pwd"));
		return ds;
	}
	
	
	
	
}





