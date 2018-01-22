package day2;

import com.lazada.assets.Monkey;

public class Day2RefArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[10];
		numbers[5] = 20;
		
		Monkey[] monkeys = new Monkey[10]; // array of 10 refs to null
		for(int i=0; i<monkeys.length; i++) {
			monkeys[i] = new Monkey();
		}
		monkeys[0].eating();
	}

}
