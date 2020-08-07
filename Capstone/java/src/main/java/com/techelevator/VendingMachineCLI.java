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
	private static final String[] PURCHASE_MENU = {"Feed Money", "Select Product", "Back"};
	private static final String[] MONEY_MENU = {"$1 Bill", "$2 Bill", "$5 Bill", "Back"};
	private static List <String> vendingMachineItemMenu = new ArrayList <String>();
	private static String [] vendingMachineItemMenuArray = new String [1];
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
		String vendingMachineItemMenu = "";
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
		if (choice.equals(BACK_BUTTON)) {
			run();
		}
	}

		
		
		
//		String vendingMachineItemMenu = "";
//		while (!vendingMachineItemMenu.contentEquals("Back")) {
//			vendingMachineItemMenu = (String) menu.getChoiceFromOptions(VENDING_MACHINE_ITEMS);
//		}
//	}


	private void processPurchaseMenuOptions() throws FileNotFoundException {
		String purchaseMenuOption = "";
		String productSelection = "";
		while (!purchaseMenuOption.contentEquals("Back")) {
			purchaseMenuOption = (String) menu.getChoiceFromOptions(PURCHASE_MENU);
			if (purchaseMenuOption.contentEquals("Feed Money")) {
				processMoneyFeed();
			}
			else if (purchaseMenuOption.equals("Select Product")) {	
				System.out.println("Enter the product code: ");
			//	System.out.println(Items.vendMap.get());
				Set<String> vendMapKeys = Items.vendMap.keySet();
				System.out.println(vendMapKeys);
				for (String key : vendMapKeys) {
					System.out.println(Items.vendMap.get(key));
				}
					}
				}
			}
				
				
				
				
				//displayVendingMachineItems();
				//getItem()...should be in Item class?
				/*	public void getItem()
				 *  	match product code (not item number) selected to item in vendMap
				 *  		if doesn't exist return customer to purchase menu
				 *  	ensure sufficient funds for item
				 *  	dispense item and print item name, cost, money remaining
				 *  	print crunch/munch/glug/chew
				 */		
				//Get user input and match it to an item on VENDING_MACHINE_ITEMS

	private void processMoneyFeed() {
		String feedOptions = "";
		while (!feedOptions.contentEquals("Back"))
		feedOptions = (String) menu.getChoiceFromOptions(MONEY_MENU);
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
