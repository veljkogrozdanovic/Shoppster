package pages;

import helpers.BaseHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstItemPage extends BaseHelper
{
    @FindBy(className = "icon-cart")
    WebElement cart;
    @FindBy(xpath = "/html/body/ung-root/ung-storefront/main/cx-page-layout/cx-page-slot[2]/ung-product-details/div/div/div[2]/div/div[2]/ung-add-to-cart/div[1]/cx-item-counter/input")
    WebElement numberOfProducts;
    @FindBy(className = "btn__text")
    WebElement addToCartBtn
            ;
    public FirstItemPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    private void selectNumberOfProducts(String productsNumber)
    {
        String s = Keys.chord(Keys.CONTROL, "a");

        numberOfProducts.sendKeys(s);
        numberOfProducts.sendKeys("3");
    }

    private void clickAddToCart()
    {
       addToCartBtn.click();
    }

    private void openCart()
    {
        cart.click();
    }

    public void addProductsToCart(String productsNumber)
    {

        selectNumberOfProducts(productsNumber);
        clickAddToCart();
        openCart();
    }

}
