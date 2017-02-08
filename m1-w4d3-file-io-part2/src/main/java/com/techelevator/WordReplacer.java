package com.techelevator;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordReplacer {

	private Scanner inputScanner;
	private PrintWriter outputWriter;
	private String newTerm;
	private String oldTerm;
	
	public WordReplacer() {
	}
	
	public void replace(String oldTerm, String newTerm, InputStream input, OutputStream output) {
		inputScanner = new Scanner(input);
		outputWriter = new PrintWriter(output);
		this.oldTerm = oldTerm;
		this.newTerm= newTerm;
		
		
		while(inputScanner.hasNextLine()) {
			String inputData = inputScanner.nextLine();
			String term1 = inputData.replaceAll(oldTerm, newTerm);
			term1 = term1.replaceAll(oldTerm.toUpperCase(), newTerm.toUpperCase());
			//outputWriter.print(inputData.replace(oldTerm, newTerm));
			outputWriter.print(term1);
			if(inputScanner.hasNextLine()) {
				outputWriter.print("\n");
			}
		}
		outputWriter.flush();
	}
}
