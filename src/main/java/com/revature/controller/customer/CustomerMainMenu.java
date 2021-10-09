package com.revature.controller.customer;

import java.util.Scanner;

import com.revature.controller.Menu;

public class CustomerMainMenu implements Menu {
	
	@Override
	public void getMenu(String username, String password) {
		
		System.out.println("Hello and welcome to your account homepage. Please select an option from below:"
				+ "\nA. Personal Profile Information \nB. View/Edit your accounts \nC. Apply for account "
				+ "\nD. Exit ");
		
		Scanner scanner2 = new Scanner(System.in);

	    while (scanner2.hasNext() == true) {
	      String s = scanner2.nextLine();

	      if (s.equalsIgnoreCase("a")) {
	        
	    	  CustomerProfileMenu cpm = new CustomerProfileMenu();
	    	  cpm.getMenu(username, password);
	    	  
	      }

	      else if (s.equalsIgnoreCase("b")) {
	       
	    	  CustomerAccountMenu cam = new CustomerAccountMenu();
	    	  cam.getMenu(username, password);
	    	  
	      }

	      else if (s.equalsIgnoreCase("c")) {
	    	  
	    	 CustomerApplicationMenu cam = new CustomerApplicationMenu();
	    	 cam.getMenu(username, password);
	        
	      }
	      
  
	      else if (s.equalsIgnoreCase("d")) {
	    	  	System.out.println("Exiting Program...");
		        System.exit(0);
		      }

	      else {
	        System.out.println("\nInvalid selection. Please select a, b, c or d");
	        CustomerMainMenu cmm = new CustomerMainMenu();
	        cmm.getMenu(username, password);
	      }

	    }
	    
	    scanner2.close();
	}
	
	
	

}
