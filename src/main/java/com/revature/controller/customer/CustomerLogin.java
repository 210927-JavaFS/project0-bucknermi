package com.revature.controller.customer;

import java.util.Scanner;

import com.revature.controller.Login;

public class CustomerLogin extends Login {
	
public void getLogin() {
		
		System.out.println("Please enter your username and password: \nUsername: ");
		
		Scanner scanner1 = new Scanner(System.in);
			
		username = scanner1.nextLine();
		
		System.out.println("Password: ");
		
		password = scanner1.nextLine();
		
		
		
		if(true) {
		 CustomerMainMenu cmm = new CustomerMainMenu();
		 cmm.getMenu();
			
			
			
		}
		
	}
	
			
		}
		
		

