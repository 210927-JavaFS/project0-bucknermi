package com.revature.dao;

import java.util.List;

import com.revature.model.Account;

public interface AccountDAO {
	
	public List<Account> findAll();
	public int balanceByID(int account_id);
	public List<Account> findAllByUsername(String username);
	public boolean existByID(int account_id);
	public int depositByID(int account_id, int deposit);
	public int withdrawByID(int account_id, int deposit);
	public boolean verifyIdByUsername(int account_id, String username);
	public List<Account> createAccount();
	public boolean uniqueUsername(String username);
	public boolean createLogin(String newUsername, String newPassword);
}
