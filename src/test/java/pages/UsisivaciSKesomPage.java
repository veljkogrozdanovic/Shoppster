package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsisivaciSKesomPage extends BaseHelper
{
    @FindBy(xpath = "/html/body/ung-root/ung-storefront/main/cx-page-layout/cx-page-slot[1]/ung-product-facet-navigation/div/div[5]/ul/li[1]/div/label/input")
    WebElement seller;

    @FindBy(xpath = "/html/body/ung-root/ung-storefront/main/cx-page-layout/cx-page-slot[5]/ung-product-list/div/section/div/div/ung-product-pagination/div/div[1]/div[1]")
    WebElement firstItem;

    public UsisivaciSKesomPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    private void selectSeller()
    {
        seller.click();
    }
    private void selectFirstItem()
    {
        firstItem.click();
    }
    public void choosProduct() throws InterruptedException {
        selectSeller();
        Thread.sleep(1000);
        selectFirstItem();
    }
}
