package com.revature.controller.customer;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Menu;
import com.revature.service.login.DecryptionService;

public class CustomerProfileMenu implements Menu {

	private static Logger log = LoggerFactory.getLogger(CustomerProfileMenu.class);

	@Override
	public void getMenu(String username, String password) {

		DecryptionService ds = new DecryptionService();
		String dpassword = ds.decryptor(password);
		System.out.println("\nYour username is: " + username + " and your password is: " + dpassword
				+ "\nType E to exit to main menu");

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext() == true) {
			String s = scanner.nextLine();

			if (s.equalsIgnoreCase("e")) {
				CustomerMainMenu cmm = new CustomerMainMenu();
				cmm.getMenu(username, password);

			}

			else {
				System.out.println("\nInvalid selection. Please select e. Returning to top of menu...");
				log.warn("Invalid input");
				CustomerProfileMenu cpm = new CustomerProfileMenu();
				cpm.getMenu(username, password);
			}

		}
		scanner.close();

	}
}
