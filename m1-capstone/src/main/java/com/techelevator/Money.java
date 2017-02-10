package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.techelevator.view.Menu;

public class Money {
	private double currentMoney = 0;
	private SelectProduct selectproduct;
	Transact transactionLog = new Transact();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();

	public Money(SelectProduct selectproduct) {
		this.selectproduct = selectproduct;
	}

	public double getCurrentMoney() {
		return currentMoney;

	}

	public double deposit() throws IOException {
		// how do i wrap in try resource
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please indicate the amount to deposit $(1, 2, 5, or 10)");
		int depositAmount = userInput.nextInt();

		boolean validValue = false;
		while (!validValue) {
			if (depositAmount == 1 || depositAmount == 2 || depositAmount == 5 || depositAmount == 10) {
				validValue = true;
				currentMoney = currentMoney + depositAmount;
				transactionLog.writeFile("Deposit: " + depositAmount);
			} else {
				System.out.println("Please enter a valid amount to deposit $(1, 2, 5, or 10)");
				depositAmount = userInput.nextInt();
			}
		}

		
		return currentMoney;
	}

	public double transact(List<String> itemsList) throws IOException {

		boolean success = false;

		for (String item : itemsList) {
			Double itemPrice = selectproduct.inventory.getItemsPriceMap().get(item);
			int quantity = selectproduct.inventory.getItemsQuantityMap().get(item);
			System.out.println("There are " + quantity + " left");
			if (currentMoney > itemPrice) {
				currentMoney -= itemPrice;
//				selectproduct.updateQuantity(itemsList);
				String output = dtf.format(now) + "  " + selectproduct.inventory.getItemsDescriptionMap().get(item)
						+ "  " + item + "  " + itemPrice;
				transactionLog.writeFile(output);
			} else {
				System.out.println("You do not have enough money to make that purchase.");
			}

		}

		return currentMoney;
	}

	public void makeChange() throws IOException {
		Map<Integer, String> change = new HashMap<>();
		int numDollars;
		int numQuarters;
		int numDimes;
		int numNickels;
		transactionLog.writeFile("Change tendered: " + currentMoney);
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
		System.out.println("Here is your change: ");

		System.out.println();
		
		currentMoney = 0;
	}

}
