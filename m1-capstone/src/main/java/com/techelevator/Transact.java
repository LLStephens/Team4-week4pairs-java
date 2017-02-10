package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class Transact {

	public void writeFile() throws FileNotFoundException{

		//File outputFile = new File("/Users/lstephens/Desktop/TransactionLog.txt");
		try(PrintWriter fileOutput = new PrintWriter(new File ("/Users/lstephens/Desktop/TransactionLog.txt"))){
			fileOutput.println("DateTime /t Product Slot/t AmountAccepted /tChangeTendered/t");
			
			fileOutput.flush();
		}
		catch (IOException e){
			e.getMessage();
		}
	}
}

//DateTime Product Slot AmountAccepted ChangeTendered
//01/01/2016 12:00 PM Crunchie B4 3.00 1.50
//01/01/2016 12:15 PM Cowtales B2 4.00 2.50