package com.aditya.contactDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.config.SpringRootConfig;
import com.aditya.dao.ContactDAO;
import com.aditya.domain.Contact;

public class TestContactDAOUpdate {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO=ctx.getBean(ContactDAO.class);
		
		Contact c=new Contact();
		c.setContactId(1);
		c.setName("Ashwin Nandagiri");
		c.setPhone("+918985889769");
		c.setEmail("nandagiri.ashwin@gmail.com");
		c.setAddress("HNo:B-40, Prakruthi Nivas, Annaram, Jinnaram, Medak, Telangana,India");
		c.setRemark("Remark");
		
		contactDAO.update(c);
		
		System.out.println("----------Contact Data Updated---------\n");
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
