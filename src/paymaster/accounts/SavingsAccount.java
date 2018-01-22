package paymaster.accounts;

import paymaster.log.Log;

public class SavingsAccount extends Account{
	
	private final double depositFee = -0.5;
	
	public SavingsAccount(String string, double d) {
		super(string, d);
	}

	@Override
	public void deposit(double moneyToDeposit) {
		//increaseBalance(0.5);
		double amt = getBalance();
		setBalance(amt + moneyToDeposit - depositFee);
		printBalance();		
	}
	
	private boolean isWithDrawLegal(double moneyToWithdraw){
		return getBalance() - moneyToWithdraw >= 0;
	}
	
	@Override
	public void withdraw(double moneyToWithdraw) {
		// no penalty withdraw
		double amt = getBalance();
		if(isWithDrawLegal(moneyToWithdraw)) {
			setBalance(amt - moneyToWithdraw);
			printBalance();
		} else {
			Log.printlnError(ERR_CANNOTAFFORD);
		}
	}
}
