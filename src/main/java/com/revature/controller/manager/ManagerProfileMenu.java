package com.revature.controller.manager;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Menu;
import com.revature.service.AccountService;
import com.revature.service.login.DecryptionService;

public class ManagerProfileMenu implements Menu {

	private static Logger log = LoggerFactory.getLogger(ManagerProfileMenu.class);

	@Override
	public void getMenu(String username, String password) {

		DecryptionService ds = new DecryptionService();
		String dpassword = ds.decryptor(password);
		AccountService as = new AccountService();
		int account_id = as.getManagerIDByUsername(username);
		System.out.println("\nYour username is: " + username + ", your password is: " + dpassword
				+ " and your manager ID is: " + account_id + "\nType E to exit to main menu");

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext() == true) {
			String s = scanner.nextLine();

			if (s.equalsIgnoreCase("e")) {
				ManagerMainMenu mmm = new ManagerMainMenu();
				mmm.getMenu(username, password);

			}

			else {
				System.out.println("\nInvalid selection. Please select e. Returning to top of menu...");
				log.warn("Invalid input");
				ManagerProfileMenu mpm = new ManagerProfileMenu();
				mpm.getMenu(username, password);
			}

		}
		scanner.close();

	}

}
