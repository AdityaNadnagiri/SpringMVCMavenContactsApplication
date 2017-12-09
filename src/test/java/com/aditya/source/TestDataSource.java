package com.aditya.source;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aditya.config.SpringRootConfig;

public class TestDataSource {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx= new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource ds=ctx.getBean(DataSource.class);
		
		JdbcTemplate jt=new JdbcTemplate(ds);
		String sql="Insert Into user (name,phone,email,address,loginName,password) values (?,?,?,?,?,?)";
		
		Object[] param = new Object[] {"Aditya Nandagiri",
									   "+13612286799",
									   "adityanandag@gmail.com",
									   "412 W Mesquite Ave, Kingsville,Texas,78363",
									   "aditya",
									   "chE208*07"};

		jt.update(sql,param);
		
		System.out.println("----------SQL Executed---------\n");
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
