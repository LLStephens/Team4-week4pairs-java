package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SelectProduct {

	//private ItemQuantity itemsQuantity;
	public Map<String, Integer> itemsQuantityMap;
	public Map<String, String> itemsDescriptionMap;
	private Inventory inventory;
	
	public SelectProduct(){
		inventory = new Inventory();
	}
	
	public void addItem(){
		String itemNumber = new String();
		String itemConfirmation;
		Scanner scanUser = new Scanner(System.in);
		System.out.println("Please Enter Your Item Number!");
		itemNumber =  scanUser.nextLine().toUpperCase();
		itemsQuantityMap = new HashMap<String, Integer>();
		itemsDescriptionMap = new HashMap<String, String>();
		
		itemsQuantityMap = inventory.getItemsQuantityMap();
		itemsDescriptionMap = inventory.getItemsDescriptionMap();
				
		while (itemsQuantityMap.containsKey(itemNumber)==false){
			System.out.println("Item Does Not Exist!");
			System.out.println("Please Enter a Valid Item Number");
			itemNumber =  scanUser.nextLine().toUpperCase();
		}
		if(itemsQuantityMap.get(itemNumber)==0){
			System.out.println("Item is Sold Out!");
		}
		if(itemsQuantityMap.containsKey(itemNumber)){
			System.out.println("Item Number: "+itemNumber +"  "+itemsDescriptionMap.get(itemNumber));
			System.out.println();
			System.out.println("Please Confirm Your Choice y/n");
			itemConfirmation =  scanUser.nextLine();

			if (itemConfirmation.toUpperCase().equals("Y")){
				int newItemQuantity = 0;
				newItemQuantity = itemsQuantityMap.get(itemNumber) - 1;
				itemsQuantityMap.put(itemNumber, newItemQuantity);
//				inventory.itemsQuantity.clear();
				inventory.setItemsQuantityMap(itemsQuantityMap);
				System.out.println(itemsQuantityMap.get(itemNumber));
//				for (Map.Entry<String, Integer> entry : inventory.getItemsQuantityMap().entrySet()) {
//					System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
//				}
				
			}
		}
	}

}














