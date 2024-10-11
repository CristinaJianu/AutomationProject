package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.NestedFramesPage;
import sharedData.Hooks;
import sharedData.SharedData;

public class NestedFramesTest extends Hooks {
    @Test
    public void metodaTest() {
        HomePage homePage=new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage=new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickNestedFramesSubMenu();

        NestedFramesPage nestedFramesPage=new NestedFramesPage(getDriver());
        nestedFramesPage.dealNestedFrames();
    }
}
