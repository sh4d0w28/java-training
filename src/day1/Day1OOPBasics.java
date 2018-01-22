package day1;

import com.lazada.assets.Monkey;


public class Day1OOPBasics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Monkey tiki = new Monkey("Tiki", 10); // tiki is ref, object is in memory
		tiki.eating();
		
		Monkey slava = new Monkey("Slava", 25);
		slava.eating();
	}

}
