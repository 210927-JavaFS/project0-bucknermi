package com.revature.controller.customer;

import java.util.Scanner;

import com.revature.controller.EntryMenu;
import com.revature.controller.Login;
import com.revature.service.CustomerLoginService;

public class CustomerLogin extends Login {

	@Override
	public void getLogin() {
		
		System.out.println("Please enter your username and password: \nUsername: ");
		
		Scanner scanner1 = new Scanner(System.in);
			
		username = scanner1.nextLine();
		
		Scanner scanner2 = new Scanner(System.in);
		
		System.out.println("Password: ");
		
		password = scanner2.nextLine();
		
		CustomerLoginService cls = new CustomerLoginService();
		boolean x = cls.testLogin(username, password);
		
		if(x) {
		System.out.println("Succesful login. Redirecting to your main menu \n");	
		 CustomerMainMenu cmm = new CustomerMainMenu();
		 cmm.getMenu();}
		
		 else {
				System.out.println("Incorrect username and password combination. Returning to main menu");
				EntryMenu em = new EntryMenu();
				em.getMenu();
			}
			
			
		}
		
	}
	
			
		
		
		

