package day2;

import com.lazada.assets.Outer;

public class Day2InnerClasses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer refObj = new Outer();
		Outer.Inner refInner = refObj.new Inner();
		
		System.out.println(refInner);
	}

}
