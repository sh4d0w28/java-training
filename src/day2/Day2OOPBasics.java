package day2;

import com.lazada.assets.Monkey;

public class Day2OOPBasics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Monkey.numMonkeys); // static belongs to class
		
		Monkey.showMonkeys();
		
		Monkey obj = new Monkey("Monkey Object", 10); // create ref
		System.out.println(obj.getBananas());
		Monkey refer = obj; // create ref
		Monkey obj2 = new Monkey();
		System.out.println(refer.getName());
		System.out.println(obj2.getName());
		
		obj = null; // lost ref
		refer = null; // lost ref, marked for GC. 
		
		//System.out.println(obj2.numMonkeys);
		Monkey.showMonkeys();
		
		System.gc(); // GC REQUEST (doesnt mean it will run)

	}

}
