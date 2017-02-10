package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.techelevator.view.Menu;

public class VendingMachinePurchaseMenu {
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	
	private Menu menu;
	private SelectProduct selectproduct;
	
	public VendingMachinePurchaseMenu(Menu menu, Inventory inventory) {
		this.menu = menu;
		selectproduct = new SelectProduct(inventory);
	}
	
	public void runPurchaseMenu() throws IOException {
		Money money = new Money(selectproduct);
		List<String> itemsList = null;
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS); //call method in menu that takes array of menu options
			
			if(choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {				
				money.deposit();
			} else if(choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {;
				itemsList = selectproduct.addItem();
			} else if(choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
				money.transact(itemsList);
				money.makeChange();
				break;
			} System.out.println("Current Money Provided: $" + money.getCurrentMoney());
		}
	}
	
}
