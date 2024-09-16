package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;

import java.util.List;

public class WebTableTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {
        // deschidem un browser
        driver = new EdgeDriver();
        //accesam un url
        driver.get("https://demoqa.com/");
        //facem browser-ul maximize
        driver.manage().window().maximize();

        HomePage homePage=new HomePage(driver);
        homePage.clickElements();

        ElementsPage elementsPage=new ElementsPage(driver);
        elementsPage.clickWebTable();

        String firstNameValue = "Cristina";
        String lastNameValue = "Jianu";
        String emailValue = "cristinajianu@gmail.com";
        String ageValue = "20";
        String salaryValue = "2000";
        String departmentValue = "IT";

        WebTablePage webTablePage=new WebTablePage(driver);
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

        driver.quit();
    }
}
