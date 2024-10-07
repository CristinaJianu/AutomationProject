package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BasePage{

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "//iframe[@srcdoc='<p>Child Iframe</p>]")
    private WebElement childFrameElement;

    public void dealNestedFrames(){
        framesMethods.switchToSpecificIFrame("frame1");
        framesMethods.switchToSpecificIFrame(childFrameElement);
        System.out.println(childFrameElement.getText());
    }
}
