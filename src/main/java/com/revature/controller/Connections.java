package com.revature.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

	public static Connection getConnection() throws SQLException{
	//For many frameworks using JDBC or operating with a JDBC it is necessary
	//to "register" the drier you are using
	try {
		
		Class.forName("org.postgresql.Driver");
	} catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	String url = "jdbc:postgresql://javafs-210927.cin4ynlmwr0b.us-east-2.rds.amazonaws.com:5432/test";
	String username = "bucknermi";
	String password = "dbpassword";
	
	return DriverManager.getConnection(url, username, password);
}
}
