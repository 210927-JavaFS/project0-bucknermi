package com.revature.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.service.AccountService;
import com.revature.service.login.CustomerLoginService;
import com.revature.service.login.EncryptionService;
import com.revature.service.login.ManagerLoginService;
import com.revature.service.login.TellerLoginService;

public class LoginServiceTesting {

	String username;
	String password;
	int account_id;
	boolean result;
	private static Logger log = LoggerFactory.getLogger(SingleAccountServiceTesting.class);
	CustomerLoginService cls = new CustomerLoginService();
	TellerLoginService tls = new TellerLoginService();
	ManagerLoginService mls = new ManagerLoginService();
	AccountService as = new AccountService();
	EncryptionService es = new EncryptionService();

	@Test
	public void customerLoginTest() {
		log.info("Testing");
		username = "test";
		password = es.encryptor("test");
		result = cls.testLogin(username, password);
		assertTrue(result);

	}

	@Test
	public void tellerLoginTest() {
		username = "tname1";
		password = es.encryptor("tpass1");
		result = tls.testLogin(username, password);
		assertTrue(result);

	}

	@Test
	public void managerLoginTest() {
		username = "test";
		password = "test";
		result = mls.testLogin(username, password);
		assertFalse(result);

	}

	@Test
	public void managerIDByLoginTest() {
		username = "mname1";
		account_id = as.getManagerIDByUsername(username);
		assertEquals(account_id, 1);

	}

	@Test
	public void tellerIDByLoginTest() {
		username = "tname1";
		account_id = as.getTellerIDByUsername(username);
		assertEquals(account_id, 1);

	}
}
