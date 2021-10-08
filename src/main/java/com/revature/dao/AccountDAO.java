package com.revature.dao;

import java.util.List;

import com.revature.model.Account;

public interface AccountDAO {
	
	public List<Account> findAll();
	public Account findByID(int account_id);
	public boolean updateAccount(Account account);
	public boolean addAccount(Account account);
	

}
