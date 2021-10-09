package com.revature.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.service.SingleAccountService;

public class SingleAccountServiceTesting {

	SingleAccountService sas = new SingleAccountService();

	int result;

	private static Logger log = LoggerFactory.getLogger(SingleAccountServiceTesting.class);

	@Test
	public void testDeposit() {
		log.info("Two tests to detemine if the mathematical methods Deposit and Withdraw return correct values");
		result = sas.deposit(12, 13);
		assertEquals(25, result);
	}

	@Test
	public void testWithdraw() {
		result = sas.withdraw(25, 12);
		assertEquals(13, result);
	}

}
