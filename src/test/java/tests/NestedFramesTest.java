package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import helpMethods.FramesMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class NestedFramesTest {

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
        AlertMethods alertMethods = new AlertMethods(driver);
        FramesMethods framesMethods = new FramesMethods(driver);

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickJsElement(alertsFrameWindowsMenu);

        WebElement nestedFramesSubMenu = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        elementMethods.clickJsElement(nestedFramesSubMenu);

        //ne mutam pe un iframe e fereastra parinte
        framesMethods.switchToSpecificIFrame("frame1");

        //mergem in fereastra copi; si il gasim dupa tag name
        WebElement childFrameElement = driver.findElement(By.tagName("iframe"));
        framesMethods.switchToSpecificIFrameByElement(childFrameElement);
        //ne am mutat in fereastra mica

        WebElement childSampleTextElement = driver.findElement(By.tagName("p"));
        //cautam primul paragraf de text elementul p
        System.out.println(childSampleTextElement.getText());
        //extragem si afisam textul


    }
}
