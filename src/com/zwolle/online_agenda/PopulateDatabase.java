package com.zwolle.online_agenda;

public class PopulateDatabase {

	// generate years starting from current year till + 10 years
	// put days in months
	//put weeks in months
	// put month in database

	private int realYear, numberOfYearsToGenerate, month = 1, year;
	
	public PopulateDatabase(){
		
	}
	
	public void createObjectsOfMonth(int numberOfYearsToGenerate){
		this.numberOfYearsToGenerate = numberOfYearsToGenerate;
		RealDate realdate = new RealDate();
		realdate.getDate();
		realYear = realdate.getRealYear();
		
		for (year = realYear; year < (realYear + this.numberOfYearsToGenerate);){
			
			for ( int m = 1; m <= 12; m++){
				//System.out.println("Jaar: " + year);
				//System.out.println("Maand: " + month);
				PopulateCalendar populateMonth = new PopulateCalendar(month, year);
				Month maand = populateMonth.generateMonth();
				maand.setYear(year);
				MonthDao.addMonth(maand);
				month++;
				;
				}
			
			year++;
			month=1;
			
			}
		}
	}

	
/*	public void createObjectsOfMonth(){
		
		Day dag = new Day();
		dag.setDay("dag1");
		
		Week week = new Week();
		week.getDagen().add(dag);
		week.setWeekNumber(44);
		
		Month month = new Month();
		month.getWeken().add(week);
		month.setYear(1995);
		
		MonthDao.addMonth(month);
			}
		}*/
	

