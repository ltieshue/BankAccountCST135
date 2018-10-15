package edu.gcu.bootcamp.java.Lori.tieshue.BankAccountCST135;

public class Customer {
	
	String firstName;
	String lastName;
	String dateOpened ="2013-04-26";
		
	/** Constructor for customer */
	public Customer(String firstName, String lastName, String dateOpened) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOpened = dateOpened;
	}
	
	
	/** establish getters and setters */		
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(String string) {
		this.dateOpened = string;
	}
	
	
	
	
	

}
