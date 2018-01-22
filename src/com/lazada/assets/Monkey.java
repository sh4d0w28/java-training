package com.lazada.assets;

public class Monkey { // reference type
	
	
	public static int numMonkeys = 0;// BELONGS TO CLASS, NOT OBJECT - usually for tracking amount of objs
	
	private int bananas;
	private String name;
	
	public static void showMonkeys() { // NON-STATIC MEMBERS CANNOT BE INSIDE STATIC
			System.out.format("There are %d monkey objects\n", numMonkeys);
	}
	
	public Monkey() {
		System.out.println("Default Monkey Constructor");
		this.name = "DEFAULT";
		this.bananas = 0;
		numMonkeys++;
	}
	
	public Monkey(String name, int bananas) { // function with same name as a class and no return
		System.out.println("Overloaded Monkey Constructor");
		this.name = name;
		this.bananas = bananas;
		numMonkeys++;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getBananas() {
		return this.bananas;
	}
	
	public void eating() {
		System.out.println(this.name + " is eating....");
	}
	
	public void eating(boolean real) {
		if (real) {
			System.out.println("real eat");
			this.bananas--;
		}
	}
}
