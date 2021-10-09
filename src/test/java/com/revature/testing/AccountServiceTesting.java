package com.revature.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.service.AccountService;

@TestInstance(Lifecycle.PER_CLASS)
public class AccountServiceTesting {

	int result;
	int testcase;
	int testcase2;
	boolean result1;
	int i = 15;
	String s = "test";
	
	
	

	AccountService as = new AccountService();
	private static Logger log = LoggerFactory.getLogger(AccountServiceTesting.class);
	
	
	@BeforeAll
	public void testAccountCreator() {
		as.createAccount(s);
		log.info("A test account has been successfully created to be used in the JUnit tests, this is a test for the"
				+ " createAccount method");
	}
	

	@Test
	public void getBalanceByIDTester() {
		testcase = as.getIDByUsername(s);
		result = as.getBalanceID(testcase);
		assertEquals(0, result);

	}

	@Test
	public void getExistByIDTest() {
		testcase = as.getIDByUsername(s);
		result1 = as.getExistByID(testcase);
		assertTrue(result1);
	}

	@Test
	public void makeDepositByIDTest() {
		testcase2 = as.getIDByUsername(s);
		testcase = as.getBalanceID(testcase2) + i;
		result = as.makeDepositByID(testcase2, i);

		assertEquals(testcase, result);
	}

	@Test
	public void makeWithdrawByIDTest() {
		testcase = as.getIDByUsername(s);
		testcase = as.getBalanceID(testcase2) - i;
		result = as.makeWithdrawByID(testcase2, i);

		assertEquals(testcase, result);
	}

	@Test
	public void checkIDByUsernameTest() {
		testcase = as.getIDByUsername(s);
		result1 = as.checkIDByUsername(testcase, s);
		assertTrue(result1);
	}

	@Test
	public void newUsernameTest() {
		result1 = as.newUsername("test");
		assertFalse(result1);
	}
	
	@Test
	public void verifyAccount() {
		testcase = as.getIDByUsername(s);
		result1 = as.verifyAccount(testcase);
		assertTrue(result1);
	}

	@AfterAll
	public void deleteTestAccount() {
		int testcase = as.getIDByUsername(s);
		as.removeAccount(testcase);
		log.info("The test account has been deleted now that testing is complete. This is a test for the"
				+ " deleteAccount method");
	}
	
	
	
}
