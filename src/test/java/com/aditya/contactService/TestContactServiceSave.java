package com.aditya.contactService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.config.SpringRootConfig;
import com.aditya.domain.Contact;
import com.aditya.service.ContactService;

public class TestContactServiceSave{
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactService contactService=ctx.getBean(ContactService.class);
		
		Contact c=new Contact();
		c.setUserId(1);
		c.setName("Srinivas Yalapati");
		c.setPhone("+12146864181");
		c.setEmail("srinivasreddy252@gmail.com");
		c.setAddress("14600 Marsh Ln, Addison, TX 75001");
		c.setRemark("Save Test");
		
		contactService.save(c);
		
		System.out.println("----------New Contact Saved---------\n");

		((ConfigurableApplicationContext) ctx).close();
	}

}
