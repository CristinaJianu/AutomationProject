package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage {

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsSubMenu;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindowsSubMenu;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesSubMenu;
    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement nestedFramesSubMenu;

    public AlertFrameWindowPage(WebDriver driver) {
        super(driver);
    }

    public void clickAlert() {
        elementMethods.clickJsElement(alertsSubMenu);
    }

    public void clickBrowserWindowsSubMenu() {
        elementMethods.clickJsElement(browserWindowsSubMenu);
    }

    public void clickFramesSubMenu() {
        elementMethods.clickJsElement(framesSubMenu);
    }

    public void clickNestedFramesSubMenu() {
        elementMethods.clickJsElement(nestedFramesSubMenu);
    }
}
