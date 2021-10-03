package com.revature.controller;

import java.util.Scanner;

public class TellerCustomerAccountsMenu implements Menu{
	
	public void getMenu() {
	
	System.out.println("Enter the name of the customer whose account you would like to edit or type e to exit to main menu: "); 
	   Scanner scanner = new Scanner(System.in);

	    while (scanner.hasNext() == true) {
	      String s = scanner.nextLine();

	      if (s.equalsIgnoreCase("a")) {
	        
	    	  
	    	  TellerMainMenu tmm = new TellerMainMenu();
	    	  tmm.getMenu();
	        
	      }
	     
	      else if (s.equalsIgnoreCase("e")) {
	    	  TellerMainMenu tmm = new TellerMainMenu();
	    	  tmm.getMenu();
		      }

	      else {
	        System.out.println("\nInvalid selection. Please select a valid customer name");
	        TellerCustomerAccountsMenu tcam = new TellerCustomerAccountsMenu();
	        tcam.getMenu();
	      }

	    }
	    
	    scanner.close();

}


}
