package com.revature.controller.teller;

import java.util.Scanner;


import com.revature.controller.InputMenu;



public class TellerAccountEditMenu implements InputMenu {
	
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
	    	  TellerMainMenu tmm = new TellerMainMenu();
	    	  tmm.getMenu();
	    	 
	        
	      }
	      
	      
	      
	      

	      else {
	        System.out.println("\nInvalid selection. Please select a, b or c");
	        TellerAccountEditMenu taem = new TellerAccountEditMenu();
	        taem.getMenu(x);
	      }

	    }
	    
	    scanner.close();
		
	}
	

}
