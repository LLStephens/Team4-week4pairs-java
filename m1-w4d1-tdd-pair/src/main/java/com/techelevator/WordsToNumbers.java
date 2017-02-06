package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class WordsToNumbers {

	Map<String, Integer> nums;	
	Map<String, Integer> tens;
	
	public int convert(String word){

	nums = new HashMap<>();
	Integer [] numsArray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20, 30, 40, 50, 60, 70, 80, 90};
	String [] numsWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen","twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
//	tens = new HashMap<>();
//	Integer [] tensArray = {20, 30, 40, 50, 60, 70, 80, 90};
//	String [] tensWords = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
		for(int i=0; i<numsArray.length; i++){
			nums.put(numsWords[i], numsArray[i]);
		}
//		for(int j = 0; j<tensArray.length; j++){
//			tens.put(tensWords[j], tensArray[j]);
//		}

	String [] words = word.split(" ");
	
//	if(nums.containsKey(word)){
//		return nums.get(word);
//	}else if(tens.containsKey(word)){
//		return tens.get(word);
//	}else if (words.length==2){
//		return tens.get(words[0])+nums.get(words[1]);
//	}else if (words.length==4){
//		return (nums.get(words[0])*100)+tens.get(words[2])+nums.get(words[3]);
//	}else if (words.length==4){
//		return (nums.get(words[0])*100)+tens.get(words[2])+nums.get(words[3]);
//	}else if (words.length==3 && words[1].equals("hundred")){
//		return (nums.get(words[0])*100)+tens.get(words[2]);
//	}return 0;
	
//	int total = 0;
//	for(int i=0; i<words.length;i++){
//		
//		if (words[i].equals("thousand")){
//			total = total * 1000;
//		}else if (words[i].equals("hundred")){
//			total =  total * 100;
//		}else {
//			total = total+ nums.get(words[i]);
//		}
//	}return total;
	
	int total = 0;
	for(int i=0; i<words.length;i++){
		
		if (words[i].equals("thousand")){
			total = total * 1000;
		}else if (words[i].equals("hundred")){
			total =  total + nums.get(i-1) * 100;
		}else {
			total = total+ nums.get(words[i]);
		}
	}return total;
	
//	public int tens(String wordNum){
//		return nums.get(wordNum);
//	}
		
		
		
	}
	
}
