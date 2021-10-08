package com.revature.controller.customer;

import java.util.Scanner;

import com.revature.controller.Menu;

public class CustomerSavingsAccountMenu implements Menu{

	@Override
	public void getMenu(String username, String password) {
		
		System.out.println("Your current balance is: type a to deposit, b to withdraw or c to exit to main menu");
		  Scanner scanner = new Scanner(System.in);

		    while (scanner.hasNext() == true) {
		      String s = scanner.nextLine();

		      if (s.equalsIgnoreCase("a")) {
		        
		    	  
		    	  
		      }

		      else if (s.equalsIgnoreCase("b")) {
		       
		    	  	
		    	  
		      }

		      else if (s.equalsIgnoreCase("c")) {
		    	  
		    	CustomerMainMenu cmm = new CustomerMainMenu();
		    	cmm.getMenu(username, password);
		        
		      }
		      
		     

		      else {
		        System.out.println("\nInvalid selection. Please select a, b or c");
		        CustomerSavingsAccountMenu csam = new CustomerSavingsAccountMenu();
		        csam.getMenu(username, password);
		      }

		    }
		    
		    scanner.close();
	}


}
