package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	public StringCalculator calc;
	
	@Before 
	public void setup(){
		calc = new StringCalculator();
	}
	
	@Test
	public void given_blank_return_0() {
		calc.add("");
		
		Assert.assertEquals(0, calc.add(""));
	}
	
	@Test
	public void given_String1_return_1() {
		calc.add("1");
		
		Assert.assertEquals(1, calc.add("1"));
	}
	
	@Test
	public void given_String12_return_3() {
		calc.add("1,2");
		
		Assert.assertEquals(3, calc.add("1,2"));
	}
	@Test
	public void given_String3456_return_18() {
		calc.add("3,4,5,6");
		
		Assert.assertEquals(18, calc.add("3,4,5,6"));
	}
	@Test
	public void given_newLine_String3456_return_18() {
		calc.add("3\n4\n5\n6");
		
		Assert.assertEquals(18, calc.add("3\n4\n5\n6"));
	}
	
}
