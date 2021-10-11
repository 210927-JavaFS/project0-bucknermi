package com.revature.controller.teller;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Menu;
import com.revature.service.login.DecryptionService;

public class TellerProfileMenu implements Menu {

	private static Logger log = LoggerFactory.getLogger(TellerProfileMenu.class);

	@Override
	public void getMenu(String username, String password) {

		DecryptionService ds = new DecryptionService();
		String dpassword = ds.decryptor(password);

		System.out.println("\nYour username is: " + username + " and your password is: " + dpassword
				+ "\nType e to exit to main menu");

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext() == true) {
			String s = scanner.nextLine();

			if (s.equalsIgnoreCase("e")) {
				TellerMainMenu tmm = new TellerMainMenu();
				tmm.getMenu(username, password);

			}

			else {
				System.out.println("\nInvalid selection. Please select a, b or c");
				log.warn("Invalid input");
				TellerProfileMenu tpm = new TellerProfileMenu();
				tpm.getMenu(username, password);
			}

		}
		scanner.close();

	}

}
