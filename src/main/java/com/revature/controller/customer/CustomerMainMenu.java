package com.revature.controller.customer;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Menu;

public class CustomerMainMenu implements Menu {

	private static Logger log = LoggerFactory.getLogger(CustomerMainMenu.class);

	@Override
	public void getMenu(String username, String password) {

		System.out.println("\nHello and welcome to your account homepage. Please select an option from below:"
				+ "\nA. Personal Profile Information \nB. View/Edit your accounts \nC. Apply for account "
				+ "\nE. Exit ");

		Scanner scanner2 = new Scanner(System.in);

		while (scanner2.hasNext() == true) {
			String s = scanner2.nextLine();

			if (s.equalsIgnoreCase("a")) {

				CustomerProfileMenu cpm = new CustomerProfileMenu();
				cpm.getMenu(username, password);

			}

			else if (s.equalsIgnoreCase("b")) {

				CustomerAccountMenu cam = new CustomerAccountMenu();
				cam.getMenu(username, password);

			}

			else if (s.equalsIgnoreCase("c")) {

				CustomerApplicationMenu cam = new CustomerApplicationMenu();
				cam.getMenu(username, password);

			}

			else if (s.equalsIgnoreCase("e")) {
				System.out.println("\nExiting Program...");
				log.info("Program exited");
				System.exit(0);
			}

			else {
				System.out.println("\nInvalid selection. Please select a, b, c or e");
				log.warn("Invalid menu input");
				CustomerMainMenu cmm = new CustomerMainMenu();
				cmm.getMenu(username, password);
			}

		}

		scanner2.close();
	}

}
