package edu.gcu.bootcamp.java.Lori.tieshue.BankAccountCST135;
//This class is used to define the key methods to be used in the Savings and Checking account classes



//The Account class is used to define the key methods to be used in the Savings and Checking account classes.
/*** This is the Bank Account Milestone project from September 2018  to explain and use inheritance.
* Class Account is the 'main' class in which the other classes (Checking and Savings) will extend from for the purpose of inheriting
* what is defined in the Account class. 
* @author Lori Tie-Shue
*@version 1.0
*/

public class Account {

//	protected static Transaction transaction = new Transaction();
	
	Transaction transaction = new Transaction();
	
	private double balance;
	private String accountID;
	
	Customer customer = new Customer("James", "Bond", "10/08/2018");
	/***
	 *getAccountID
	 * @return accountID will make sure the accountID defined as Savings vs. Checking will be accessed correctly
	 */
	public String getAccountID() {
		return accountID;
	}

	
	/***
	 * setAccountID is establishing the accountID for Savings vs. Checking
	 * @param accountID
	 */
	
	public void setAccountID(String accountID) {
		this.accountID = accountID;
		
	}

	/***
	 * setBalance is maintaining/establishing the balance for Savings vs. Checking
	 * @param balance
	 */

	public void setBalance(double balance) {
		this.balance = balance;
		
	}

	/***
	 *getBalance
	 * @return balance will make sure the balance maintained as Savings vs. Checking will be accessed correctly
	 */
	
	public double getBalance() {
		return this.balance;
	}
	
	/***
	 * doWithdraw ensures the balance is maintaining for Savings vs. Checking when the doWithdraw method is called.
	 * @param balance
	 */
	
	public double doWithdraw(double amount) {
		this.setBalance(this.balance -amount);
		String [] detailTrans = {java.time.LocalDate.now().toString(), this.accountID, Double.toString(amount), Double.toString(balance), this.getClass().getSimpleName()};
		transaction.trans.add(detailTrans);
		return this.balance;
	}
	
	
	/***
	 * doDeposit ensures the balance is maintaining for Savings vs. Checking when the doWithdraw method is called.
	 * @param balance
	 */
	public double doDeposit(double amount) {
		this.setBalance(this.balance + amount);
		String [] detailTrans = {java.time.LocalDate.now().toString(), this.accountID, Double.toString(amount), Double.toString(balance), this.getClass().getSimpleName()};
		transaction.trans.add(detailTrans);
		return this.balance;
	}
	

	

	
	
	
	
	
}
