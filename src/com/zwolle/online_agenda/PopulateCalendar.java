package com.zwolle.online_agenda;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PopulateCalendar{
	
	private int realYear, realMonth, realDay, realHour, realMinute, realSecond, realWeekofYear, realWeekofMonth;
	private String [] months = {"January", "February", "March", "April", "May", "June", "July","August", "September", "October", "November", "December"};
	private int firstDayofMonth, lastDayofMonth, weekNumber;
		
	
	//get actual date
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

	
		//set header month + year
	public String getCurrentMonthHeader(){
		getDate();
		return months[realMonth];
	}
		
	
	public int getCurrentYearHeader(){
		getDate();
		return realYear;
	}

	    
	// get first & last day of the current month
	public int getFirstDayOfMonth(){
		GregorianCalendar calendar = new GregorianCalendar();
	    calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
	    firstDayofMonth = calendar.get(GregorianCalendar.DAY_OF_WEEK);
	    firstDayofMonth = (firstDayofMonth-1);
	    if (firstDayofMonth==0)
	    	firstDayofMonth = 7;
	    return firstDayofMonth;
	}
	    
	
	public int getLastDayOfMonth(){
			
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
		lastDayofMonth= calendar.get(GregorianCalendar.DAY_OF_WEEK);
		lastDayofMonth = (lastDayofMonth-1);
	    if (lastDayofMonth==0)
	    	lastDayofMonth = 7;

		return lastDayofMonth;
	}
	 
	
	// get weekNr.
    public int getWeekNumber(){
	    GregorianCalendar calendar = new GregorianCalendar();
	    calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
	    weekNumber = calendar.get(GregorianCalendar.WEEK_OF_YEAR);
	    return weekNumber;
    }
	    
	// logic to change current month when button nextmonth or lastmonth
	    
    
	    
	//get arrayList tot populate week
	 public ArrayList<Week> generateMonth(){ 
	    
	    	getFirstDayOfMonth();
			getLastDayOfMonth();
			getWeekNumber();
			return generateWeeks(firstDayofMonth, lastDayofMonth, weekNumber);	
	    }
	    
	 
	 // String generator to populate arrayList with weekdays
	 private ArrayList<Week> generateWeeks(int startDayofMonth, int endDayofMonth, int weekNumber)
	    {

	    	// Keep track of days
	        int day = 1;
	   
	        // Create ArrayList to hold weeks
	        ArrayList<Week> month = new ArrayList<Week>();
	        
	        // Week loop, max 6 weeks in a month  
	        for (int w = 1; w <= 6; w++){
	        	Week week = new Week(weekNumber);
	        	
	        	// Weekday loop, max 7 days in week
	        	for (int d = 1; d <= 7; d++) 
	            {
	                // If we are on the last week of the month,
	                // and we've reached the endDay that we specified,
	                // break out of loop
	                if (w == 6 && d == endDayofMonth + 1)
	                    break;

	                // These are the empty spaces for the beginning of
	                // the first week
	                if (w == 1 && d < startDayofMonth)
	                {
	                    // Just append empty space, then CONTINUE
	                    // to next iteration (d++)
	                    week.getDays().add("");
	                    continue;
	                }
	                
	                // add days of week
	                else { 
	                	week.getDays().add(String.valueOf(day++));
	                	}
	                }

	        	month.add(week);
	        	weekNumber++;
	        }
	        
	        return month;
	}
	
}
