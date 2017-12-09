package com.aditya.userDAO;

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
		u.setName("Mahesh Gaddam");
		u.setPhone("+17026826531");
		u.setEmail("mahi.ramuk@gmail.com");
		u.setAddress("USA");
		u.setLoginName("mahesh");
		u.setPassword("chE208*07");
		u.setRole(1);
		u.setLoginStatus(1);
		
		userDAO.save(u);
		
		System.out.println("----------User Data Saved---------\n");

		((ConfigurableApplicationContext) ctx).close();
	}

}
