package com.zwolle.online_agenda;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PopulateCalendar{
	
	    private final String WEEKDAYS = "Su Mo Tu We Th Fr Sa";
	    private final String NEW_LINE = "\n";
	    private final String EMPTY_STRING = " ";
	    private final String TRIPLE_EMPTY_STRING = "   ";
	    private int firstDayofMonth, lastDayofMonth, weekNumber;
	 
	    // Create arrays for weeks and days
    	private ArrayList<Integer> weeks = new ArrayList<Integer>();	
    	private ArrayList<String> days = new ArrayList<String>();
	    
	    
	// get first & last day of the current month     
	    
	    public int getFirstDayOfMonth(){
			
	    	GregorianCalendar calendar = new GregorianCalendar();
	    	calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
	    	firstDayofMonth= calendar.get(GregorianCalendar.DAY_OF_WEEK);
	     
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
	    weekNumber = calendar.WEEK_OF_YEAR;
	    return weekNumber;
	    }
	    
	    
	    
	    // logic to change current month when button nextmonth or lastmonth
	    
	    
	    //get arraylist tot populate weeks
	    
	  /*  public String [] giveStringWeeks(){ 
	    
	    	getFirstDayOfMonth();
			getLastDayOfMonth();
			
			String calendarString = getFormattedCalendar(firstDayofMonth, lastDayofMonth);
			
			String [] weekString; //= getFormattedCalendar(firstDayofMonth, lastDayofMonth);
	    			
	    	return weekString;
	   
	    }*/
	    
	    //get arraylist tot populate days in weeks
	    
	/*    public String [] giveStringDays(){ 
	    
	    	getFirstDayOfMonth();
			getLastDayOfMonth();
			
			String calendarString = getFormattedCalendar(firstDayofMonth, lastDayofMonth);
			
			String [] dayString; //= getFormattedCalendar(firstDayofMonth, lastDayofMonth);
			return dayString;
	    }*/

	   
	    
	    // String Generator to populate arrayLists
	    private void getFormattedCalendar(int startDayofMonth, int endDayofMonth)
	    {

	    	 // This will keep track of days
	        int day = 1;
	        		
	        //add first weeknumber to arraylist
	        weeks.add(weekNumber);
	       
	        // Week loop, max 5 weeks in a month  
	        for (int w = 1; w <= 5; w++)
	        {
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
	                    days.add(EMPTY_STRING);
	                    continue;
	                }
	                
	                // add days of week
	                else { 
	                	day++;
	                	days.add(String.valueOf(day));
	                	}
	                }

	            weeks.add(weekNumber++);
	        }
	}
	
}
