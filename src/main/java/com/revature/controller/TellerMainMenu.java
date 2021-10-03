package com.revature.controller;

import java.util.Scanner;

public class TellerMainMenu implements Menu {
	
	public void getMenu() {
		
		System.out.println("Hello and welcome to your account homepage. Please select an option from below:"
				+ "\nA. Personal Profile Information \nB. Customer Accounts \nC. Exit ");
		
		Scanner scanner2 = new Scanner(System.in);

	    while (scanner2.hasNext() == true) {
	      String s = scanner2.nextLine();

	      if (s.equalsIgnoreCase("a")) {
	        
	    	  TellerProfileMenu tpm = new TellerProfileMenu();
	    	  tpm.getMenu();
	    	 
	      }

	      else if (s.equalsIgnoreCase("b")) {
	       
	    	  	TellerCustomerAccountsMenu tcam = new TellerCustomerAccountsMenu();
	    	  	tcam.getMenu();
	    	  
	      }

	      else if (s.equalsIgnoreCase("c")) {
	    	  
	    	System.out.println("Exiting Program...");  
	    	System.exit(0);
	      }
	  
	      else {
	        System.out.println("\nInvalid selection. Please select a, b or c");
	        
	        TellerMainMenu tmm = new TellerMainMenu();
	        tmm.getMenu();
	      }

	    }
	    scanner2.close();
	}

}
