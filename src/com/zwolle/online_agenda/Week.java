package com.zwolle.online_agenda;

import java.util.ArrayList;


//class holds
// * a list of week dates per week
// * the week number of that week
public class Week {

	private int weekNumber;
	private ArrayList<String> days;
	
	
	public Week(int weekNumber){
		
		this.weekNumber = weekNumber;
		days = new ArrayList<String>();
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
