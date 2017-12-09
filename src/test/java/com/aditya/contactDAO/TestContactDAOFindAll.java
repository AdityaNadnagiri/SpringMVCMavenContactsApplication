package com.aditya.contactDAO;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.config.SpringRootConfig;
import com.aditya.dao.ContactDAO;
import com.aditya.domain.Contact;

public class TestContactDAOFindAll {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO=ctx.getBean(ContactDAO.class);
		
		List<Contact> contacts=contactDAO.findAll();
		
		for (Contact c : contacts) {
			System.out.println(c.getContactId()+" "
							  +c.getUserId()+" "
							  +c.getName()+" "
							  +c.getPhone()+" "
							  +c.getEmail()+" "
							  +c.getAddress());
		}
		
		System.out.println("----------All Data Found---------\n");
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
