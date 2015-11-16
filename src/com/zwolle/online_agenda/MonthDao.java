package com.zwolle.online_agenda;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class MonthDao {
		private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("calendar");
		
		public static void addDay(){
			Day d = new Day();
			d.setDay("dit is een dag");
			
			Week w = new Week();
			w.getDagen().add(d);
			w.setWeekNumber(32);
			
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(w);
			t.commit();
			em.close();
		}
	/*	//voeg een dag aan de database toe
		public static void addDay(Day day) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(day);
			t.commit();
			em.close();
		}
		
		//voeg een week aan de database toe
		public static void addWeek(Week week) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(week.getWeek());
			em.persist(week);
			t.commit();
			em.close();
		}*/
		
		
	

}
