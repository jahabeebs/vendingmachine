package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Items {
	private String name;
	private BigDecimal price;
	private int inventory = 5;
	
	static String d1Info = vendMap.get("D1");
	static String [] d1Array = d1Info.split("\\|");
	static String d1name = d1Array[1];
	static BigDecimal d1Price = new BigDecimal(d1Array[2]);
	static int d1Inventory = new Integer(5);
	
	static String d2Info = vendMap.get("D2");
	static String [] d2Array = d2Info.split("\\|");
	static String d2name = d2Array[1];
	static BigDecimal d2Price = new BigDecimal(d2Array[2]);
	static int d2Inventory = new Integer(5);
	
	static String d3Info = vendMap.get("D3");
	static String [] d3Array = d3Info.split("\\|");
	static String d3name = d3Array[1];
	static BigDecimal d3Price = new BigDecimal(d3Array[2]);
	static int d3Inventory = new Integer(5);
	
	static String d4Info = vendMap.get("D4");
	static String [] d4Array = d4Info.split("\\|");
	static String d4name = d4Array[1];
	static BigDecimal d4Price = new BigDecimal(d4Array[2]);
	static int d4Inventory = new Integer(5);
	
	public String getMessage() {
		return "Chew Chew, Yum!";
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
