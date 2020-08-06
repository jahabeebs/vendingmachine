package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Items {

	
	private static File vendItems = new File("vendingmachine.csv");
	public static void main(String[] args) throws FileNotFoundException {
		Items t = new Items();	
		boolean fileExists = vendItems.exists();

	
	Map <String, String> vendMap = new HashMap<>();
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
	System.out.println(vendMap.get("A1"));
	
}
}