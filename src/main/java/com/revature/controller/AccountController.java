package com.revature.controller;

import java.util.List;

import com.revature.model.Account;
import com.revature.service.AccountService;

public class AccountController {
	
	private AccountService accountService = new AccountService();
	
	public void displayAllAccounts() {
		List<Account> list = accountService.findAllAccounts();
		for(Account account:list) {
			System.out.println(account);
		}
	}

}
