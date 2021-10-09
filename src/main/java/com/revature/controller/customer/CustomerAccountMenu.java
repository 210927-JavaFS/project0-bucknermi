package com.revature.controller.customer;

import java.util.Scanner;

import com.revature.controller.AccountController;
import com.revature.controller.Menu;
import com.revature.service.AccountService;

public class CustomerAccountMenu implements Menu {

	@Override
	public void getMenu(String username, String password) {

		AccountController ac = new AccountController();
		System.out.println("The information on your current accounts is: ");
		ac.displayByUsername(username);

		System.out.println("Enter the id of the account you would like to edit: ");
		Scanner scanner = new Scanner(System.in);
		int account_id = scanner.nextInt();
		AccountService as = new AccountService();

		if (as.checkIDByUsername(account_id, username)) {
			System.out.println("type a to deposit, b to withdraw or c to exit to main menu");

			while (scanner.hasNext() == true) {
				String s = scanner.nextLine();

				if (s.equalsIgnoreCase("a")) {

				}

				else if (s.equalsIgnoreCase("b")) {

				}

				else if (s.equalsIgnoreCase("c")) {

					CustomerMainMenu cmm = new CustomerMainMenu();
					cmm.getMenu(username, password);

				}

				else {
					System.out.println("\nInvalid selection. Please select a, b or c");
					CustomerAccountMenu cam = new CustomerAccountMenu();
					cam.getMenu(username, password);
				}

			}

			scanner.close();
		}
		else {
			System.out.println("You do not have access to that account, returning to main menu: ");
		}

	}
}
