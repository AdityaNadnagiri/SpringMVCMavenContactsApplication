package com.aditya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditya.dao.BaseDAO;
import com.aditya.dao.ContactDAO;
import com.aditya.domain.Contact;
import com.aditya.rm.ContactRowMapper;
import com.aditya.util.StringUtil;

@Service
public class ContactServiceImplementation extends BaseDAO implements ContactService{

	@Autowired
	private ContactDAO contactDAO;
	public void save(Contact c) {
		
		contactDAO.save(c);
	}

	public void update(Contact c) {

		contactDAO.update(c);
	}

	public void delete(Integer contactId) {
		
		contactDAO.delete(contactId);		
	}

	public void delete(Integer[] contactIds) {

		String ids=StringUtil.toCommaSeperatedString(contactIds);
		String sql=" DELETE FROM CONTACT"
				 + " WHERE CONTACTID IN("+ids+")";
		
		getJdbcTemplate().update(sql);
	}

	public List<Contact> findUserContact(Integer userId) {
		
		return contactDAO.findByProperty("userId", userId);
	}

	public List<Contact> findUserContact(Integer userId, String txt) {

		String sql=" SELECT contactId, userId, Name, phone, email, address, remark "
				 + " FROM CONTACT WHERE userId=? AND (name    like '%"+txt+"%' OR "
				 								  + " phone   like '%"+txt+"%' OR "
				 								  + " address like '%"+txt+"%' OR "
				 								  + " email   like '%"+txt+"%' OR "
				 								  + " remark  like '%"+txt+"%')";
		
		return getJdbcTemplate().query(sql, new ContactRowMapper(), userId);
	}

}
