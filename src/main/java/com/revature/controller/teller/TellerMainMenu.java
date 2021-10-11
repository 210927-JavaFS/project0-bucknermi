package com.revature.controller.teller;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Menu;

public class TellerMainMenu implements Menu {

	private static Logger log = LoggerFactory.getLogger(TellerMainMenu.class);

	@Override
	public void getMenu(String username, String password) {

		System.out.println("\nHello and welcome to your account homepage. Please select an option from below:"
				+ "\nA. Personal Profile Information \nB. Edit customer accounts \nE. Exit ");

		Scanner scanner2 = new Scanner(System.in);

		while (scanner2.hasNext() == true) {
			String s = scanner2.nextLine();

			if (s.equalsIgnoreCase("a")) {

				TellerProfileMenu tpm = new TellerProfileMenu();
				tpm.getMenu(username, password);

			}

			else if (s.equalsIgnoreCase("b")) {

				TellerCustomerAccountsMenu tcam = new TellerCustomerAccountsMenu();
				tcam.getMenu(username, password);

			}

			else if (s.equalsIgnoreCase("E")) {

				System.out.println("Exiting Program...");
				log.info("Program exited");
				System.exit(0);
			}

			else {
				System.out.println("\nInvalid selection. Please select a, b or e...");
				log.warn("Invalid input");
				TellerMainMenu tmm = new TellerMainMenu();
				tmm.getMenu(username, password);
			}

		}
		scanner2.close();
	}

}
