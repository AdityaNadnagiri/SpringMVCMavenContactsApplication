package com.aditya.userDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.config.SpringRootConfig;
import com.aditya.dao.UserDAO;

public class TestUserDAODelete {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=ctx.getBean(UserDAO.class);
		
		userDAO.delete(32);
		
		System.out.println("----------User Data Deleted---------\n");
		
		((ConfigurableApplicationContext) ctx).close();		
	}

}
