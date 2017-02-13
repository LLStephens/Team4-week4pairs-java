package com.techelevator;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Money {
	private double currentMoney = 0;
	private SelectProduct selectproduct;
	private Transact transactionLog = new Transact();
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	private LocalDateTime now = LocalDateTime.now();

	public Money(SelectProduct selectproduct) {
		this.selectproduct = selectproduct;
	}

	public double getCurrentMoney() {
		return currentMoney;
	}

	public double deposit() {
		Scanner userInput = new Scanner(System.in);

		System.out.println("Please indicate the amount to deposit $(1, 2, 5, or 10)");
		int depositAmount = userInput.nextInt();
		

		boolean validValue = false;
		while (!validValue) {
			if (depositAmount == 1 || depositAmount == 2 || depositAmount == 5 || depositAmount == 10) {
				validValue = true;
				currentMoney = currentMoney + depositAmount;
				transactionLog.writeFile("Deposit: $" + depositAmount);
			} else {
				System.out.println("Please enter a valid amount to deposit $(1, 2, 5, or 10)");
				depositAmount = userInput.nextInt();
			}
		}
		return currentMoney;
	}

	public void transact(List<String> itemsList) throws IOException {
		Double sum = 0.00;
		Double itemPrice = 0.00;
		String itemName = new String();
		
		for (String item : itemsList) {
			itemName = item;
			itemPrice = selectproduct.inventory.getItemsPriceMap().get(item);
			System.out.println("Cost of item: $" + itemPrice);
			sum += itemPrice;
			int quantity = selectproduct.inventory.getItemsQuantityMap().get(item);
			System.out.println("There are " + quantity + " of that item left");
			System.out.println("Sum of all items: " + sum);
			String output = dtf.format(now) + "  " + selectproduct.inventory.getItemsDescriptionMap().get(itemName)
					+ "  " + itemName + "  " + itemPrice;
			transactionLog.writeFile(output);

		}
		
		if(currentMoney >= sum){
			currentMoney -= sum;
			makeChange();
			itemsList.clear();
		}else{
			System.out.println("You do not have enough money to make that purchase.");
			
		}
			
	}

	public void makeChange() throws IOException {
		int numDollars;
		int numQuarters;
		int numDimes;
		int numNickels;
		String strMoney = String.format("%.2f", currentMoney);
		transactionLog.writeFile("Change: $" + strMoney);
		String outputDisplay;
		currentMoney = currentMoney * 100;

		numDollars = (int) (currentMoney / 100);
		currentMoney %= 100;

		numQuarters = (int) (currentMoney / 25);
		currentMoney %= 25;

		numDimes = (int) (currentMoney / 10);
		currentMoney %= 10;

		numNickels = (int) (currentMoney / 5);
		currentMoney %= 5;

		outputDisplay = "Your change is: \n" + "\t" + numDollars + " dollar(s) \n" + "\t" + numQuarters
				+ " quarter(s) \n" + "\t" + numDimes + " dime(s) \n" + "\t" + numNickels + " nickel(s) \n";
		System.out.println(outputDisplay);

		currentMoney = 0;
	}


}
