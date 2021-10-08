package com.revature.controller;

import java.util.Scanner;

public class Registration {
	
	public String newUsername;
	public String newPassword;
	
	public void register() {
		
		System.out.println("Please enter a username and password. After you have chosen your password press enter"
				+ " to register your account and return to the main menu: \nUsername: ");
		
		Scanner scanner1 = new Scanner(System.in);
			
		newUsername = scanner1.nextLine();
		
		System.out.println("Password: ");
		
		newPassword = scanner1.nextLine();
		
		scanner1.close();
		
		EntryMenu em = new EntryMenu();
		em.getMenu("none", "nones");
		
	}

}
