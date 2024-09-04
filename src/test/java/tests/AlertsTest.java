package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest {

    public WebDriver driver;

    @Test

    public void metodaTest() {
        // deschidem un browser
        driver = new EdgeDriver();
        //accesam un url
        driver.get("https://demoqa.com/");
        //facem browser-ul maximize
        driver.manage().window().maximize();

        ElementMethods elementMethods = new ElementMethods(driver);
        TabMethods tabMethods = new TabMethods(driver);
        AlertMethods alertMethods=new AlertMethods(driver);

//        //wait implicit nu fct la alerte
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
       elementMethods.clickJsElement(alertsFrameWindowsMenu);

        WebElement alertsSubMenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementMethods.clickJsElement(alertsSubMenu);

        WebElement okAlertElement = driver.findElement(By.id("alertButton"));
        elementMethods.clickJsElement(okAlertElement);

        alertMethods.acceptAlert();

        WebElement timerAlertButtonElement = driver.findElement(By.id("timerAlertButton"));
        elementMethods.clickJsElement(timerAlertButtonElement);

        alertMethods.acceptAlert();

        WebElement confirmAlertElement = driver.findElement(By.id("confirmButton"));
        elementMethods.clickJsElement(confirmAlertElement);

        alertMethods.dismissAlert();

        WebElement promtAlertElement = driver.findElement(By.id("promtButton"));
        elementMethods.clickJsElement(promtAlertElement);

        alertMethods.fillAlert("this is a test");
    }
}
