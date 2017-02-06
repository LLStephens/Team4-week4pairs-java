package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataNumbersToWordsTest {

	public KataNumbersToWords numToWord;
	
	@Before
	public void setup(){
		numToWord = new KataNumbersToWords();
	}
	
	@Test
	public void given_1_return_one(){
		
		Assert.assertEquals("one", numToWord.convert(1));
	}
	
	@Test
	public void given_19_return_nineteen(){
		
		Assert.assertEquals("nineteen", numToWord.convert(19));
	}
	
	@Test
	public void given_20_return_twenty(){
		
		Assert.assertEquals("twenty", numToWord.convert(20));
	}
	
	@Test
	public void given_22_return_twentytwo(){
		
		Assert.assertEquals("twenty two", numToWord.convert(22));
	}
	
	@Test
	public void given_99_return_ninetynine(){
		
		Assert.assertEquals("ninety nine", numToWord.convert(99));
	}
	@Test
	public void given_22_return_two(){
		
		Assert.assertEquals("two hundred", numToWord.convert(200));
	}

	@Test
	public void given_229_return_twoHundredTwentyNine(){
		
		Assert.assertEquals("two hundred twenty nine", numToWord.convert(229));
	}
	@Test
	public void given_999_return_nine_hundred_ninety_nine(){
		
		Assert.assertEquals("nine hundred ninety nine", numToWord.convert(999));
	}
	
	@Test
	public void given_1125_return_one_thousand_one_hundred_twenty_five(){
		
		Assert.assertEquals("one thousand one hundred twenty five", numToWord.convert(1125));
	}
	
	@Test
	public void given_11250_return_eleven_thousand_two_hundred_fifty(){
		
		Assert.assertEquals("eleven thousand two hundred fifty", numToWord.convert(11250));
	}
	@Test
	public void given_97600_return_ninety_seven_thousand_six_hundred(){
		
		Assert.assertEquals("ninety seven thousand six hundred", numToWord.convert(97600));
	}
	
	@Test
	public void given_90600_return_ninety_thousand_six_hundred(){
		
		Assert.assertEquals("ninety thousand six hundred", numToWord.convert(90600));
	}
	
	@Test
	public void given_450000_return_four_hundred_fifty_thousand(){
		
		Assert.assertEquals("four hundred fifty thousand", numToWord.convert(450000));
	}
	
	@Test
	public void given_453423_return_four_hundred_fifty_three_thousand_four_hundred_twenty_three(){
		
		Assert.assertEquals("four hundred fifty three thousand four hundred twenty three", numToWord.convert(453423));
	}
}
