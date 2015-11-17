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
	
	
	//controller for /calendar
	@RequestMapping("/calendar")
	public String Calendar (Model model) {
	
		
		PopulateCalendar cal = new PopulateCalendar(2015, 12);
		
		model.addAttribute("month", cal.getMonthHeader());
		model.addAttribute("year", cal.getYearHeader());
		//model.addAttribute("generateMonth", cal.generateMonth().getWeken());
		
		//model.addAttribute("generateMonth", MonthDao.find();
		//hoe weet je het id  van de opgeslagen maand?
		//hoe parse je naar Long?
	
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
