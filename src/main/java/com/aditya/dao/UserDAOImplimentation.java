package com.aditya.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.aditya.domain.User;
import com.aditya.rm.UserRowMapper;

@Repository
public class UserDAOImplimentation extends BaseDAO implements UserDAO{

	public void save(User u) {

		String sql=" INSERT INTO USER(name,phone,email,address,loginName,password,role,loginStatus)"
				 + " VALUES (:name,:phone,:email,:address,:loginName,:password,:role,:loginStatus)";
		
		Map<String,String> m=new HashMap<String,String>();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("loginName", u.getLoginName());
		m.put("password", u.getPassword());
		m.put("role", u.getRole().toString());
		m.put("loginStatus", u.getLoginStatus().toString());
		
		KeyHolder kh= new GeneratedKeyHolder();
		SqlParameterSource ps=new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql, ps,kh);
		u.setUserId(kh.getKey().intValue());
	}

	public void update(User u) {
		
		String sql="UPDATE USER "
				+ " SET name=:name, phone=:phone, email=:email,loginName=:loginName, address=:address, role=:role, loginStatus=:loginStatus "
				+ " WHERE userId=:userId";
		
		Map<String,String> m=new HashMap<String,String>();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("loginName", u.getLoginName());
		m.put("role", u.getRole().toString());
		m.put("loginStatus", u.getLoginStatus().toString());
		m.put("userId", u.getUserId().toString());
		
		getNamedParameterJdbcTemplate().update(sql,m);
	}

	public void delete(User u) {
		
		this.delete(u.getUserId());
	}

	public void delete(Integer userId) {
		
		String sql=" DELETE FROM USER "
				 + "WHERE userId=?";
		
		getJdbcTemplate().update(sql, userId);
	}

	public User findById(Integer userId) {
		
		String sql=" SELECT userId,name, phone, email, address, loginName, role, loginStatus "
				 + " FROM USER WHERE userId=?";
		
		return getJdbcTemplate().queryForObject(sql, new UserRowMapper(),userId);
	}

	public List<User> findAll() {
		
		String sql=" SELECT userId,name, phone, email, address, loginName, role, loginStatus "
				 + " FROM USER";
		
		return getJdbcTemplate().query(sql, new UserRowMapper());
	}

	public List<User> findByProperty(String propName, Object propValue) {
		
		String sql=" SELECT userId,name, phone, email, address, loginName, role, loginStatus "
				 + " FROM USER WHERE "+propName+"=?";
		
		return getJdbcTemplate().query(sql, new UserRowMapper(),propValue);
	}

}
