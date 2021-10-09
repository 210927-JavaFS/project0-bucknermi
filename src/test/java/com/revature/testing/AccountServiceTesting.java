package com.revature.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.service.AccountService;

public class AccountServiceTesting {

	int result;
	int testcase;
	boolean result1;
	int i = 15;
	
	

	AccountService as = new AccountService();
	private static Logger log = LoggerFactory.getLogger(AccountServiceTesting.class);
	
	@BeforeAll
	public int testAccountCreator() {
		as.newLogin("test", "test");
		as.createAccount("test");
		log.info("A test account has been successfully created to be used in the JUnit tests");
		
	}

	@Test
	public void getBalanceByIDTester() {
		result = as.getBalanceID(1);
		assertEquals(1000, result);

	}

	@Test
	public void getExistByIDTest() {
		result1 = as.getExistByID(1);
		assertTrue(result1);
	}

	@Test
	public void makeDepositByIDTest() {
		testcase = as.getBalanceID(1) + i;
		result = as.makeDepositByID(1, i);

		assertEquals(testcase, result);
	}

	@Test
	public void makeWithdrawByIDTest() {
		testcase = as.getBalanceID(1) - i;
		result = as.makeWithdrawByID(1, i);

		assertEquals(testcase, result);
	}

	@Test
	public void checkIDByUsernameTest() {
		result1 = as.checkIDByUsername(1, "cname1");
		assertTrue(result1);
	}

	@Test
	public void newUsernameTest() {
		result1 = as.newUsername("cname1");
		assertFalse(result1);
	}

	@Test
	
}
