package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Items {
	// Are these lines even needed?
//	private int inventory; 
//	private String name;
//	private BigDecimal price;
//
//	public Items(String name, BigDecimal price) {
//		this.name = name;
//		this.price = price;
//	}

	private static File vendItems = new File("vendingmachine.csv");
	public static Map<String, String> vendMap = new TreeMap<>();

	public static void main(String[] args) throws FileNotFoundException {
		//Items t = new Items("Potato Crisps", new BigDecimal("3.05"));
		//Chips chip = new Chips(Chips.a1name, Chips.a1Price);
		//chip.getName();
		String[] itemsArray = new String[4]; //I wonder why it works with 1+ too
		try (Scanner vendReader = new Scanner(vendItems)) {
			while (vendReader.hasNextLine()) {
				String vendLine = vendReader.nextLine();
				itemsArray = vendLine.split("\\|");
				vendMap.put(itemsArray[0], vendLine);
				System.out.println(vendLine);
			}
		}
	}
}
//	}
//	public String returnKeyValueInfo() {
//		vendMapInfo = vendMap.get("A1");
//		return vendMapInfo;
//	}
