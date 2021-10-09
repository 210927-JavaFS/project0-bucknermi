package com.revature.controller.customer;

import java.util.Scanner;

import com.revature.controller.Menu;

public class CustomerProfileMenu implements Menu {
	
	@Override
	public void getMenu(String username, String password) {
	
	System.out.println("Your username is: " +username+ " and your password is: " +password+ 
			"\nType e to exit to main menu");
	
	Scanner scanner = new Scanner(System.in);

    while (scanner.hasNext() == true) {
      String s = scanner.nextLine();

      if (s.equalsIgnoreCase("e")) {
    	  CustomerMainMenu cmm = new CustomerMainMenu();
          cmm.getMenu(username, password);
    	  
      }


      else {
        System.out.println("\nInvalid selection. Please select a, b or c");
        CustomerProfileMenu cpm = new CustomerProfileMenu();
        cpm.getMenu(username, password);
      }

    }
     scanner.close();

}
}
