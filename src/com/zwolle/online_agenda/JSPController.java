package com.zwolle.online_agenda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("myRequestObject")
public class JSPController {
	
	
	private int monthNumber, yearNumber;	
	private String [] months = {"January", "February", "March", "April", "May", "June", "July","August", "September", "October", "November", "December"};
	
	//set header month
		public String getMonthHeader(int month){
			return months[month];
		}

	//controller for nextMonth
	@RequestMapping("/calendar/nextmonth")
	public String nextMonth (Model model, HttpSession session){
		
		if (monthNumber == 11) {
			yearNumber++;
			monthNumber = 0;
			
			//hardcoded! errorpage if year is not there to generate 
			if (yearNumber > 2025 ){ return "YearNotGenerated";}
			
			String username = session.getAttribute("username").toString();
			String password = session.getAttribute("password").toString();
			
			model.addAttribute("month", getMonthHeader(monthNumber));
			model.addAttribute("year", RegisterDAO.findUserByUsernameAndPassword(username,password).getMaanden().get(monthNumber).getYear());
			model.addAttribute("generateMonth", RegisterDAO.findUserByUsernameAndPassword(username,password).getMaanden().get(monthNumber).getWeken());

			return "Calendar";
		
			} else {
			
			monthNumber++;
			
			String username = session.getAttribute("username").toString();
			String password = session.getAttribute("password").toString();
			
			model.addAttribute("month", getMonthHeader(monthNumber));
			model.addAttribute("year", RegisterDAO.findUserByUsernameAndPassword(username,password).getMaanden().get(monthNumber).getYear());
			model.addAttribute("generateMonth", RegisterDAO.findUserByUsernameAndPassword(username,password).getMaanden().get(monthNumber).getWeken());

			return "Calendar";
		}
	}
	
	//controller for previousMonth
		@RequestMapping("/calendar/previousmonth")
		public String lastMonth (Model model, HttpSession session){
			
			if (monthNumber == 0) {
				
				yearNumber--; 
				monthNumber = 11;
			
				//hardcoded! errorpage if year is not there to generate 
				if (yearNumber < 2015 ){ return "YearNotGenerated";}
				
				
				String username = session.getAttribute("username").toString();
				String password = session.getAttribute("password").toString();
				
				model.addAttribute("month", getMonthHeader(monthNumber));
				model.addAttribute("year", RegisterDAO.findUserByUsernameAndPassword(username,password).getMaanden().get(monthNumber).getYear());
				model.addAttribute("generateMonth", RegisterDAO.findUserByUsernameAndPassword(username,password).getMaanden().get(monthNumber).getWeken());

				return "Calendar";
			
			} else {
				monthNumber--;
				
				String username = session.getAttribute("username").toString();
				String password = session.getAttribute("password").toString();
				
				model.addAttribute("month", getMonthHeader(monthNumber));
				model.addAttribute("year", RegisterDAO.findUserByUsernameAndPassword(username,password).getMaanden().get(monthNumber).getYear());
				model.addAttribute("generateMonth", RegisterDAO.findUserByUsernameAndPassword(username,password).getMaanden().get(monthNumber).getWeken());

				return "Calendar";
			}
		}
			
	
	//controller for /calendar
	@RequestMapping("/calendar")
	public String calendar (Model model, HttpSession session){
	
		RealDate date = new RealDate();
		date.getDate();
		monthNumber = date.getRealMonth();
		yearNumber = date.getRealYear();
		
		String username = session.getAttribute("username").toString();
		String password = session.getAttribute("password").toString();
		
		model.addAttribute("month", getMonthHeader(monthNumber));
		model.addAttribute("year", RegisterDAO.findUserByUsernameAndPassword(username,password).getMaanden().get(monthNumber).getYear());
		model.addAttribute("generateMonth", RegisterDAO.findUserByUsernameAndPassword(username,password).getMaanden().get(monthNumber).getWeken());

		return "Calendar";
	}
	
	
	
	//display note
	@RequestMapping("/calendar/note")
	public String displayNote() {
	
		//get note
		return "Note";
	}
	

}
