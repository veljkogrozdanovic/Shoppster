package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SrafilicaSearchPage extends BaseHelper
{
    @FindBy(xpath = "/html/body/ung-root/ung-storefront/main/cx-page-layout/cx-page-slot[2]/ung-product-facet-navigation/div/div[2]/ul/li[3]/div/label/input")
    WebElement boschCheckbox;

    @FindBy(xpath = "/html/body/ung-root/ung-storefront/main/cx-page-layout/cx-page-slot[2]/ung-product-facet-navigation/div/div[4]/ul/li[2]/div/label/input")
    WebElement priceRange;



    public SrafilicaSearchPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private void SelectBosch()
    {
        wdWait.until(ExpectedConditions.visibilityOf(boschCheckbox));
        boschCheckbox.click();
    }
    private void SelectPriceRange()
    {
        wdWait.until(ExpectedConditions.visibilityOf(priceRange));
        priceRange.click();
    }


    public void ChooseSraflica() throws InterruptedException
    {
        SelectBosch();
        Thread.sleep(2000);
        SelectPriceRange();
    }
}