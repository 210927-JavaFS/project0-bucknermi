package com.revature.controller;

import java.util.Scanner;

public class CustomerMainMenu implements Menu {
	
	public void getMenu() {
		
		System.out.println("Hello and welcome to your account homepage. Please select an option from below:"
				+ "\nA. Personal Profile Information \nB. Checking Account \nC. Savings Account \nD. Transfer Funds \nE. Apply to open account "
				+ "\nF. Exit ");
		
		Scanner scanner2 = new Scanner(System.in);

	    while (scanner2.hasNext() == true) {
	      String s = scanner2.nextLine();

	      if (s.equalsIgnoreCase("a")) {
	        
	    	  ManagerProfileMenu mpm = new ManagerProfileMenu();
	    	  mpm.getMenu();
	    	  
	      }

	      else if (s.equalsIgnoreCase("b")) {
	       
	    	  
	      }

	      else if (s.equalsIgnoreCase("c")) {
	    	  
	    	 
	        
	      }
	      
	      else if (s.equalsIgnoreCase("d")) {
		        
	    	  
		      }
	      
	      else if (s.equalsIgnoreCase("e")) {
		        
	    	  
	      }
	      
	      else if (s.equalsIgnoreCase("f")) {
	    	  	System.out.println("Exiting Program...");
		        System.exit(0);
		      }

	      else {
	        System.out.println("\nInvalid selection. Please select a, b, c, d, e or f");
	        CustomerMainMenu cmm = new CustomerMainMenu();
	        cmm.getMenu();
	      }

	    }
	    
	    scanner2.close();
	}
	
	
	

}
