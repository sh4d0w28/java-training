package day2.exercise;

import paymaster.accounts.Account;
import paymaster.accounts.CheckingAccount;
import paymaster.accounts.SavingsAccount;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account account1 = new CheckingAccount("Test subject #24248", 200.0);
		Account account2 = new SavingsAccount("Test subject #523581", 2.000);
			
		System.out.println("--- INIT ---");
		System.out.println(account1);
		System.out.println(account2);
		
		System.out.println("--- PROCESS ---");
		account1.withdraw(199.3);
		account2.deposit(1);
		
		account1.withdraw(199.3);
		account2.withdraw(199.3);
	}

}