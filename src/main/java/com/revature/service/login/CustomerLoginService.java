package com.revature.service.login;

import com.revature.dao.CustomerLoginDAO;
import com.revature.dao.impl.CustomerLoginDAOImpl;

public class CustomerLoginService {
	
	private CustomerLoginDAO cldao = new CustomerLoginDAOImpl();
	
	public boolean testLogin(String username, String password) {
		return cldao.test(username, password);
	}

}
