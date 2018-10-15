package edu.gcu.bootcamp.java.Lori.tieshue.BankAccountCST135;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Transaction {
	Calendar cal = Calendar.getInstance();
	List <String[]> trans = new ArrayList<String[]>();
	
	
	/** This displays the Array List 'trans' */
	public void displayTransArray() {
		System.out.println(Arrays.deepToString(trans.toArray()));
		
		
	}

}



