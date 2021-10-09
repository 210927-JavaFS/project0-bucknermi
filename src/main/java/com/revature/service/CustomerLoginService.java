package com.revature.service;

import com.revature.dao.CustomerLoginDAO;
import com.revature.dao.CustomerLoginDAOImpl;

public class CustomerLoginService {
	
	private CustomerLoginDAO cldao = new CustomerLoginDAOImpl();
	
	public boolean testLogin(String username, String password) {
		return cldao.test(username, password);
	}

}
