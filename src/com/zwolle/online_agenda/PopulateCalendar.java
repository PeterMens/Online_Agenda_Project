package com.zwolle.online_agenda;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PopulateCalendar{

	private int firstDayofMonth, lastDayofMonth, weekNumber, year, month;
	private String [] months = {"January", "February", "March", "April", "May", "June", "July","August", "September", "October", "November", "December"};
	
	// constructor for populating calendar month
	public PopulateCalendar ( int year, int month){
		this.month = month-1;
		this.year = year;
	}
	
	//set header month
	public String getMonthHeader(){
		return months[month];
	}
		
	//set header year
	public int getYearHeader(){
		return year;
	}

	    
	// get first day of month
	public int getFirstDayOfMonth(){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(GregorianCalendar.YEAR, year);
		calendar.set(GregorianCalendar.MONTH, month);
		calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
	    firstDayofMonth = calendar.get(GregorianCalendar.DAY_OF_WEEK);
	    firstDayofMonth = (firstDayofMonth-1);
	    if (firstDayofMonth==0)
	    	firstDayofMonth = 7;
	    return firstDayofMonth;
	}
	    
	// get last day of month
	public int getLastDayOfMonth(){
			
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(GregorianCalendar.YEAR, year);
		calendar.set(GregorianCalendar.MONTH, month);
		lastDayofMonth= calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		
		return lastDayofMonth;
	}
	 
	
	// get weekNr.
    public int getWeekNumber(){
	    GregorianCalendar calendar = new GregorianCalendar();
	    calendar.set(GregorianCalendar.YEAR, year);
		calendar.set(GregorianCalendar.MONTH, month);
	    calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
	    weekNumber = calendar.get(GregorianCalendar.WEEK_OF_YEAR);
	    return weekNumber;
    }
	    
	
	//get arrayList of month populated with weeks
	 public Month generateMonth(){ 
	    
	    	getFirstDayOfMonth();
			getLastDayOfMonth();
			getWeekNumber();
			return generateWeeks(firstDayofMonth, lastDayofMonth, weekNumber);	
	    }
	    
	 
	 // String generator to populate arrayList with weekdays
	 private Month generateWeeks(int startDayofMonth, int endDayofMonth, int weekNumber)
	    {

	    	// Keep track of days
	        int day = 1;
	   
	        // Create ArrayList to hold weeks
	        //ArrayList<Week> month = new ArrayList<Week>();
	       
	        //Create instance of Month
	        Month month = new Month();
	       
	        // Week loop, max 6 weeks in a month  
	      
	        for (int w = 1; w <= 6; w++){
	        	
	        	//if there is no 6th week in a month, don't make 6 objects.
	        	if(endDayofMonth + 1 > day){
	        		if(weekNumber > 53){ weekNumber = 1;}
		        	Week week = new Week(weekNumber);
		        		
		        	// Weekday loop, max 7 days in week
		        	for (int d = 1; d <= 7; d++) 
		            {
		                // If we are on the last week of the month,
		                // and we've reached the endDay that we specified,
		                // break out of loop
		        	
		        		if (endDayofMonth + 1 == day)
		                    break; 
		         
	
		                // These are the empty spaces for the beginning of
		                // the first week
		                if (w == 1 && d < startDayofMonth)
		                {
		                    // Just append empty space, then CONTINUE
		                    // to next iteration (d++)
		                    Day objectDay = new Day();
		                    objectDay.setDay("");
		                    week.getDagen().add(objectDay);
		                    continue;
		                }
		                
		                // add days of week
		                else { 
		                	Day objectDay = new Day();
		                    objectDay.setDay(String.valueOf(day++));
		                    week.getDagen().add(objectDay);
		                	}
		                }
	
		        	month.getWeken().add(week);
		        	
		        	if (weekNumber == 52){
		        		weekNumber = 0;
		        	} 
		        	weekNumber++;
		        }
	        }
	        
	        return month;
	}
	
}
