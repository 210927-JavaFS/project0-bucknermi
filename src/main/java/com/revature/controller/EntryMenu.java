package com.revature.controller;

import java.util.Scanner;

import com.revature.controller.customer.CustomerLogin;
import com.revature.controller.manager.ManagerLogin;
import com.revature.controller.teller.TellerLogin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class EntryMenu implements Menu{
	

	private static Logger log = LoggerFactory.getLogger(EntryMenu.class);
	public void getMenu() {
		
		
		
		 System.out.println(
			        "Hello and welcome to the Bank. Select your login level from the options below or type E "
			        + "to exit \nA. Manager \nB. Teller \nC. Customer \nD. Register for new account \nE. Exit ");
		 
		 	log.info("Entry menu accessed");

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
			    	  
			        
			      }
			      
			      
			      
			      else if (s.equalsIgnoreCase("e")) {
			    	  System.out.println("Exiting Program...");
				        System.exit(0);
				      }

			      else {
			        System.out.println("\nInvalid selection. Please select a, b or c");
			        EntryMenu em = new EntryMenu();
			        em.getMenu();
			      }

			    }
			    
			    scanner.close();

	}

}
