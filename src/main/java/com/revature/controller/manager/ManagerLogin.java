package com.revature.controller.manager;

import java.util.Scanner;

import com.revature.controller.Login;

public class ManagerLogin extends Login{

	@Override
	public void getLogin() {
		
		System.out.println("Please enter your username and password: \nUsername: ");
		
		Scanner scanner1 = new Scanner(System.in);
			
		username = scanner1.nextLine();
		
		Scanner scanner2 = new Scanner(System.in);
		
		System.out.println("Password: ");
		
		password = scanner2.nextLine();
		
		
		
		if(true) {
			ManagerMainMenu mmm = new ManagerMainMenu();
			mmm.getMenu();
		}
		
	}
		
	}


