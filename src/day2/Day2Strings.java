package day2;

import com.lazada.assets.Monkey;

public class Day2Strings {  /// IMMUTABLE AND REFERENCE!

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words = "These are some words"; // no need to use new String("")
		String others = "These are some words";
		//words += ". And so are these";
		
		Monkey obj1 = new Monkey("Obj", 10);
		Monkey obj2 = new Monkey("Obj", 10);
		
		System.out.println(obj1 == obj2); // comparing memory address, not values (For ref only)
		System.out.println(obj1);
		System.out.println(obj2);
		
		System.out.println(words.equals(others));
		
		String a1 = "TEST";
		String a2 = "T" + "EST";
		
		System.out.println(a1 == a2);
		
		System.out.println(words.toString());
		
		StringBuilder strBuilder = new StringBuilder(200);
		strBuilder.append("Highway to hell.\n");
		strBuilder.append("Highway to hell.\n");
		strBuilder.append("Highway to hell.\n");
		strBuilder.append("Highway to hell, yeah\n");
		System.out.println(strBuilder.toString());     // SB will concatenate only after toString()
	}

}
