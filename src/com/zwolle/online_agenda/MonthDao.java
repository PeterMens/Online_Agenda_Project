package com.zwolle.online_agenda;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class MonthDao {
		private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("calendar");
		
		
		public static void addMonth (Month month){
			
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(month);
			t.commit();
			em.close();
		}
		
		/**
		 * Verwijder een month uit de database
		 */
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
		
		/**
		 * Haal een month op a.d.h.v. zijn id
		 */
		public static Month find(Long id){
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			Month month = em.find(Month.class, id);
			t.commit();
			em.close();
			return month;
		}
		
		/**
		 * Haal alle months op uit de database
		 *//*
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
