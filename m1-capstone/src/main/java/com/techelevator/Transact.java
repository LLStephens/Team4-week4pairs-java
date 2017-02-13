package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Transact {
	private PrintWriter outputWriter = null;
	
	public Transact(){
		try {
			outputWriter = new PrintWriter(new FileWriter("TransactionLog.txt", true));
			outputWriter.println("Date\tTime\tProduct\tSlot\tAmountAccepted");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void writeFile(String contentsToWrite) {
		outputWriter.println(contentsToWrite);
		outputWriter.flush();
	}
}
