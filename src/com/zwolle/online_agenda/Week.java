package com.zwolle.online_agenda;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;


//class holds
// * a list of week dates per week
// * the week number of that week

@Entity
public class Week {

	private int weekNumber;
	private Long id;
	private List<Day> dagen;

	public Week(){
		dagen = new ArrayList<Day>();
	}
	
	public Week(int weekNumber){
		this.weekNumber = weekNumber;
		dagen = new ArrayList<Day>();	
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

	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}

	@OneToMany(cascade=CascadeType.ALL)
	public List<Day> getDagen() {
		return dagen;
	}

	public void setDagen(List<Day> dagen) {
		this.dagen = dagen;
	}
	
}
