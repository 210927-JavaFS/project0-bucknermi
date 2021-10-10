package com.revature.controller.manager;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Menu;
import com.revature.service.login.DecryptionService;

public class ManagerProfileMenu implements Menu{
	
	private static Logger log = LoggerFactory.getLogger(ManagerProfileMenu.class);
	
	@Override
	public void getMenu(String username, String password) {
		
		DecryptionService ds = new DecryptionService();
		String dpassword = ds.decryptor(password);
		System.out.println("Your username is: " +username+ " and your password is: " +dpassword+ 
				"\nType e to exit to main menu");
		
		Scanner scanner = new Scanner(System.in);

	    while (scanner.hasNext() == true) {
	      String s = scanner.nextLine();

	      if (s.equalsIgnoreCase("e")) {
	    	  ManagerMainMenu mmm = new ManagerMainMenu();
	          mmm.getMenu(username, password);
	    	  
	      }


	      else {
	        System.out.println("\nInvalid selection. Please select a, b or c");
	        log.warn("Invalid input");
	        ManagerProfileMenu mpm = new ManagerProfileMenu();
	        mpm.getMenu(username, password);
	      }

	    }
	     scanner.close();

	}

}
