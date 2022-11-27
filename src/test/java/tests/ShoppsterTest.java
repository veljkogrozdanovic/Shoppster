package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;
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
        //Thread.sleep(1500);
        srafilicaSearchPage.ChooseSraflica();
        Thread.sleep(1000);

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
    }

    @Test
    public void usisivaciSaKesomTest() throws InterruptedException
    {
        String pageTitle = "Usisivači s kesom";
        ShoppsterHomePage shoppsterHomePage = new ShoppsterHomePage(driver);
        MaliKucniAparatiPage maliKucniAparatiPage = new MaliKucniAparatiPage(driver);
        UsisivaciPage usisivaciPage = new UsisivaciPage(driver);

        shoppsterHomePage.chooseMaliKucniAparati();
        Thread.sleep(1000);
        maliKucniAparatiPage.chooseUsisivaci();
        Thread.sleep(1000);
        usisivaciPage.chooseUsisivaciSaKesom();
        Thread.sleep(1000);

        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("CategoryPageHeadingSlot")));
        WebElement results = driver.findElement(By.className("CategoryPageHeadingSlot"));
        Assert.assertTrue("Page title doesn't match",results.getText().contains(pageTitle));
     }

    @Test

    public void checkPriceTest() throws InterruptedException
    {
        String productsNumber = "3";

        ShoppsterHomePage shoppsterHomePage = new ShoppsterHomePage(driver);
        MaliKucniAparatiPage maliKucniAparatiPage = new MaliKucniAparatiPage(driver);
        UsisivaciPage usisivaciPage = new UsisivaciPage(driver);
        UsisivaciSKesomPage usisivaciSKesomPage = new UsisivaciSKesomPage(driver);
        FirstItemPage firstItemPage = new FirstItemPage(driver);

       shoppsterHomePage.chooseMaliKucniAparati();
       Thread.sleep(1500);
       maliKucniAparatiPage.chooseUsisivaci();
       Thread.sleep(1500);
       usisivaciPage.chooseUsisivaciSaKesom();
       Thread.sleep(1500);
       usisivaciSKesomPage.choosProduct();
       Thread.sleep(1500);
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("price__value--special")));
        WebElement priceElement = driver.findElement(By.className("price__value--special"));
        String priceText = priceElement.getText().replace(" ","").replace(".","");
        float price = Float.parseFloat((priceText));
        System.out.println("Price is:"+price);

        firstItemPage.addProductsToCart(productsNumber);
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart-page__title")));
        WebElement totalPriceElement = driver.findElement(By.className("price__value--special"));
        String totalPriceText = totalPriceElement.getText().replace(" ","").replace(".","");
        float totalPrice = Float.parseFloat(totalPriceText);
        System.out.println("Total price is:"+totalPrice);
        float numberOfProducts = Float.parseFloat(productsNumber);

        Assert.assertEquals(true, totalPrice == numberOfProducts * price);
    }
}
