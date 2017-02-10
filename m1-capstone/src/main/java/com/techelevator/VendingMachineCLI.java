package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE,  };
	
	private Menu menu;
	private VendingMachinePurchaseMenu purchaseMenu;
	private Inventory inventory;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.inventory = new Inventory();
		purchaseMenu = new VendingMachinePurchaseMenu(menu, inventory);
	}
	
	public void run() throws IOException {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS); //call method in menu that takes array of menu options
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				InventoryDisplay id = new InventoryDisplay();
				id.displayItems();
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchaseMenu.runPurchaseMenu();
			}
		}
	}
	
}
