package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Items {
	private String name;
	private BigDecimal price;
	private int inventory = 5;
	
	static String b1Info = vendMap.get("B1");
	static String [] b1Array = b1Info.split("\\|");
	static String b1name = b1Array[1];
	static BigDecimal b1Price = new BigDecimal(b1Array[2]);
	static int b1Inventory = new Integer(5);
	
	static String b2Info = vendMap.get("B2");
	static String [] b2Array = b2Info.split("\\|");
	static String b2name = b2Array[1];
	static BigDecimal b2Price = new BigDecimal(b2Array[2]);
	static int b2Inventory = new Integer(5);
	
	static String b3Info = vendMap.get("B3");
	static String [] b3Array = b3Info.split("\\|");
	static String b3name = b3Array[1];
	static BigDecimal b3Price = new BigDecimal(b3Array[2]);
	static int b3Inventory = new Integer(5);
	
	static String b4Info = vendMap.get("B4");
	static String [] b4Array = b4Info.split("\\|");
	static String b4name = b4Array[1];
	static BigDecimal b4Price = new BigDecimal(b4Array[2]);
	static int b4Inventory = new Integer(5);
	
	public static String getMessage() {
		return "Munch Munch, Yum!";
	}
	
	public int getInventory() {
		return inventory;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}
}
