package com.revature.controller.manager;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Menu;

public class ManagerMainMenu implements Menu {

	private static Logger log = LoggerFactory.getLogger(ManagerMainMenu.class);

	@Override
	public void getMenu(String username, String password) {

		System.out.println("\nHello and welcome to your account homepage. Please select an option from below:"
				+ "\nA. Personal profile information \nB. View/Edit customer accounts \nC. Review account requests \nD. Exit ");

		Scanner scanner3 = new Scanner(System.in);

		while (scanner3.hasNext() == true) {
			String s = scanner3.nextLine();

			if (s.equalsIgnoreCase("a")) {
				ManagerProfileMenu mpm = new ManagerProfileMenu();
				mpm.getMenu(username, password);

			}

			else if (s.equalsIgnoreCase("b")) {

				ManagerCustomerAccountsMenu mcam = new ManagerCustomerAccountsMenu();
				mcam.getMenu(username, password);

			}

			else if (s.equalsIgnoreCase("c")) {

				ManagerApplicationMenu mam = new ManagerApplicationMenu();
				mam.getMenu(username, password);

			}

			else if (s.equalsIgnoreCase("d")) {

				System.out.println("\nExiting Program...");
				log.info("Program exited");
				System.exit(0);

			}

			else {
				System.out.println("\nInvalid selection. Please select a, b or c");
				log.warn("Invalid input");
				ManagerMainMenu mmm = new ManagerMainMenu();
				mmm.getMenu(username, password);
			}

		}
		scanner3.close();
	}

}
