package com.aditya.service;

import java.util.List;

import com.aditya.domain.User;
import com.aditya.exceptions.UserBlockedException;

public interface UserService {
	
	public static final Integer LOGINSTATUSACTIVE=1;
	public static final Integer LOGINSTATUSBLOCKED=2;
	
	public static final Integer ADMINROLE=1;
	public static final Integer USERROLE=2;
	
	/*
	 * the method handles the user registration task.
	 * @param u the new user detail as user.
	*/
	public void regester(User u);
	
	/*
	 * the method handles login operation using given credentials and 
	 * returns user object when success ,
	 * returns null when failed and 
	 * throws exception when the user is blocked
	 * @param loginName
	 * @param password
	 * @return User/null
	 * @throws com.aditya.exceptions.UserBlockedException when user account is blocked
	 */
	public User login(String loginName,String password) throws UserBlockedException;
	
	/*
	 * call this method to get list of registered users
	*/
	public List<User> getUserList(); 
	
	/*
	 * call this method to block or unblock the user
	*/
	public void changeLoginStatus(Integer userId, Integer loginStatus);
	

}
