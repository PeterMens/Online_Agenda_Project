package com.zwolle.online_agenda;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/register")
public class Register {
// register new user with name and password
// generate database for user 
// koppel database met username+password
	
	@RequestMapping(method = RequestMethod.GET)
	public String register(){
			return "Register";
		}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerSubmit(HttpServletResponse response, @RequestParam(value = "username", required=false) String username,  
			@RequestParam(value = "newPassword", required=false) String newPassword){
			
		User user = new User();
		user.setUsername(username);
		user.setPassword(newPassword);
		
		//create database 
		// add month in user
		//write user to db
			
		return "RegisterSucces";
		
		}
			
	}
		


