package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

	private Map<String, Integer> itemsQuantity;
	private Map<String, String> itemsDescription;
	private Map<String, Double> itemsPrice;
	
	public Inventory() {
		itemsQuantity = new HashMap<String, Integer>();
		itemsDescription = new HashMap<String, String>();

		itemsPrice = new HashMap<String, Double>();
		File file = new File("vendingmachine.csv");

			try {
				Scanner scanInput = new Scanner(file);
				while (scanInput.hasNextLine()) {
					String line = scanInput.nextLine();
					String[] items = line.split("\\|");
					itemsQuantity.put(items[0], 5);
					itemsDescription.put(items[0], items[1]);

					itemsPrice.put(items[0],Double.parseDouble(items[2]));
				}
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
		}
	}

	public Map<String, Integer> getItemsQuantityMap() {
		return itemsQuantity;
	}
	
	public void setItemsQuantityMap(Map itemsQuantity) {
		this.itemsQuantity = itemsQuantity;
	}
	
	public Map<String, String> getItemsDescriptionMap() {
		return itemsDescription;
	}
	

	public Map<String, Double> getItemsPriceMap() {
		return itemsPrice;
	}
	
}


