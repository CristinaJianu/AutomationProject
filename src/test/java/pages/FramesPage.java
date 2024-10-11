package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage{
    @FindBy(id = "sampleHeading")
    private WebElement sampleTextElement;
    @FindBy(id = "sampleHeading")
    private WebElement secondSampleTextElement;

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void dealFirstIFrame()
    {
        framesMethods.switchToSpecificIFrame("frame1");
        loggerUtility.infoLog("The user switches to specific iframe");

        System.out.println(sampleTextElement.getText());
        loggerUtility.infoLog("The user interacts with an element within iframe");

        framesMethods.switchToParentIFrame();
        loggerUtility.infoLog("The user switches to parent frame");

    }

    public void dealSecondIFrame(){
        framesMethods.switchToSpecificIFrame("frame2");
        loggerUtility.infoLog("The user switches to specific iframe");

        System.out.println(secondSampleTextElement.getText());
        loggerUtility.infoLog("The user interacts with an element within iframe");

    }
}
