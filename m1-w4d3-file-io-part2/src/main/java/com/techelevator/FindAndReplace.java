package com.techelevator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {
	
	public static void main(String[] args) throws IOException{
		
		try(Scanner userInput = new Scanner(System.in)){
			System.out.println("Enter a search term: ");
			String searchTerm = userInput.next();
			System.out.println("Enter a replacement term: ");
			String replacementTerm = userInput.next();
		
		
		try(Scanner wordInput = new Scanner(System.in)){
			System.out.println("Which file do you want to search?");
			String filePath = wordInput.next();
			System.out.println("Name the new file destination: ");
			String outputPath = wordInput.next();
		
			try {
				File fileToRead = getFileAtPath(filePath);
				File fileToWrite = makeFile(outputPath);
				
				FileInputStream inputStream = new FileInputStream(fileToRead);
				FileOutputStream outputStream = new FileOutputStream(fileToWrite);
			
		
				WordReplacer change = new WordReplacer();
				change.replace(searchTerm, replacementTerm, inputStream, outputStream);
				
			} catch(FileNotFoundException ex) {
				System.out.println(ex.getMessage());
				System.exit(1);
				
			}
			}
		}
	}
		private static File getFileAtPath(String filePath) throws IOException{
			File ourFile = new File(filePath);
			if(!ourFile.exists()) {
				throw new FileNotFoundException("There was not file at " + filePath);
			}
			
			if(!ourFile.isFile()) {
				throw new IOException(filePath + " is not a file.");
			}
			return ourFile;
		}
		
		private static File makeFile(String outputPath) throws FileNotFoundException {
			File newFile = new File(outputPath);
			if(newFile.exists()) {
				throw new FileNotFoundException("A file already exists by that name " + outputPath);
			}
			return newFile;
		}		
}
