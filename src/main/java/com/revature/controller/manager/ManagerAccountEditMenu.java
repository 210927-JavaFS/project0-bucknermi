package com.revature.controller.manager;

import java.util.Scanner;

import com.revature.controller.InputMenu;


public class ManagerAccountEditMenu implements InputMenu { 
public void getMenu(int x) {
		
		System.out.println("Account ID:  , Account username:  ,Account type:  , Account balance:   "
				+ "\nChoose from one of the options below: /nA: Deposit /nB: Withdraw /nC: Transfer funds "
				+ "\nD: Exit to main menu");
		
	    Scanner scanner = new Scanner(System.in);

	    while (scanner.hasNext() == true) {
	      String s = scanner.nextLine();

	      if (s.equalsIgnoreCase("a")) {
	        
	    	 
	      }

	      else if (s.equalsIgnoreCase("b")) {
	       
	    	  	
	    	  	
	      }

	      else if (s.equalsIgnoreCase("c")) {
	    	  
	    	 
	      }
	      
	      	else if (s.equalsIgnoreCase("d")) {
	    	  ManagerMainMenu mmm = new ManagerMainMenu();
	    	  mmm.getMenu();
	    	 
	        
	      }
	      
	      
	      
	      

	      else {
	        System.out.println("\nInvalid selection. Please select a, b or c");
	        ManagerAccountEditMenu maem = new ManagerAccountEditMenu();
	        maem.getMenu(x);
	      }

	    }
	    
	    scanner.close();
		
	}

}
