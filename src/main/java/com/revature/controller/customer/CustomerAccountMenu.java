package com.revature.controller.customer;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.controller.AccountController;
import com.revature.controller.Menu;
import com.revature.controller.manager.ManagerCustomerAccountsMenu;
import com.revature.controller.manager.ManagerMainMenu;
import com.revature.service.AccountService;

public class CustomerAccountMenu implements Menu {

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
		}
		else { 
			try { Integer.parseInt(s1);
					
			
		}
			catch(NumberFormatException e) {
				
				System.out.println("Invalid input exiting to top of menu...");
			}
			
		}
		int account_id = Integer.parseInt(s1);
		AccountService as = new AccountService();

		if (as.checkIDByUsername(account_id, username)) {
			System.out.println("type a to deposit, b to withdraw or c to exit to main menu");

			while (scanner.hasNext() == true) {
				String s = scanner.nextLine();

				if (s.equalsIgnoreCase("a")) {
					System.out.println("Enter the amount you would like to deposit:");
					try {
						int deposit = scanner.nextInt();
						as.makeDepositByID(account_id, deposit);
						System.out.println("New balance is: " + as.getBalanceID(account_id)
								+ " Returning to your main menu...");
						ManagerMainMenu mmm = new ManagerMainMenu();
						mmm.getMenu(username, password);
					} catch (InputMismatchException e) {
						System.out.println("Invalid input returning to menu top...");
						ManagerCustomerAccountsMenu mcam = new ManagerCustomerAccountsMenu();
						mcam.getMenu(username, password);
					}


				}

				else if (s.equalsIgnoreCase("b")) {
					System.out.println("Enter the amount you would like to withdraw:");
					try {
						int withdraw = scanner.nextInt();
						as.makeWithdrawByID(account_id, withdraw);
						System.out.println("New balance is: " + as.getBalanceID(account_id)
								+ " Returning to your main menu...");
						ManagerMainMenu mmm = new ManagerMainMenu();
						mmm.getMenu(username, password);
					} catch (InputMismatchException e) {
						System.out.println("Invalid input returning to menu top...");
						ManagerCustomerAccountsMenu mcam = new ManagerCustomerAccountsMenu();
						mcam.getMenu(username, password);
					}


				}

				else if (s.equalsIgnoreCase("c")) {

				

				}

				else {
					System.out.println("\nInvalid selection. Please select a, b or c...");
					CustomerAccountMenu cam = new CustomerAccountMenu();
					cam.getMenu(username, password);
				}

			}

			scanner.close();
		}
		else {
			System.out.println("You do not have access to that account, returning to top of menu... ");
		}

	}
}
