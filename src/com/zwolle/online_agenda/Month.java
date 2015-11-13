package com.zwolle.online_agenda;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Month {
	
	private int year;
	private Long id;
	private ArrayList<Week> month;
	
	public Month (){	
	month = new ArrayList<Week>();
	
	}

	public ArrayList<Week> getMonth() {
		return month;
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
	
	public void setMonth(ArrayList<Week> month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	

	
	
	
}
