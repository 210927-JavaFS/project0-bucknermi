package com.revature.controller.manager;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.EntryMenu;
import com.revature.controller.Login;
import com.revature.service.login.EncryptionService;
import com.revature.service.login.ManagerLoginService;

public class ManagerLogin extends Login{
	
	private static Logger log = LoggerFactory.getLogger(ManagerLogin.class);

	@Override
	public void getLogin() {
		
		System.out.println("Please enter your username and password: \nUsername: ");
		
		Scanner scanner1 = new Scanner(System.in);
			
		username = scanner1.nextLine();
		
		Scanner scanner2 = new Scanner(System.in);
		
		System.out.println("Password: ");
		
		password = scanner2.nextLine();
		
		EncryptionService es = new EncryptionService();
		
		password = es.encryptor(password);
		
		ManagerLoginService mls = new ManagerLoginService();
		boolean x = mls.testLogin(username, password);
		
		if(x) {
			System.out.println("Succesful login. Redirecting to your main menu");
			ManagerMainMenu mmm = new ManagerMainMenu();
			mmm.getMenu(username, password);
		}
		else {
			System.out.println("Incorrect username and password combination. Returning to main menu");
			log.warn("Manger login attempt failed");
			EntryMenu em = new EntryMenu();
			em.getMenu(username, password);
		}
		
	}
		
	}


