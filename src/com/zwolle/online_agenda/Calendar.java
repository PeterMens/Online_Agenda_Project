package com.zwolle.online_agenda;

import java.util.GregorianCalendar;

import org.hibernate.mapping.Column;


public class Calendar {

// this class is used to check what date it currently is and populate a table with the days of the week.
	
	private int realYear, realMonth, realDay, realHour, realMinute, realSecond, realWeekofYear, realWeekofMonth;
	private int firstDayofMonth, weekNr1,weekNr2,weekNr3,weekNr4, weekNr5;
	private String [] months = {"January", "February", "March", "April", "May", "June", "July","August", "September", "October", "November", "December"}; 
	private String [] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	private int [] weekNumbers;
	
	public void getDate (){
		GregorianCalendar calendar = new GregorianCalendar();
		
		realYear = calendar.get(GregorianCalendar.YEAR); // returns
		realMonth = calendar.get(GregorianCalendar.MONTH); // returns 0-11
		realDay = calendar.get(GregorianCalendar.DAY_OF_MONTH);  //returns day of month
		realHour = calendar.get(GregorianCalendar.HOUR_OF_DAY); //return hours
		realMinute = calendar.get(GregorianCalendar.MINUTE); //returns number of minute within hour
		realSecond = calendar.get(GregorianCalendar.SECOND); //returns number of second within minute
		realWeekofYear = calendar.get(GregorianCalendar.WEEK_OF_YEAR);
		realWeekofMonth = calendar.get(GregorianCalendar.WEEK_OF_MONTH);
	}
	
	
	public String setCurrentMonthHeader(){
		getDate();
		return months[realMonth];
		}
	
	public int getFirstDayOfMonth(){
		
    	GregorianCalendar calendar = new GregorianCalendar();
    	calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
    	firstDayofMonth= calendar.get(GregorianCalendar.DAY_OF_WEEK);
        return firstDayofMonth;
	}
	
	public void getWeekNumbers(){
		
		/*
		int weekNumber = realWeekofYear;
		for(int i = 0; i<4; i++){
			weekNumber++;
			weekNumbers.
		}*/
			
	
	}
	
}
