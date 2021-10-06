package com.revature.controller.manager;

import java.util.Scanner;

import com.revature.controller.Menu;

public class ManagerMainMenu implements Menu {
	
	@Override
	public void getMenu() {
	
	System.out.println("\nHello and welcome to your account homepage. Please select an option from below:"
			+ "\nA. Personal profile information \nB. Edit customer accounts \nC. Review account requests \nD. Exit ");
	
	Scanner scanner3 = new Scanner(System.in);

    while (scanner3.hasNext() == true) {
      String s = scanner3.nextLine();

      if (s.equalsIgnoreCase("a")) {
    	  ManagerProfileMenu mpm = new ManagerProfileMenu();
	       mpm.getMenu();
    	  
      }

      else if (s.equalsIgnoreCase("b")) {
       
    	  	ManagerCustomerAccountsMenu mcam = new ManagerCustomerAccountsMenu();
    	  	mcam.getMenu();
    	  
      }

      else if (s.equalsIgnoreCase("c")) {
    	  
    	  ManagerApplicationMenu mam = new ManagerApplicationMenu();
    	  mam.getMenu();
        
      }
      
      else if (s.equalsIgnoreCase("d")) {
    	  
    	  System.out.println("Exiting Program...");
    	  System.exit(0);
	       
	      }

      else {
        System.out.println("\nInvalid selection. Please select a, b or c");
        ManagerMainMenu mmm = new ManagerMainMenu();
        mmm.getMenu();
      }

    }
     scanner3.close();
    }
   
}

