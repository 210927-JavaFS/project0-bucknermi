package com.revature.controller.manager;

import java.util.Scanner;

import com.revature.controller.Menu;

public class ManagerProfileMenu implements Menu{
	
	@Override
	public void getMenu() {
		
		System.out.println("Your username and password are: \nType e to exit to main menu");
		
		Scanner scanner = new Scanner(System.in);

	    while (scanner.hasNext() == true) {
	      String s = scanner.nextLine();

	      if (s.equalsIgnoreCase("e")) {
	    	  ManagerMainMenu mmm = new ManagerMainMenu();
	          mmm.getMenu();
	    	  
	      }


	      else {
	        System.out.println("\nInvalid selection. Please select a, b or c");
	        ManagerProfileMenu mpm = new ManagerProfileMenu();
	        mpm.getMenu();
	      }

	    }
	     scanner.close();

	}

}
