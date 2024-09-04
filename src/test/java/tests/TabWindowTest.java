package tests;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TabWindowTest {

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

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickJsElement(alertsFrameWindowsMenu);

        WebElement browserWindowsSubMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementMethods.clickJsElement(browserWindowsSubMenu);

        WebElement tabButtonElement = driver.findElement(By.id("tabButton"));
        elementMethods.clickJsElement(tabButtonElement);

        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();

        tabMethods.switchSpecificTab(0);

        WebElement windowButtonElement = driver.findElement(By.id("windowButton"));
        elementMethods.clickJsElement(windowButtonElement);

        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        tabMethods.quitTab();

    }
}
