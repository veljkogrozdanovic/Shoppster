package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.ShoppsterHomePage;
import pages.SrafilicaSearchPage;

import java.util.List;

public class ShoppsterTest extends BaseTest
{
    @Test
    public void shopsterTest() throws InterruptedException
    {
        String searchTerm = "Srafilica";
        String brand = "Bosch";
        ShoppsterHomePage shopsterHomePage = new ShoppsterHomePage(driver);
        SrafilicaSearchPage srafilicaSearchPage = new SrafilicaSearchPage(driver);

        shopsterHomePage.choosItems(searchTerm);
        Thread.sleep(1500);
        srafilicaSearchPage.ChooseSraflica();
        Thread.sleep(1500);

        WebElement results = driver.findElement(By.className("plp__title"));
        Assert.assertTrue("Search term doesn't match",results.getText().contains(searchTerm));

        WebElement resultsContainer = driver.findElement(By.className("row"));
        List<WebElement> articlesList = resultsContainer.findElements(By.className("plp__item"));
        System.out.println("Number of articles is:"+articlesList.size());

        for (WebElement article : articlesList)
        {
            WebElement elementTittle = article.findElement(By.tagName("a"));
            Assert.assertTrue("Tittle doesn't contain requested Brand.\nTittle is: "+elementTittle.getText()+ "\nRequested brand: "+brand,
                    elementTittle.getText().contains(brand));
        }

        Thread.sleep(1000);
    }
}
