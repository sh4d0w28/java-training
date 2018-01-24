package com.mvladimirovich.paymaster.users;

import com.mvladimirovich.paymaster.accounts.Account;
import com.mvladimirovich.paymaster.accounts.AccountTypeEnum;
import com.mvladimirovich.paymaster.accounts.CheckingAccount;
import com.mvladimirovich.paymaster.accounts.SavingsAccount;

import java.io.Serializable;

public class User implements Serializable {

    private static int userCount = 1;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private int id;
    private final String name;
    private Account account;

    public User(String name, AccountTypeEnum accountType, double initBalance) {
        this.name = name;

        switch (accountType) {
            case CHECKING:
                this.account = new CheckingAccount(name, initBalance);
                this.id = userCount++;
                break;
            case SAVINGS:
                this.account = new SavingsAccount(name, initBalance);
                this.id = userCount++;
                break;
            default:
                break;
        }
    }

    public void doDeposit(double d) {
        account.deposit(d);
    }

    @Override
    public String toString() {
        return String.format("#%3d %s (%s) ::: %s", id, name, account.printBalance(), this.hashCode());
    }
}
