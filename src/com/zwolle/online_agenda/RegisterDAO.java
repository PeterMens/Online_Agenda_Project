package com.zwolle.online_agenda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public abstract class RegisterDAO {
		private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("calendar");
		
		
		//voeg user aan database toe
		public static void addUser (User user){
			
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(user);
			t.commit();
			em.close();
		}
		
		// haal user op uit database
		public static User findUserByUsernameAndPassword(String Username, String Password){
			User user;
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			try {
				TypedQuery<User> q = em.createQuery("from User u where u.username= :username and u.password= :password", User.class);
				q.setParameter("username", Username);
				user = q.setParameter("password", Password).getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
			t.commit();
			em.close();	
			return user;
		}
		
		// Verwijder een user uit de database
		public static void remove(Long id){
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			User user = em.find(User.class, id);
			if(user != null){
				em.remove(user);
			}
			t.commit();
			em.close();
		}
		
		 //Haal een user op a.d.h.v. zijn id
		public static User find(Long id){
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			User user = em.find(User.class, id);
			t.commit();
			em.close();
			return user;
		}
		
}

