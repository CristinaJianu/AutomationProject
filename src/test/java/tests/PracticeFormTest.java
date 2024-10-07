package tests;

import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormsPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {
     @Test
    public void metodaTest() {
        HomePage homePage=new HomePage(getDriver());
        homePage.clickForms();

         FormsPage formsPage=new FormsPage(getDriver());
         formsPage.clickPracticeFormSubMenu();

        String firstNameValue="Cristina";
        String lastNameValue="Jianu";
        String emailValue="cristinajianu@gmail.com";
        String genderValue = "Male";
        String mobileNumberValue="0766867832";
        String monthValue="January";
        String yearValue="2030";
        String dayValue="15";
        List<String> subjectValues = Arrays.asList("Accounting", "Maths", "Biology");
        List<String> hobbiesValues = Arrays.asList("Sports");
        String pathFile="src/test/resources/Jianu Cristina.txt";
        String currentAddressValue = "Bucuresti, sector 2";
        String stateInputValue="NCR" ;
        String cityInputValue="DELHI" ;

        PracticeFormsPage practiceFormsPage=new PracticeFormsPage(getDriver());
        practiceFormsPage.fillEntireForm(firstNameValue,lastNameValue,emailValue,genderValue,
                mobileNumberValue,monthValue,yearValue,dayValue,subjectValues,hobbiesValues,pathFile,
                currentAddressValue,stateInputValue,cityInputValue);
        practiceFormsPage.validateFormValues(firstNameValue,lastNameValue,emailValue,
                genderValue,mobileNumberValue,subjectValues,hobbiesValues,pathFile,currentAddressValue,
                stateInputValue,cityInputValue);
   }
}

