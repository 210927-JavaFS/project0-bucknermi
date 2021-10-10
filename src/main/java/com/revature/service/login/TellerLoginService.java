package com.revature.service.login;

import com.revature.dao.TellerLoginDAO;
import com.revature.dao.impl.TellerLoginDAOImpl;

public class TellerLoginService {
	
	private TellerLoginDAO tldao = new TellerLoginDAOImpl();

	public boolean testLogin(String username, String password) {
		return tldao.test(username, password);
	}

}
