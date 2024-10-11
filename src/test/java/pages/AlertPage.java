package pages;

import modelObject.AlertModel;
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

    public void dealAlertProcess(AlertModel testData)
    {
        elementMethods.clickJsElement(okAlertElement);
        loggerUtility.infoLog("The user clicks on alertOK element");

        alertMethods.acceptAlert();
        loggerUtility.infoLog("The user accepts the alert");

        elementMethods.clickJsElement(timerAlertButtonElement);
        loggerUtility.infoLog("The user clicks on AlertTimer element");

        alertMethods.acceptAlert();
        loggerUtility.infoLog("The user accepts the alert");

        elementMethods.clickJsElement(confirmAlertElement);
        loggerUtility.infoLog("The user clicks on confirmAlert element");

        alertMethods.dismissAlert();
        loggerUtility.infoLog("The user dismisses the alert");

        elementMethods.clickJsElement(promtAlertElement);
        loggerUtility.infoLog("The user clicks on AlertPromt element");

        alertMethods.fillAlert(testData.getAlertText());
        loggerUtility.infoLog("The user fills the alert displayed with"+ testData.getAlertText()+" value and accepts it");

    }
}
