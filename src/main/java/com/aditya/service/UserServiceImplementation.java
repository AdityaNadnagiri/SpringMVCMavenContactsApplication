package com.aditya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditya.dao.BaseDAO;
import com.aditya.dao.UserDAO;
import com.aditya.domain.User;
import com.aditya.exceptions.UserBlockedException;

@Service
public class UserServiceImplementation extends BaseDAO implements UserService{

	@Autowired
	private UserDAO userDAO; 
	public void regester(User u) {

		userDAO.save(u);
	}

	public User login(String loginName, String password) throws UserBlockedException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub
		
	}

}
