package com.revature.dao;

import java.util.List;

import com.revature.model.Account;

public interface AccountDAO {
	
	public List<Account> findAll();
	public int balanceByID(int account_id);
	public boolean existByID(int account_id);

}
