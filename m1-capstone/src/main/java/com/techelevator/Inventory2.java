package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory2 {
	private Map<String, String> itemSlotName = new HashMap<>();
	private Map<String, Double> itemNameCost = new HashMap<>();
	private Map<String, Integer> itemSlotQuantity = new HashMap<>();

	public void createInventory() {
		String filePath = "/Users/lstephens/Desktop/vendingmachine.csv";
		try {
			File searchFile = getSearchFile(filePath);
			try (Scanner fileInput = new Scanner(searchFile)) {

				while (fileInput.hasNextLine()) {
					String line = fileInput.nextLine();

					String[] stock = line.split("\\|");
					itemSlotName.put(stock[0], stock[1]);
					// System.out.println(itemSlotName);
					itemNameCost.put(stock[1], Double.parseDouble(stock[2]));
					// System.out.println(itemNameCost);
					itemSlotQuantity.put(stock[0], 5);
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		}
	}

	private static File getSearchFile(String filePath) throws IOException {
		File searchFile = new File(filePath);

		if (!searchFile.exists()) {
			throw new FileNotFoundException("Search file: " + filePath + " does not exist");
		}
		if (!searchFile.isFile()) {
			throw new IOException("Search file: " + filePath + " exists but is not a file");
		}
		return searchFile;
	}
	
	public void updateInventory(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("What would you like to purchase?");
		String purchase = userInput.nextLine();
		System.out.println("hi");
		if(itemSlotQuantity.containsKey(purchase)){
			int newItemQuantity = itemSlotQuantity.get(purchase)-1;
			itemSlotQuantity.put(purchase, newItemQuantity);
		} else {
			System.out.println("Invalid selection");
		}
	}
}
