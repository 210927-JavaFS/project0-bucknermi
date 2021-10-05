package com.revature.controller.manager;

import java.util.Scanner;

import com.revature.controller.Menu;

public class ManagerApplicationMenu implements Menu {
	
	@Override
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
