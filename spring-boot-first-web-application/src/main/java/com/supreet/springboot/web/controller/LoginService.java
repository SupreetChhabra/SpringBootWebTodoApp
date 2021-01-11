package com.supreet.springboot.web.controller;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateUser(String name, String password) {
		
		return name.equalsIgnoreCase("Supreet") && password.equalsIgnoreCase("1111");
	}
	

}
