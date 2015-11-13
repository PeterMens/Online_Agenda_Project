package com.zwolle.online_agenda;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


//class holds
// * a list of week dates per week
// * the week number of that week

@Entity
public class Week {

	private int weekNumber;
	private Long id;
	private ArrayList<String> days;
	
	public Week(){
		
	}
	
	public Week(int weekNumber){
		this.weekNumber = weekNumber;
		days = new ArrayList<String>();
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

	public int getWeekNumber() {
		return weekNumber;
	}

	public void setWeeknumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}

	public ArrayList<String> getDays() {
		return days;
	}

	public void setDays(ArrayList<String> days) {
		this.days = days;
	}
	
}
