package pages;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import helpMethods.FramesMethods;
import helpMethods.TabMethods;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public LoggerUtility loggerUtility;
    public ElementMethods elementMethods;
    public AlertMethods alertMethods;
    public FramesMethods framesMethods;
    public TabMethods tabMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        loggerUtility=new LoggerUtility();
        elementMethods =new ElementMethods(this.driver);
        alertMethods=new AlertMethods(this.driver);
        framesMethods=new FramesMethods(this.driver);
        tabMethods=new TabMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }
}
