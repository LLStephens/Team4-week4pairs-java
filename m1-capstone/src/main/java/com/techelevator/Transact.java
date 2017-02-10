package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transact {
	PrintWriter outputWriter = null;
	
	public Transact(){
		try {
			outputWriter = new PrintWriter(new FileWriter("TransactionLog.txt", true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		outputWriter.println("Date\tTime\tProduct\tSlot\tAmountAccepted\tChangeTendered");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
	}

	public void writeFile(String contentsToWrite) throws IOException {
		

		outputWriter.println(contentsToWrite);
		outputWriter.flush();

	}
}
