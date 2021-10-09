package com.revature.model;

public class Account {
	
	private int account_id;
	private String username;
	private int balance;
	private String teller;
	private boolean activated;
	
	public Account(int account_id, String username, int balance, String teller, boolean activated) {
		super();
		this.account_id = account_id;
		this.username = username;
		this.balance = balance;
		this.teller = teller;
		this.activated=activated;
	}

	public Account(String username, int balance, String teller) {
		super();
		this.username = username;
		this.balance = balance;
		this.teller = teller;
		this.activated=activated;
	}
	
	

	public Account(int account_id, int balance) {
		super();
		this.account_id = account_id;
		this.balance = balance;
	}

	public Account() {
		super();
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getTeller() {
		return teller;
	}

	public void setTeller(String teller) {
		this.teller = teller;
	}
	

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_id;
		result = prime * result + (activated ? 1231 : 1237);
		result = prime * result + balance;
		result = prime * result + ((teller == null) ? 0 : teller.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (account_id != other.account_id)
			return false;
		if (activated != other.activated)
			return false;
		if (balance != other.balance)
			return false;
		if (teller == null) {
			if (other.teller != null)
				return false;
		} else if (!teller.equals(other.teller))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", username=" + username + ", balance=" + balance + ", teller="
				+ teller + ", activated=" + activated + "]";
	}

	
	
	
	

}
