package com.hexa.client;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@EnableTransactionManagement
@PropertySource(value="classpath:hexa.properties")
@ComponentScan("com.hexa")
public class HibernateConfig {

	
	@Autowired
	private Environment env;
	
	@Bean
	public DriverManagerDataSource getdataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("driver"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("uname"));
		ds.setPassword(env.getProperty("pwd"));
		return ds;
	}
	
	@Bean
	@Autowired
	public LocalSessionFactoryBean getSessionFactory(DriverManagerDataSource ds){
		System.out.println(ds.getUsername());
		LocalSessionFactoryBean fac = new LocalSessionFactoryBean();
		fac.setDataSource(ds);
		fac.setHibernateProperties(getProperties());
		fac.setPackagesToScan(new String[]{"com.hexa.entity"});
		return fac;
	}
	
	public Properties getProperties(){
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", env.getProperty("dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("showsql"));
		props.setProperty("hibernate.format_sql", env.getProperty("formatsql"));
		return props;
		
	}
	
	/*@Bean
	@Autowired
	public HibernateTransactionManager getTxmanger(SessionFactory sfac){
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(sfac);
		return tx;
	}*/
}








