package com.revature.controller;

import java.util.Scanner;

public class EntryMenu implements Menu{
	
	public void getMenu() {
		
		 System.out.println(
			        "\nHello and welcome to the Bank. Select your login level from the options below or type D to exit \nA. Manager \nB. Teller \nC. Customer \nD. Exit ");

			    Scanner scanner = new Scanner(System.in);

			    while (scanner.hasNext() == true) {
			      String s = scanner.nextLine();

			      if (s.equalsIgnoreCase("a")) {
			        
			    	  
			    	  ManagerLogin ml = new ManagerLogin();
			    	  ml.getLogin();
			      }

			      else if (s.equalsIgnoreCase("b")) {
			       
			    	  	
			    	  	TellerLogin tl = new TellerLogin();
			    	  	tl.getLogin();
			      }

			      else if (s.equalsIgnoreCase("c")) {
			    	  
			    	  CustomerLogin cl = new CustomerLogin();
			    	  cl.getLogin();
			        
			      }
			      
			      else if (s.equalsIgnoreCase("d")) {
				        System.exit(0);
				      }

			      else {
			        System.out.println("\nInvalid selection. Please select a, b or c");
			        EntryMenu m = new EntryMenu();
			        m.getMenu();
			      }

			    }

	}

}
