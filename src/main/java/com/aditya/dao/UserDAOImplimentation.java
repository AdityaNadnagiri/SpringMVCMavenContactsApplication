package com.aditya.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
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

		String sql=" Insert into user(name,phone,email,address,loginName,password,role,loginStatus)"
				 + " values (:name,:phone,:email,:address,:loginName,:password,:role,:loginStatus)";
		
		Map m=new HashMap();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("loginName", u.getLoginName());
		m.put("password", u.getPassword());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());
		
		KeyHolder kh= new GeneratedKeyHolder();
		SqlParameterSource ps=new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql, ps,kh);
		Integer userId=kh.getKey().intValue();
		u.setUserId(userId);
		
	}

	public void update(User u) {
		String sql="update user "
				+ " set name=:name,"
				+ " phone=:phone,"
				+ " email=:email,"
				+ " address=:address,"
				+ " role=:role,"
				+ " loginStatus=:loginStatus "
				+ " where userId=:userId";
		
		Map m=new HashMap();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());
		m.put("userId", u.getUserId());
		
		getNamedParameterJdbcTemplate().update(sql,m);
		
	}

	public void delete(User u) {
		
		this.delete(u.getUserId());
		
	}

	public void delete(Integer userId) {
		String sql=" Delete "
				 + " from user where userId=?";
		
		getJdbcTemplate().update(sql, userId);
		
	}

	public User findById(Integer userId) {
		
		String sql=" select "
				 + " userId,name, phone, email, address, loginName, role, loginStatus "
				 + " from user where userId=?";
		
		User u=getJdbcTemplate().queryForObject(sql, new UserRowMapper(),userId);
		
		return u;
	}

	public List<User> findAll() {
		
		String sql=" select "
			     + " userId,name, phone, email, address, loginName, role, loginStatus "
				 + " from user";
		
		return getJdbcTemplate().query(sql, new UserRowMapper());
		
	}

	public List<User> findByProperty(String propName, Object propValue) {
		
		String sql=" select "
				 + " userId,name, phone, email, address, loginName, role, loginStatus "
				 + " from user where "+propName+"=?";
		
		return getJdbcTemplate().query(sql, new UserRowMapper(),propValue);
	}

}
