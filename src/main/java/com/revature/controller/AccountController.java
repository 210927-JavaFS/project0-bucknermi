package com.revature.controller;

import java.util.List;

import com.revature.dao.model.Account;
import com.revature.service.AccountService;

public class AccountController {

	private AccountService accountService = new AccountService();

	public void displayAllAccounts() {
		List<Account> list = accountService.findAllAccounts();
		for (Account account : list) {
			System.out.println(account);
		}
	}

	public void displayByUsername(String username) {
		List<Account> list = accountService.findAllUsername(username);
		for (Account account : list) {
			System.out.println(account);
		}
	}

	public void displayByActivated() {
		List<Account> list = accountService.findAllActivated();
		for (Account account : list) {
			System.out.println(account);
		}
	}

}
