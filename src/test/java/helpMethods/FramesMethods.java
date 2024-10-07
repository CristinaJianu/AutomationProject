package helpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesMethods {

    public WebDriver driver;

    public FramesMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToSpecificIFrame(String value) {
        driver.switchTo().frame(value);
    }

    public void switchToParentIFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchToSpecificIFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

}
