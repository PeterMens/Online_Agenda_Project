package com.zwolle.online_agenda;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Day {

		private Long id;
		private String day;
		private List<Note> notities;

		public Day(){
			notities = new ArrayList<Note>();		
		}
		
		@Id
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
		
		@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
		public List<Note> getNotities() {
			return notities;
		}

		
		public void setNotities(List<Note> notities) {
			this.notities = notities;
		}
		
		
}
