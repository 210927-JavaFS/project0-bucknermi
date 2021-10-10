package com.revature.controller.manager;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.AccountController;
import com.revature.controller.Menu;
import com.revature.service.AccountService;

public class ManagerApplicationMenu implements Menu {
	
	private static Logger log = LoggerFactory.getLogger(ManagerApplicationMenu.class);
	
	@Override
	public void getMenu(String username, String password) {
		
		System.out.println("Your pending application requests are below Enter the request ID to approve or delete account request, or type e to exit");
		
		AccountController ac = new AccountController();
		ac.displayByActivated();
		
		  Scanner scanner = new Scanner(System.in);

		    while (scanner.hasNext() == true) {
		      String s = scanner.nextLine();

		  if (s.equalsIgnoreCase("e")) {
		    	 ManagerMainMenu mmm = new ManagerMainMenu();
		    	 mmm.getMenu(username, password);
			      }
		  else {
			  try { int account_id = Integer.parseInt(s);
				AccountService as = new AccountService();
				boolean y = as.getExistByID(account_id);
				if(y) {
					System.out.println("You have selected account with id: " +account_id);
					System.out.println("Type a to activate account, type b to delete account or type e to exit");
					String s1 = scanner.nextLine();
					
					if(s1.equalsIgnoreCase("a")) {
						as.verifyAccount(account_id);
						System.out.println("account has been verified returning to your main menu...");
						ManagerMainMenu mmm = new ManagerMainMenu();
						mmm.getMenu(username, password);
					}
					else if(s1.equalsIgnoreCase("b")) {
						as.removeAccount(account_id);
						System.out.println("account has been deleted returning to your main menu...");
						ManagerMainMenu mmm = new ManagerMainMenu();
						mmm.getMenu(username, password);

					}
					else if(s1.equalsIgnoreCase("e")) {
						System.out.println("returning to top of menu..");
						ManagerApplicationMenu mam = new ManagerApplicationMenu();
						mam.getMenu(username, password);
					}
					else {
						System.out.println("Invalid ID selection. Returning to top of menu...");
						log.warn("Invalid input");
						ManagerApplicationMenu mam = new ManagerApplicationMenu();
						mam.getMenu(username, password);
						
					}
					
				}
				else {
					System.out.println("Invalid ID selection. Returning to top of menu...");
					log.warn("Invalid input");
					ManagerApplicationMenu mam = new ManagerApplicationMenu();
					mam.getMenu(username, password);
				}
		  }
			  catch(NumberFormatException e) {
				  System.out.println("\nInvalid selection. Please select a valid customer id. Returning to top of menu...");
				  log.warn("Invalid input");
					ManagerApplicationMenu mam = new ManagerApplicationMenu();
					mam.getMenu(username, password);
			  }

		      

		    }
		    
		    
	}

	
}
}
