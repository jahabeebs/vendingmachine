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
		System.out.println(fileExists);
	
	Map <String, String[]> vendMap = new HashMap<>();
	String [] itemsArray = {};
	
	try (Scanner vendReader = new Scanner(vendItems)) {
		while (vendReader.hasNextLine()) {
		String vendLine = vendReader.nextLine();
		//System.out.println(vendLine);
		itemsArray = vendLine.split("|");
		vendMap.put(itemsArray[0], itemsArray);
		}
	} 
	System.out.println(vendMap);
	
}
}