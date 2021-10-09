package com.revature.service;

import com.revature.dao.TellerLoginDAO;
import com.revature.dao.TellerLoginDAOImpl;

public class TellerLoginService {
	
	private TellerLoginDAO tldao = new TellerLoginDAOImpl();

	public boolean testLogin(String username, String password) {
		return tldao.test(username, password);
	}

}
