package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import helpMethods.FramesMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class FramesTest {

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
        FramesMethods framesMethods=new FramesMethods(driver);

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickJsElement(alertsFrameWindowsMenu);

        WebElement framesSubMenu = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementMethods.clickJsElement(framesSubMenu);

        //ne mutam pe un iframe
        framesMethods.switchToSpecificIFrame("frame1");

        WebElement sampleTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleTextElement.getText());

        framesMethods.switchToParentIFrame();

        framesMethods.switchToSpecificIFrame("frame2");

        WebElement secondSampleTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(secondSampleTextElement.getText());
    }
}

//temaa nested frames (test nou ) interact cu meniu si sub meniu 