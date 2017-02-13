//package com.techelevator;
//
//import java.io.ByteArrayInputStream;
//import java.util.Scanner;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//
//
//
//public class MoneyTest {
//
//	public Money money;
//	public SelectProduct selectproduct;
//	ByteArrayInputStream in = new ByteArrayInputStream("My string".getBytes());
//	
//	
//	@Before
//	public void setup(){
//		money = new Money(selectproduct);
//	}
//	
//	@Test
//	public void given_10_returns_10(){
//		money.deposit(10.0);
//		Assert.assertEquals(10, money.getCurrentMoney(), 0.001);
//	}
//	@Test
//	public void given_0_returns_0(){
//		money.deposit(0.0);
//		Assert.assertEquals(null, money.getCurrentMoney());
//	}
//	
//	@Test
//	public void given_3_returns_0(){
//		money.deposit(3.0);
//		Assert.assertEquals(null, money.getCurrentMoney());
//	}
//	
//}
