package day1;
import java.util.Scanner;

public class Day1FirstExercise {	
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner uinput = new Scanner(System.in);
		
		int taxrate = 45;
		double otRate = 1.5;
		int basicPay = 650000;
		int basicHrs = 40;
		
		// get hours		
		System.out.print("WHRS: /> ");
		double workingHrs = 0;
		try {
			workingHrs = Double.parseDouble(uinput.nextLine());
			if (workingHrs < 0) {
				uinput.close();
				throw new Exception("zero hrs");
			}
		} catch (Exception ex) {
			System.out.println("[ERR]: Wrong amount of hours");
			uinput.close();
			return;
		}
		
		// calculate gross
		double gross = 0;
		if (workingHrs > basicHrs) {
			gross = basicHrs * basicPay +
					(workingHrs - basicHrs) * basicPay * otRate;
		} else {
			gross = workingHrs * basicPay;
		}
		//get tax
		double taxes = gross * taxrate / 100;
		
		//get net
		double net = gross - taxes;
		
		print(gross, taxes, net);
		uinput.close();
	}
	
	public static void print(double gross, double taxes, double net) {
		
		System.out.format( "Gross Pay:\t%150.0f₫\n", gross);
		System.out.format("(-) Tax:\t%150.0f₫\n", taxes);
		System.out.format("Nett Pay:\t%150.0f₫\n", net);		
	}
}
