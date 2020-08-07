package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Money {

	static BigDecimal balance = new BigDecimal(0.00).setScale(2);
	private static int quarters;
	private static int dimes;
	private static int nickels;
	private static double balanceD;
	private static BigDecimal pastBalance = balance;
	
	
	public static void feedMoney (String feed) throws FileNotFoundException {
	
	
		if (feed.equals("$1 Bill")) {
			balance = balance.add(new BigDecimal (1.00));
		}
		else if (feed.equals("$2 Bill")) {
			balance = balance.add(new BigDecimal (2.00));
		}
		else if (feed.equals("$5 Bill")) {
			balance = balance.add(new BigDecimal (5.00));
		}
		writeLog("FEED MONEY", pastBalance, balance);
		System.out.println("BALANCE: " + balance);
	}
	
	public static void makeChange(BigDecimal balance) throws FileNotFoundException {
		BigDecimal balanceWas = balance;
		balanceD = (balance.doubleValue())*100;
		quarters = (int) (balanceD/25);
		balanceD = balanceD - (quarters*25);
		dimes = (int) (balanceD/10);
		balanceD = balanceD - (dimes*10);
		nickels = (int) (balanceD/5);
		balance = balance.multiply(new BigDecimal(0.00));
		writeLog("GIVE CHANGE", balanceWas, balance);
		
		System.out.println("CHANGE: "+ quarters + " quarters " + dimes + " dimes " + nickels + " nickels.");
	}
	
	
	//01/01/2016 12:00:00 PM FEED MONEY: $5.00 $5.00
	public static void writeLog (String transaction, BigDecimal was, BigDecimal currentBalance) throws FileNotFoundException {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");
		String formattedDate = dateTime.format(myFormatObj);
		
		
		try(PrintWriter log = new PrintWriter(new FileOutputStream(new File("Log.txt"), true))) {
			log.println(formattedDate + " " + transaction + " " + was + " " + currentBalance);
		}
	}
	

	public static void buyItem (String itemCode) throws FileNotFoundException {

		//If the item code doesn't match a key to the vendMap, then print CODE INVALID
		if (!Items.vendMap.containsKey(itemCode)) {
			System.out.println("CODE INVALID");
		}
		//If the item code DOES match a key to the vendMap, then compare the balance to the item price
		if (Items.vendMap.containsKey(itemCode)) {
			//If balance is LESS THAN price, then say INSUFFICIENT FUNDS
			if (balance.compareTo(Items.vendMapPrice.get(itemCode))==-1) {
				System.out.println("INSUFFICIENT FUNDS");
			}
			//If the stock of the item is 0, then say OUT OF STOCK
			else if (Items.vendMapStock.get(itemCode)==0) {
				System.out.println("OUT OF STOCK");
			}
			//IF balance is GREATER THAN OR EQUAL to price, then
			else if (balance.compareTo(Items.vendMapPrice.get(itemCode))==1 || (balance.compareTo(Items.vendMapPrice.get(itemCode))==0)) {
				//Balance gets updated, balance - price
				BigDecimal wasBalance = balance;
				balance = balance.subtract(Items.vendMapPrice.get(itemCode));
				//Stock of item reduces by 1
				Items.vendMapStock.put(itemCode, Items.vendMapStock.get(itemCode)-1);
				//Updates the log with item name, initial balance, and current balance
				writeLog(Items.vendMapName.get(itemCode), wasBalance, balance);
					if (Items.vendMapType.get(itemCode).equals("Chip")) {
						Chips.getMessage();
					}
					else if (Items.vendMapType.get(itemCode).equals("Candy")) {
						Candy.getMessage();
					}
					else if (Items.vendMapType.get(itemCode).equals("Drink")) {
						Drink.getMessage();
					}
					else {
						Gum.getMessage();
					}
			}
		}
	}
	
	
	
}
		
		
		
		
		
		
		
		
		//This says "While balance is greater than 0.00"
//		while (balance.compareTo(new BigDecimal (0.00))==1) {
			//This says "If balance % 25 == 0"
//			if (balance.remainder(new BigDecimal(0.25)).compareTo(new BigDecimal(0.00))==0) {
//				quarters = balance.doubleValue()/0.25;
//				balance = balance.divide(new BigDecimal (0.25));	
//			}
			//This says "If balance % 25 > 0"
//			else if (balance.remainder(new BigDecimal(0.25)).compareTo(new BigDecimal(0.00))==1) {
				
		//	}
		//}
