package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.WatchEvent;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {
    public WebDriver driver;

    @Test

    public void metodaTest() {
        // deschidem un browser
        driver = new EdgeDriver();
        //accesam un url
        driver.get("https://demoqa.com/");
        //facem browser-ul maximize
        driver.manage().window().maximize();

        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", formsMenu);

        WebElement practiceFormSubMenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        js.executeScript("arguments[0].click();", practiceFormSubMenu);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Cristina";
        js.executeScript("arguments[0].click();", firstNameElement);
        firstNameElement.sendKeys(firstNameValue);
        //scriem in firstnameElement valoarea din first name value

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Jianu";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "cristinajianu@gmail.com";
        emailElement.sendKeys(emailValue);

        List<WebElement> genderOptionsList = driver.findElements(By.xpath("//input[@name='gender']"));
        String genderValue = "Male";

        switch (genderValue) {
            case "Male":
                js.executeScript("arguments[0].click();", genderOptionsList.get(0));
                break;
            case "Female":
                js.executeScript("arguments[0].click();", genderOptionsList.get(1));
                break;
            case "Other":
                js.executeScript("arguments[0].click();", genderOptionsList.get(2));
                break;
        }

        WebElement mobileNumberElement = driver.findElement(By.id("userNumber"));
        String mobileNumberValue = "0766867832";
        mobileNumberElement.sendKeys(mobileNumberValue);

        //dateOfBirth intereaction
        WebElement dateOfBirthElement = driver.findElement(By.id("dateOfBirthInput"));
        js.executeScript("arguments[0].click();", dateOfBirthElement);

        WebElement monthElement= driver.findElement((By.className("react-datepicker__month-select")));
        Select monthSelect=new Select(monthElement);
        String monthValue="January";
        monthSelect.selectByVisibleText(monthValue);

        WebElement yearElement= driver.findElement((By.className("react-datepicker__year-select")));
        Select yearSelect=new Select(yearElement);
        String yearValue="2030";
        yearSelect.selectByVisibleText(yearValue);

        String dayValue="15";
        List<WebElement> daysList=driver.findElements(By.xpath("//div[@class = 'react-datepicker__month']/div/div[not(contains(@class,'react-datepicker__day--outside-month'))]"));
        for (int i=0; i<daysList.size(); i++)
        {
            if(daysList.get(i).getText().equals(dayValue)){
                js.executeScript("arguments[0].click();", daysList.get(i));
                break;
            }
        }

        WebElement subjectElement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectValues = Arrays.asList("Accounting", "Maths", "Biology");
        for (int index = 0; index < subjectValues.size(); index++) {
            subjectElement.sendKeys(subjectValues.get(index));
            subjectElement.sendKeys(Keys.ENTER);
        }

        List<String> hobbiesValues = Arrays.asList("Sports");
        List<WebElement> hobbiesOptionsList = driver.findElements(By.xpath(("//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")));

        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (hobbiesValues.contains(currentText)) {
                js.executeScript("arguments[0].click();", hobbiesOptionsList.get(index));
            }
        }


        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/Jianu Cristina.txt");
        pictureElement.sendKeys(file.getAbsolutePath());


        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "Bucuresti, sector 2";
        currentAddressElement.sendKeys(currentAddressValue);

        WebElement stateElement = driver.findElement(By.xpath("//div[text()='Select State']"));
        js.executeScript("arguments[0].click();", stateElement);


        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "NCR";
        stateInputElement.sendKeys(stateValue);
        stateInputElement.sendKeys(Keys.ENTER);


        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "DELHI";
        cityInputElement.sendKeys(cityValue);
        cityInputElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitElement);


        //validam datele introduse

        WebElement thankYouElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankYouElement.getText(), "Thanks for submitting the form");

        List<WebElement> labelList = driver.findElements(By.xpath(("//table[@class='table table-dark table-striped table-bordered table-hover']//td[1]")));
        List<WebElement> valuesList = driver.findElements(By.xpath(("//table[@class='table table-dark table-striped table-bordered table-hover']//td[2]")));

        Assert.assertEquals(labelList.get(0).getText(), "Student Name");
        Assert.assertEquals(labelList.get(1).getText(), "Student Email");
        Assert.assertEquals(labelList.get(2).getText(), "Gender");
        Assert.assertEquals(labelList.get(3).getText(), "Mobile");
        Assert.assertEquals(labelList.get(4).getText(), "Date of Birth");
        Assert.assertEquals(labelList.get(5).getText(), "Subjects");
        Assert.assertEquals(labelList.get(6).getText(), "Hobbies");
        Assert.assertEquals(labelList.get(7).getText(), "Picture");
        Assert.assertEquals(labelList.get(8).getText(), "Address");
        Assert.assertEquals(labelList.get(9).getText(), "State and City");

        Assert.assertEquals(valuesList.get(0).getText(), firstNameValue + " " + lastNameValue);
        Assert.assertEquals(valuesList.get(1).getText(), emailValue);
        Assert.assertEquals(valuesList.get(2).getText(), genderValue);
        Assert.assertEquals(valuesList.get(3).getText(), mobileNumberValue);
        //Assert.assertEquals(valuesList.get(4), "19 August,2024");
//        Assert.assertEquals(valuesList.get(5).getText(), subjectValues);

       // Assert.assertEquals(valuesList.get(6), hobbiesValues);
//        Assert.assertEquals(valuesList.get(7), file);
//        Assert.assertEquals(valuesList.get(8), currentAddressValue);
//        Assert.assertEquals(valuesList.get(9), stateValue);

        driver.quit();


   }

}

