package com.revature.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.service.SingleAccountService;

public class SingleAccountServiceTesting {
	
	SingleAccountService sas = new SingleAccountService();
	
	int result;
	
	
	@Test
	public void testDeposit() {
		result = sas.deposit(12, 13);
		assertEquals(25, result);
	}
	
	@Test public void testWithdraw() {
		result = sas.withdraw(25, 12);
		assertEquals(13, result);
	}
	

}
