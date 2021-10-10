package com.revature.dao;

import java.util.List;

import com.revature.dao.model.Account;

public interface AccountDAO {
	
	public List<Account> findAll(); //returns all accounts as objects
	public int balanceByID(int account_id); //returns account balance from id
	public List<Account> findAllByUsername(String username); //returns account as object from username
	public boolean existByID(int account_id); //determines if 
	public int depositByID(int account_id, int deposit); //deposits input amount into account of given id
	public int withdrawByID(int account_id, int withdraw); //withdraws input amount from account of given id
	public boolean verifyIdByUsername(int account_id, String username); //checks if input username has access to given account id
	public boolean createAccount(String username); //creates new account associated with input username
	public boolean uniqueUsername(String username); //checks if the input username is unique and can be used to create a new login account
	public boolean createLogin(String newUsername, String newPassword); //creates username password login for registering user
	public List<Account> accountRequests(); //returns all deactivated accounts as ojbects
	public boolean activateAccount(int account_id); //activates account with given input id
	public boolean deleteAccount(int account_id); //deletes account with given id
	public int IDByUsername(String username); //returns first account id associted with user (used for testing)
	
	
}
