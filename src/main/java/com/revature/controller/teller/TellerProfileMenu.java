package com.revature.controller.teller;

import java.util.Scanner;

public class TellerProfileMenu {
	public void getMenu() {
		
		System.out.println("Your username and password are: \nType e to exit to main menu");
		
		Scanner scanner = new Scanner(System.in);

	    while (scanner.hasNext() == true) {
	      String s = scanner.nextLine();

	      if (s.equalsIgnoreCase("e")) {
	    	  TellerMainMenu tmm = new TellerMainMenu();
	    	  tmm.getMenu();
	    	  
	      }


	      else {
	        System.out.println("\nInvalid selection. Please select a, b or c");
	        TellerProfileMenu tpm = new TellerProfileMenu();
	        tpm.getMenu();
	      }

	    }
	     scanner.close();

	}

}
