package com.revature.controller.customer;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.AccountController;
import com.revature.controller.Menu;


import com.revature.service.AccountService;

public class CustomerAccountMenu implements Menu {

	private static Logger log = LoggerFactory.getLogger(CustomerAccountMenu.class);

	@Override
	public void getMenu(String username, String password) {

		AccountController ac = new AccountController();
		System.out.println("The information on your current accounts is: ");
		ac.displayByUsername(username);

		System.out.println("Enter the id of the account you would like to edit or type e to exit: ");
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		if (s1.equalsIgnoreCase("e")) {
			System.out.println("Exiting to main menu...");
			CustomerMainMenu cmm = new CustomerMainMenu();
			cmm.getMenu(username, password);
		} else {
			try {
				Integer.parseInt(s1);

			} catch (NumberFormatException e) {

				System.out.println("Invalid input exiting to top of menu...");
				log.warn("Invalid input");
				CustomerAccountMenu cam = new CustomerAccountMenu();
				cam.getMenu(username, password);
			}

		}
		int account_id = Integer.parseInt(s1);
		AccountService as = new AccountService();

		if (as.checkIDByUsername(account_id, username)) {
			System.out.println(
					"type a to deposit, b to withdraw, c to transfer money to another account or e to exit to main menu");

			while (scanner.hasNext() == true) {
				String s = scanner.nextLine();

				if (s.equalsIgnoreCase("a")) {
					System.out.println("Enter the amount you would like to deposit:");
					try {
						int deposit = scanner.nextInt();
						if (deposit < 0) {
							System.out.println("You cannot deposit a negative amount, returning to top of menu...");
							log.warn("Invalid input");
							CustomerAccountMenu cam = new CustomerAccountMenu();
							cam.getMenu(username, password);
						} else {
							as.makeDepositByID(account_id, deposit);
							System.out.println("New balance is: " + as.getBalanceID(account_id)
									+ " Returning to your main menu...");
							CustomerMainMenu mmm = new CustomerMainMenu();
							mmm.getMenu(username, password);
						}
					} catch (InputMismatchException e) {
						System.out.println("Invalid input returning to menu top...");
						log.warn("Invalid input");
						CustomerAccountMenu mcam = new CustomerAccountMenu();
						mcam.getMenu(username, password);
					}

				}

				else if (s.equalsIgnoreCase("b")) {
					System.out.println("Enter the amount you would like to withdraw:");
					try {
						int withdraw = scanner.nextInt();
						if (withdraw < 0) {
							System.out.println("You cannot withdraw a negative amount, returning to top of menu...");
							log.warn("Invalid input");
							CustomerAccountMenu cam = new CustomerAccountMenu();
							cam.getMenu(username, password);
						} else {
							as.makeWithdrawByID(account_id, withdraw);
							System.out.println("New balance is: " + as.getBalanceID(account_id)
									+ " Returning to your main menu...");
							CustomerMainMenu mmm = new CustomerMainMenu();
							mmm.getMenu(username, password);
						}
					} catch (InputMismatchException e) {
						System.out.println("Invalid input returning to menu top...");
						log.warn("Invalid input");
						CustomerAccountMenu mcam = new CustomerAccountMenu();
						mcam.getMenu(username, password);
					}

				}

				else if (s.equalsIgnoreCase("c")) {
					System.out.println("Enter the ID of the account you would like to transfer into: ");
					String s2 = scanner.nextLine();
					try {
						int account_id2 = Integer.parseInt(s2);
						boolean y2 = as.getExistByID(account_id2);
						if (y2) {
							System.out.println("Enter the amount you would like to transfer:");
							try {
								int transfer = scanner.nextInt();
								if (transfer < 0) {
									System.out.println(
											"You cannot transfer a negative amount, returning to top of menu...");
									CustomerAccountMenu cam = new CustomerAccountMenu();
									cam.getMenu(username, password);
								} else {
									as.makeWithdrawByID(account_id, transfer);
									as.makeDepositByID(account_id2, transfer);
									System.out.println("new balance for account transferred into: ");
									System.out.println(as.getBalanceID(account_id2));
									System.out.println("and new balance for account transferring from: ");
									System.out.println(as.getBalanceID(account_id));
									System.out.println("Returning to your main menu...");
									CustomerMainMenu mmm = new CustomerMainMenu();
									mmm.getMenu(username, password);
								}
							} catch (InputMismatchException e) {
								System.out.println("Invalid input returning to menu top...");
								log.warn("Invalid input");
								CustomerAccountMenu mcam = new CustomerAccountMenu();
								mcam.getMenu(username, password);
							}

						}

						else {
							System.out.println("\nInvalid selection. Please select a valid customer id returning"
									+ "to top of menu...");
							log.warn("Invalid input");
							CustomerAccountMenu mcam = new CustomerAccountMenu();
							mcam.getMenu(username, password);
						}
					} catch (InputMismatchException e) {
						System.out.println("Invalid input returning to menu top...");
						log.warn("Invalid input");
						CustomerAccountMenu mcam = new CustomerAccountMenu();
						mcam.getMenu(username, password);
					}

				}

				else {
					System.out.println("\nInvalid selection. Please select a, b or c...");
					log.warn("Invalid input");
					CustomerAccountMenu cam = new CustomerAccountMenu();
					cam.getMenu(username, password);
				}

			}

			scanner.close();
		} else {
			System.out.println("You do not have access to that account, returning to top of menu... ");
			log.warn("Invalid input");
			CustomerAccountMenu cam = new CustomerAccountMenu();
			cam.getMenu(username, password);
		}

	}
}
