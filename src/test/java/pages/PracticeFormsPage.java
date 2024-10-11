package pages;

import modelObject.PracticeFormModel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class PracticeFormsPage extends BasePage {
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(xpath = "//label[contains(@for,'gender-radio-1')]/../label")
    private List<WebElement> genderOptionsList;
    @FindBy(id = "userNumber")
    private WebElement mobileNumberElement;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthElement;
    @FindBy(className = "react-datepicker__month-select")
    private WebElement monthElement;
    @FindBy(className = "react-datepicker__year-select")
    private WebElement yearElement;
    @FindBy(className = "//div[@class = 'react-datepicker__month']/div/div[not(contains(@class,'react-datepicker__day--outside-month'))]")
    private List<WebElement> daysList;
    @FindBy(id = "subjectsInput")
    private WebElement subjectElement;
    @FindBy(xpath = "//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")
    private List<WebElement> hobbiesOptionsList;
    @FindBy(id = "uploadPicture")
    private WebElement pictureElement;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressElement;
    @FindBy(xpath = "//div[text()='Select State']")
    private WebElement stateElement;
    @FindBy(id = "react-select-3-input")
    private WebElement stateInputElement;
    @FindBy(id = "react-select-4-input")
    private WebElement cityInputElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement thankYouElement;
    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']//td[1]")
    private List<WebElement> labelList;
    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']//td[2]")
    private List<WebElement> valuesList;

    public PracticeFormsPage(WebDriver driver) {
        super(driver);
    }

    public void fillEntireForm(PracticeFormModel testData) {

        elementMethods.fillElement(firstNameElement, testData.getFirstName());
        loggerUtility.infoLog("The user fills first name field with "+testData.getFirstName()+" value");
        elementMethods.fillElement(lastNameElement, testData.getLastName());
        loggerUtility.infoLog("The user fills last name field with "+testData.getLastName()+" value");

        elementMethods.fillElement(emailElement, testData.getUserEmail());
        loggerUtility.infoLog("The user fills email field with "+testData.getUserEmail()+" value");

        switch (testData.getGender()) {
            case "Male":
                elementMethods.clickJsElement(genderOptionsList.get(0));
                loggerUtility.infoLog("The user clicks on gender options list");

                break;
            case "Female":
                elementMethods.clickJsElement(genderOptionsList.get(1));
                loggerUtility.infoLog("The user clicks on gender options list");

                break;
            case "Other":
                elementMethods.clickJsElement(genderOptionsList.get(2));
                loggerUtility.infoLog("The user clicks on gender options list");
                break;
        }

        elementMethods.fillElement(mobileNumberElement, testData.getMobileNumber());
        loggerUtility.infoLog("The user fills mobile number field with "+testData.getMobileNumber()+" value");

        elementMethods.clickJsElement(dateOfBirthElement);
        loggerUtility.infoLog("The user clicks the date of birth element");

        elementMethods.selectDropdownElement(monthElement, testData.getMonth());
        loggerUtility.infoLog("The user selects month element with "+testData.getMonth()+" value");

        elementMethods.selectDropdownElement(yearElement, testData.getYear());
        loggerUtility.infoLog("The user selects year element with "+testData.getYear()+" value");

        for (int i = 0; i < daysList.size(); i++) {
            if (daysList.get(i).getText().equals(testData.getDay())) {
                elementMethods.clickJsElement(daysList.get(i));
                loggerUtility.infoLog("The user clicks on days list");
                break;
            }
        }
        for (int index = 0; index < testData.getSubjects().size(); index++) {
            elementMethods.fillPressElement(subjectElement, testData.getSubjects().get(index), Keys.ENTER);
            loggerUtility.infoLog("The user fills subject element with "+testData.getSubjects().get(index)+" value");

        }
        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (testData.getHobbies().contains(currentText)) {
                elementMethods.clickJsElement(hobbiesOptionsList.get(index));
                loggerUtility.infoLog("The user clicks on hobbies list");
            }
        }
        File file = new File(testData.getPathFile());
        elementMethods.fillElement(pictureElement, file.getAbsolutePath());
        loggerUtility.infoLog("The user selects picture element with "+file.getAbsolutePath());

        elementMethods.fillElement(currentAddressElement, testData.getCurrentAddress());
        loggerUtility.infoLog("The user fills current address field with "+testData.getCurrentAddress()+" value");

        elementMethods.clickJsElement(stateElement);
        loggerUtility.infoLog("The user clicks on state element");

        elementMethods.fillPressElement(stateInputElement, testData.getState(), Keys.ENTER);
        loggerUtility.infoLog("The user fills state input field with "+testData.getState()+" value");

        elementMethods.fillPressElement(cityInputElement, testData.getCity(), Keys.ENTER);
        loggerUtility.infoLog("The user fills city input field with "+testData.getCity()+" value");

        elementMethods.clickJsElement(submitElement);
        loggerUtility.infoLog("The user clicks on submit element");
    }



        public void validateFormValues (PracticeFormModel testData){

        elementMethods.waitVisibleElement(thankYouElement);
            Assert.assertEquals(thankYouElement.getText(), "Thanks for submitting the form");
            loggerUtility.infoLog("The user validates the size the thank you element");

            Assert.assertEquals(labelList.get(0).getText(), "Student Name");
            loggerUtility.infoLog("The user validates the student name");

            Assert.assertEquals(labelList.get(1).getText(), "Student Email");
            loggerUtility.infoLog("The user validates the student email");

            Assert.assertEquals(labelList.get(2).getText(), "Gender");
            loggerUtility.infoLog("The user validates the gender");

            Assert.assertEquals(labelList.get(3).getText(), "Mobile");
            loggerUtility.infoLog("The user validates the mobile");

            Assert.assertEquals(labelList.get(4).getText(), "Date of Birth");
            loggerUtility.infoLog("The user validates the Date of Birth");

            Assert.assertEquals(labelList.get(5).getText(), "Subjects");
            loggerUtility.infoLog("The user validates the Date of Birth");

            Assert.assertEquals(labelList.get(6).getText(), "Hobbies");
            loggerUtility.infoLog("The user validates the Hobbies");

            Assert.assertEquals(labelList.get(7).getText(), "Picture");
            loggerUtility.infoLog("The user validates the Picture");

            Assert.assertEquals(labelList.get(8).getText(), "Address");
            loggerUtility.infoLog("The user validates the Address");

            Assert.assertEquals(labelList.get(9).getText(), "State and City");
            loggerUtility.infoLog("The user validates the State and City");

            Assert.assertEquals(valuesList.get(0).getText(), testData.getFirstName() + " " + testData.getLastName());
            loggerUtility.infoLog("The user validates the presence of "+testData.getFirstName()+ " and "+ testData.getLastName()+" values into table content");

            Assert.assertEquals(valuesList.get(1).getText(), testData.getUserEmail());
            loggerUtility.infoLog("The user validates the presence of "+testData.getUserEmail()+  "value into table content");

            Assert.assertEquals(valuesList.get(2).getText(), testData.getGender());
            loggerUtility.infoLog("The user validates the presence of "+testData.getGender()+  "value into table content");

            Assert.assertEquals(valuesList.get(3).getText(), testData.getMobileNumber());
            loggerUtility.infoLog("The user validates the presence of "+testData.getMobileNumber()+  "value into table content");

            Assert.assertEquals(valuesList.get(4).getText(), "19 August,2024");
            loggerUtility.infoLog("The user validates the presence date of birth -19 August,2024");

            String subjectValue =String.join(", ",testData.getSubjects());
            Assert.assertEquals(valuesList.get(5).getText(), testData.getSubjects());
            loggerUtility.infoLog("The user validates the presence of "+testData.getSubjects()+  "value into table content");

            String hobbyValue =String.join(", ",testData.getHobbies());
            Assert.assertEquals(valuesList.get(6).getText(), testData.getHobbies());
            loggerUtility.infoLog("The user validates the presence of "+testData.getHobbies()+  "value into table content");


            File file = new File(testData.getPathFile());
            Assert.assertEquals(valuesList.get(7).getText(), file.getName());
            loggerUtility.infoLog("The user validates the presence of "+testData.getPathFile()+  "value into table content");

            Assert.assertEquals(valuesList.get(8).getText(), testData.getCurrentAddress());
            loggerUtility.infoLog("The user validates the presence of "+testData.getCurrentAddress()+  "value into table content");

            Assert.assertEquals(valuesList.get(9).getText(), testData.getState() +" "+ testData.getCity());
            loggerUtility.infoLog("The user validates the presence of "+testData.getState()+ " and "+ testData.getCity()+" values into table content");

        }
    }

