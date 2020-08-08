package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Money {

	public static BigDecimal balance = new BigDecimal(0.00).setScale(2);
	private static int quarters;
	private static int dimes;
	private static int nickels;
	private static double balanceD;
	private static BigDecimal pastBalance = balance;
	
	
	public static BigDecimal getBalance() {
		return Money.balance;
	}
	
	
	
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
		Money.balance = balance.multiply(new BigDecimal(0.00));
		writeLog("GIVE CHANGE", balanceWas, balance);
		balanceWas = balanceWas.multiply(new BigDecimal(0.00));
		System.out.println("CHANGE: "+ quarters + " quarters " + dimes + " dimes " + nickels + " nickels.");
	}
	
	
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
				System.out.println("Enjoy your "+Items.vendMapName.get(itemCode)+"! \n"+"BALANCE: "+balance);	
				if (itemCode.contains("A")) {
						Chips.getMessage();
					}
					else if (itemCode.contains("B")) {
						Candy.getMessage();
					}
					else if (itemCode.contains("C")) {
						Drink.getMessage();
					}
					else {
						Gum.getMessage();
					}
			}
		}
	}
	
	
	
}
		