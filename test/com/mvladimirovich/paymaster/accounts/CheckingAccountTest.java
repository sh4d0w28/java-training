package com.mvladimirovich.paymaster.accounts;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

public class CheckingAccountTest {

    @Test
    public void constructorTest() {
        CheckingAccount ca = new CheckingAccount("TEST", 0);
        CheckingAccount ca2 = new CheckingAccount(0, "TEST", 0);
    }

    @Test
    public void setDepositFee() {
        CheckingAccount ca = new CheckingAccount("TEST", 0);
        ca.setDepositFee(5);
        Assert.assertFalse(ca.isDepositLegal(4));
        ca.setDepositFee(0);
        Assert.assertTrue(ca.isDepositLegal(4));
    }

    @Test
    public void setWithdrawFee() {
        CheckingAccount ca = new CheckingAccount("TEST", 200);
        Assert.assertFalse(ca.isWithdrawLegal(200));
        ca.setWithdrawFee(0);
        Assert.assertTrue(ca.isWithdrawLegal(200));
    }

    @Test
    public void changeBalance() {
        CheckingAccount ca = new CheckingAccount("TEST", 200);
        Assert.assertEquals(200.0, ca.getBalance(), 0);
        ca.changeBalance(-20);
        Assert.assertEquals(180.0, ca.getBalance(), 0);
    }

    @Test
    public void isDepositLegal() {
        CheckingAccount ca = new CheckingAccount("TEST", 0);
        Assert.assertFalse(ca.isDepositLegal(0.1));
        ca.setDepositFee(0);
        Assert.assertTrue(ca.isDepositLegal(0.6));
    }

    @Test
    public void isWithdrawLegal() {
        CheckingAccount ca = new CheckingAccount("TEST", 100);
        ca.setWithdrawFee(5);
        Assert.assertFalse(ca.isWithdrawLegal(100));
        Assert.assertTrue(ca.isWithdrawLegal(95));
    }

    @Test
    public void deposit() {
        CheckingAccount ca = new CheckingAccount("TEST", 100);
        ca.deposit(200);
        Assert.assertEquals(299.5, ca.getBalance(), 0);
    }

    @Test
    public void withdraw() {
        CheckingAccount ca = new CheckingAccount("TEST", 100);
        ca.withdraw(5);
        Assert.assertEquals(94.5, ca.getBalance(), 0);
    }

    @Test
    public void getBalance() {
        CheckingAccount ca = new CheckingAccount("TEST", 100);
        ca.withdraw(5);
        Assert.assertEquals(94.5, ca.getBalance(), 0);
        ca.withdraw(5);
        Assert.assertEquals(89, ca.getBalance(), 0);
    }
}