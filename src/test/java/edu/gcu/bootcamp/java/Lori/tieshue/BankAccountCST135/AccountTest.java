package edu.gcu.bootcamp.java.Lori.tieshue.BankAccountCST135;


import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class AccountTest {
	
int expectedResult;
int actualResult;	

int expectedResult2;
int actualResult2;	

Checking c = new Checking(2500, "45676543");
Savings s = new Savings(5000, "45676543");
	
	@Test
	public void verifyWithdrawl() {
		int withAm = 500;
		
		
		expectedResult = withAm;
		actualResult = (int) (c.doWithdraw(withAm));
		
		
		assertEquals(actualResult, expectedResult);
		
	}
	
	@Test
	public void verifySavingDeposit() {
		int depAm = 500;
		
		
		expectedResult2 = 5500;
		actualResult2 = (int) (s.doDeposit(depAm));
		
		
		assertEquals(actualResult2, expectedResult2);
		
	}
	
	
	
	

}







