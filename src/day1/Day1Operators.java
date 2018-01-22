package day1;
import java.util.Scanner;


public class Day1Operators {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		 TODO Auto-generated method stub
//
//		() Brackets
//		% Modulus
//		/ Div
//		* Multiply
//		+ Add
//		- Sub
		
//		++, --
		
		//double celcius = (212 - 32) * 5 / 9;
		//System.out.println(celcius);
		
		
//		 Relational Operators
//		> < != == >= <=
		
// LOGICAL
//		&&
//		||
//		!
		

		Scanner uinput = new Scanner(System.in);
		int x = Integer.parseInt(uinput.nextLine());
		double y = Double.parseDouble(uinput.nextLine());
		
		if (x != y) {
			System.out.println("NOT EQ");
		}
		
		uinput.close();
		
	}

}
