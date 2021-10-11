package com.revature.controller.customer;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.EntryMenu;
import com.revature.controller.Menu;
import com.revature.service.AccountService;
import com.revature.service.login.CustomerLoginService;
import com.revature.service.login.EncryptionService;

public class CustomerApplicationMenu implements Menu {

	private static Logger log = LoggerFactory.getLogger(CustomerApplicationMenu.class);

	@Override
	public void getMenu(String username, String password) {

		System.out.println("\nA. Apply for new account \nB. Apply for joint account \nE. Exit");

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext() == true) {
			String s = scanner.nextLine();

			if (s.equalsIgnoreCase("a")) {

				AccountService as = new AccountService();
				as.createAccount(username);
				System.out.println("\nYour account request has been created and will be reviewed by a manager");
				System.out.println("\nReturning to your main menu...");
				CustomerMainMenu cmm = new CustomerMainMenu();
				cmm.getMenu(username, password);
			}

			else if (s.equalsIgnoreCase("b")) {
				System.out.println("Enter the username and password of the account which will be "
						+ "included as the second user of the joint account: ");
				Scanner scanner1 = new Scanner(System.in);

				String secondary_username = scanner1.nextLine();

				Scanner scanner2 = new Scanner(System.in);

				System.out.println("Password: ");

				String secondary_password = scanner2.nextLine();

				EncryptionService es = new EncryptionService();

				secondary_password = es.encryptor(secondary_password);

				CustomerLoginService cls = new CustomerLoginService();
				boolean x = cls.testLogin(username, password);

				if (x) {
					System.out.println("\nYour request has been successfuly created...");
					AccountService as = new AccountService();
					as.createSharedAccount(username, secondary_username);
					System.out.println("\nReturning to your main menu...");
					CustomerMainMenu cmm = new CustomerMainMenu();
					cmm.getMenu(username, password);
				}

				else {
					System.out.println(
							"\nIncorrect username and password combination. Attempt failed, returning to top of menu...");
					log.warn("Invalid input");
					CustomerApplicationMenu cam = new CustomerApplicationMenu();
					cam.getMenu(username, password);

				}

			}

			else if (s.equalsIgnoreCase("e")) {
				System.out.println("\nExiting to your main menu...");
				CustomerMainMenu cmm = new CustomerMainMenu();
				cmm.getMenu(username, password);
			}

			else {
				System.out.println("\nInvalid selection. Please select a, b or e...");
				log.warn("Invalid menu input");
				CustomerApplicationMenu cpm = new CustomerApplicationMenu();
				cpm.getMenu(username, password);
			}

		}

		scanner.close();
	}

}
