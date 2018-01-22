package day2;

import day2.assets.Child;

public class Day2Inheritance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {  // inherrit public stuff
		// TODO Auto-generated method stub
		Child obj = new Child();
		obj.doSomething(); // call child
		obj.doSomething("!"); /// call parent stuff
		obj.play();
	}

}
