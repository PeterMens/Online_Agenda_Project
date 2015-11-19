package com.zwolle.online_agenda;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class JSPController {
	
	private int monthNumber, yearNumber;	
	private String [] months = {"January", "February", "March", "April", "May", "June", "July","August", "September", "October", "November", "December"};
	
	
	//set header month
		public String getMonthHeader(int month){
			return months[month];
		}

	//controller for nextMonth
	@RequestMapping("/calendar/nextmonth")
	public String nextMonth (Model model){
		
		if (monthNumber == 11) {
			yearNumber++;
			monthNumber = 0;
			
			//hardcoded! errorpage if year is not there to generate 
			if (yearNumber > 2025 ){ return "YearNotGenerated";}
			
			System.out.println("Maand on nextclick = " + monthNumber);
			System.out.println("Jaar on nextclick = " + yearNumber);
			
			model.addAttribute("month", getMonthHeader(monthNumber));
			model.addAttribute("year", MonthDao.findMonthByYearAndMonthNumber(yearNumber, monthNumber).getYear());
			model.addAttribute("generateMonth", MonthDao.findMonthByYearAndMonthNumber(yearNumber, monthNumber).getWeken());
		
			} else {
			
			monthNumber++;
			
			System.out.println("Maand on nextclick = " + monthNumber);
			System.out.println("Jaar on nextclick = " + yearNumber);
			
			model.addAttribute("month", getMonthHeader(monthNumber));
			model.addAttribute("year", MonthDao.findMonthByYearAndMonthNumber(yearNumber, monthNumber).getYear());
			model.addAttribute("generateMonth", MonthDao.findMonthByYearAndMonthNumber(yearNumber, monthNumber).getWeken());
		}
		
		return "Calendar";
	}
	
	//controller for previousMonth
		@RequestMapping("/calendar/previousmonth")
		public String lastMonth (Model model){
			
			if (monthNumber == 0) {
				
				yearNumber--; 
				monthNumber = 11;
			
				//hardcoded! errorpage if year is not there to generate 
				if (yearNumber < 2015 ){ return "YearNotGenerated";}
				
				System.out.println("Maand on previousclick = " + monthNumber);
				System.out.println("Jaar on previousclick = " + yearNumber);
				
				model.addAttribute("month", getMonthHeader(monthNumber));
				model.addAttribute("year", MonthDao.findMonthByYearAndMonthNumber(yearNumber, monthNumber).getYear());
				model.addAttribute("generateMonth", MonthDao.findMonthByYearAndMonthNumber(yearNumber, monthNumber).getWeken());
			
			} else {
				monthNumber--;
				
				System.out.println("Maand on previousclick = " + monthNumber);
				System.out.println("Jaar on previousclick = " + yearNumber);
				
				model.addAttribute("month", getMonthHeader(monthNumber));
				model.addAttribute("year", MonthDao.findMonthByYearAndMonthNumber(yearNumber, monthNumber).getYear());
				model.addAttribute("generateMonth", MonthDao.findMonthByYearAndMonthNumber(yearNumber, monthNumber).getWeken());
			}
			
			return "Calendar";
		}
			
	
	//controller for /calendar
	@RequestMapping("/calendar")
	public String calendar (Model model) {
	
		RealDate date = new RealDate();
		date.getDate();
		monthNumber = date.getRealMonth();
		yearNumber = date.getRealYear();
		
		model.addAttribute("month", getMonthHeader(monthNumber));
		model.addAttribute("year", MonthDao.findMonthByYearAndMonthNumber(yearNumber, monthNumber).getYear());
		model.addAttribute("generateMonth", RegisterDAO.findUserByUsernameAndPassword(Login.getUsername(), Login.getPassword()).getMaanden());
		
		
		//model.addAttribute("generateMonth", MonthDao.findMonthByYearAndMonthNumber(yearNumber, monthNumber).getWeken());
		
		return "Calendar";
	}
	
	
	
	//display note
	@RequestMapping("/calendar/note")
	public String displayNote() {
	
		//get note
		return "Note";
	}
	

}
