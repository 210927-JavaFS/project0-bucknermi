package com.revature.testing;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.AccountController;
import com.revature.controller.EntryMenu;
import com.revature.model.Account;
import com.revature.service.AccountService;

public class AccountServiceTesting {
	
	AccountService as = new AccountService();
	private static Logger log = LoggerFactory.getLogger(EntryMenu.class);
	
	@BeforeAll
	public void testObjectCreator() {
	as.createAccount("tester");
	String s = as.toString();
	log.info(s);
	
	}
	
	
	@Test
	public void testgetBalanceByID() {
		
		
		
	}
	

}
