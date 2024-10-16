package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import sharedData.browserService.ChromeService;
import sharedData.browserService.EdgeService;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;

    public void setUpDriver(){
        String browser = System.getProperty("browser");

        switch (browser){
            case "edge":
                EdgeService edgeService = new EdgeService();
                edgeService.openBrowser();
                driver = edgeService.getDriver();
                break;
            case "chrome":
                ChromeService chromeService = new ChromeService();
                chromeService.openBrowser();
                driver = chromeService.getDriver();
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver()
    {
        driver.quit();
    }
}
