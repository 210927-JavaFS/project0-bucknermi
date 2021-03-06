package com.revature.dao.model;

public class Account {

	private int account_id;
	private String username;
	private int balance;
	private boolean activated;
	private String secondary_user;

	public Account(int account_id, String username, int balance, boolean activated, String secondary_user) {
		super();
		this.account_id = account_id;
		this.username = username;
		this.balance = balance;
		this.activated = activated;
		this.secondary_user = secondary_user;
	}

	public Account(String username, int balance, String teller) {
		super();
		this.username = username;
		this.balance = balance;
		this.activated = activated;
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

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String getSecondary_user() {
		return secondary_user;
	}

	public void setSecondary_user(String secondary_user) {
		this.secondary_user = secondary_user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_id;
		result = prime * result + (activated ? 1231 : 1237);
		result = prime * result + balance;
		result = prime * result + ((secondary_user == null) ? 0 : secondary_user.hashCode());
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
		if (secondary_user == null) {
			if (other.secondary_user != null)
				return false;
		} else if (!secondary_user.equals(other.secondary_user))
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
		return "Account [account_id=" + account_id + ", username=" + username + ", balance=" + balance + ", activated="
				+ activated + ", secondary_user=" + secondary_user + "]";
	}

}
