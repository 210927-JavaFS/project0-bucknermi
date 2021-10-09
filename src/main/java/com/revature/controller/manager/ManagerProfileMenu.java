package com.revature.controller.manager;

import java.util.Scanner;

import com.revature.controller.Menu;

public class ManagerProfileMenu implements Menu{
	
	@Override
	public void getMenu(String username, String password) {
		
		System.out.println("Your username is: " +username+ " and your password is: " +password+ 
				"\nType e to exit to main menu");
		
		Scanner scanner = new Scanner(System.in);

	    while (scanner.hasNext() == true) {
	      String s = scanner.nextLine();

	      if (s.equalsIgnoreCase("e")) {
	    	  ManagerMainMenu mmm = new ManagerMainMenu();
	          mmm.getMenu(username, password);
	    	  
	      }


	      else {
	        System.out.println("\nInvalid selection. Please select a, b or c");
	        ManagerProfileMenu mpm = new ManagerProfileMenu();
	        mpm.getMenu(username, password);
	      }

	    }
	     scanner.close();

	}

}
