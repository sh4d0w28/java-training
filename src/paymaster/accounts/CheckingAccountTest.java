package paymaster.accounts;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class CheckingAccountTest {

    private Account ca;

    @BeforeClass
    public static void classSetup() {
        System.out.println("befire class even start");
    }

    @Before
    public void testSetup() {
        ca = new CheckingAccount("Tiki", 200);
    }

    @Test
    public void test() {
        int x = 5;
        Assert.assertEquals(5,x);
    }

    @Test
    public void testCheckingAccountIsCreatable() {

        Assert.assertNotNull(ca);
    }

    @Test
    public void ensureAccountHasPositive() {

        ca.withdraw(1000);
        Assert.assertTrue(ca.getBalance() == 200);
    }

    @Test
    public void testAssertThat() {
        Assert.assertThat("Aiki", CoreMatchers.either(CoreMatchers.containsString("T")).or(CoreMatchers.containsString("K")));
    }
}