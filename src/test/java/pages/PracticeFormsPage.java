package pages;

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

    public void fillEntireForm(String firstNameValue, String lastNameValue, String emailValue,
                               String genderValue, String mobileNumberValue, String monthValue,
                               String yearValue, String dayValue, List<String> subjectValues,
                               List<String> hobbiesValues, String pathFile, String currentAddressValue,
                               String stateInputValue, String cityInputValue) {

        elementMethods.fillElement(firstNameElement, firstNameValue);
        loggerUtility.infoLog("The user fills first name field with "+firstNameValue+" value");
        elementMethods.fillElement(lastNameElement, lastNameValue);
        loggerUtility.infoLog("The user fills last name field with "+lastNameValue+" value");

        elementMethods.fillElement(emailElement, emailValue);
        loggerUtility.infoLog("The user fills email field with "+emailValue+" value");

        switch (genderValue) {
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

        elementMethods.fillElement(mobileNumberElement, mobileNumberValue);
        loggerUtility.infoLog("The user fills mobile number field with "+mobileNumberValue+" value");

        elementMethods.clickJsElement(dateOfBirthElement);
        loggerUtility.infoLog("The user clicks the date of birth element");

        elementMethods.selectDropdownElement(monthElement, monthValue);
        loggerUtility.infoLog("The user selects month element with "+monthValue+" value");

        elementMethods.selectDropdownElement(yearElement, yearValue);
        loggerUtility.infoLog("The user selects year element with "+yearValue+" value");

        for (int i = 0; i < daysList.size(); i++) {
            if (daysList.get(i).getText().equals(dayValue)) {
                elementMethods.clickJsElement(daysList.get(i));
                loggerUtility.infoLog("The user clicks on days list");
                break;
            }
        }
        for (int index = 0; index < subjectValues.size(); index++) {
            elementMethods.fillPressElement(subjectElement, subjectValues.get(index), Keys.ENTER);
            loggerUtility.infoLog("The user fills subject element with "+subjectValues.get(index)+" value");

        }
        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (hobbiesValues.contains(currentText)) {
                elementMethods.clickJsElement(hobbiesOptionsList.get(index));
                loggerUtility.infoLog("The user clicks on hobbies list");
            }
        }
        File file = new File(pathFile);
        elementMethods.fillElement(pictureElement, file.getAbsolutePath());
        loggerUtility.infoLog("The user selects picture element with "+file.getAbsolutePath());

        elementMethods.fillElement(currentAddressElement, currentAddressValue);
        loggerUtility.infoLog("The user fills current address field with "+currentAddressValue+" value");

        elementMethods.clickJsElement(stateElement);
        loggerUtility.infoLog("The user clicks on state element");

        elementMethods.fillPressElement(stateInputElement, stateInputValue, Keys.ENTER);
        loggerUtility.infoLog("The user fills state input field with "+stateInputValue+" value");

        elementMethods.fillPressElement(cityInputElement, cityInputValue, Keys.ENTER);
        loggerUtility.infoLog("The user fills city input field with "+cityInputValue+" value");

        elementMethods.clickJsElement(submitElement);
        loggerUtility.infoLog("The user clicks on submit element");
    }



        public void validateFormValues (String firstNameValue, String lastNameValue, String emailValue,
                String genderValue, String mobileNumberValue, List < String > subjectValues,
                List < String > hobbiesValues, String pathFile, String currentAddressValue,
                String stateInputValue, String cityInputValue){

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

            Assert.assertEquals(valuesList.get(0).getText(), firstNameValue + " " + lastNameValue);
            loggerUtility.infoLog("The user validates the presence of "+firstNameValue+ " and "+ lastNameValue+" values into table content");

            Assert.assertEquals(valuesList.get(1).getText(), emailValue);
            loggerUtility.infoLog("The user validates the presence of "+emailValue+  "value into table content");

            Assert.assertEquals(valuesList.get(2).getText(), genderValue);
            loggerUtility.infoLog("The user validates the presence of "+genderValue+  "value into table content");

            Assert.assertEquals(valuesList.get(3).getText(), mobileNumberValue);
            loggerUtility.infoLog("The user validates the presence of "+mobileNumberValue+  "value into table content");

            Assert.assertEquals(valuesList.get(4).getText(), "19 August,2024");
            loggerUtility.infoLog("The user validates the presence date of birth -19 August,2024");

            String subjectValue =String.join(", ",subjectValues);
            Assert.assertEquals(valuesList.get(5).getText(), subjectValues);
            loggerUtility.infoLog("The user validates the presence of "+subjectValues+  "value into table content");

            String hobbyValue =String.join(", ",hobbiesValues);
            Assert.assertEquals(valuesList.get(6).getText(), hobbiesValues);
            loggerUtility.infoLog("The user validates the presence of "+hobbiesValues+  "value into table content");


            File file = new File(pathFile);
            Assert.assertEquals(valuesList.get(7).getText(), file.getName());
            loggerUtility.infoLog("The user validates the presence of "+file+  "value into table content");

            Assert.assertEquals(valuesList.get(8).getText(), currentAddressValue);
            loggerUtility.infoLog("The user validates the presence of "+currentAddressValue+  "value into table content");

            Assert.assertEquals(valuesList.get(9).getText(), stateInputValue +" "+ cityInputValue);
            loggerUtility.infoLog("The user validates the presence of "+stateInputValue+ " and "+ cityInputValue+" values into table content");

        }
    }

