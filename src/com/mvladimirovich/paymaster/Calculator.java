package com.mvladimirovich.paymaster;

import com.mvladimirovich.paymaster.common.Log;

class Calculator {

    private static final int taxrate = 45;
    private static final int basicHrs = 40;
    private static final double otRate = 1.5;
    private static final int basicPay = 650000;

    public static double calculateGrossNet(double workingHrs) {
        double gross, taxes, net;
        if (workingHrs > basicHrs) {
            gross = basicHrs * basicPay + (workingHrs - basicHrs) * basicPay * otRate;
        } else {
            gross = workingHrs * basicPay;
        }
        //get tax
        taxes = gross * taxrate / 100;
        //get net
        net = gross - taxes;
        Log.printlnGood("-- RESULT --");
        Log.printFormatGood("Gross Pay:\t%20.0f₫\n", gross);
        Log.printFormatGood("(-) Tax:\t%20.0f₫\n", taxes);
        Log.printFormatGood("Nett Pay:\t%20.0f₫\n", net);
        Log.printlnGood("-- ------ --");
        return net;
    }
}
