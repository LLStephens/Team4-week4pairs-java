package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class InventoryDisplay {
    
	public InventoryDisplay(){
	}
	
		public void displayItems(){
			
			File file = new File("/Users/lstephens/Desktop/vendingmachine.csv");
			
			try {
			    Scanner scanInput = new Scanner(file);
			    
			    System.out.println("");
			    System.out.printf("%-10s%-25s%-20s%n","Slot No.", "Description","Price" );
			    while(scanInput.hasNextLine()) {
				    String line = scanInput.nextLine();
				    System.out.println();
					PrintWriter outputWriter = null;
				    String [] items = line.split("\\|");
				    System.out.printf("%-10s%-25s%-20s%n",items[0],items[1], "$"+items[2] );
			    }
			}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
	}

}



//public class InventoryDisplay {
//	
//	HashMap<String, Integer> itemsQuantity = new HashMap();
//    HashMap<String, String> itemsDescription = new HashMap();
//    
//	public InventoryDisplay(){
//	}
//	
//		public void displayItems(){
//			
//			File file = new File("/Users/mramadan/Desktop/vendingmachine.csv");
//			
//			try {
//			    Scanner scanInput = new Scanner(file);
//			    
//			    System.out.println("");
//			    System.out.printf("%-10s%-25s%-10s%-20s%n","Slot No.", "Description","Price", "Quantity" );
//			    while(scanInput.hasNextLine()) {
//				    String line = scanInput.nextLine();
//				    System.out.println();
//					PrintWriter outputWriter = null;
//				    String [] items = line.split("\\|");
//				    System.out.printf("%-10s%-25s%-12s%-20s%n",items[0],items[1], "$"+items[2], 5 );
//				    itemsQuantity.put(items[0], 5);
//				    itemsDescription.put(items[0], items[1]);
//			    }
//			    System.out.println(itemsQuantity.get("A1"));
//			}
//		
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//			
//	}
//
//}