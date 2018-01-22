package com.lazada.assets;

public class Outer {

	private int data;
	private Inner depend;
	
	public Outer() {
		this.depend = new Inner();
	}
	
	public class Inner {  // have access to private vars from outer
		public int doSomething() {
			return data;
		}
	}
}
