package com.techelevator;

public class StringCalculator {

	public int add(String numbers){
		
	String [] words = numbers.split(",|\n");
	
		int sum = 0;
		if(numbers== ""){
			return 0;
		} else {
			for(int i = 0; i<words.length; i++){
				sum = sum + (Integer.parseInt(words[i]));
			}
		} return sum;
		
	}
}
 

