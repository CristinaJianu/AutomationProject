package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.HomePage;
import sharedData.Hooks;

public class AlertsTest extends Hooks {
    @Test
    public void metodaTest() {
        HomePage homePage=new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage=new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickAlert();

        AlertPage alertPage=new AlertPage(getDriver());
        alertPage.dealAlertProcess("this is a test");
    }
}
