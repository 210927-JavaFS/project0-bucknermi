package com.revature.testing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.service.CustomerLoginService;
import com.revature.service.ManagerLoginService;
import com.revature.service.TellerLoginService;

public class LoginServiceTesting {
	
	String username;
	String password;
	boolean result;
	private static Logger log = LoggerFactory.getLogger(SingleAccountServiceTesting.class);
	CustomerLoginService cls = new CustomerLoginService();
	TellerLoginService tls = new TellerLoginService();
	ManagerLoginService mls = new ManagerLoginService();
	
	@Test
	public void CustomerLoginTest() {
		log.info("Testing");
		username = "test";
		password = "test";
		result = cls.testLogin(username, password);
		assertTrue(result);
		
	}
	
	@Test
	public void TellerLoginTest() {
		username = "tname1";
		password = "tpass1";
		result = tls.testLogin(username, password);
		assertTrue(result);
		
	}
	
	@Test
	public void ManagerLoginTest() {
		username = "test";
		password = "test";
		result = mls.testLogin(username, password);
		assertFalse(result);
		
	}

}
