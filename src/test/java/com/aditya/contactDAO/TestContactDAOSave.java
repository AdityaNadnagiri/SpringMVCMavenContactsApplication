
package com.aditya.contactDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.config.SpringRootConfig;
import com.aditya.dao.ContactDAO;
import com.aditya.domain.Contact;

public class TestContactDAOSave {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO=ctx.getBean(ContactDAO.class);
		
		Contact c=new Contact();
		c.setUserId(1);
		c.setName("Ashwin");
		c.setPhone("+918985889769");
		c.setEmail("nandagiri.ashwin@gmail.com");
		c.setAddress("India");
		c.setRemark("Remarks");
		contactDAO.save(c);
		
		System.out.println("----------Contact Data Saved---------\n");
		
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
