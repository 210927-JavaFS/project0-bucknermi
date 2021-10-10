package com.revature.controller.teller;

import java.util.Scanner;

import com.revature.controller.EntryMenu;
import com.revature.controller.Login;
import com.revature.service.EncryptionService;
import com.revature.service.TellerLoginService;

public class TellerLogin extends Login {
	
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
			
			TellerLoginService tls = new TellerLoginService();
			boolean x = tls.testLogin(username, password);
			
			if(x) {
				System.out.println("Succesful login. Redirecting to your main menu");
				TellerMainMenu tmm = new TellerMainMenu();
				tmm.getMenu(username, password);
			}
			
			else {
				System.out.println("Incorrect username and password combination. Returning to main menu");
				EntryMenu em = new EntryMenu();
				em.getMenu(username, password);
			}
			
		}
}

