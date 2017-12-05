package com.aditya.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.aditya"})
public class SpringRootConfig {
	
	@Bean
	public BasicDataSource basicDataSource() {
		
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/capp_db");
		ds.setUsername("root");
		ds.setPassword("");
		
		return ds;
		
	} 

}
