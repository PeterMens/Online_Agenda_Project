package com.zwolle.online_agenda;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public abstract class Login {
	
	private static String username, password;

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}


	// check form info uit jsp met database, als het klopt, haal calendar uit database en toon /calendar jsp.
	@RequestMapping(method = RequestMethod.GET)
	public String register(){
			return "Login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String registerSubmit(HttpServletResponse response, @RequestParam(value = "usernameInput", required=false) String usernameInput,  
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
		if (passwordInput.equals(RegisterDAO.findUserByUsernameAndPassword(usernameInput, passwordInput).getPassword()) == false){
			model.addAttribute("invalidPassword", "Password incorrect");
			return "Login";
		}
			// moet false, als je checked, voor nu om te testen = true.
		//check username with database
		if (usernameInput.equals(RegisterDAO.findUserByUsernameAndPassword(usernameInput, passwordInput).getUsername()) == false){
				model.addAttribute("invalidUsername", "User not found");
				return "Login";
		} else {
		
		//password = passwordInput;
		//username = usernameInput;
			
		return "redirect: /calendar";
		
		}
	}
}
