package com.mvladimirovich.paymaster.accounts;

public class CheckingAccount extends Account{

	public CheckingAccount(Integer id, String string, double d) {

		super(id, AccountTypeEnum.CHECKING, string, d);
		setDepositFee(0.5);
		setWithdrawFee(0.5);
	}

	public CheckingAccount(String string, double d) {
		super(AccountTypeEnum.CHECKING, string, d);
		setDepositFee(0.5);
		setWithdrawFee(0.5);
	}
}