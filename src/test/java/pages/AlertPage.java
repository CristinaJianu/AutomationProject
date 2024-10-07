package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{
    @FindBy(id = "alertButton")
    private WebElement okAlertElement;
    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButtonElement;
    @FindBy(id = "confirmButton")
    private WebElement confirmAlertElement;
    @FindBy(id = "promtButton")
    private WebElement promtAlertElement;

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public void dealAlertProcess(String text)
    {
        elementMethods.clickJsElement(okAlertElement);
        alertMethods.acceptAlert();
        elementMethods.clickJsElement(timerAlertButtonElement);
        alertMethods.acceptAlert();
        elementMethods.clickJsElement(confirmAlertElement);
        alertMethods.dismissAlert();
        elementMethods.clickJsElement(promtAlertElement);
        alertMethods.fillAlert(text);
    }
}
