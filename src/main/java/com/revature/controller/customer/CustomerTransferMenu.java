package com.revature.controller.customer;

import java.util.Scanner;

import com.revature.controller.Menu;

public class CustomerTransferMenu implements Menu {
	
	public void getMenu() {
		
		System.out.println("Enter the account id number you would like to transfer to and the ammount you would "
				+ "like to transfer: type e to exit");
		
		
			  Scanner scanner = new Scanner(System.in);

			    while (scanner.hasNext() == true) {
			      String s = scanner.nextLine();

			     if (s.equalsIgnoreCase("e")) {
			    	  
			    	CustomerMainMenu cmm = new CustomerMainMenu();
			    	cmm.getMenu();
			        
			      }
			      
			     
			     else {
			        System.out.println("\nInvalid selection. Please select e");
			        CustomerTransferMenu ctm = new CustomerTransferMenu();
			        ctm.getMenu();
			    
			      }

			    }
			    
			    scanner.close();
		}

	}


