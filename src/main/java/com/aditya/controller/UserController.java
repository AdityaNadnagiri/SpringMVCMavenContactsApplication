package com.aditya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aditya.command.LoginCommand;
import com.aditya.domain.User;
import com.aditya.exceptions.UserBlockedException;
import com.aditya.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/index",""})
	public String index(Model m) {
		m.addAttribute("command",new LoginCommand());
		return "index"; //JSP - /WEB-INF/view/index.jsp
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String handlerLogin(@ModelAttribute("command") LoginCommand cmd, Model m) {
		
		try {
			User logedinUser=userService.login(cmd.getLoginName(),cmd.getPassword());
			if(logedinUser==null) {
				// FAILED 
				// add error message and go back to login form
				m.addAttribute("err","Login Failed! Enter Valid Credentials.");
				return "index"; //JSP - /WEB-INF/view/index.jsp
			}else {
				// SUCCESS
				// check the role and get direct to the appropriate user dash board
				if(logedinUser.getRole().equals(UserService.ADMINROLE)) {
					
					return "redirect:admin/home";
				}else if(logedinUser.getRole().equals(UserService.USERROLE)) {
					
					return "redirect:user/home";
				}else {
					m.addAttribute("err","Invalid User Role");
					return "index";
				}
				 	
			}
		} catch (UserBlockedException ex) {
			m.addAttribute("err",ex.getMessage());
			return "index";
		}
		
	}

		@RequestMapping(value= {"/admin/home"})
	public String adminHome() {

		return "adminHome"; //JSP - /WEB-INF/view/userHomePage.jsp
	}

	@RequestMapping(value= {"/user/home"})
	public String userHome() {

		return "userHome"; //JSP - /WEB-INF/view/userHomePage.jsp
	}

	
}
