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
	public static Map<String, BigDecimal> vendMapPrice = new TreeMap<>();
	public static Map<String, String> vendMapName = new TreeMap<>();
	public static Map<String, Integer> vendMapStock = new TreeMap<>();
	public static String[] itemsArray = new String[4];
	
	public static void readFiles() throws FileNotFoundException {
		//Items t = new Items();
		try (Scanner vendReader = new Scanner(vendItems)) {
			while (vendReader.hasNextLine()) {
				String vendLine = vendReader.nextLine();
				itemsArray = vendLine.split("\\|");
				vendMap.put(itemsArray[0], vendLine);
				vendMapPrice.put(itemsArray[0], new BigDecimal(itemsArray[2]));
				vendMapName.put(itemsArray[0], itemsArray[1]);
				vendMapStock.put(itemsArray[0], 5);
				
				//System.out.println(vendLine);
			}

System.out.println(vendMap.get("A1"));

		}
	}
}


//System.out.println(Chips.a1Info);
//
//		}
//	}
//}
//	}
//	public String returnKeyValueInfo() {
//		vendMapInfo = vendMap.get("A1");
//		return vendMapInfo;
//	}
