package day1.exercise;
import java.util.Scanner;

// JAVA 8 has label, not 7

public class Day1SecondExercise {

	public static final int taxrate = 45;
	public static final double otRate = 1.5;
	public static final int basicPay = 650000;
	public static final int basicHrs = 40;
	
	public static Scanner uinput;
	
	public static void init() {
		uinput = new Scanner(System.in);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		init();
		boolean mOARmOAR;
		do {
			// get hours		
			double workingHrs = getWorkingHours();
			calculateAndPrint(workingHrs);
			mOARmOAR = isWantMore();			
		} while (mOARmOAR);
	}
	public static void calculateAndPrint(double workingHrs) {
/*

		double gross, taxes, net;
		if (workingHrs > basicHrs) {
			gross = basicHrs * basicPay +
					(workingHrs - basicHrs) * basicPay * otRate;
		} else {
			gross = workingHrs * basicPay;
		}
		//get tax
		taxes = gross * taxrate / 100;
		//get net
		net = gross - taxes;
		
		print(gross, taxes, net);
*/
	}

	public static boolean isWantMore(){
		System.out.print("ANOTHER ONE (y/n)? />");
		String confimation = uinput.nextLine();
		if ( confimation.toLowerCase().startsWith("y") ) {
			return true;
		}
		System.out.println(" okay ");
		return false;
	}
	
	public static double getWorkingHours() {
		System.out.print("WHRS: /> ");
		double workingHrs = 0;
		try {
			workingHrs = Double.parseDouble(uinput.nextLine());
			if (workingHrs < 0) {
				throw new Exception("zero hrs");
			}
		} catch (Exception ex) {
			System.out.println("[ERR]: Wrong amount of hours");
		}
		return workingHrs;
	}
	
	public static void print(double gross, double taxes, double net) {
		
		System.out.format( "Gross Pay:\t%150.0f₫\n", gross);
		System.out.format("(-) Tax:\t%150.0f₫\n", taxes);
		System.out.format("Nett Pay:\t%150.0f₫\n", net);		
	}
}
