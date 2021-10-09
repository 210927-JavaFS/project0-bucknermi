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



public class AccountDAOImpl implements AccountDAO{

	@Override
	public List<Account> findAll() {
		try(Connection conn = Connections.getConnection()) { //try-with-resources
			String sql = "SELECT * FROM account";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Account> list = new ArrayList<>();while(result.next()) {
				Account account = new Account();
				account.setAccount_id(result.getInt("account_id"));
				account.setUsername(result.getString("username"));
				account.setBalance(result.getInt("balance"));
				account.setTeller(result.getString("teller"));
				account.setActivated(result.getBoolean("activated"));
				list.add(account);
			}
			 return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int balanceByID(int account_id) {
		try(Connection conn = Connections.getConnection()) { //try-with-resources
			String sql = "SELECT balance FROM account WHERE account_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, account_id);
			
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				int x = result.getInt("balance");
				return x;
			}
			}
			 
			
		catch(SQLException e) {
			e.printStackTrace();
		
		
	}
		return 0;

}

	@Override
	public boolean existByID(int account_id) {
		try(Connection conn = Connections.getConnection()) { //try-with-resources
			String sql = "SELECT * FROM account WHERE account_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, account_id);
			
			
			ResultSet result = statement.executeQuery();
			
			boolean x = result.next();
			
			
			return x;	
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
}
