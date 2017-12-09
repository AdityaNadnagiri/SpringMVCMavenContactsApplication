package com.aditya.userDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.config.SpringRootConfig;
import com.aditya.dao.UserDAO;
import com.aditya.domain.User;

public class TestUserDAOUpdate {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=ctx.getBean(UserDAO.class);
		
		User u=new User();
		u.setName("Ashwin Nandagiri");
		u.setPhone("+918985889769");
		u.setEmail("nandagiri.ashwin@gmail.com");
		u.setAddress("HNo:B-40, Prakruthi Nivas, Annaram, Jinnaram, Medak, Telangana,India");
		u.setLoginName("ashwin");
		u.setRole(1);
		u.setLoginStatus(1);
		u.setUserId(31);
		userDAO.update(u);
		
		System.out.println("----------User Data Updated---------\n");
		
		((ConfigurableApplicationContext) ctx).close();		
	}

}
