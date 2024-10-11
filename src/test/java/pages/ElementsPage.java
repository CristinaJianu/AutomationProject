package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage{
    @FindBy(xpath = "//span[text()='Web Tables']")
    public WebElement webTableSubMenu;

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickWebTable()
    {
        elementMethods.clickJsElement(webTableSubMenu);
        loggerUtility.infoLog("The user clicks on web table submenu");

    }
}
