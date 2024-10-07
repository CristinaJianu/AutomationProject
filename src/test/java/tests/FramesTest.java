package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.FramesPage;
import pages.HomePage;
import sharedData.SharedData;

public class FramesTest extends SharedData {
    @Test
    public void metodaTest() {
        HomePage homePage=new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage=new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickFramesSubMenu();

        FramesPage framesPage=new FramesPage(getDriver());
        framesPage.dealFirstIFrame();
        framesPage.dealSecondIFrame();
    }
}
