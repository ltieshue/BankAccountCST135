package edu.gcu.bootcamp.java.Lori.tieshue.BankAccountCST135;

/*The Saving class extends the Account class which means it inherits everything from Account (i.e. variables, methods etc.).
 * If there is a method that needs to function differently for the Saving class than what was defined in the Account class it can be 
 * defined in the Saving class. If that is the case then the method in the Saving class will be used and not the method in the Account class.
 */ 


public class Savings extends Account {
	private double serviceFee = 25.00;
	private double annualInterestRate = .03;
	private double minBalance = 500.00;
	double interestRateForMonth; 
	
	
	public Savings (double balance, String accountID ) {
		this.setBalance(balance);
		this.setAccountID(accountID);
	}
	

	public double getServiceFee() {
		return serviceFee;
	}



	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}



	public double getAnnualInterestRate() {
		return annualInterestRate;
	}



	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}



	public double getMinBalance() {
		return minBalance;
	}



	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	
	/**	Calculates and displays the balance at the end of the month and adds the transaction information to the List Array */	
	public void doEndMonth() {
		if (this.getBalance() > this.getMinBalance()) {
		interestRateForMonth = (this.getBalance()*this.getAnnualInterestRate()/12);
		this.setBalance(interestRateForMonth + this.getBalance()); 
		addInterestRateSavingToArray();
		}
		else {
			this.setBalance(this.getBalance() - this.getServiceFee());
			addServiceFeeSavingToArray();
		}
		System.out.printf("SAVING BALANCE: $%.2f.\n", this.getBalance());
		transaction.displayTransArray();
		}

	/**	Adds InterestRateSavingToArray to the Transaction List Array */	
	public void addInterestRateSavingToArray() {
		String [] detailTrans = {java.time.LocalDate.now().toString(), this.getAccountID(), Double.toString(interestRateForMonth),
				Double.toString(this.getBalance()), this.getClass().getSimpleName()};
		transaction.trans.add(detailTrans);
	}

	/**	Adds Service Fee Savings to Transaction List Array */	
	public void addServiceFeeSavingToArray() {
		String [] detailTrans = {java.time.LocalDate.now().toString(), this.getAccountID(), Double.toString(this.getServiceFee()),
				Double.toString(this.getBalance()), this.getClass().getSimpleName()};
		transaction.trans.add(detailTrans);
	}
		
	
	
}