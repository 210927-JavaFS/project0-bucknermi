package com.revature.controller.customer;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Menu;
import com.revature.service.AccountService;

public class CustomerApplicationMenu implements Menu {
	
	private static Logger log = LoggerFactory.getLogger(CustomerApplicationMenu.class);

	@Override
	public void getMenu(String username, String password) {

		System.out.println("Type a to apply for a new account or type e to exit");

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext() == true) {
			String s = scanner.nextLine();

			if (s.equalsIgnoreCase("a")) {

				AccountService as = new AccountService();
				as.createAccount(username);
				System.out.println("Your account request has been created and will be reviewed by a manager");
				System.out.println("Returning to your main menu...");
				CustomerMainMenu cmm = new CustomerMainMenu();
				cmm.getMenu(username, password);
			}

			else if (s.equalsIgnoreCase("e")) {
				System.out.println("Exiting to your main menu...");
				CustomerMainMenu cmm = new CustomerMainMenu();
				cmm.getMenu(username, password);
			}

			else {
				System.out.println("\nInvalid selection. Please select a, b or e");
				log.warn("Invalid input");
				CustomerApplicationMenu cpm = new CustomerApplicationMenu();
				cpm.getMenu(username, password);
			}

		}

		scanner.close();
	}

}
