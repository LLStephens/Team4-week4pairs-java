package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class InventoryDisplay {

	public InventoryDisplay() {	
	}

	public void displayItems() {

		File file = new File("vendingmachine.csv");

		try {
			Scanner scanInput = new Scanner(file);

			System.out.println("");
			System.out.printf("%-10s%-25s%-25s%n", "Slot No.", "Description", "Price");
			while (scanInput.hasNextLine()) {
				
				String line = scanInput.nextLine();
				System.out.println();
				PrintWriter outputWriter = null;
				String[] items = line.split("\\|");
				System.out.printf("%-10s%-25s%-25s%n", items[0], items[1], "$" + items[2]);  //teach me how to make this display the current quantity
				
			}
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}

