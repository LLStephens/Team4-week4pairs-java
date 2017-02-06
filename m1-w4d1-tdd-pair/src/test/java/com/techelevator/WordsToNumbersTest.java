package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;




public class WordsToNumbersTest {

	public WordsToNumbers wordToNum;
	
	@Before
	public void setup(){
		wordToNum = new WordsToNumbers();
	}
	
	@Test
	public void given_one_return_1(){
		Assert.assertEquals(1, wordToNum.convert("one"));
	}
	
	@Test
	public void given_eleven_return_11(){
		Assert.assertEquals(11, wordToNum.convert("eleven"));
	}
	
	@Test
	public void given_twenty_five_return_25(){
		Assert.assertEquals(25, wordToNum.convert("twenty five"));
	}
	@Test
	public void given_one_hundred_twenty_five_return_125(){
		Assert.assertEquals(125, wordToNum.convert("one hundred twenty five"));
	}
	@Test
	public void given_seven_hundred_five_return_705(){
		Assert.assertEquals(705, wordToNum.convert("seven hundred five"));
	}
	
	@Test
	public void jgiven_seven_hundred_five_return_705(){
		Assert.assertEquals(7523, wordToNum.convert("seven thousand five hundred twenty three"));
	}
}