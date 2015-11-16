package com.zwolle.online_agenda;

import java.util.GregorianCalendar;

public class RealDate {

	private int realYear, realMonth, realDay, realHour, realMinute, realSecond;
	
	
		//get actual date of locale machine serverside
		public void getDate (){
			GregorianCalendar calendar = new GregorianCalendar();
			
			realYear = calendar.get(GregorianCalendar.YEAR); // returns
			realMonth = calendar.get(GregorianCalendar.MONTH); // returns 0-11
			realDay = calendar.get(GregorianCalendar.DAY_OF_MONTH);  //returns day of month
			realHour = calendar.get(GregorianCalendar.HOUR_OF_DAY); //return hours
			realMinute = calendar.get(GregorianCalendar.MINUTE); //returns number of minute within hour
			realSecond = calendar.get(GregorianCalendar.SECOND); //returns number of second within minute
		}


		public int getRealYear() {
			return realYear;
		}


		public void setRealYear(int realYear) {
			this.realYear = realYear;
		}


		public int getRealMonth() {
			return realMonth;
		}


		public void setRealMonth(int realMonth) {
			this.realMonth = realMonth;
		}


		public int getRealDay() {
			return realDay;
		}


		public void setRealDay(int realDay) {
			this.realDay = realDay;
		}


		public int getRealHour() {
			return realHour;
		}


		public void setRealHour(int realHour) {
			this.realHour = realHour;
		}


		public int getRealMinute() {
			return realMinute;
		}


		public void setRealMinute(int realMinute) {
			this.realMinute = realMinute;
		}


		public int getRealSecond() {
			return realSecond;
		}


		public void setRealSecond(int realSecond) {
			this.realSecond = realSecond;
		}

		
		
		
		
}
