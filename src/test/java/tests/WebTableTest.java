package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.Hooks;

public class WebTableTest extends Hooks {
    @Test
    public void metodaTest() {
        HomePage homePage=new HomePage(getDriver());
        homePage.clickElements();

        ElementsPage elementsPage=new ElementsPage(getDriver());
        elementsPage.clickWebTable();

        String firstNameValue = "Cristina";
        String lastNameValue = "Jianu";
        String emailValue = "cristinajianu"+System.currentTimeMillis()+"@gmail.com";
        String ageValue = "20";
        String salaryValue = "2000";
        String departmentValue = "IT";

        WebTablePage webTablePage=new WebTablePage(getDriver());
        webTablePage.createProcess(firstNameValue,lastNameValue,emailValue,ageValue,
                salaryValue,departmentValue,3);

        String editFirstNameValue = "Cristina";
        String editLastNameValue = "Jianu";
        String editEmailValue = "cristinajianu@gmail.com";
        String editAgeValue = "20";
        String editSalaryValue = "2000";
        String editDepartmentValue = "IT";

        webTablePage.editProcess(editFirstNameValue,editLastNameValue,editEmailValue,editAgeValue,
                editSalaryValue,editDepartmentValue,3);

        webTablePage.deleteProcess(3);
    }
}
