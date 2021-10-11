package com.revature.controller.manager;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.AccountController;
import com.revature.controller.Menu;
import com.revature.controller.customer.CustomerAccountMenu;
import com.revature.service.AccountService;

public class ManagerCustomerAccountsMenu implements Menu {

	private static Logger log = LoggerFactory.getLogger(ManagerCustomerAccountsMenu.class);

	@Override
	public void getMenu(String username, String password) {
		System.out.println("\nCustomer account information is: ");
		AccountController a = new AccountController();
		a.displayAllAccounts();
		System.out.println("\nEnter the ID of the account you would like to edit or type E to exit to main menu: ");
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
						System.out.println("\nCurrent balance is " + z);
						System.out.println("\nA. Deposit \nB. Withdraw \nC. Transfer \nD. Exit to your main menu");
						Scanner scanner3 = new Scanner(System.in);

						while (scanner3.hasNext() == true) {
							String s1 = scanner3.nextLine();

							if (s1.equalsIgnoreCase("a")) {

								System.out.println("\nEnter the number of gold coins you would like to deposit:");
								try {
									int deposit = scanner3.nextInt();
									if (deposit < 0) {
										System.out.println(
												"\nYou cannot deposit a negative amount, returning to top of menu...");
										log.warn("Invalid input");
										CustomerAccountMenu cam = new CustomerAccountMenu();
										cam.getMenu(username, password);
									} else {
										as.makeDepositByID(account_id, deposit);
										System.out.println("\nBalance is: " + as.getBalanceID(account_id)
												+ ", returning to your main menu...");
										ManagerMainMenu mmm = new ManagerMainMenu();
										mmm.getMenu(username, password);
									}
								} catch (InputMismatchException e) {
									System.out.println("\nInvalid input returning to menu top...");
									log.warn("Invalid input");
									ManagerCustomerAccountsMenu mcam = new ManagerCustomerAccountsMenu();
									mcam.getMenu(username, password);
								}
							}

							else if (s1.equalsIgnoreCase("b")) {

								System.out.println("\nEnter the number of gold coins would like to withdraw:");
								try {
									int withdraw = scanner3.nextInt();
									if (withdraw < 0) {
										System.out.println(
												"You cannot withdraw a negative amount, returning to top of menu...");
										log.warn("Invalid input");
										CustomerAccountMenu cam = new CustomerAccountMenu();
										cam.getMenu(username, password);
									} else {
										as.makeWithdrawByID(account_id, withdraw);
										System.out.println("\nBalance is: " + as.getBalanceID(account_id)
												+ ", returning to your main menu...");
										ManagerMainMenu mmm = new ManagerMainMenu();
										mmm.getMenu(username, password);
									}
								} catch (InputMismatchException e) {
									System.out.println("\nInvalid input returning to menu top...");
									log.warn("Invalid input");
									ManagerCustomerAccountsMenu mcam = new ManagerCustomerAccountsMenu();
									mcam.getMenu(username, password);
								}

							}

							else if (s1.equalsIgnoreCase("c")) {
								System.out.println("\nEnter the ID of the account you would like to transfer into: ");
								String s2 = scanner.nextLine();
								try {
									int account_id2 = Integer.parseInt(s2);
									boolean y2 = as.getExistByID(account_id2);
									if (y2) {
										System.out.println(
												"\nEnter the number of gold coins you would like to transfer:");
										try {
											int transfer = scanner3.nextInt();
											if (transfer < 0) {
												System.out.println(
														"\nYou cannot transfer a negative amount, returning to top of menu...");
												log.warn("Invalid input");
												CustomerAccountMenu cam = new CustomerAccountMenu();
												cam.getMenu(username, password);
											} else {
												as.makeWithdrawByID(account_id, transfer);
												as.makeDepositByID(account_id2, transfer);
												System.out.println("\nBalance for account transferred into: ");
												System.out.println(as.getBalanceID(account_id2));
												System.out.println("\nand balance for account transferring from: ");
												System.out.println(as.getBalanceID(account_id));
												System.out.println("\nReturning to your main menu...");
												ManagerMainMenu mmm = new ManagerMainMenu();
												mmm.getMenu(username, password);
											}
										} catch (InputMismatchException e) {
											System.out.println("\nInvalid input returning to menu top...");
											log.warn("Invalid input");
											ManagerCustomerAccountsMenu mcam = new ManagerCustomerAccountsMenu();
											mcam.getMenu(username, password);
										}

									}

									else {
										System.out.println(
												"\nInvalid selection. Please select a valid customer id returning"
														+ "to top of menu...");
										log.warn("Invalid input");
										ManagerCustomerAccountsMenu mcam = new ManagerCustomerAccountsMenu();
										mcam.getMenu(username, password);
									}
								} catch (InputMismatchException e) {
									System.out.println("\nInvalid input returning to menu top...");
									log.warn("Invalid input");
									ManagerCustomerAccountsMenu mcam = new ManagerCustomerAccountsMenu();
									mcam.getMenu(username, password);
								}

							}

							else if (s1.equalsIgnoreCase("d")) {

								System.out.println("Exiting to main menu...");
								ManagerMainMenu mmm = new ManagerMainMenu();
								mmm.getMenu(username, password);

							}

							else {
								System.out.println("\nInvalid selection. Please select a, b or c...");
								log.warn("Invalid input");
								ManagerMainMenu mmm = new ManagerMainMenu();
								mmm.getMenu(username, password);
							}

						}
					}

				} catch (NumberFormatException e) {
					System.out.println(
							"\nInvalid selection. Please select a valid customer id returning to top of menu...");
					log.warn("Invalid input");
					ManagerCustomerAccountsMenu mcam = new ManagerCustomerAccountsMenu();
					mcam.getMenu(username, password);
				}

			}

		}

	}
}
