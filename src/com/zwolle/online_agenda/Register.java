package com.zwolle.online_agenda;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
			@RequestParam(value = "newPassword", required=false) String newPassword, @RequestParam(value = "confirmPassword", required=false) String confirmPassword, Model model){
			
		
		// check form
		if(username == ""){
			model.addAttribute("usernameEmpty", "Fill in a username.");
			return "Register";
		}
		
		if (newPassword == ""){
			model.addAttribute("passwordEmpty", "Fill in a password.");
			return "Register";
		}
			
		if (newPassword.equals(confirmPassword) == false){
			model.addAttribute("noMatch", "Password doesn't match");
			return "Register";
		} else {	
		
		//make months and users in populateDatabase class (returns a user)
		User user = new User();
		PopulateDatabase populate = new PopulateDatabase();
		populate.createObjectsOfMonth(11);
		user.setMaanden(populate.getMaanden());
		user.setUsername(username);
		user.setPassword(newPassword);
		
		//add user to database
		if(user.getMaanden().isEmpty() == false){
			RegisterDAO.addUser(user);
			}
		return "RegisterSucces";
		}	
	}
}

	


