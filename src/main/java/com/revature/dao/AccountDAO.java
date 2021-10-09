package com.revature.dao;

import java.util.List;

import com.revature.model.Account;

public interface AccountDAO {
	
	public List<Account> findAll();
	public int balanceByID(int account_id);
	public List<Account> findAllByUsername(String username);
	public boolean existByID(int account_id);
	public int depositByID(int account_id, int deposit);
	public int withdrawByID(int account_id, int withdraw);
	public boolean verifyIdByUsername(int account_id, String username);
	public boolean createAccount(String username);
	public boolean uniqueUsername(String username);
	public boolean createLogin(String newUsername, String newPassword);
	public List<Account> accountRequests();
	public boolean activateAccount(int account_id);
	public boolean deleteAccount(int account_id);
	
	
}
