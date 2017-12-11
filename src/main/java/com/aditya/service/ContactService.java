package com.aditya.service;

import java.util.List;

import com.aditya.domain.Contact;

public interface ContactService {
	
	public void save(Contact c);
	public void update(Contact c);
	public void delete(Integer contactId);
	public void delete(Integer[] contactIds);
	/*
	 * This method returns all contacts of the user who is logged in. 
	 * @param userId
	 * @return
	*/
	public List<Contact> findUserContact(Integer userId);
	/*
	 * This method searches contacts based on free-text-criteria(txt). 
	 * @param userId (User whis is logged in)
	 * @param txt (free-text-criteria)
	 * @return 
	*/
	public List<Contact> findUserContact(Integer userId,String txt); 

}
