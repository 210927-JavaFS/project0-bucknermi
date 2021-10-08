package com.revature.controller.teller;

import java.util.Scanner;

import com.revature.controller.Menu;



public class TellerAccountDisplayMenu implements Menu {
	
	@Override
	public void getMenu(String username, String password) {
		
		System.out.println("This accounts username is: , this account's ");
		
		Scanner scanner = new Scanner(System.in);

	    while (scanner.hasNext() == true) {
	      String s = scanner.nextLine();

	      if (s.equalsIgnoreCase("e")) {
	    	  TellerMainMenu tmm = new TellerMainMenu();
	    	  tmm.getMenu(username, password);
	    	  
	      }


	      else {
	        System.out.println("\nInvalid selection. Please select a, b or c");
	        TellerProfileMenu tpm = new TellerProfileMenu();
	        tpm.getMenu(username, password);
	      }

	    }
	     scanner.close();

	}


}
