package com.zwolle.online_agenda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class JSPController {
	
	
	//controller for /calendar
	@RequestMapping("/calendar")
	public String Calendar (Model model) {
		PopulateCalendar cal = new PopulateCalendar(1995, 1);
		
		model.addAttribute("realMonth", cal.getMonthHeader());
		model.addAttribute("realYear", cal.getYearHeader());
		model.addAttribute("month", cal.generateMonth());
		
		
		return "Calendar";
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
