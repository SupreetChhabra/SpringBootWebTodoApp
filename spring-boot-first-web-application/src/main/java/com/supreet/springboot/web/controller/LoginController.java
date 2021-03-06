package com.supreet.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLogin(ModelMap model) {
		return "login";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcome(@RequestParam String name,@RequestParam String password, ModelMap model) {
		boolean isValidUser=service.validateUser(name,password);
		
		if (!isValidUser) {
			model.put("errorMessage", "InvalidCredentials");
			return "login";
		}
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}

}
