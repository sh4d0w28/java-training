package com.mvladimirovich.paymaster.accounts;

import org.junit.Assert;
import org.junit.Test;

public class SavingsAccountTest {

    @Test
    public void constructorTest() {
        SavingsAccount ca = new SavingsAccount("TEST", 0);
        SavingsAccount ca2 = new SavingsAccount(0, "TEST", 0);
    }

    @Test
    public void setDepositFee() {
        SavingsAccount ca = new SavingsAccount("TEST", 0);
        ca.setDepositFee(5);
        Assert.assertFalse(ca.isDepositLegal(4));
        ca.setDepositFee(0);
        Assert.assertTrue(ca.isDepositLegal(4));
    }

    @Test
    public void setWithdrawFee() {
        SavingsAccount ca = new SavingsAccount("TEST", 200);
        Assert.assertTrue(ca.isWithdrawLegal(200));
        ca.setWithdrawFee(0.5);
        Assert.assertFalse(ca.isWithdrawLegal(200));
    }

    @Test
    public void changeBalance() {
        SavingsAccount ca = new SavingsAccount("TEST", 200);
        Assert.assertEquals(200.0, ca.getBalance(), 0);
        ca.changeBalance(-20);
        Assert.assertEquals(180.0, ca.getBalance(), 0);
    }

    @Test
    public void isDepositLegal() {
        SavingsAccount ca = new SavingsAccount("TEST", 0);
        ca.setDepositFee(200);
        Assert.assertFalse(ca.isDepositLegal(0.1));
        ca.setDepositFee(0);
        Assert.assertTrue(ca.isDepositLegal(0.6));
    }

    @Test
    public void isWithdrawLegal() {
        SavingsAccount ca = new SavingsAccount("TEST", 100);
        ca.setWithdrawFee(5);
        Assert.assertFalse(ca.isWithdrawLegal(100));
        Assert.assertTrue(ca.isWithdrawLegal(95));
    }

    @Test
    public void deposit() {
        SavingsAccount ca = new SavingsAccount("TEST", 100);
        ca.deposit(200);
        Assert.assertEquals(300.5, ca.getBalance(), 0);
    }

    @Test
    public void withdraw() {
        SavingsAccount ca = new SavingsAccount("TEST", 100);
        ca.withdraw(5);
        Assert.assertEquals(95, ca.getBalance(), 0);
    }

    @Test
    public void getBalance() {
        SavingsAccount ca = new SavingsAccount("TEST", 100);
        ca.withdraw(5);
        Assert.assertEquals(95, ca.getBalance(), 0);
        ca.withdraw(5);
        Assert.assertEquals(90, ca.getBalance(), 0);
    }
}