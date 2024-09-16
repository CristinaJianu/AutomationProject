package pages;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public AlertMethods alertMethods;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        elementMethods=new ElementMethods(this.driver);
        alertMethods=new AlertMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(id = "alertButton")
    public WebElement okAlertElement;
    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButtonElement;
    @FindBy(id = "confirmButton")
    public WebElement confirmAlertElement;
    @FindBy(id = "promtButton")
    public WebElement promtAlertElement;

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
