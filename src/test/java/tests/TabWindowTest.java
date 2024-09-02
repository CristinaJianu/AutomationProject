package tests;

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

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", alertsFrameWindowsMenu);

        WebElement browserWindowsSubMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        js.executeScript("arguments[0].click();", browserWindowsSubMenu);


        WebElement tabButtonElement = driver.findElement(By.id("tabButton"));
        js.executeScript("arguments[0].click();", tabButtonElement);

        System.out.println("URL ul paginii curente este " + driver.getCurrentUrl());
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
        System.out.println("URL ul paginii curente este " + driver.getCurrentUrl());

        driver.close();

        driver.switchTo().window(tabList.get(0));
        System.out.println("URL ul paginii curente este " + driver.getCurrentUrl());

        WebElement windowButtonElement = driver.findElement(By.id("windowButton"));
        js.executeScript("arguments[0].click();", windowButtonElement);

        System.out.println("URL ul paginii curente este " + driver.getCurrentUrl());
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        System.out.println("URL ul paginii curente este " + driver.getCurrentUrl());

        driver.close();
        driver.quit();

    }
}
