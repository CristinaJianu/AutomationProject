package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BasePage{

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>]")
    private WebElement childIFrameElement;
    @FindBy(tagName = "p")
    private WebElement childTextElement;

    public void dealNestedFrames(){
        framesMethods.switchToSpecificIFrame("frame1");
        loggerUtility.infoLog("The user switches the focus to a specific parent iFrame");

        framesMethods.switchToSpecificIFrame(childIFrameElement);
        loggerUtility.infoLog("The user switches the focus to a specific parent child iFrame");

        System.out.println(childTextElement.getText());
        loggerUtility.infoLog("The user interacts with an element within iframe");

    }
}
