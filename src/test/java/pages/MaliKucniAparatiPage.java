package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaliKucniAparatiPage extends BaseHelper
{
    @FindBy(linkText = "Usisivači")
    WebElement usisivaci;

    public MaliKucniAparatiPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void chooseUsisivaci()
    {
        usisivaci.click();
    }
}

