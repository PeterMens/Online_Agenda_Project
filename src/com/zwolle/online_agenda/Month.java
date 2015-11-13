package com.zwolle.online_agenda;

import java.util.ArrayList;

public class Month {
	
	private ArrayList<Week> month;
	
	public Month (){	
	month = new ArrayList<Week>();
	
	}

	public ArrayList<Week> getMonth() {
		return month;
	}

	public void setMonth(ArrayList<Week> month) {
		this.month = month;
	}
	

	
	
	
}
