package day2;

import day2.assets.Child;
import day2.assets.OtherChild;
import day2.assets.Parent;

public class Day2Polimorphism {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent refer = new Child();
		refer = new OtherChild();
		System.out.println(refer);
		
		Parent[] listOfObjects = new Parent[10];
		listOfObjects[0] = new Child();
		listOfObjects[1] = new OtherChild();
		
		if (listOfObjects[0] instanceof Child) {
			Child childEl = (Child) listOfObjects[0];
			childEl.play();
		}
	}

}
