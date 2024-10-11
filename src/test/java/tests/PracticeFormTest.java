package tests;

import modelObject.PracticeFormModel;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormsPage;
import sharedData.Hooks;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends Hooks {
     @Test
    public void metodaTest() {

        PracticeFormModel testData = new PracticeFormModel("src/test/resources/inputData/PracticeFormResource.json");
        HomePage homePage=new HomePage(getDriver());
        homePage.clickForms();

         FormsPage formsPage=new FormsPage(getDriver());
         formsPage.clickPracticeFormSubMenu();

         PracticeFormsPage practiceFormsPage = new PracticeFormsPage(getDriver());
         practiceFormsPage.fillEntireForm(testData);
         practiceFormsPage.validateFormValues(testData);
   }
}

