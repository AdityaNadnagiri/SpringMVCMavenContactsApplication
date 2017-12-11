package com.aditya.userService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.config.SpringRootConfig;
import com.aditya.domain.User;
import com.aditya.service.UserService;

public class TestUserServiceRegester {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService=ctx.getBean(UserService.class);
		
		User u=new User();
		u.setName("Srinivas Yalapati");
		u.setPhone("+12146864181");
		u.setEmail("srinivasreddy252@gmail.com");
		u.setAddress("14600 Marsh Ln, Addison, TX 75001");
		u.setLoginName("srinivas");
		u.setPassword("chE208*07");
		u.setRole(UserService.ADMINROLE);
		u.setLoginStatus(UserService.LOGINSTATUSACTIVE);
		
		userService.regester(u);
		
		System.out.println("----------New User Regestered---------\n");

		((ConfigurableApplicationContext) ctx).close();
	}

}
