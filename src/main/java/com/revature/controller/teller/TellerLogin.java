package com.revature.controller.teller;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.EntryMenu;
import com.revature.controller.Login;
import com.revature.service.login.EncryptionService;
import com.revature.service.login.TellerLoginService;

public class TellerLogin extends Login {

	private static Logger log = LoggerFactory.getLogger(TellerLogin.class);

	@Override
	public void getLogin() {

		System.out.println("\nPlease enter your username and password: \nUsername: ");

		Scanner scanner1 = new Scanner(System.in);

		username = scanner1.nextLine();

		Scanner scanner2 = new Scanner(System.in);

		System.out.println("Password: ");

		password = scanner2.nextLine();

		EncryptionService es = new EncryptionService();

		password = es.encryptor(password);

		TellerLoginService tls = new TellerLoginService();
		boolean x = tls.testLogin(username, password);

		if (x) {
			System.out.println("\nSuccesful login. Redirecting to your main menu...");
			TellerMainMenu tmm = new TellerMainMenu();
			tmm.getMenu(username, password);
		}

		else {
			System.out.println("\nIncorrect username and password combination. Returning to main menu...");
			log.warn("Teller login attempt failed");
			EntryMenu em = new EntryMenu();
			em.getMenu(username, password);
		}

	}
}
