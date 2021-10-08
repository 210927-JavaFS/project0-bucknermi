package com.revature.controller.manager;

import java.util.Scanner;

import com.revature.controller.EntryMenu;
import com.revature.controller.Login;
import com.revature.service.ManagerLoginService;

public class ManagerLogin extends Login{

	@Override
	public void getLogin() {
		
		System.out.println("Please enter your username and password: \nUsername: ");
		
		Scanner scanner1 = new Scanner(System.in);
			
		username = scanner1.nextLine();
		
		Scanner scanner2 = new Scanner(System.in);
		
		System.out.println("Password: ");
		
		password = scanner2.nextLine();
		
		ManagerLoginService mls = new ManagerLoginService();
		boolean x = mls.testLogin(username, password);
		
		if(x) {
			System.out.println("Succesful login. Redirecting to your main menu");
			ManagerMainMenu mmm = new ManagerMainMenu();
			mmm.getMenu(username, password);
		}
		else {
			System.out.println("Incorrect username and password combination. Returning to main menu");
			EntryMenu em = new EntryMenu();
			em.getMenu(username, password);
		}
		
	}
		
	}


