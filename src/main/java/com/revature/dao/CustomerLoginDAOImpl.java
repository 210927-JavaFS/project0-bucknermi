package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.controller.Connections;

public class CustomerLoginDAOImpl implements CustomerLoginDAO {

	@Override
	public boolean test(String username, String password) {
		
		try(Connection conn = Connections.getConnection()) { //try-with-resources
			String sql = "SELECT * FROM customer_names WHERE username = ? AND PASSWORD = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();
			
			boolean x = result.next();
			
			
			return x;	
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	

}
