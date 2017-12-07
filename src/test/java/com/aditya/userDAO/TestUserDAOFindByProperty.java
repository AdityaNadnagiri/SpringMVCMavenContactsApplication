package com.aditya.userDAO;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.config.SpringRootConfig;
import com.aditya.dao.UserDAO;
import com.aditya.domain.User;

public class TestUserDAOFindByProperty {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=ctx.getBean(UserDAO.class);
		
		List<User> users=userDAO.findByProperty("not email", "");
		for (User u : users) {
			System.out.println(u.getUserId()+" "+u.getName()+" "+u.getPhone()+" "+u.getEmail()+" "+
							u.getAddress()+" "+u.getRole()+" "+u.getLoginName()+" "+u.getLoginStatus());
		}
		
		System.out.println("----------All Data Found---------");
		
	}

}
