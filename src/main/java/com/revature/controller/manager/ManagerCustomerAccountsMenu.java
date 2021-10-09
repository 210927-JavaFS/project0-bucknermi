package com.revature.controller.manager;

import java.util.Scanner;

import com.revature.controller.AccountController;
import com.revature.controller.Menu;
import com.revature.service.AccountService;

public class ManagerCustomerAccountsMenu implements Menu {

	@Override
	public void getMenu(String username, String password) {
		System.out.println("Customer account information is: ");
		AccountController a = new AccountController();
		a.displayAllAccounts();
		System.out.println(
				"Enter the id of the customer whose account you would like to edit or type e to exit to main menu: ");
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext() == true) {
			String s = scanner.nextLine();

			if (s.equalsIgnoreCase("e")) {
				ManagerMainMenu mmm = new ManagerMainMenu();
				mmm.getMenu(username, password);
			}

			else {

				try {
					int account_id = Integer.parseInt(s);
					AccountService as = new AccountService();
					boolean y = as.getExistByID(account_id);
					if (y) {
						int z = as.getBalanceID(account_id);
						System.out.println("Current balance is" + z);
						System.out.println("A. Deposit \nB. Withdraw \nC. Transfer \nD. Exit to your maine menu");
						Scanner scanner3 = new Scanner(System.in);

						while (scanner3.hasNext() == true) {
							String s1 = scanner3.nextLine();

							if (s1.equalsIgnoreCase("a")) {

								System.out.println("Enter the amount you would like to deposit:");
								int deposit = scanner3.nextInt();
								as.makeDepositByID(account_id, deposit);
								System.out.println(as.getBalanceID(account_id));
							}

							else if (s1.equalsIgnoreCase("b")) {

							}

							else if (s1.equalsIgnoreCase("c")) {

							}

							else if (s1.equalsIgnoreCase("d")) {

								System.out.println("Exiting Program...");
								System.exit(0);

							}

							else {
								System.out.println("\nInvalid selection. Please select a, b or c");
								ManagerMainMenu mmm = new ManagerMainMenu();
								mmm.getMenu(username, password);
							}

						}
					}

				} catch (NumberFormatException e) {
					System.out.println("\nInvalid selection. Please select a valid customer id");
					ManagerCustomerAccountsMenu mcam = new ManagerCustomerAccountsMenu();
					mcam.getMenu(username, password);
				}

			}

		}

	}
}
