package edu.gcu.bootcamp.java.Lori.tieshue.BankAccountCST135;

import java.util.Scanner;

//Because all of the classes are in the package we do not need to import any of the classes to the Bank class.
//The 'main' method needs to be in this class as it is required to call the methods. 

/* Because all of the classes are in the package we do not need to import any of the classes to the Bank class.
* The 'main' method needs to be in this class as it is required to call the methods. 
*/


/* Because all of the classes are in the package we do not need to import any of the classes to the Bank class.
* The 'main' method needs to be in this class as it is required to call the methods. 
*/


/***
* Bank is the primary class in which the other classes and methods will be organized/outline of the sequence of events/methods.
* @author Lori
* @version 2.0
*/

public class Bank {
	Transaction transaction = new Transaction();
	Scanner sc = new Scanner(System.in);	
	private String name = "GCU Credit Union";
	
	/***
	 * main method needs to exist as it is the method that establishes the other events to be executed in this project.  
	 * In the main class the Bank, Savings and Checking classes are made into objects. 
	 * @param args
	 */
	
		public static void main (String[]args) {
			Bank bank = new Bank();
			Savings savings = new Savings(5000.0, "1234567");
			Checking checking = new Checking(2500.0, "45676543");
			Loan loan = new Loan(10000.00, "9876543");
			
			bank.displayMenu(checking, savings, loan);

			loan.calculateInterestRate();
			
		}
	
		
		/*** 
		 * The displayMenu method establishes the primary view for the end users.  Checking and Savings are the classes/objects that will be accessed/maintained.
		 * @param checking
		 * @param savings
		 */
		
		private void displayMenu(Checking checking, Savings savings, Loan loan) {
			int option;
			do {
				System.out.println("===================================");
				System.out.println("             MAIN MENU");
				System.out.println("            "+ this.name.toUpperCase());
				System.out.println("===================================");
				System.out.println("Pick an option: ");
				System.out.println("---------------------");
				System.out.println(" 1: : Deposit to Checking");
				System.out.println(" 2: : Deposit to Savings");
				System.out.println(" 3: : Write a Check");
				System.out.println(" 4: : Withdraw from Savings");
				System.out.println(" 5: : Loan Payment");
				System.out.println(" 6: : Get balance");
				System.out.println(" 7: : Close month");
				System.out.println("---------------------");
				System.out.println(" 9: : Exit");
				option= sc.nextInt();
				this.actionMenu(option, checking, savings, loan);
			}
		while (option !=9);
				
		}
		

			
		private void actionMenu(int opt, Checking checking, Savings savings, Loan loan) {
			switch (opt) {
					
			case 1: displayDepositChecking(checking);
			break;
			
			case 2: displayDepositSavings(savings);
			break;
			
			case 3: displayWithdrawChecking(checking);
			break;
			
			case 4: displayWithdrawSavings(savings);
			break;
			
			case 5: displayPaymentLoan(loan);
			break;
			
			case 6: displayBalanceScreen(checking, savings, loan);
			break;
			
			case 7: doEndMonth(checking, savings, loan);
			break;
			
			case 9: displayExitScreen();
			break;
			
			
			
			}
			
		}
	
		/**	doEndMonth calls each classes unique doEndMonth (Checking, Savings, Loan classes) */	
		public void doEndMonth(Checking checking, Savings savings, Loan loan) {
			savings.doEndMonth();
			System.out.println();
			checking.doEndMonth();
			System.out.println();
			loan.doEndMonth();
			System.out.println();
			}
			
					
		private void displayBalanceScreen(Checking checking, Savings savings, Loan loan) {
			System.out.printf("CHECKING BALANCE: $%.2f.\n", checking.getBalance());
			System.out.printf("SAVINGS BALANCE: $%.2f. \n",savings.getBalance());
			System.out.printf("LOAN BALANCE: $%.2f. \n", loan.getBalance());
		}

		
				
		/*
		 * 
		 */
		private void displayDepositChecking(Checking checking) {
		
			System.out.println("DEPOSIT INTO Checking:" + checking.getAccountID());
			System.out.printf("Your Checking Account balance is: $%.2f.\n", checking.getBalance());
			System.out.println("How much do you want to deposit: " );
			double amount = sc.nextDouble();
			checking.doDeposit(amount);
					
		}
			
		
		private void displayDepositSavings(Savings savings) {
			System.out.println("DEPOSIT INTO Savings " + savings.getAccountID() + ".");
			System.out.printf("Your Savings Account balance is: $%.2f.\n", savings.getBalance());
			System.out.println("How much do you want to deposit: " );
			double amount = sc.nextDouble();
			savings.doDeposit(amount);
			
		}
	
		
		private void displayWithdrawChecking(Checking checking) {
			System.out.println("WITHDRAW FROM Checking:" + checking.getAccountID() + ".");
			System.out.printf("Your Checking Account balance is: $%.2f.\n", checking.getBalance());
			System.out.printf("You will have a $%.2f overdraft fee if check amount/withdraw exceeds balance.\n",  checking.getOverDraft());
			System.out.println("How much do you want to withdraw: " );
			double amount = sc.nextDouble();
		if (amount > checking.getBalance()) {
			System.out.printf("OVERDRAFT NOTICE: $%.2f fee assessed!", checking.getOverDraft());
		}
		else {
			System.out.printf("Your new balance is: $%.2f.\n", checking.getBalance());	
			}
			checking.doWithdraw(amount);
		}
		
		private void displayWithdrawSavings(Savings savings) {
			System.out.println("WITHDRAW FROM Savings:" + savings.getAccountID() + ".");
			System.out.printf("Your Savings Account balance is: $%.2f.\n", savings.getBalance());
			System.out.printf("You will have a $%.2f service fee if balance is below $%.2f at the end of the month.\n", savings.getServiceFee(), savings.getMinBalance());
			System.out.println("How much do you want to withdraw: " );
			double amount = sc.nextDouble();
			savings.doWithdraw(amount);
		}
	
		private void displayPaymentLoan(Loan loan) {
			System.out.println("Payment to loan " + loan.getAccountID() + ".");
			System.out.printf("Your Loan balance is: $%.2f.\n", loan.getBalance());
			System.out.println("How much do you want to pay towards your loan: " );
			double amount = sc.nextDouble();
			loan.doWithdraw(amount);
		}
		
		

		private void displayExitScreen() {
				
				System.out.println("Thank you for being a GCU Credit Union loyal customer.");
				
			}
			
	
		
		
}	



