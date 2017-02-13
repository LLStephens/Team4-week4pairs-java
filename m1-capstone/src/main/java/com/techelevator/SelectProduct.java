package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SelectProduct {

	private Map<String, Integer> itemsQuantityMap;
	private Map<String, String> itemsDescriptionMap;
	protected Inventory inventory;
	private String itemNumber = new String();
	private List<String> itemsList = new ArrayList<>();
	public List<Double> cartPrices;

	public SelectProduct(Inventory inventory) {
		this.inventory = inventory;
		cartPrices = new ArrayList<>();
	}

	public List<String> addItem() {
		String itemConfirmation;
		boolean soldOut = false;

		Scanner scanUser = new Scanner(System.in);
		System.out.println("Please Enter Your Item Number!");
		itemNumber = scanUser.nextLine().toUpperCase();

		itemsQuantityMap = inventory.getItemsQuantityMap();
		itemsDescriptionMap = inventory.getItemsDescriptionMap();
	

		while (itemsQuantityMap.containsKey(itemNumber) == false) {
			System.out.println("Item Does Not Exist!");
			System.out.println("Please Enter a Valid Item Number");
			itemNumber = scanUser.nextLine().toUpperCase();
		}
		if (itemsQuantityMap.get(itemNumber) == 0) {
			System.out.println("Item is Sold Out!");
			soldOut = true;
			
		}if (!soldOut && itemsQuantityMap.containsKey(itemNumber)) {
			System.out.println("Item Number: " + itemNumber + "  " + itemsDescriptionMap.get(itemNumber));
			System.out.println();
			System.out.println("Please Confirm Your Choice y/n");
			itemConfirmation = scanUser.nextLine();

			if (itemConfirmation.toUpperCase().equals("Y")) {
				
				int newItemQuantity = 0;
				newItemQuantity = itemsQuantityMap.get(itemNumber) - 1;
				itemsQuantityMap.put(itemNumber, newItemQuantity);	
				itemsList.add(itemNumber);
				System.out.println(itemsList);
			}

		}
		return itemsList;
	}
	

}
