package com.revature.controller.manager;

import java.util.Scanner;

import com.revature.controller.AccountController;
import com.revature.controller.Menu;
import com.revature.service.AccountService;

public class ManagerApplicationMenu implements Menu {
	
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
					
				}
				else {
					System.out.println("Invalid ID selection. Returning to top of menu...");
					ManagerApplicationMenu mam = new ManagerApplicationMenu();
					mam.getMenu(username, password);
				}
		  }
			  catch(NumberFormatException e) {
				  System.out.println("\nInvalid selection. Please select a valid customer id. Returning to top of menu...");
					ManagerApplicationMenu mam = new ManagerApplicationMenu();
					mam.getMenu(username, password);
			  }

		      

		    }
		    
		    
	}

	
}
}
