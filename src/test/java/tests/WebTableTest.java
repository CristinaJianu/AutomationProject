package tests;

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

        WebElement elementsMenu= driver.findElement(By.xpath("//h5[text()='Elements']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", elementsMenu);

        WebElement webTableSubMenu= driver.findElement(By.xpath("//span[text()='Web Tables']"));
        js.executeScript("arguments[0].click();", webTableSubMenu);
        

        //validam dimensiunea intiala a tabelului

        List<WebElement> tableContentList=driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(tableContentList.size(),3,"default sie for table is not 3");

        //definim un element (de preferat sa le denumim ca pe site)
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        js.executeScript("arguments[0].click();", addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Cristina";
        firstNameElement.click();
        firstNameElement.sendKeys(firstNameValue);
        //scriem in firstnameelement valoarea din first name value


        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Jianu";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "cristinajianu@gmail.com";
        emailElement.sendKeys(emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String agelValue = "20";
        ageElement.sendKeys(agelValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salarylValue = "20000";
        salaryElement.sendKeys(salarylValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentlValue = "IT";
        departmentElement.sendKeys(departmentlValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitElement);

        //validam noua dimensiune a tabelului
        List<WebElement> newTableContentList=driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(newTableContentList.size(),4,"default sie for table is not 4");


        //validam valorile pe care le am introdus
        String rowContent= newTableContentList.get(3).getText();
        Assert.assertTrue(rowContent.contains(firstNameValue),"The last row does not contain first name value");
        Assert.assertTrue(rowContent.contains(lastNameValue),"The last row does not contain last name value");
        Assert.assertTrue(rowContent.contains(emailValue),"The last row does not contain email value");
        Assert.assertTrue(rowContent.contains(departmentlValue),"The last row does not contain department value");
        Assert.assertTrue(rowContent.contains(salarylValue),"The last row does not contain salary value");
        Assert.assertTrue(rowContent.contains(agelValue),"The last row does not contain age value");



        //function edit
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        js.executeScript("arguments[0].click();", editElement);


        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Catalin";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Popescu";
        editLastNameElement.clear();
        editLastNameElement.sendKeys(editLastNameValue);

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "popescu@gmail.com";
        editEmailElement.clear();
        editEmailElement.sendKeys(editEmailValue);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        String editAgeValue = "24";
        editAgeElement.clear();
        editAgeElement.sendKeys(editAgeValue);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "30000";
        editSalaryElement.clear();
        editSalaryElement.sendKeys(editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "HR";
        editDepartmentElement.clear();
        editDepartmentElement.sendKeys(editDepartmentValue);

        WebElement editSubmitElement = driver.findElement(By.id("submit"));
        editSubmitElement.click();


        //validam valorile modificate din tabel
        rowContent= newTableContentList.get(3).getText();
        Assert.assertTrue(rowContent.contains(editFirstNameValue),"The last row does not contain first name value");
        Assert.assertTrue(rowContent.contains(editLastNameValue),"The last row does not contain last name value");
        Assert.assertTrue(rowContent.contains(editEmailValue),"The last row does not contain email value");
        Assert.assertTrue(rowContent.contains(editDepartmentValue),"The last row does not contain department value");
        Assert.assertTrue(rowContent.contains(editSalaryValue),"The last row does not contain salary value");
        Assert.assertTrue(rowContent.contains(editAgeValue),"The last row does not contain age value");


        //function delete
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        js.executeScript("arguments[0].click();", deleteElement);

       newTableContentList=driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(newTableContentList.size(),3,"default sie for table is not 3");


        driver.quit();

    }

}
