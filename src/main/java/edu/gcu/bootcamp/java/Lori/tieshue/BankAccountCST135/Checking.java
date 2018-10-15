package edu.gcu.bootcamp.java.Lori.tieshue.BankAccountCST135;

//The Checking class extends the Account class which means it inherits everything from Account (i.e. variables, methods etc.).
//If there is a method that needs to function differently for the Checking class than what was defined in the Account class it can be 
	//defined in the Checking class. If that is the case then the method in the Checking class will be used and not the method in the Account class.

/***
* The Checking class extends the Account class which means it inherits everything from Account (i.e. variables, methods etc.).
* If there is a method that needs to function differently for the Checking class than what was defined in the Account class it can be 
* defined in the Checking class. If that is the case then the method in the Checking class will be used and not the method in the Account class.
*/ 


public class Checking extends Account{

	private double overDraft = 45.00;

	

	/***
	 * Checking establishes the Balance and AccountID
	 * @param balance
	 * @param accountID
	 */

	public Checking (double balance, String accountID ) {
		this.setBalance(balance);
		this.setAccountID(accountID);
	}
	
/***
* getOverDraft allows the overDraft be retrieved.
* @return overDraft allows the overDraft be retrieved.
*/
	public double getOverDraft() {
		return overDraft;
	}


/*** 
* setOverDraft establishes the overdraft
* @param overDraft
*/
	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	}

/***
* doWithdraw method does the math to execute the withdraw from the checking. This version of the withdraw is used and NOT the one established in the
* Account class as this will override what is in the Account class.
* NOTE: there are 2 different calculation (the 1st if there is no fee associated with the withdraw. The 2nd is where the fee is applied.)	
*/
	
	
	public double doWithdraw(double withdrawAmount){
		if (withdrawAmount <= this.getBalance()) {
			this.setBalance(this.getBalance() - withdrawAmount);
			
		}
		else {
			this.setBalance(this.getBalance() - withdrawAmount - this.getOverDraft());	
		}
		
		addWithdrawCheckingArray(withdrawAmount);
		return withdrawAmount;	
	}

	
	/** Adds withdrawal checking amount (check on menu) to the array 'detailTrans' */
	public void addWithdrawCheckingArray(double withdrawAmount) {
		String [] detailTrans = {java.time.LocalDate.now().toString(), this.getAccountID(), Double.toString(withdrawAmount), Double.toString(this.getBalance()), this.getClass().getSimpleName()};
		transaction.trans.add(detailTrans);
	}
	
	/** displays the balance at end of month and displays the array */
	public void doEndMonth() {
		System.out.println("CHECKING BALANCE: $" + this.getBalance() );
		transaction.displayTransArray();
		}
			
	
	
	
	
}
