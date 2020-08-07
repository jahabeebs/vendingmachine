package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Items {
	
	//should implement an interface that includes
	//name variable, dollar amount, inventory
	private String name;
	private BigDecimal price;
	private int inventory = 5;
	
	static String a1Info = vendMap.get("A1");
	static String [] a1Array = a1Info.split("\\|");
	static String a1name = a1Array[1];
	static BigDecimal a1Price = new BigDecimal(a1Array[2]);
	static int a1Inventory = new Integer(5);
	
	static String a2Info = vendMap.get("A2");
	static String [] a2Array = a2Info.split("\\|");
	static String a2name = a2Array[1];
	static BigDecimal a2Price = new BigDecimal(a2Array[2]);
	static int a2Inventory = new Integer(5);
	
	static String a3Info = vendMap.get("A3");
	static String [] a3Array = a3Info.split("\\|");
	static String a3name = a3Array[1];
	static BigDecimal a3Price = new BigDecimal(a3Array[2]);
	static int a3Inventory = new Integer(5);
	
	static String a4Info = vendMap.get("A4");
	static String [] a4Array = a4Info.split("\\|");
	static String a4name = a4Array[1];
	static BigDecimal a4Price = new BigDecimal(a4Array[2]);
	static int a4Inventory = new Integer(5);
	
//	public Chips(String name, BigDecimal price) {
//		super(name, price);
//	}
	
	public static String getMessage() {
		return "Crunch Crunch, Yum!";
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

