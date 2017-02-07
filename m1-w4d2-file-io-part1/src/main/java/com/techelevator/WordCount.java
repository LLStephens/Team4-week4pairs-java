package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WordCount {


	public static void main(String[] args) {
		try(Scanner userInput = new Scanner(System.in)){
			System.out.print("Enter file path >>> ");
			String filePath = userInput.nextLine();
			
			try {
				File searchFile = getSearchFile(filePath);
				try(Scanner fileInput = new Scanner(searchFile)){ 
					int sentNumber = 1;
					int count = 0;
					while(fileInput.hasNextLine()) {
						String line = fileInput.nextLine();
						
						if(line.contains(".")||line.contains("?")||line.contains("!")){
							sentNumber ++;
						}
						
						String [] words = line.split(" ");
						for(String word : words){
							count ++;
						}
						
					} System.out.println("Number of sentences: " + sentNumber);
					System.out.println("Number of words: " + count);
				
		}
				
			} catch (FileNotFoundException ex) {
				System.out.println(ex.getMessage());
				System.exit(1);  
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
				System.exit(1);
			}
		}
	}
	
	private static File getSearchFile(String filePath) throws IOException{
		File searchFile = new File(filePath);
		
		if(!searchFile.exists()) {
			throw new FileNotFoundException("Search file: " + filePath + " does not exist");
		}
		
		if(!searchFile.isFile()) {
			throw new IOException("Search file: " + filePath + " exists but is not a file");
			}
			
			return searchFile;
		}

}
