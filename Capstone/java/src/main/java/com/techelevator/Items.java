package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Items {
	
	private String name;
	private BigDecimal price;
	
	public Items (String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	
	private static File vendItems = new File("vendingmachine.csv");
	public static Map <String, String> vendMap = new HashMap<>();
	public static void main(String[] args) throws FileNotFoundException {
		Items t = new Items("Potato Crisps", new BigDecimal("3.50"));
	    Chips chip = new Chips("Potato Crisps", new BigDecimal("3.50"));
		chip.getName();
		String [] itemsArray = new String[4];
	try (Scanner vendReader = new Scanner(vendItems)) {
		while (vendReader.hasNextLine()) {
		String vendLine = vendReader.nextLine();
		String tempVendLine = "";
		if (vendLine.contains("|")) {
			tempVendLine = vendLine.replace("|", ":");
		}
		itemsArray = tempVendLine.split(":");
		vendMap.put(itemsArray[0], vendLine);
		}
	}
}
}
//	}
//	public String returnKeyValueInfo() {
//		vendMapInfo = vendMap.get("A1");
//		return vendMapInfo;
//	}
