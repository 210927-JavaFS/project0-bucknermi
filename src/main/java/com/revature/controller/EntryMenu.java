package com.revature.controller;

import java.util.Scanner;

public class EntryMenu implements Menu{
	
	public void getMenu() {
		
		 System.out.println(
			        "\nHello and welcome to the Bank. Select your login level from the options below \nA. Manager \nB. Teller \nC. Employee ");

			    Scanner scanner = new Scanner(System.in);

			    while (scanner.hasNext() == true) {
			      String s = scanner.nextLine();

			      if (s.equalsIgnoreCase("a")) {
			        
			    	  System.out.println("a");
			      }

			      else if (s.equalsIgnoreCase("b")) {
			       
			    	  	System.out.println("b");
			      }

			      else if (s.equalsIgnoreCase("c")) {
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
