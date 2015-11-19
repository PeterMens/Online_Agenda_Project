package com.zwolle.online_agenda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public abstract class MonthDao {
		private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("calendar");
		
		
		//voeg maand aan database toe
		public static void addMonth (Month month){
			
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(month);
			t.commit();
			em.close();
		}
		
		// haal maand op uit database
		public static Month findMonthByYearAndMonthNumber(int yearNumber, int monthNumber){
			Month month;
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			try {
				TypedQuery<Month> q = em.createQuery("from Month u where u.year= :year and u.monthNumber= :monthNumber", Month.class);
				q.setParameter("year", yearNumber);
				month = q.setParameter("monthNumber", monthNumber).getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
			t.commit();
			em.close();	
			return month;
		}
		
		// Verwijder een month uit de database
		public static void remove(Long id){
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			Month month = em.find(Month.class, id);
			if(month != null){
				em.remove(month);
			}
			t.commit();
			em.close();
		}
		
		 //Haal een month op a.d.h.v. zijn id
		public static Month find(Long id){
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			Month month = em.find(Month.class, id);
			t.commit();
			em.close();
			return month;
		}
		
		/*
		//Haal alle months op uit de database
		public static List<Rit> all(){
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			List<Rit> ritten = em.createQuery("from Rit", Rit.class).getResultList();
			t.commit();
			em.close();
			return ritten;
		}*/

}
