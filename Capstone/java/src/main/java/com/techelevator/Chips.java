package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Items {
	
	//should implement an interface that includes
	//name variable, dollar amount, inventory
	private int inventory = 5;
	private String name;
	private BigDecimal price;
	
	public Chips(String name, BigDecimal price) {
		super(name, price);
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
		String str = getInfoFromMap();
		String [] chipsInfoArray = str.split("//|");
		name = chipsInfoArray[1];
		return name;
	}
	
//	public String [] arraySplitter() {
//		String str = getInfoFromMap();
//		String [] chipsInfoArray = str.split("//|");
//		System.out.println(chipsInfoArray[1]);
//		return null;
//	}
	
	public String getInfoFromMap() {
		String mapInfo = vendMap.get("A1");
		return mapInfo;
		
//		String [] chipArray = chipInfo.split("|");
//		String name = chipArray[1];
//		System.out.println(chipInfo);
//		return chipInfo;
	}
}

