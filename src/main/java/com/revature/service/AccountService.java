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
	
	public int makeDepositByID(int account_id, int deposit) {
		return accountDAO.depositByID(account_id, deposit);
	}
	
	public int makeWithdrawByID(int account_id, int withdraw) {
		return accountDAO.withdrawByID(account_id, withdraw);
	}
	
	public List<Account> findAllUsername(String username) {
		return accountDAO.findAllByUsername(username);
	}
	
	public boolean checkIDByUsername(int account_id, String username) {
		return accountDAO.verifyIdByUsername(account_id, username);
	}
	
	public boolean newUsername(String username) {
		return accountDAO.uniqueUsername(username);
	}
	
	public boolean newLogin(String newUsername, String newPassword) {
		return accountDAO.createLogin(newUsername, newPassword);
	}
 
}
