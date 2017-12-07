package com.aditya.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.aditya.domain.Contact;

@Repository
public class ContactDAOImplimentation extends BaseDAO implements ContactDAO{

	public void save(Contact c) {

		String sql=" insert into contact (userId, Name, phone, email, address, remark) "
			     + " values (:userId, :Name, :phone, :email, :address, :remark)";
		
		Map m=new HashMap();
		m.put("userId", c.getUserId());
		m.put("userId", c.getName());
		m.put("userId", c.getPhone());
		m.put("userId", c.getEmail());
		m.put("userId", c.getAddress());
		m.put("userId", c.getRemark());
		
		SqlParameterSource pS=new MapSqlParameterSource(m);
		KeyHolder kH=new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, pS,kH);
		c.setContactId(kH.getKey().intValue());
		
	}

	public void update(Contact c) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Contact c) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Integer contactID) {
		// TODO Auto-generated method stub
		
	}

	public Contact findById(Integer contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contact> findByProperty(String propName, Object propValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
