package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Items{
	
	private String name;
	private BigDecimal price;
	private int inventory = 5;
	
	static String c1Info = vendMap.get("C1");
	static String [] c1Array = c1Info.split("\\|");
	static String c1name = c1Array[1];
	static BigDecimal c1Price = new BigDecimal(c1Array[2]);
	static int c1Inventory = new Integer(5);
	
	static String c2Info = vendMap.get("C2");
	static String [] c2Array = c2Info.split("\\|");
	static String c2name = c2Array[1];
	static BigDecimal c2Price = new BigDecimal(c2Array[2]);
	static int c2Inventory = new Integer(5);
	
	static String c3Info = vendMap.get("C3");
	static String [] c3Array = c3Info.split("\\|");
	static String c3name = c3Array[1];
	static BigDecimal c3Price = new BigDecimal(c3Array[2]);
	static int c3Inventory = new Integer(5);
	
	static String c4Info = vendMap.get("C4");
	static String [] c4Array = c4Info.split("\\|");
	static String c4name = c4Array[1];
	static BigDecimal c4Price = new BigDecimal(c4Array[2]);
	static int c4Inventory = new Integer(5);
	

	public static String getMessage() {
		return "Glug Glug, Yum!";
	}
	
	public int getInventory() {
		return this.inventory;
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public String setInfoFromMap() {
		return name;
	}
	
	
	public void getInfoFromMap() {
		
	}
	

}
