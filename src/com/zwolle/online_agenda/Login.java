package com.zwolle.online_agenda;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class Login {

	// check form info uit jsp met database, als het klopt, haal calendar uit database en toon /calendar jsp.
	
	@RequestMapping(method = RequestMethod.GET)
	public String register(){
			return "Login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerSubmit(HttpServletResponse response, @RequestParam(value = "usernameInput", required=false) String usernameInput,  
	@RequestParam(value = "passwordInput", required=false) String passwordInput, Model model){
			
		
		// check form
		if(usernameInput == ""){
			model.addAttribute("usernameEmpty", "Fill in a username.");
			return "Login";
		}
		
		if (passwordInput == ""){
			model.addAttribute("passwordEmpty", "Fill in a password.");
			return "Login";
		}
			
		//checkpassword with database	
		// moet false, als je checked, voor nu om te testen = true.
		if (passwordInput.equals("falsePassword") == true){
			model.addAttribute("invalidPassword", "Password incorrect");
			return "Login";
		}
			// moet false, als je checked, voor nu om te testen = true.
		//check username with database
		if (usernameInput.equals("falseUsername") == true){
				model.addAttribute("invalidUsername", "User not found");
				return "Login";
		} else {
		
		// haal agenda uit DB op
		
		return "Calendar";
		
		}
	}
}
