package com.zwolle.online_agenda;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class User {

	
	private String username;
	private String password;
	private Long id;
	private List<Month> maanden;
	
	public User(){
		maanden = new ArrayList<Month>();	
	}
	
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }
	
    
    public void setId(Long id){
    	this.id = id;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	public List<Month> getMaanden() {
		return maanden;
	}

	public void setMaanden(List<Month> maanden) {
		this.maanden = maanden;
	}
	
}
