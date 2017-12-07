package com.aditya.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aditya.domain.Contact;

public class ContactRowMapper2 implements RowMapper<Contact>{

	public Contact mapRow(ResultSet rs, int i) throws SQLException {

		Contact c=new Contact();
		c.setContactId(rs.getInt("ContactId"));
		c.setUserId(rs.getInt("UserId"));
		c.setName(rs.getString("name"));
		c.setPhone(rs.getString("phone"));
		c.setEmail(rs.getString("email"));
		c.setAddress(rs.getString("address"));
		c.setRemark(rs.getString("remark"));
		return c;
	}
	
	

}
