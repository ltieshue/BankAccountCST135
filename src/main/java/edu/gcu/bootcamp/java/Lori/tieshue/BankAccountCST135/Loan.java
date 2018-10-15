package edu.gcu.bootcamp.java.Lori.tieshue.BankAccountCST135;

public class Loan extends Account {
	
	
	private double interestRate = .09;
	private double lateFee = 25.00;
	Boolean isPaid = false;
	double interestRateAmount; 

	public Loan (double balance, String accountID ) {
		this.setBalance(balance);
		this.setAccountID(accountID);
	}
	
				
	/**	This overrides the Account class' method for doWithdraw and applies lateFee. */
	public double doWithdraw(double amount) {
		this.setBalance(this.getBalance()-amount);		
		this.isPaid = true;
		
		String [] detailTrans = {java.time.LocalDate.now().toString(), this.getAccountID(), Double.toString(amount), Double.toString(this.getBalance()), this.getClass().getSimpleName()};
		transaction.trans.add(detailTrans);
				
		
		return this.getBalance();
	}

	
	/**	Getters and Setters for Loan InterestRate and lateFee. */	
	public double getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


	public double getLateFee() {
		return lateFee;
	}


	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	/**	Calculates InterestRate but using annual rate divided by 12 (12 months) then move it to the String Array for transactions (detailTrans) */	
	public double calculateInterestRate() {
		double interestRateAmount = this.getBalance()*(interestRate/12);
		String [] detailTrans = {java.time.LocalDate.now().toString(), this.getAccountID(), Double.toString(interestRateAmount), Double.toString(this.getBalance()), this.getClass().getSimpleName()};
		transaction.trans.add(detailTrans);
		return interestRateAmount;
	
	}
	
	
	
	/**	doEndMonth for the Loan applies late fee loan if 'isPaid' is false (no payment) and applies interest.  Else, just apply interest rate */	
	public void doEndMonth() {
		if (this.isPaid == false) {
			this.setBalance(this.getBalance()+lateFee+ calculateInterestRate()); 
			addLateFeeLoanToArray();
		}
		else {
			this.setBalance(this.getBalance()+ calculateInterestRate());
		}
		
		
		System.out.printf("LOAN BALANCE: $%.2f.\n", this.getBalance() );
		transaction.displayTransArray();	
		this.isPaid = false;	
		}
		
	/**	Moves Late Fee to transaction List Array. */		
	public void addLateFeeLoanToArray() {
		String [] detailTrans = {java.time.LocalDate.now().toString(), this.getAccountID(), Double.toString(this.getLateFee()),
				Double.toString(this.getBalance()), this.getClass().getSimpleName()};
		transaction.trans.add(detailTrans);
	}
	
	

}
