package com.revature.controller;

import java.util.Scanner;

public class ManagerApplicationMenu implements Menu {
	
	public void getMenu() {
		
		System.out.println("Your pending application requests are: Enter the request ID and approve or deny, or type e to exit");
		
		  Scanner scanner = new Scanner(System.in);

		    while (scanner.hasNext() == true) {
		      String s = scanner.nextLine();

		  if (s.equalsIgnoreCase("e")) {
		    	 ManagerMainMenu mmm = new ManagerMainMenu();
		    	 mmm.getMenu();
			      }

		      else {
		        System.out.println("\nInvalid selection. Please select e");
		       ManagerApplicationMenu mam = new ManagerApplicationMenu();
		       mam.getMenu();
		      }

		    }
		    
		    scanner.close();
	}

	
}
