package com.revature.controller.teller;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Menu;
import com.revature.service.AccountService;
import com.revature.service.login.DecryptionService;

public class TellerProfileMenu implements Menu {

	private static Logger log = LoggerFactory.getLogger(TellerProfileMenu.class);

	@Override
	public void getMenu(String username, String password) {

		DecryptionService ds = new DecryptionService();
		String dpassword = ds.decryptor(password);
		AccountService as = new AccountService();
		int teller_id = as.getTellerIDByUsername(username);

		System.out.println("\nYour username is: " + username + ", your password is: " + dpassword
				+ " and your teller ID is: " + teller_id + "\nType E to exit to main menu");

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext() == true) {
			String s = scanner.nextLine();

			if (s.equalsIgnoreCase("e")) {
				TellerMainMenu tmm = new TellerMainMenu();
				tmm.getMenu(username, password);

			}

			else {
				System.out.println("\nInvalid selection. Please select e. Returning to top of menu...");
				log.warn("Invalid input");
				TellerProfileMenu tpm = new TellerProfileMenu();
				tpm.getMenu(username, password);
			}

		}
		scanner.close();

	}

}
