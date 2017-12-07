package com.aditya.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

// Note: do not @Repository or @Service or @Component annotation 
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport{
@Autowired
	public void SetDataSource2(DataSource ds) {
	
	super.setDataSource(ds);
}

}
