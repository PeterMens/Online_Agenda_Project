package com.zwolle.online_agenda;

import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;

import org.hibernate.annotations.GenericGenerator;

/*// will be used to add/save and modify a contactlist.
@Entity
public class Contact {
	
	private String firstName;
	private Long id;

	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }
	
	
	public String chooseFirstName(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name:");
		firstName = sc.nextLine();
		
		return firstName;
	    }
	
	
	
	}*/

