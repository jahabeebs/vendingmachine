package com.techelevator;

import java.math.BigDecimal;

public class Money {
	BigDecimal balance = new BigDecimal(0.00).setScale(2);
	private int quarters;
	private int dimes;
	private int nickels;
	private double balanceD;
	
	
	public void feedMoney (int feed) {
		if (feed == 1) {
			balance = balance.add(new BigDecimal (1.00));
		}
		else if (feed == 2) {
			balance = balance.add(new BigDecimal (2.00));
		}
		else if (feed == 5) {
			balance = balance.add(new BigDecimal (5.00));
		}
		System.out.println("BALANCE: " + balance);
	}
	
	public void makeChange(BigDecimal balance) {
		balanceD = (balance.doubleValue())*100;
		quarters = (int) (balanceD/25);
		balanceD = balanceD - (quarters*25);
		dimes = (int) (balanceD/10);
		balanceD = balanceD - (dimes*10);
		nickels = (int) (balanceD/5);
		balance = balance.multiply(new BigDecimal(0.00));
		
		System.out.println("CHANGE: "+ quarters + " quarters " + dimes + " dimes " + nickels + " nickels.");
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
