package com.revature.dao;

import java.util.List;

import com.revature.model.Account;

public interface AccountDAO {
	
	public List<Account> findAll();
	public int balanceByID(int account_id);
	public int balanceByUsername(String username);
	public boolean existByID(int account_id);
	public int depositByID(int account_id, int deposit);
	public int withdrawByID(int account_id, int deposit);
	
}
