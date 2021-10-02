package com.revature.controller;

import java.util.Scanner;

public class TellerLogin extends Login {
	
	
		public void getLogin() {
			
			System.out.println("Please enter your username and password: \nUsername: ");
			
			Scanner scanner1 = new Scanner(System.in);
				
			username = scanner1.nextLine();
			
			System.out.println("Password: ");
			
			password = scanner1.nextLine();
			
			scanner1.close();
			
			if(true) {
				
				TellerMainMenu tmm = new TellerMainMenu();
				tmm.getMenu();
			}
			
		}
}

