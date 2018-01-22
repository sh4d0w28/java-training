package paymaster;

public class Calculator {

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

        System.out.format("-- RESULT --\n");
        System.out.format( "Gross Pay:\t%20.0f₫\n", gross);
        System.out.format("(-) Tax:\t%20.0f₫\n", taxes);
        System.out.format("Nett Pay:\t%20.0f₫\n", net);
        System.out.format("-- ------ --\n");

        return net;
    }

    private static void print() {

    }
}
