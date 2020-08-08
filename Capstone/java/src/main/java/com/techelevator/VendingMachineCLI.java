package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.techelevator.view.Menu;

public class VendingMachineCLI {
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String[] PURCHASE_MENU = {"Feed Money", "Select Product","Get Change", "Back"};
	private static final String[] MONEY_MENU = {"$1 Bill", "$2 Bill", "$5 Bill", "Back"};
	private static List <String> vendingMachineItemMenu = new ArrayList <String>();
	private static final String[] BACK_BUTTON = {"Back"};

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		Items.readFiles();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayVendingMachineItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				processPurchaseMenuOptions();
			}
		}
	}

	private void displayVendingMachineItems() throws FileNotFoundException {
		File vendItems = new File("vendingmachine.csv");
		try (Scanner vendReader = new Scanner(vendItems)) {
			while (vendReader.hasNextLine()) {
				String vendLine = vendReader.nextLine();
				VendingMachineCLI.vendingMachineItemMenu.add(vendLine);
			}
			for (String s : VendingMachineCLI.vendingMachineItemMenu) {
				System.out.println(s);
			}
		}
		String choice = (String) menu.getChoiceFromOptions(BACK_BUTTON);
	}


	private void processPurchaseMenuOptions() throws FileNotFoundException {
		String purchaseMenuOption = "";
		while (!purchaseMenuOption.contentEquals("Back")) {
			purchaseMenuOption = (String) menu.getChoiceFromOptions(PURCHASE_MENU);
			if (purchaseMenuOption.contentEquals("Feed Money")) {
				processMoneyFeed();
			}
			else if (purchaseMenuOption.equals("Select Product")) {
				processProductSelection();
			}
			else if (purchaseMenuOption.contentEquals("Get Change")) {
				Money.makeChange(Money.getBalance());
			}
		}
	}

	private void processProductSelection() throws FileNotFoundException {	
			Set<String> vendMapKeys = Items.vendMap.keySet();
			for (String key : vendMapKeys) {
				System.out.println(Items.vendMap.get(key) + "|" + Items.vendMapStock.get(key) + " Left");
			}
			System.out.println("1) Back");
			Scanner userInput = new Scanner(System.in);
			String itemCode = userInput.nextLine();
			if (itemCode.equals("1")) {
				processPurchaseMenuOptions();
			}
			else {
			Money.buyItem(itemCode);
			processProductSelection();
			}
	}

	private void processMoneyFeed() throws FileNotFoundException {
		String feedOptions = "";
		while (!feedOptions.contentEquals("Back")) {
			feedOptions = (String) menu.getChoiceFromOptions(MONEY_MENU);
			System.out.println(feedOptions);
			Money.feedMoney(feedOptions);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
