package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.controller.Connections;
import com.revature.dao.TellerLoginDAO;

public class TellerLoginDAOImpl implements TellerLoginDAO{

	@Override
	public boolean test(String username, String password) {
		
		try(Connection conn = Connections.getConnection()) { //try-with-resources
			String sql = "SELECT * FROM teller_names WHERE username = ? AND PASSWORD = ?;";
			
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
