package com.aditya.userDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.config.SpringRootConfig;
import com.aditya.dao.UserDAO;
import com.aditya.domain.User;

public class TestUserDAOFindSingleReord {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=ctx.getBean(UserDAO.class);
		
		User u=userDAO.findById(30);
		System.out.println(u.getUserId()+" "+u.getName()+" "
						  +u.getPhone()+" "+u.getEmail()+" "
						  +u.getAddress()+" "+u.getRole()+" "
						  +u.getLoginName()+" "+u.getLoginStatus());
		
		System.out.println("----------User Data Found---------\n");
		
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
