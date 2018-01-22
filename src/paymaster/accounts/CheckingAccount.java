package paymaster.accounts;

import paymaster.log.Log;

public class CheckingAccount extends Account{
	
	private final double depositFee = 0.5;
	private final double withdrawFee = 0.5;
	
	public CheckingAccount(String string, double d) {
		super(string, d);
	}

	private boolean isDepositLegal(double moneyToDeposit){
		return getBalance() + moneyToDeposit >= depositFee;
	}
	
	private boolean isWithDrawLegal(double moneyToWithdraw){
		return getBalance() - moneyToWithdraw >= withdrawFee;
	}
	
	@Override
	public void deposit(double moneyToDeposit) {
		double amt = getBalance();
		
		if(isDepositLegal(moneyToDeposit)) {
			setBalance(amt + moneyToDeposit - depositFee);
			printBalance();			
		} else {
			Log.printlnError(ERR_CANNOTAFFORD);
		}
		
	}
	
	@Override
	public void withdraw(double moneyToWithdraw) {
		double amt = getBalance();
		
		if(isWithDrawLegal(moneyToWithdraw)) {
			setBalance(amt - moneyToWithdraw - withdrawFee);
			printBalance();
		} else {
			Log.printlnError(ERR_CANNOTAFFORD);
		}
	}
	
}