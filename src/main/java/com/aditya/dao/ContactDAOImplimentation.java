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
import com.aditya.rm.ContactRowMapper;

@Repository
public class ContactDAOImplimentation extends BaseDAO implements ContactDAO{

	public void save(Contact c) {

		String sql=" INSERT INTO CONTACT (userId, Name, phone, email, address, remark) "
			     + " VALUES (:userId, :name, :phone, :email, :address, :remark)";
		
		Map<String,String> m=new HashMap<String,String>();
		m.put("userId", c.getUserId().toString());
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		
		SqlParameterSource pS=new MapSqlParameterSource(m);
		KeyHolder kH=new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, pS,kH);
		c.setContactId(kH.getKey().intValue());
	}

	public void update(Contact c) {

		String sql=" UPDATE CONTACT "
			     + " SET name=:name, phone=:phone, email=:email, address=:address, remark=:remark "
			     + " WHERE contactId=:contactId";
		
		Map<String,String> m=new HashMap<String,String>();
		m.put("contactId", c.getContactId().toString());
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		
		getNamedParameterJdbcTemplate().update(sql, m);
	}

	public void delete(Contact c) {
		
		this.delete(c.getContactId());
	}

	public void delete(Integer contactId) {
		
		String sql=" DELETE FROM CONTACT"
			     + " WHERE contactId=?";
		getJdbcTemplate().update(sql,contactId);
	}

	public Contact findById(Integer contactId) {
		
		String sql=" SELECT contactId, userId, Name, phone, email, address, remark "
				 + " FROM CONTACT WHERE contactId=?";
		return getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), contactId);
	}

	public List<Contact> findAll() {
		
		String sql=" SELECT contactId, userId, Name, phone, email, address, remark "
				 + " FROM CONTACT ";
		return getJdbcTemplate().query(sql, new ContactRowMapper());
	}

	public List<Contact> findByProperty(String propName, Object propValue) {
		
		String sql=" SELECT contactId, userId, Name, phone, email, address, remark "
				 + " FROM CONTACT WHERE "+propName+"=?";
		return getJdbcTemplate().query(sql, new ContactRowMapper(), propValue);
	}

}
