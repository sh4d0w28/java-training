package com.mvladimirovich.paymaster.accounts;

public class SavingsAccount extends Account{

	public SavingsAccount(Integer id, String string, double d) {
		super(id, AccountTypeEnum.SAVINGS, string, d);
		setDepositFee(-0.5);
		setWithdrawFee(0);
	}

	public SavingsAccount(String string, double d) {
		super(AccountTypeEnum.SAVINGS, string, d);
		setDepositFee(-0.5);
		setWithdrawFee(0);
	}
}