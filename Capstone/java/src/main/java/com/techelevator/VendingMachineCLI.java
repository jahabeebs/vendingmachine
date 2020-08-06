package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String[] PURCHASE_MENU = {"Feed Money", "Select Product", "Back"};
	private static final String[] MONEY_MENU = {"$1 Bill", "$2 Bill", "$5 Bill", "Back"};
	private static final String[] VENDING_MACHINE_ITEMS = { //We need to add inventory stock to each string
			"A1|Potato Crisps|3.05|Chip",
			"A2|Stackers|1.45|Chip",
			"A3|Grain Waves|2.75|Chip",
			"A4|Cloud Popcorn|3.65|Chip",
			"B1|Moonpie|1.80|Candy",
			"B2|Cowtales|1.50|Candy",
			"B3|Wonka Bar|1.50|Candy",
			"B4|Crunchie|1.75|Candy",
			"C1|Cola|1.25|Drink",
			"C2|Dr. Salt|1.50|Drink",
			"C3|Mountain Melter|1.50|Drink",
			"C4|Heavy|1.50|Drink",
			"D1|U-Chews|0.85|Gum",
			"D2|Little League Chew|0.95|Gum",
			"D3|Chiclets|0.75|Gum",
			"D4|Triplemint|0.75|Gum",
			"Back"
	};
	
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayVendingMachineItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				processPurchaseMenuOptions();
			}
		}
	}

	private void displayVendingMachineItems() {
		String vendingMachineItemChoice = "";
		while (!vendingMachineItemChoice.contentEquals("Back")) {
			vendingMachineItemChoice = (String) menu.getChoiceFromOptions(VENDING_MACHINE_ITEMS);
			//Read user input and match it to an item on VENDING_MACHINE_ITEMS
		}
	}

	private void processPurchaseMenuOptions() {
		String purchaseMenuOption = "";
		while (!purchaseMenuOption.contentEquals("Back")) {
			purchaseMenuOption = (String) menu.getChoiceFromOptions(PURCHASE_MENU);
			if (purchaseMenuOption.equals("Feed Money")) {
				processMoneyFeed();
			}
			else if (purchaseMenuOption.equals("Select Product")) {
				displayVendingMachineItems();
				//Get user input and match it to an item on VENDING_MACHINE_ITEMS
			}
		}
	}

	private void processMoneyFeed() {
		String feedOptions = "";
		while (!feedOptions.contentEquals("Back"))
		feedOptions = (String) menu.getChoiceFromOptions(MONEY_MENU);
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
