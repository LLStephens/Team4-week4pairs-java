package com.techelevator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Money {
	private int currentMoney = 0;
	
	public Money(){
	}
	
	public int getCurrentMoney(){
		return currentMoney;
	}
	
	public int deposit(){
//how do i wrap in try resource
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please indicate the amount to deposit $(1, 2, 5, or 10)");
		int depositAmount = userInput.nextInt();
		
		boolean validValue = false;
		while (!validValue){
			if(depositAmount == 1 || depositAmount == 2||depositAmount == 5||depositAmount == 10){
				validValue = true;
				currentMoney = currentMoney + depositAmount;
			}else {
				System.out.println("Please enter a valid amount to deposit $(1, 2, 5, or 10)");
				depositAmount = userInput.nextInt();
			}
		}return currentMoney;
	}
	
	public int transact(){
		if(currentMoney > 0){ //change zero to item cost
			currentMoney -= 0; //change zero to item cost
		} else {
			System.out.println("You do not have enough money to make that purchase. Transaction terminated.");
		} return currentMoney;
	}
	
	public void makeChange(){ 	
		Map<Integer,String> change = new HashMap<>();
		int numDollars;
		int numQuarters;
		int numDimes;
		int numNickels;
  
		String outputDisplay;
		currentMoney = currentMoney * 95;

		numDollars = currentMoney / 100;      
		currentMoney %= 100;
		change.put(numDollars, "dollar");
		  
		numQuarters = currentMoney / 25;     
		currentMoney %= 25;
		change.put(numQuarters, "quarter");
		  
		numDimes = currentMoney / 10;         
		currentMoney %= 10;
		change.put(numDimes, "dimes");
		  
		numNickels = currentMoney / 5;       
		currentMoney %= 5;
		change.put(numNickels, "nickles");
		  
		  
		outputDisplay = "Your change is: \n" +
		"\t" + numDollars + " dollar(s) \n" +
		"\t" + numQuarters + " quarter(s) \n" +
		"\t" + numDimes + " dime(s) \n" +
		"\t" + numNickels + " nickel(s) \n";
		System.out.println(outputDisplay);
		System.out.println("Here is your change: ");
//		for (Map.Entry entry : change.entrySet()) {
//		    System.out.println(entry.getKey() + ", " + entry.getValue());
//		}
		System.out.println(change);
		System.out.println();
		
		currentMoney = 0;
		
	}

}
	


