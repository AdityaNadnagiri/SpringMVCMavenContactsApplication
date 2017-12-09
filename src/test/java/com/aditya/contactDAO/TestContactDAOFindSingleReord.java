package com.aditya.contactDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.config.SpringRootConfig;
import com.aditya.dao.ContactDAO;
import com.aditya.domain.Contact;

public class TestContactDAOFindSingleReord {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO=ctx.getBean(ContactDAO.class);
		Contact c=contactDAO.findById(1);
		
		System.out.println(c.getContactId()+" "+c.getUserId()+" "
						  +c.getName()+" "+c.getPhone()+" "
						  +c.getEmail()+" "+c.getAddress()+" "+c.getRemark());
		
		System.out.println("----------Data Found---------\n");
		
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
