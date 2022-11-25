package tests;

import org.junit.Test;
import pages.ShoppsterHomePage;

public class ShoppsterTest extends BaseTest
{
    @Test
    public void shopsterTest() throws InterruptedException {
        ShoppsterHomePage shopsterHomePage = new ShoppsterHomePage(driver);

        shopsterHomePage.choosItems("Srafilica");
    }
}
