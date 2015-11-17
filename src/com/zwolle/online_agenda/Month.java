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
public class Month {
	
	private int monthNumber;
	private int year;
	private Long id;
	private List<Week> weken;
	
	public Month (){	
	weken = new ArrayList<Week>();
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	public List<Week> getWeken() {
		return weken;
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
	
	public void setWeken(List<Week> month) {
		this.weken = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonthNumber() {
		return monthNumber;
	}

	public void setMonthNumber(int monthNumber) {
		this.monthNumber = monthNumber;
	}

	

	
	
	
}
