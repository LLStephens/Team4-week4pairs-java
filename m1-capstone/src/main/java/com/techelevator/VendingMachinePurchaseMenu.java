package com.techelevator;

import java.io.FileNotFoundException;

import com.techelevator.view.Menu;

public class VendingMachinePurchaseMenu {
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	
	private Menu menu;
	
	public VendingMachinePurchaseMenu(Menu menu) {
		this.menu = menu;
	}
	
	public void runPurchaseMenu() {
		Money money = new Money();
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS); //call method in menu that takes array of menu options
			
			if(choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {				
				money.deposit();
			} else if(choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {;
				Inventory inventory = new Inventory();
				inventory.updateInventory();
			} else if(choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
				money.makeChange();
			} System.out.println("Current Money Provided: $" + money.getCurrentMoney());
		}
	}
	
}
