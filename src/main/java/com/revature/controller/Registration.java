package com.revature.controller;

import java.util.Scanner;

import com.revature.service.AccountService;
import com.revature.service.login.EncryptionService;

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
		
		AccountService as = new AccountService();
		
		if(as.newUsername(newUsername)) {
			EncryptionService es = new EncryptionService();
			newPassword = es.encryptor(newPassword);
			as.newLogin(newUsername, newPassword);
			System.out.println("\nLogin creation successful, returning to main menu...");
		}
		else {
			System.out.println("\nThis username is already taken account creation failed returning to main menu...");
			
		}
		
		
		
		
		EntryMenu em = new EntryMenu();
		em.getMenu("none", "none");
		
	}

}
