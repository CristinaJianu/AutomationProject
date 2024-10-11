package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindowsMenu;
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;
    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickForms()
    {
        elementMethods.clickJsElement(formsMenu);
        loggerUtility.infoLog("The user clicks on Forms Menu");


    }
    public void clickAlertFrameWindow()
    {
        elementMethods.clickJsElement(alertsFrameWindowsMenu);
        loggerUtility.infoLog("The user clicks on Alert, Frame & Window menu");
    }

    public void clickElements()
    {
        elementMethods.clickJsElement(elementsMenu);
        loggerUtility.infoLog("The user clicks on Elements menu");
    }


}
