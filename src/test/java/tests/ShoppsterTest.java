package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MaliKucniAparatiPage;
import pages.ShoppsterHomePage;
import pages.SrafilicaSearchPage;
import pages.UsisivaciPage;

import java.util.List;

public class ShoppsterTest extends BaseTest
{
    @Test
    public void srafilicaTest() throws InterruptedException
    {
        String searchTerm = "Srafilica";
        String brand = "Bosch";

        ShoppsterHomePage shopsterHomePage = new ShoppsterHomePage(driver);
        SrafilicaSearchPage srafilicaSearchPage = new SrafilicaSearchPage(driver);

        shopsterHomePage.chooseItems(searchTerm);
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

    @Test
    public void usisivaciSaKesomTest() throws InterruptedException
    {
        String pageTitle = "Usisivači s kesom";
        ShoppsterHomePage shoppsterHomePage = new ShoppsterHomePage(driver);
        MaliKucniAparatiPage maliKucniAparatiPage = new MaliKucniAparatiPage(driver);
        UsisivaciPage usisivaciPage = new UsisivaciPage(driver);

        shoppsterHomePage.chooseMaliKucniAparati();
        maliKucniAparatiPage.chooseUsisivaci();
        usisivaciPage.chooseUsisivaciSaKesom();

        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("CategoryPageHeadingSlot")));
        WebElement results = driver.findElement(By.className("CategoryPageHeadingSlot"));
        Assert.assertTrue("Page title doesn't match",results.getText().contains(pageTitle));
     }
}
