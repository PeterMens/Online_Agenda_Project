package com.zwolle.online_agenda;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Day {

		private Long id;
		private String day;
		
		public Day(){
			
		}
		
		@Id
		//@Column(name="day_id")
	    @GeneratedValue(generator="increment")
	    @GenericGenerator(name="increment", strategy = "increment")
	    public Long getId() {
	        return id;
	    }
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getDay() {
			return day;
		}
		
		public void setDay(String dayString) {
			this.day = dayString;
		}
		
		
}
