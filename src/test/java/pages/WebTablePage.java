package pages;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class WebTablePage {
    public WebDriver driver;
    public ElementMethods elementMethods;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    public List<WebElement> tableContentList;
    @FindBy(id = "addNewRecordButton")
    public WebElement addElement;
    @FindBy(id = "firstName")
    public WebElement firstNameElement;
    @FindBy(id = "lastName")
    public WebElement lastNameElement;
    @FindBy(id = "userEmail")
    public WebElement emailElement;
    @FindBy(id = "age")
    public WebElement ageElement;
    @FindBy(id = "salary")
    public WebElement salaryElement;
    @FindBy(id = "department")
    public WebElement departmentElement;
    @FindBy(id = "submit")
    public WebElement submitElement;
    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    public List<WebElement> newTableContentList;
    @FindBy(id = "edit-record-4")
    public WebElement editElement;
    @FindBy(id = "firstName")
    public WebElement editFirstNameElement;
    @FindBy(id = "lastName")
    public WebElement editLastNameElement;
    @FindBy(id = "userEmail")
    public WebElement editEmailElement;
    @FindBy(id = "age")
    public WebElement editAgeElement;
    @FindBy(id = "salary")
    public WebElement editSalaryElement;
    @FindBy(id = "department")
    public WebElement editDepartmentElement;
    @FindBy(id = "delete-record-4")
    public WebElement deleteElement;

    public void createProcess(String firstNameValue, String lastNameValue, String emailValue,
                              String ageValue, String salaryValue, String departmentValue, int tableSize) {
        Assert.assertEquals(tableContentList.size(), tableSize, "default size for table is not " + tableSize);
        elementMethods.clickJsElement(addElement);
        elementMethods.fillElement(firstNameElement, firstNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);
        elementMethods.fillElement(emailElement, emailValue);
        elementMethods.fillElement(ageElement, ageValue);
        elementMethods.fillElement(salaryElement, salaryValue);
        elementMethods.fillElement(departmentElement, departmentValue);
        elementMethods.clickJsElement(submitElement);
        Assert.assertEquals(newTableContentList.size(), tableSize + 1, "default size for table is not " + tableSize + 1);

        //validare
        String rowContent = newTableContentList.get(tableSize).getText();
        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(firstNameValue), "The last row does not contain first name value");
        Assert.assertTrue(rowContent.contains(lastNameValue), "The last row does not contain last name value");
        Assert.assertTrue(rowContent.contains(emailValue), "The last row does not contain email value");
        Assert.assertTrue(rowContent.contains(departmentValue), "The last row does not contain department value");
        Assert.assertTrue(rowContent.contains(salaryValue), "The last row does not contain salary value");
        Assert.assertTrue(rowContent.contains(ageValue), "The last row does not contain age value");

    }

    public void editProcess(String editFirstNameValue, String editLastNameValue, String editEmailValue,
                            String editAgeValue, String editSalaryValue, String editDepartmentValue,
                            int tableSize) {
        elementMethods.clickJsElement(editElement);
        elementMethods.clearEditElement(editFirstNameElement, editFirstNameValue);
        elementMethods.clearEditElement(editLastNameElement, editLastNameValue);
        elementMethods.clearEditElement(editEmailElement, editEmailValue);
        elementMethods.clearEditElement(editAgeElement, editAgeValue);
        elementMethods.clearEditElement(editSalaryElement, editSalaryValue);
        elementMethods.clearEditElement(editDepartmentElement, editDepartmentValue);
        elementMethods.clickJsElement(submitElement);

        elementMethods.waitVisibleList(newTableContentList);
        String rowContent = newTableContentList.get(tableSize).getText();
        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(editFirstNameValue), "The last row does not contain first name value");
        Assert.assertTrue(rowContent.contains(editLastNameValue), "The last row does not contain last name value");
        Assert.assertTrue(rowContent.contains(editEmailValue), "The last row does not contain email value");
        Assert.assertTrue(rowContent.contains(editDepartmentValue), "The last row does not contain department value");
        Assert.assertTrue(rowContent.contains(editSalaryValue), "The last row does not contain salary value");
        Assert.assertTrue(rowContent.contains(editAgeValue), "The last row does not contain age value");
    }

    public void deleteProcess(int tableSize)
    {
        elementMethods.clickJsElement(deleteElement);
        Assert.assertEquals(newTableContentList.size(), tableSize, "default size for table is not "+tableSize);
    }
}
