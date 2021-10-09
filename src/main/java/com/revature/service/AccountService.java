package com.revature.service;

import java.util.List;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.model.Account;

public class AccountService {
	
	private AccountDAO accountDAO = new AccountDAOImpl();
	
	public List<Account> findAllAccounts() {
		return accountDAO.findAll();
	}
	
	public int getBalanceID(int account_id) {
		return accountDAO.balanceByID(account_id);
	}
	
	public boolean getExistByID(int account_id) {
		return accountDAO.existByID(account_id);
	}

}
