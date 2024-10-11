package pages;

import modelObject.WebTableModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class WebTablePage extends BasePage {
    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    private List<WebElement> tableContentList;
    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    private List<WebElement> newTableContentList;
    @FindBy(id = "edit-record-4")
    private WebElement editElement;
    @FindBy(id = "firstName")
    private WebElement editFirstNameElement;
    @FindBy(id = "lastName")
    private WebElement editLastNameElement;
    @FindBy(id = "userEmail")
    private WebElement editEmailElement;
    @FindBy(id = "age")
    private WebElement editAgeElement;
    @FindBy(id = "salary")
    private WebElement editSalaryElement;
    @FindBy(id = "department")
    private WebElement editDepartmentElement;
    @FindBy(id = "delete-record-4")
    private WebElement deleteElement;

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public void createProcess(WebTableModel testData, int tableSize) {
        Assert.assertEquals(tableContentList.size(), tableSize, "default size for table is not "
                + tableSize);
        loggerUtility.infoLog("The user validates the size of table content to be "+tableSize);

        elementMethods.clickJsElement(addElement);
        loggerUtility.infoLog("The user clicks on add element button");

        elementMethods.fillElement(firstNameElement, testData.getFirstName());
        loggerUtility.infoLog("The user fills first name field with "+testData.getFirstName()+" value");

        elementMethods.fillElement(lastNameElement, testData.getLastName());
        loggerUtility.infoLog("The user fills last name field with "+testData.getLastName()+" value");

        elementMethods.fillElement(emailElement, testData.getUserEmail());
        loggerUtility.infoLog("The user fills email field with "+testData.getUserEmail()+" value");

        elementMethods.fillElement(ageElement, testData.getAge());
        loggerUtility.infoLog("The user fills age field with "+ testData.getAge()+" value");

        elementMethods.fillElement(salaryElement, testData.getSalary());
        loggerUtility.infoLog("The user fills salary field with "+testData.getSalary()+" value");

        elementMethods.fillElement(departmentElement, testData.getDepartment());
        loggerUtility.infoLog("The user fills department field with "+testData.getDepartment()+" value");

        elementMethods.clickJsElement(submitElement);
        loggerUtility.infoLog("The user clicks on submit element button");

        Assert.assertEquals(newTableContentList.size(), tableSize + 1, "default size for table is not " + tableSize + 1);
        loggerUtility.infoLog("The user validates the size of table content to be "+tableSize+1);

        //validare
        String rowContent = newTableContentList.get(tableSize).getText();
        //System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(testData.getFirstName()), "The last row does not contain first name value");
        loggerUtility.infoLog("The user validates the presence of "+testData.getFirstName()+" value into table content");

        Assert.assertTrue(rowContent.contains(testData.getLastName()), "The last row does not contain last name value");
        loggerUtility.infoLog("The user validates the presence of "+testData.getLastName()+" value into table content");

        Assert.assertTrue(rowContent.contains(testData.getUserEmail()), "The last row does not contain email value");
        loggerUtility.infoLog("The user validates the presence of "+testData.getUserEmail()+" value into table content");

        Assert.assertTrue(rowContent.contains(testData.getDepartment()), "The last row does not contain department value");
        loggerUtility.infoLog("The user validates the presence of "+testData.getDepartment()+" value into table content");

        Assert.assertTrue(rowContent.contains(testData.getSalary()), "The last row does not contain salary value");
        loggerUtility.infoLog("The user validates the presence of "+testData.getSalary()+" value into table content");

        Assert.assertTrue(rowContent.contains(testData.getAge()), "The last row does not contain age value");
        loggerUtility.infoLog("The user validates the presence of "+testData.getAge()+" value into table content");

    }

    public void editProcess(WebTableModel testData,   int tableSize) {
        elementMethods.clickJsElement(editElement);
        loggerUtility.infoLog("The user clicks on edit button");

        elementMethods.clearEditElement(editFirstNameElement, testData.getEditFirstName());
        loggerUtility.infoLog("The user clears and fills the First name field with "+ testData.getEditFirstName()+ " value");

        elementMethods.clearEditElement(editLastNameElement, testData.getEditLastName());
        loggerUtility.infoLog("The user clears and fills the lasta name field with "+ testData.getEditLastName()+ " value");

        elementMethods.clearEditElement(editEmailElement, testData.getEditEmail());
        loggerUtility.infoLog("The user clears and fills the email field with "+ testData.getEditEmail()+ " value");

        elementMethods.clearEditElement(editAgeElement, testData.getEditAge());
        loggerUtility.infoLog("The user clears and fills the age field with "+ testData.getEditAge()+ " value");

        elementMethods.clearEditElement(editSalaryElement, testData.getEditSalary());
        loggerUtility.infoLog("The user clears and fills the salary field with "+ testData.getEditSalary()+ " value");

        elementMethods.clearEditElement(editDepartmentElement, testData.getEditDepartment());
        loggerUtility.infoLog("The user clears and fills the department field with "+ testData.getEditDepartment()+ " value");

        elementMethods.clickJsElement(submitElement);
        loggerUtility.infoLog("The user clicks on submit button");

        elementMethods.waitVisibleList(newTableContentList);
        loggerUtility.infoLog("The user waits a vit for presence of table content");

        String rowContent = newTableContentList.get(tableSize).getText();
        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(testData.getEditFirstName()), "The last row does not contain first name value");
        loggerUtility.infoLog("The user validates the presence of "+testData.getEditFirstName()+" value into table content");

        Assert.assertTrue(rowContent.contains(testData.getEditLastName()), "The last row does not contain last name value");
        loggerUtility.infoLog("The user validates the presence of "+testData.getEditLastName()+" value into table content");

        Assert.assertTrue(rowContent.contains(testData.getEditEmail()), "The last row does not contain email value");
        loggerUtility.infoLog("The user validates the presence of "+testData.getEditEmail()+" value into table content");

        Assert.assertTrue(rowContent.contains(testData.getEditDepartment()), "The last row does not contain department value");
        loggerUtility.infoLog("The user validates the presence of "+testData.getEditDepartment()+" value into table content");

        Assert.assertTrue(rowContent.contains(testData.getEditSalary()), "The last row does not contain salary value");
        loggerUtility.infoLog("The user validates the presence of "+testData.getEditSalary()+" value into table content");

        Assert.assertTrue(rowContent.contains(testData.getEditAge()), "The last row does not contain age value");
        loggerUtility.infoLog("The user validates the presence of "+testData.getEditAge()+" value into table content");

    }

    public void deleteProcess(int tableSize) {
        elementMethods.clickJsElement(deleteElement);
        loggerUtility.infoLog("The user clicks on delete element");

        Assert.assertEquals(newTableContentList.size(), tableSize, "default size for table is not " + tableSize);
        loggerUtility.infoLog("The user validates the size of table content to be "+tableSize);

    }
}
