package com.zwolle.online_agenda;

import java.util.ArrayList;
import java.util.List;

public class PopulateDatabase {

	// generate years starting from current year till + 10 years
	// put days in months
	//put weeks in months
	// put month in database

	private int realYear, numberOfYearsToGenerate, month = 0, year;
	private List<Month> maanden;
	
	
	public PopulateDatabase(){
		maanden = new ArrayList<Month>();
	}

	
	public List<Month> getMaanden() {
		return maanden;
	}


	public void setMaanden(List<Month> maanden) {
		this.maanden = maanden;
	}

	public void createObjectsOfMonth(int numberOfYearsToGenerate){
		this.numberOfYearsToGenerate = numberOfYearsToGenerate;
		RealDate realdate = new RealDate();
		realdate.getDate();
		realYear = realdate.getRealYear();
		
		for (year = realYear; year < (realYear + this.numberOfYearsToGenerate);){
			
			for ( int m = 0; m <= 11; m++){
				//System.out.println("Jaar: " + year);
				//System.out.println("Maand: " + month);
				PopulateCalendar populateMonth = new PopulateCalendar(month, year);
				Month maand = populateMonth.generateMonth();
				maand.setYear(year);
				maand.setMonthNumber(month);
				maanden.add(maand);
				//MonthDao.addMonth(maand);
				month++;
				;
				}
			
			year++;
			month=0;
			
			}
		}
		
	}

	


