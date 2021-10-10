package com.revature.controller.teller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.controller.AccountController;
import com.revature.controller.Menu;
import com.revature.controller.customer.CustomerAccountMenu;
import com.revature.service.AccountService;

public class TellerCustomerAccountsMenu implements Menu {

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
				TellerMainMenu tmm = new TellerMainMenu();
				tmm.getMenu(username, password);
			}

			else {

				try {
					int account_id = Integer.parseInt(s);
					AccountService as = new AccountService();
					boolean y = as.getExistByID(account_id);
					if (y) {
						int z = as.getBalanceID(account_id);
						System.out.println("Current balance is " + z);
						System.out.println("A. Deposit \nB. Withdraw \nC. Transfer \nD. Exit to your main menu");
						Scanner scanner3 = new Scanner(System.in);

						while (scanner3.hasNext() == true) {
							String s1 = scanner3.nextLine();

							if (s1.equalsIgnoreCase("a")) {

								System.out.println("Enter the amount you would like to deposit:");
								try {
									int deposit = scanner3.nextInt();
									if(deposit<0) {
										System.out.println("You cannot deposit a negative amount, returning to top of menu...");
										CustomerAccountMenu cam = new CustomerAccountMenu();
										cam.getMenu(username, password);
									}
									else {
									as.makeDepositByID(account_id, deposit);
									System.out.println("New balance is: " + as.getBalanceID(account_id)
											+ " Returning to your main menu...");
									TellerMainMenu tmm = new TellerMainMenu();
									tmm.getMenu(username, password);}
								} catch (InputMismatchException e) {
									System.out.println("Invalid input returning to menu top...");
									TellerCustomerAccountsMenu tcam = new TellerCustomerAccountsMenu();
									tcam.getMenu(username, password);
								}
							}

							else if (s1.equalsIgnoreCase("b")) {

								System.out.println("Enter the amount you would like to withdraw:");
								try {
									int withdraw = scanner3.nextInt();
									if(withdraw<0) {
										System.out.println("You cannot withdraw a negative amount, returning to top of menu...");
										CustomerAccountMenu cam = new CustomerAccountMenu();
										cam.getMenu(username, password);
									}
									else {
									as.makeWithdrawByID(account_id, withdraw);
									System.out.println("New balance is: " + as.getBalanceID(account_id)
											+ " Returning to your main menu...");
									TellerMainMenu tmm = new TellerMainMenu();
									tmm.getMenu(username, password);}
								} catch (InputMismatchException e) {
									System.out.println("Invalid input returning to menu top...");
									TellerCustomerAccountsMenu tcam = new TellerCustomerAccountsMenu();
									tcam.getMenu(username, password);
								}

							}

							else if (s1.equalsIgnoreCase("c")) {
								System.out.println("Enter the ID of the account you would like to transfer into: ");
								String s2 = scanner.nextLine();
								try {
									int account_id2 = Integer.parseInt(s2);
									boolean y2 = as.getExistByID(account_id2);
									if (y2) {
										System.out.println("Enter the amount you would like to transfer:");
										try {
											int transfer = scanner3.nextInt();
											if(transfer<0) {
												System.out.println("You cannot transfer a negative amount, returning to top of menu...");
												CustomerAccountMenu cam = new CustomerAccountMenu();
												cam.getMenu(username, password);
											}
											else {
											as.makeWithdrawByID(account_id, transfer);
											as.makeDepositByID(account_id2, transfer);
											System.out.println("new balance for account transferred into: ");
											System.out.println(as.getBalanceID(account_id2));
											System.out.println("and new balance for account transferring from: ");
											System.out.println(as.getBalanceID(account_id));
											System.out.println("Returning to your main menu...");
											TellerMainMenu tmm = new TellerMainMenu();
											tmm.getMenu(username, password);}
										} catch (InputMismatchException e) {
											System.out.println("Invalid input returning to menu top...");
											TellerCustomerAccountsMenu tcam = new TellerCustomerAccountsMenu();
											tcam.getMenu(username, password);
										}

									}

									else {
										System.out.println(
												"\nInvalid selection. Please select a valid customer id returning"
														+ "to top of menu...");
										TellerCustomerAccountsMenu mcam = new TellerCustomerAccountsMenu();
										mcam.getMenu(username, password);
									}
								} catch (InputMismatchException e) {
									System.out.println("Invalid input returning to menu top...");
									TellerCustomerAccountsMenu tcam = new TellerCustomerAccountsMenu();
									tcam.getMenu(username, password);
								}

							}

							else if (s1.equalsIgnoreCase("d")) {

								System.out.println("Exiting Program...");
								System.exit(0);

							}

							else {
								System.out.println("\nInvalid selection. Please select a, b or c...");
								TellerMainMenu tmm = new TellerMainMenu();
								tmm.getMenu(username, password);
							}

						}
					}

				} catch (NumberFormatException e) {
					System.out.println(
							"\nInvalid selection. Please select a valid customer id returning to top of menu...");
					TellerCustomerAccountsMenu tcam = new TellerCustomerAccountsMenu();
					tcam.getMenu(username, password);
				}

			}

		}

	}
}
