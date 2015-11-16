package com.zwolle.online_agenda;

public class PopulateDatabase {

	// give year + month for last 5 and coming 5 year
	// put weeks in months
	// put month in database

	private int realYear, realMonth, numberOfYearsToGenerate;
	
	public PopulateDatabase(){
		
	}
	
	public void createObjectsOfMonth(int numberOfYearsToGenerate){
		this.numberOfYearsToGenerate = numberOfYearsToGenerate;
		RealDate realdate = new RealDate();
		realdate.getDate();
		realYear = realdate.getRealYear();
		realMonth = realdate.getRealMonth();
		
		for (int y = realYear; y < (realYear + this.numberOfYearsToGenerate);){
			 
			for (int m = realMonth; m<= 11; m++ ){
				PopulateCalendar populateMonth = new PopulateCalendar(m, y);
				Month month = populateMonth.generateMonth();
				month.setYear(y);
				
				MonthDao.addMonth(month);
				y++;
			}
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
	

