package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends BasePage {
    public FormsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceFormSubMenu;

    public void clickPracticeFormSubMenu() {
        elementMethods.clickJsElement(practiceFormSubMenu);
        loggerUtility.infoLog("The user clicks on practice form submenu");

    }

}