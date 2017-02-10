package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SelectProduct {

	//private ItemQuantity itemsQuantity;
	public Map<String, Integer> itemsQuantityMap;
	public Map<String, String> itemsDescriptionMap;
	public Inventory inventory;
	String itemNumber = new String();
	List <String> itemsList  = new ArrayList<>();
	public SelectProduct(Inventory inventory){
		this.inventory = inventory;
	}
	
	public List<String> addItem(){
		
		String itemConfirmation;
		boolean soldOut = false;
		Scanner scanUser = new Scanner(System.in);
		System.out.println("Please Enter Your Item Number!");
		itemNumber =  scanUser.nextLine().toUpperCase();
		
		itemsQuantityMap = inventory.getItemsQuantityMap();
		itemsDescriptionMap = inventory.getItemsDescriptionMap();
		
		while (itemsQuantityMap.containsKey(itemNumber)==false){
			System.out.println("Item Does Not Exist!");
			System.out.println("Please Enter a Valid Item Number");
			itemNumber =  scanUser.nextLine().toUpperCase();
		}
		if(itemsQuantityMap.get(itemNumber)==0){
			System.out.println("Item is Sold Out!");
			soldOut = true;
		}
		if(!soldOut && itemsQuantityMap.containsKey(itemNumber)){
			System.out.println("Item Number: "+itemNumber +"  "+itemsDescriptionMap.get(itemNumber));
			System.out.println();
			System.out.println("Please Confirm Your Choice y/n");
			itemConfirmation =  scanUser.nextLine();

			if (itemConfirmation.toUpperCase().equals("Y")){
				
				int newItemQuantity = 0;
				newItemQuantity = itemsQuantityMap.get(itemNumber) - 1;
				itemsQuantityMap.put(itemNumber, newItemQuantity);
				//inventory.setItemsQuantityMap(itemsQuantityMap);
				itemsList.add(itemNumber);
			}
		}
		return itemsList; 
	}
	
	
	
	public void updateQuantity(List<String> itemsList) {
		itemsQuantityMap = inventory.getItemsQuantityMap();

		for (String items : itemsList) {
			int newItemQuantity = 0;

			newItemQuantity = itemsQuantityMap.get(items) - 1;
			itemsQuantityMap.put(items, newItemQuantity);

			// newItemQuantity = itemsQuantityMap.get(items) - 1;
			// itemsQuantityMap.put(items, newItemQuantity);
			// itemsQuantityMap.put(items, value)
		}
		inventory.setItemsQuantityMap(itemsQuantityMap);
	}

}







