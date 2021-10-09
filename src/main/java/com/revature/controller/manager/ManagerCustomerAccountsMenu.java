package com.revature.controller.manager;

import java.util.Scanner;

import com.revature.controller.AccountController;
import com.revature.controller.Menu;
import com.revature.service.AccountService;

public class ManagerCustomerAccountsMenu implements Menu { 
	
	@Override
	public void getMenu(String username, String password) {
		System.out.println("Customer account information is: ");
		AccountController a = new AccountController();
		a.displayAllAccounts();
		System.out.println("Enter the id of the customer whose account you would like to edit or type e to exit to main menu: "); 
		   Scanner scanner = new Scanner(System.in);

		    while (scanner.hasNext() == true) {
		      String s = scanner.nextLine();

		      if (s.equalsIgnoreCase("e")) {
		    	  ManagerMainMenu mmm = new ManagerMainMenu();
		    	  mmm.getMenu(username, password);
			      }

		      else {
		    	  
		    	  try {
		    		  int x = Integer.parseInt(s);
		    		 AccountService as = new AccountService();
		    		 boolean y = as.getExistByID(x);
		    		
		    	  }
		    	  catch(NumberFormatException e) {
		        System.out.println("\nInvalid selection. Please select a valid customer id");
		        ManagerCustomerAccountsMenu mcam = new ManagerCustomerAccountsMenu();
		        mcam.getMenu(username, password);
		      }

		    }
		    
		    

}

		
		
	}
}


