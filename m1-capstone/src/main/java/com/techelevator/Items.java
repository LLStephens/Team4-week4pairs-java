package com.techelevator;

public class Items {

	private String slot;
	private String name;
	private double cost;
	private int quantity;
	

	public Items(String name, double cost, int quantity){
		this.slot = slot;
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
	}
	
	
	
	public String getName(){
		return name;
	}
	
	public String getSlot(){
		return slot;
	}
	
	public double getCost(){
		return cost;
	}
	
	public double getQuantity(){
		return quantity;
	}
	
}
