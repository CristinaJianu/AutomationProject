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

        ElementMethods elementMethods = new ElementMethods(driver);
        TabMethods tabMethods = new TabMethods(driver);
        AlertMethods alertMethods = new AlertMethods(driver);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementMethods.clickJsElement(elementsMenu);

        WebElement webTableSubMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementMethods.clickJsElement(webTableSubMenu);


        //validam dimensiunea intiala a tabelului

        List<WebElement> tableContentList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(tableContentList.size(), 3, "default sie for table is not 3");

        //definim un element (de preferat sa le denumim ca pe site)
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementMethods.clickJsElement(addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Cristina";
        elementMethods.clickElement(firstNameElement);
        elementMethods.fillElement(firstNameElement, firstNameValue);
        //scriem in firstnameelement valoarea din first name value


        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Jianu";
        elementMethods.fillElement(lastNameElement, lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "cristinajianu@gmail.com";
        elementMethods.fillElement(emailElement, emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "20";
        elementMethods.fillElement(ageElement, ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "2000";
        elementMethods.fillElement(salaryElement, salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "IT";
        elementMethods.fillElement(departmentElement, departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementMethods.clickJsElement(submitElement);

        //validam noua dimensiune a tabelului
        List<WebElement> newTableContentList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(newTableContentList.size(), 4, "default sie for table is not 4");


        //validam valorile pe care le am introdus
        String rowContent = newTableContentList.get(3).getText();
        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(firstNameValue),"The last row does not contain first name value");
        Assert.assertTrue(rowContent.contains(lastNameValue),"The last row does not contain last name value");
        Assert.assertTrue(rowContent.contains(emailValue),"The last row does not contain email value");
        Assert.assertTrue(rowContent.contains(departmentValue),"The last row does not contain department value");
        Assert.assertTrue(rowContent.contains(salaryValue),"The last row does not contain salary value");
        Assert.assertTrue(rowContent.contains(ageValue),"The last row does not contain age value");

        //function edit
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementMethods.clickJsElement(editElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Cristina";
        elementMethods.clearEditElement(editFirstNameElement, editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Jianu";
        elementMethods.clearEditElement(editLastNameElement, editLastNameValue);

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "cristinajianu@gmail.com";
        elementMethods.clearEditElement(editEmailElement, editEmailValue);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        String editAgeValue = "20";
        elementMethods.clearEditElement(editAgeElement, editAgeValue);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "2000";
        elementMethods.clearEditElement(editSalaryElement, editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "IT";
        elementMethods.clearEditElement(editDepartmentElement, editDepartmentValue);

        WebElement editSubmitElement = driver.findElement(By.id("submit"));
        elementMethods.clickJsElement(editSubmitElement);

        //validam valorile modificate din tabel
//        rowContent= newTableContentList.get(3).getText();
//        Assert.assertTrue(rowContent.contains(editFirstNameValue),"The last row does not contain first name value");
//        Assert.assertTrue(rowContent.contains(editLastNameValue),"The last row does not contain last name value");
//        Assert.assertTrue(rowContent.contains(editEmailValue),"The last row does not contain email value");
//        Assert.assertTrue(rowContent.contains(editDepartmentValue),"The last row does not contain department value");
//        Assert.assertTrue(rowContent.contains(editSalaryValue),"The last row does not contain salary value");
//        Assert.assertTrue(rowContent.contains(editAgeValue),"The last row does not contain age value");

        //function delete
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementMethods.clickJsElement(deleteElement);

        newTableContentList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(newTableContentList.size(), 3, "default sie for table is not 3");

        driver.quit();
    }
}
