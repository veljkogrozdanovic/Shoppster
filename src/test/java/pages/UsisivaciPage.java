package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsisivaciPage extends BaseHelper
{
    @FindBy(linkText = "Usisivači s kesom")
    WebElement usisivaciSaKesomBTN;

    public UsisivaciPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void chooseUsisivaciSaKesom()
    {
        usisivaciSaKesomBTN.click();
    }
}

