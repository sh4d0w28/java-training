package paymaster.accounts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

// ONE FUNCTION SHOULD RETURN COLLECTION
// HAS TO BE ANNOTATED WITH Parameterized.Parameters


@RunWith(Parameterized.class)
public class CheckingAccountTestParam {

    private String hName;
    private double startBal;
    private double testAmount;
    private CheckingAccount ca;

    @Test
    public void test() {
        ca.withdraw(this.testAmount);
        Assert.assertTrue(ca.getBalance() > 0);
    }

    public CheckingAccountTestParam(String hName, double startBal, double testAmount) {
        this.hName = hName;
        this.startBal = startBal;
        this.testAmount = testAmount;
    }

    @Before
    public void setup() {
        ca = new CheckingAccount(this.hName, this.startBal);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {"hName", 100, 150},
                {"hName2", 0, -20},
                {"Loc", 2000, 1500}
        });
    }
}