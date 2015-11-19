package com.zwolle.online_agenda;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("myRequestObject")
@RequestMapping("/login")
public class Login {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String login(){
		return "Login";
	}
	
	// check form info uit jsp met database, als het klopt, haal calendar uit database en toon /calendar jsp.
	@RequestMapping(method = RequestMethod.POST)
	public String registerSubmit(HttpServletResponse response, @RequestParam(value = "usernameInput", required=false) String usernameInput,  
	@RequestParam(value = "passwordInput", required=false) String passwordInput, Model model, HttpSession session){
			
		
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
		if (passwordInput.equals(RegisterDAO.findUserByUsernameAndPassword(usernameInput, passwordInput).getPassword()) == false){
			model.addAttribute("invalidPassword", "Password incorrect");
			return "Login";
		}
			
		//check username with database
		if (usernameInput.equals(RegisterDAO.findUserByUsernameAndPassword(usernameInput, passwordInput).getUsername()) == false){
				model.addAttribute("invalidUsername", "User not found");
				return "Login";
		} else {
		
		
		//username en password via session aan jsp controller doorgeven
		session.setAttribute("username",usernameInput);
		session.setAttribute("password", passwordInput);
		
		return "redirect:calendar";
		
		}
	}
}
