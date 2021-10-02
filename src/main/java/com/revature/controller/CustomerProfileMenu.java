package com.revature.controller;

import java.util.Scanner;

public class CustomerProfileMenu {
	
	public void getMenu() {
	
	System.out.println("Your username and password are: \n Type e to exit to main menu");
	
	Scanner scanner = new Scanner(System.in);

    while (scanner.hasNext() == true) {
      String s = scanner.nextLine();

      if (s.equalsIgnoreCase("e")) {
    	  CustomerMainMenu cmm = new CustomerMainMenu();
          cmm.getMenu();
    	  
      }


      else {
        System.out.println("\nInvalid selection. Please select a, b or c");
        CustomerProfileMenu cpm = new CustomerProfileMenu();
        cpm.getMenu();
      }

    }
     scanner.close();

}
}
