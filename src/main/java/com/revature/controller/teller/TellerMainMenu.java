package com.revature.controller.teller;

import java.util.Scanner;

import com.revature.controller.Menu;

public class TellerMainMenu implements Menu {
	
	@Override
	public void getMenu(String username, String password) {
		
		System.out.println("Hello and welcome to your account homepage. Please select an option from below:"
				+ "\nA. Personal Profile Information \nB. Edit customer accounts \nC. Exit ");
		
		Scanner scanner2 = new Scanner(System.in);

	    while (scanner2.hasNext() == true) {
	      String s = scanner2.nextLine();

	      if (s.equalsIgnoreCase("a")) {
	        
	    	  TellerProfileMenu tpm = new TellerProfileMenu();
	    	  tpm.getMenu(username, password);
	    	 
	      }

	      else if (s.equalsIgnoreCase("b")) {
	       
	    	  	TellerCustomerAccountsMenu tcam = new TellerCustomerAccountsMenu();
	    	  	tcam.getMenu(username, password);
	    	  
	      }

	      else if (s.equalsIgnoreCase("c")) {
	    	  
	    	System.out.println("Exiting Program...");  
	    	System.exit(0);
	      }
	  
	      else {
	        System.out.println("\nInvalid selection. Please select a, b or c");
	        
	        TellerMainMenu tmm = new TellerMainMenu();
	        tmm.getMenu(username, password);
	      }

	    }
	    scanner2.close();
	}

}
