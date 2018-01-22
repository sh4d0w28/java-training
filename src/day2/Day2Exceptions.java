package day2;

import java.util.Scanner;

public class Day2Exceptions {

	public static void doSomething() throws NewException
	{
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner uin = new Scanner(System.in);
		
		try{
			
			//RULES: 
			// 1. try block must be accompany with catch or finally block
			// 2. No code in between blocks
			// 3. catch blocks must be arranged from less common to most common
			
			System.out.print(" >> ");
			int x = Integer.parseInt(uin.nextLine());
			
			System.out.print(" >> "); 
			int y = Integer.parseInt(uin.nextLine());
			
			int z = x / y;
			
			throw new NewException();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		} // TRY / CATCH WILL EXECUTED TWICE. One time in shadow space, second in real. So double time and double memory.
	}

}

class NewException extends Exception {
	
	public NewException() {
		super("Segmentation fault");
	}
}