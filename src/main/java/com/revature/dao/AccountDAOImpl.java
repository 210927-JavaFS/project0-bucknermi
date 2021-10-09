package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.controller.Connections;
import com.revature.model.Account;
import com.revature.service.AccountService;
import com.revature.service.SingleAccountService;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public List<Account> findAll() {
		try (Connection conn = Connections.getConnection()) { // try-with-resources
			String sql = "SELECT * FROM account";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Account> list = new ArrayList<>();
			while (result.next()) {
				Account account = new Account();
				account.setAccount_id(result.getInt("account_id"));
				account.setUsername(result.getString("username"));
				account.setBalance(result.getInt("balance"));
				account.setActivated(result.getBoolean("activated"));
				list.add(account);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int balanceByID(int account_id) {
		try (Connection conn = Connections.getConnection()) { // try-with-resources
			String sql = "SELECT balance FROM account WHERE account_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, account_id);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				int x = result.getInt("balance");
				return x;
			}
		}

		catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;

	}

	@Override
	public boolean existByID(int account_id) {
		try (Connection conn = Connections.getConnection()) { // try-with-resources
			String sql = "SELECT * FROM account WHERE account_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, account_id);

			ResultSet result = statement.executeQuery();

			boolean x = result.next();

			return x;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public int depositByID(int account_id, int deposit) {
		AccountService as = new AccountService();
		int x = as.getBalanceID(account_id);
		SingleAccountService sas = new SingleAccountService();
		int y = sas.deposit(x, deposit);
		try (Connection conn = Connections.getConnection()) { // try-with-resources
			String sql = "UPDATE account SET balance = ? WHERE account_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, y);
			statement.setInt(2, account_id);

			statement.execute();

			return y;

		}

		catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;

	}

	@Override
	public int withdrawByID(int account_id, int deposit) {

		AccountService as = new AccountService();
		int x = as.getBalanceID(account_id);
		SingleAccountService sas = new SingleAccountService();
		int y = sas.withdraw(x, deposit);
		try (Connection conn = Connections.getConnection()) { // try-with-resources
			String sql = "UPDATE account SET balance = ? WHERE account_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, y);
			statement.setInt(2, account_id);

			statement.execute();

			return y;

		}

		catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;
	}

	@Override
	public List<Account> findAllByUsername(String username) {
		try (Connection conn = Connections.getConnection()) { // try-with-resources
			String sql = "SELECT * FROM account WHERE username = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, username);

			ResultSet result = statement.executeQuery();
			
			List<Account> list = new ArrayList<>();
			
			while (result.next()) {
				Account account = new Account();
				account.setAccount_id(result.getInt("account_id"));
				account.setUsername(result.getString("username"));
				account.setBalance(result.getInt("balance"));
				account.setActivated(result.getBoolean("activated"));
				list.add(account);
			}
			return list;
		
			
			}

		catch (SQLException e) {
			e.printStackTrace();

		}
		
		return null;
		}

	@Override
	public boolean verifyIdByUsername(int account_id, String username) {
		try (Connection conn = Connections.getConnection()) { // try-with-resources
			String sql = "SELECT * FROM account WHERE account_id = ? AND username = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, account_id);
			statement.setString(2,  username);

			ResultSet result = statement.executeQuery();

			boolean x = result.next();

			return x;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
		
	}

	@Override
	public boolean createAccount(String username) {
		
		try (Connection conn = Connections.getConnection()) { // try-with-resources
			String sql = "INSERT into account (username, balance, activated) VALUES (? , 0, false) ;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, username);
			

		
			statement.execute();
			return true;
				
			}
		

		catch (SQLException e) {
			e.printStackTrace();

		}
		
		
		return false;
	}

	@Override
	public boolean uniqueUsername(String username) {
		try (Connection conn = Connections.getConnection()) { // try-with-resources
			String sql = "SELECT * FROM account WHERE username = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, username);

			ResultSet result = statement.executeQuery();

			boolean x = result.next();

			return !x;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean createLogin(String newUsername, String newPassword) {
		try (Connection conn = Connections.getConnection()) { // try-with-resources
			String sql = "INSERT into customer_names (username, password) VALUES (? , ?) ;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, newUsername);
			statement.setString(2, newPassword);

		
			statement.execute();
			return true;
				
			}
		

		catch (SQLException e) {
			e.printStackTrace();

		}
		return false;
		
	}

	@Override
	public List<Account> accountRequests() {
		try (Connection conn = Connections.getConnection()) { // try-with-resources
			String sql = "SELECT * FROM account WHERE activated = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setBoolean(1, false);

			ResultSet result = statement.executeQuery();
			
			List<Account> list = new ArrayList<>();
			
			while (result.next()) {
				Account account = new Account();
				account.setAccount_id(result.getInt("account_id"));
				account.setUsername(result.getString("username"));
				account.setBalance(result.getInt("balance"));
				account.setActivated(result.getBoolean("activated"));
				list.add(account);
			}
			return list;
		
			
			}

		catch (SQLException e) {
			e.printStackTrace();

		}
		
		return null;
	}

	@Override
	public boolean activateAccount(int account_id) {
		try (Connection conn = Connections.getConnection()) { // try-with-resources
			String sql = "UPDATE account SET activated = true WHERE account_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, account_id);
			

		
			statement.execute();
			return true;
				
			}
		

		catch (SQLException e) {
			e.printStackTrace();

		}
		return false;
		
	}

	@Override
	public boolean deleteAccount(int account_id) {
		try (Connection conn = Connections.getConnection()) { // try-with-resources
			String sql = "DELETE FROM account WHERE account_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, account_id);
			

		
			statement.execute();
			return true;
				
			}
		

		catch (SQLException e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public int IDByUsername(String username) {
		try (Connection conn = Connections.getConnection()) { // try-with-resources
			String sql = "SELECT account_id FROM account WHERE username = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, username);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				int x = result.getInt("account_id");
				return x;
			}
		}

		catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;
	}


	
	
}


