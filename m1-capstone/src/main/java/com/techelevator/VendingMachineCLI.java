package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE,  };
	
	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS); //call method in menu that takes array of menu options
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				Inventory inventory = new Inventory();
				inventory.createInventory();
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				Menu menu = new Menu(System.in, System.out);
				VendingMachinePurchaseMenu purchaseMenu = new VendingMachinePurchaseMenu(menu);
				purchaseMenu.runPurchaseMenu();
			}
		}
	}
	
}
