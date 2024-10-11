package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabWindowPage extends BasePage {
    @FindBy(id = "tabButton")
    private WebElement tabButtonElement;
    @FindBy(id = "windowButton")
    private WebElement windowButtonElement;

    public TabWindowPage(WebDriver driver) {
        super(driver);
    }

    public void dealTabProcess()
    {
        elementMethods.clickJsElement(tabButtonElement);
        loggerUtility.infoLog("The user clicks on tab button element");

        tabMethods.switchSpecificTab(1);
        loggerUtility.infoLog("The user switches to a specific tab");

        tabMethods.closeCurrentTab();
        loggerUtility.infoLog("The user closes the current tab");

        tabMethods.switchSpecificTab(0);
        loggerUtility.infoLog("The user switches to a specific tab");

    }

    public void dealWindowProcess()
    {
        elementMethods.clickJsElement(windowButtonElement);
        loggerUtility.infoLog("The user clicks on window button submenu");

        tabMethods.switchSpecificTab(1);
        loggerUtility.infoLog("The user switches to a specific tab");

        tabMethods.closeCurrentTab();
        loggerUtility.infoLog("The user closes the current tab");

        tabMethods.quitTab();
        loggerUtility.infoLog("The user quits the tab");

    }
}
