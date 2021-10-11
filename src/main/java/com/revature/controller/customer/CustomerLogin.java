package com.revature.controller.customer;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.EntryMenu;
import com.revature.controller.Login;
import com.revature.service.login.CustomerLoginService;
import com.revature.service.login.EncryptionService;

public class CustomerLogin extends Login {

	private static Logger log = LoggerFactory.getLogger(CustomerLogin.class);

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

		CustomerLoginService cls = new CustomerLoginService();
		boolean x = cls.testLogin(username, password);

		if (x) {
			System.out.println("\nSuccesful login. Redirecting to your main menu...");
			CustomerMainMenu cmm = new CustomerMainMenu();
			cmm.getMenu(username, password);
		}

		else {
			System.out.println("\nIncorrect username and password combination. Returning to main menu...");
			log.warn("Customer login attempt faild");
			EntryMenu em = new EntryMenu();
			em.getMenu(username, password);

		}

	}

}
