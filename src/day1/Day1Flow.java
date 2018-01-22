package day1;
import java.util.Scanner;


public class Day1Flow {
	
	public static void main(String[] args) {
		
		Scanner uin = new Scanner(System.in);
		// // String, enum, integer, char - STRING - JRE FROM 7 - on exam
//		switch(uin.nextLine()) {
//			case "English":
//				System.out.println("Hello");
//				break;
//			case "Vienamese":
//				System.out.println("Xin chao");
//				break;
//			case "Russian":
//				System.out.println("Privet");
//				break;
//			case "Hindi":
//				System.out.println("Namaste");
//				break;
//			case "Tamil": 
//				System.out.println("Vanakam");
//				break;
//			case "Malay": 
//				System.out.println("Apa Khabar");
//				break;
//			default:
//				break; // recommended
//		}
		
		int counter = 0;
		while(counter < 10) {
			System.out.println(counter++);
		}
		
		do
			System.out.println(counter--);
		while (counter > 0);
		
		// for(initializer; expression; iterator)
		
		for(int i = 0, j = 10; i<20 && j<10; i++, j++) { // same types only
			
		}
		uin.close();
	}

}
