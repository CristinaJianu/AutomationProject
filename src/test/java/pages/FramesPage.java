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
        System.out.println(sampleTextElement.getText());
        framesMethods.switchToParentIFrame();
    }

    public void dealSecondIFrame(){
        framesMethods.switchToSpecificIFrame("frame2");
        System.out.println(secondSampleTextElement.getText());
    }
}
