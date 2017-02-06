package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class KataNumbersToWords {
	
	Map<Integer, String> nums;	
	Map<Integer, String> tens;
	
	public String convert(int number){

	nums = new HashMap<>();
	Integer [] numsArray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
	String [] numsWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	
	tens = new HashMap<>();
	Integer [] tensArray = {20, 30, 40, 50, 60, 70, 80, 90};
	String [] tensWords = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
		for(int i=0; i<numsArray.length; i++){
			nums.put(numsArray[i], numsWords[i]);
		}
		for(int j = 0; j<tensArray.length; j++){
			tens.put(tensArray[j], tensWords[j]);
		}

		if (number < 100){
			return ten(number);
		}
		else if (number > 100 && number < 1000){
			return hundred(number);
		}else if(number > 1000 && number <100000 ){
			return thousands(number);
		}else{
			return hundredThousands(number);
		}
	
	}
	
	public String hundredThousands(int fiveDigit){
		
		int firstThreeDigit = fiveDigit/1000;
		int lastThreeDigit = fiveDigit % 1000;
	
		if(fiveDigit%1000==0){
			return hundred(firstThreeDigit) + " thousand";
		} else {
			return hundred(firstThreeDigit) + " thousand "+ hundred(lastThreeDigit)  ;
		}
	}
	
	public String thousands(int fourDigitNumber){
		int firstDigit = fourDigitNumber/1000;
		int twoDigit = fourDigitNumber / 100;
		int threeDigitNumber = fourDigitNumber % 1000;
		if(fourDigitNumber%1000==0){
			return nums.get(firstDigit) + " thousand";
		} else {
			return ten(firstDigit) + " thousand "+ hundred(threeDigitNumber)  ;
		}
	}
	
	public String hundred(int threeDigitNumber){
		int firstDigit = threeDigitNumber/100;
		int twoDigit = threeDigitNumber % 100;
		if(threeDigitNumber%100==0){
			 return nums.get(firstDigit) + " hundred";
		} else {
			return nums.get(firstDigit) + " hundred "+ ten(twoDigit)  ;
		}
	}
		
	public String ten(int twoDigitNumber){
		if(twoDigitNumber < 20 ){ //0-19
			return nums.get(twoDigitNumber);
		} else if(twoDigitNumber <100 && twoDigitNumber % 10==0){  //20,30,40...
			return tens.get(twoDigitNumber);
		} else{ 
			
			int firstDigit = twoDigitNumber/10;
			int secDigit = twoDigitNumber % 10;
			firstDigit = firstDigit *10;
			return tens.get(firstDigit) +  " " + nums.get(secDigit);
		}
	}
}
