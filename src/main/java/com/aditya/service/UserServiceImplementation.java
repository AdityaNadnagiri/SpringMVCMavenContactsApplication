package com.aditya.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.aditya.dao.BaseDAO;
import com.aditya.dao.UserDAO;
import com.aditya.domain.User;
import com.aditya.exceptions.UserBlockedException;
import com.aditya.rm.UserRowMapper;

@Service
public class UserServiceImplementation extends BaseDAO implements UserService{

	@Autowired
	private UserDAO userDAO; 
	public void regester(User u) {

		userDAO.save(u);
	}

	public User login(String loginName, String password) throws UserBlockedException {
		
		String sql=" SELECT userId, name, phone, email, address, loginName, role, loginStatus "
				 + " FROM USER WHERE loginName=:ln and password=:pw";
		Map<String, String> m=new HashMap<String, String>();
		m.put("ln", loginName);
		m.put("pw", password);
		
		try 
		{
			
			User u = getNamedParameterJdbcTemplate().queryForObject(sql,m,new UserRowMapper());
			if(u.getLoginStatus().equals(UserService.LOGINSTATUSBLOCKED)) {
				throw new UserBlockedException("Your Account Has Been Blocked. Contact Admin");
			}else {
					
				return u;
			}
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub
		
	}

}
