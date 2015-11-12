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
		Calendar calendar = new Calendar();
		model.addAttribute("dayOfWeek", calendar.getFirstDayOfMonth());
		model.addAttribute("realMonth", calendar.setCurrentMonthHeader());
		
		int[] weken = { 31, 32, 33, 34 };
		model.addAttribute("weken", weken);
		int[] dagen = {1,2,3,4,5,6,7};
		model.addAttribute("dagen", dagen);
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
