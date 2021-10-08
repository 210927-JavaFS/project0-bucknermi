package com.revature.controller.customer;

import java.util.Scanner;

import com.revature.controller.Menu;

public class CustomerApplicationMenu implements Menu {
	
	@Override
	public void getMenu(String username, String password) {
		
		System.out.println("Your past account request results are:  Type a to request a new checking account, "
				+ "b to request a new savings account and e to exit:");
		
		  Scanner scanner = new Scanner(System.in);

		    while (scanner.hasNext() == true) {
		      String s = scanner.nextLine();

		      if (s.equalsIgnoreCase("e")) {
		    	  
		    	  CustomerMainMenu cmm = new CustomerMainMenu();
		    	  cmm.getMenu(username, password);
			      }

		      else {
		        System.out.println("\nInvalid selection. Please select a, b or e");
		        CustomerApplicationMenu cpm = new CustomerApplicationMenu();
		        cpm.getMenu(username, password);
		      }

		    }
		    
		    scanner.close();
	}
	
	
	
}
