package com.revature.controller.manager;

import java.util.Scanner;

import com.revature.controller.AccountController;
import com.revature.controller.Menu;

public class ManagerCustomerAccountsMenu implements Menu { 
	
	@Override
	public void getMenu(String username, String password) {
		System.out.println("Customer account information is: ");
		AccountController a = new AccountController();
		a.displayAllAccounts();
		System.out.println("Enter the name of the customer whose account you would like to edit or type e to exit to main menu: "); 
		   Scanner scanner = new Scanner(System.in);

		    while (scanner.hasNext() == true) {
		      String s = scanner.nextLine();

		      if (s.equalsIgnoreCase("a")) {
		        
		    	  
		    	  ManagerMainMenu mmm = new ManagerMainMenu();
		    	  mmm.getMenu(username, password);
		        
		      }
		     
		      else if (s.equalsIgnoreCase("e")) {
		    	  ManagerMainMenu mmm = new ManagerMainMenu();
		    	  mmm.getMenu(username, password);
			      }

		      else {
		        System.out.println("\nInvalid selection. Please select a valid customer name");
		        ManagerCustomerAccountsMenu mcam = new ManagerCustomerAccountsMenu();
		        mcam.getMenu(username, password);
		      }

		    }
		    
		    scanner.close();

}

		
		
	}


