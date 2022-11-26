package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppsterHomePage extends BaseHelper

{
    @FindBy(className = "searchbox--rounded")
    WebElement searchBar;

    @FindBy(className = "searchbox__icon")
    WebElement searchButton;

    @FindBy(className = "btn-primary")
    WebElement cookiesButton;

    @FindBy(linkText = "Mali kućni aparati")
    WebElement mkaButton;

    public ShoppsterHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private void navigateToShopsterHomePage() {driver.get("https://www.shoppster.rs/");}

    private void acceptCookies() throws InterruptedException
    {
        if (driver.findElements(By.className("btn-primary")).size() != 0)
            wdWait.until(ExpectedConditions.elementToBeClickable(cookiesButton));
        Thread.sleep(2000);
        cookiesButton.click();
    }

    private void selectItems(String items)
    {
        searchBar.sendKeys(items);
    }
    private void clickSearchButton()
    {
        searchButton.click();
    }

    private void selectMaliKucniAparati()
    {
        mkaButton.click();
    }
    public void chooseItems(String items) throws InterruptedException {
        navigateToShopsterHomePage();
        acceptCookies();
        selectItems(items);
        clickSearchButton();
    }
    public  void chooseMaliKucniAparati() throws InterruptedException {
        navigateToShopsterHomePage();
        acceptCookies();
        selectMaliKucniAparati();
    }

}
