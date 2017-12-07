package com.aditya.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.config.SpringRootConfig;
import com.aditya.dao.UserDAO;
import com.aditya.domain.User;

public class TestUserDAOSave {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=ctx.getBean(UserDAO.class);
		User u=new User();
		u.setName("Ashwin");
		u.setPhone("+918985889769");
		u.setEmail("nandagiri.ashwin@gmail.com");
		u.setAddress("India");
		u.setLoginName("Ashwin");
		u.setPassword("aditya123");
		u.setRole(1);
		u.setLoginStatus(1);
		userDAO.save(u);
		((ConfigurableApplicationContext) ctx).close();
		System.out.println("----------Data Saved---------");
		
		
		
		
	}

}
