package com.mvladimirovich.paymaster.accounts;

import com.mvladimirovich.paymaster.common.Log;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class Account implements IWithdrawable, IDepositable, Serializable {

    private double depositFee = 0;
    private double withdrawFee = 0;

    static int accCnt = 0;

    private int id;
	private AccountTypeEnum type;
	private String holderName;
	private double balance;

    public Account(AccountTypeEnum type, String holder, double initBalance) {
        this.holderName = holder;
        this.type = type;
        this.balance = initBalance;
        this.id = accCnt++;
    }

	public Account(Integer id, AccountTypeEnum type, String holder, double initBalance) {
		this.holderName = holder;
		this.type = type;
		this.balance = initBalance;
		this.id = id;
	}

    public void setDepositFee(double depositFee) {
        this.depositFee = depositFee;
    }

    public void setWithdrawFee(double withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

	public void changeBalance(double delta) {
	    this.balance += delta;
    }

    protected boolean isDepositLegal(double moneyToDeposit){
        return this.balance + moneyToDeposit >= depositFee;
    }

    protected boolean isWithdrawLegal(double moneyToWithdraw){
        return this.balance - moneyToWithdraw >= withdrawFee;
    }

    @Override
    public void deposit(double moneyToDeposit) {
        if(isDepositLegal(moneyToDeposit)) {
            changeBalance(moneyToDeposit-depositFee);
        }
    }

    @Override
    public void withdraw(double moneyToWithdraw) {
        if(isWithdrawLegal(moneyToWithdraw)) {
            changeBalance(-moneyToWithdraw-withdrawFee);
        }
    }

    public double getBalance() {
		return this.balance;
	}

    public String printBalance() {
		Locale current = Locale.getDefault();
		NumberFormat nf = NumberFormat.getCurrencyInstance(current);
		return nf.format(this.balance);
	}
}
