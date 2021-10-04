package com.revature.controller.teller;

import java.util.Scanner;

import com.revature.controller.Login;

public class TellerLogin extends Login {
	
	
		public void getLogin() {
			
			System.out.println("Please enter your username and password: \nUsername: ");
			
			Scanner scanner1 = new Scanner(System.in);
				
			username = scanner1.nextLine();
			
			System.out.println("Password: ");
			
			password = scanner1.nextLine();
			
			
			
			if(true) {
				
				TellerMainMenu tmm = new TellerMainMenu();
				tmm.getMenu();
			}
			
		}
}

