package com.aditya.contactDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.config.SpringRootConfig;
import com.aditya.dao.ContactDAO;

public class TestContactDAODelete {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO=ctx.getBean(ContactDAO.class);
		
		contactDAO.delete(2);
		
		System.out.println("----------Data Deleted---------");
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
