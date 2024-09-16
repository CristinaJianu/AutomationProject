package pages;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {
    public WebDriver driver;
    public ElementMethods elementMethods;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods=new ElementMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    public WebElement webTableSubMenu;

    public void clickWebTable()
    {
        elementMethods.clickJsElement(webTableSubMenu);
    }
}
