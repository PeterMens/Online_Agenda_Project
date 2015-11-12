package com.zwolle.online_agenda;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PopulateCalendar{
	
	    
private int firstDayofMonth, lastDayofMonth, weekNumber;
	 

	    
	// get first & last day of the current month     
	    
	    public int getFirstDayOfMonth(){
			
	    	GregorianCalendar calendar = new GregorianCalendar();
	    	calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
	    	firstDayofMonth = calendar.get(GregorianCalendar.DAY_OF_WEEK);
	     
	    	return firstDayofMonth;
		}
	    
	    public int getLastDayOfMonth(){
			
	    	GregorianCalendar calendar = new GregorianCalendar();
	    	calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
	    	lastDayofMonth= calendar.get(GregorianCalendar.DAY_OF_WEEK);

	    	return lastDayofMonth;
		}
	    
	    // get weekNr.
	    public int getWeekNumber(){
	    GregorianCalendar calendar = new GregorianCalendar();
	    weekNumber = calendar.get(GregorianCalendar.WEEK_OF_YEAR);
	    return weekNumber;
	    }
	    
	    
	    
	    // logic to change current month when button nextmonth or lastmonth
	    
	    
	    //get arraylist tot populate week
	 public ArrayList<Week> generateMonth(){ 
	    
	    	getFirstDayOfMonth();
			getLastDayOfMonth();
			getWeekNumber();
			return getFormattedCalendar(firstDayofMonth, lastDayofMonth, weekNumber);
			
	    }
	    

	    
	    // String Generator to populate arrayLists
	    private ArrayList<Week> getFormattedCalendar(int startDayofMonth, int endDayofMonth, int weekNumber)
	    {

	    	 // This will keep track of days
	        int day = 1;
	   
	     
	        ArrayList<Week> month = new ArrayList<Week>();
	        
	        // Week loop, max 5 weeks in a month  
	        for (int w = 1; w <= 5; w++){
	        	Week week = new Week(weekNumber);
	        	
	        	// Weekday loop, max 7 days in week
	        	for (int d = 1; d <= 7; d++) 
	            {
	                // If we are on the last week of the month,
	                // and we've reached the endDay that we specified,
	                // break out of loop
	                if (w == 5 && d == endDayofMonth + 1)
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
