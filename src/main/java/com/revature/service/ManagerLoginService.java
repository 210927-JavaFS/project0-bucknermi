package com.revature.service;

import com.revature.dao.ManagerLoginDAO;
import com.revature.dao.ManagerLoginDAOImpl;

public class ManagerLoginService {
	
	private ManagerLoginDAO mlsdao = new ManagerLoginDAOImpl();

	public boolean testLogin(String username, String password) {
		return mlsdao.test(username, password);
	}
}
