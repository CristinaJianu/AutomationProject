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
        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        tabMethods.switchSpecificTab(0);
    }

    public void dealWindowProcess()
    {
        elementMethods.clickJsElement(windowButtonElement);
        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        tabMethods.quitTab();
    }
}
