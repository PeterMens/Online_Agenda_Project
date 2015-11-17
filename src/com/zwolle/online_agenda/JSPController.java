package com.zwolle.online_agenda;

import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.xml.internal.bind.v2.model.core.ID;


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
		
		if (monthNumber > 12) {yearNumber++; monthNumber = 1;} else {
			monthNumber++;
			
			model.addAttribute("month", getMonthHeader(monthNumber));
			model.addAttribute("year", MonthDao.findMonthByYearAndMonthNumber(yearNumber, monthNumber).getYear());
			model.addAttribute("generateMonth", MonthDao.findMonthByYearAndMonthNumber(yearNumber, monthNumber).getWeken());
		}
		System.out.println("Maand = " + monthNumber);
		System.out.println("Jaar = " + yearNumber);
		return "Calendar";
	}
	
	//controller for previousMonth
		@RequestMapping("/calendar/previousmonth")
		public String lastMonth (Model model){
			
			if (monthNumber < 1) {yearNumber--; monthNumber = 12;} else {
				monthNumber--;
				
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
		model.addAttribute("generateMonth", MonthDao.findMonthByYearAndMonthNumber(yearNumber, monthNumber).getWeken());
		
	
		
	
	
		return "Calendar";
	}
	
	
	@RequestMapping("/generate")
	public @ResponseBody String GenerateDatabase () {
	PopulateDatabase db = new PopulateDatabase();
		db.createObjectsOfMonth(11);
		
		return "Database Generated";
	}
	
	/*@RequestMapping("/contact")
	public @ResponseBody String Contact (){
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contact");
	Contact contact = new Contact();
	contact.chooseFirstName();
	
	 EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		
		em.persist(contact);
		
		t.commit();
		em.close();
	 
	 return "Contact";
	 }*/
	 

}
