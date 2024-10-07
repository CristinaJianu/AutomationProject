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
        elementMethods.fillElement(lastNameElement, lastNameValue);
        elementMethods.fillElement(emailElement, emailValue);

        switch (genderValue) {
            case "Male":
                elementMethods.clickJsElement(genderOptionsList.get(0));
                break;
            case "Female":
                elementMethods.clickJsElement(genderOptionsList.get(1));
                break;
            case "Other":
                elementMethods.clickJsElement(genderOptionsList.get(2));
                break;
        }

        elementMethods.fillElement(mobileNumberElement, mobileNumberValue);
        elementMethods.clickJsElement(dateOfBirthElement);
        elementMethods.selectDropdownElement(monthElement, monthValue);
        elementMethods.selectDropdownElement(yearElement, yearValue);
        for (int i = 0; i < daysList.size(); i++) {
            if (daysList.get(i).getText().equals(dayValue)) {
                elementMethods.clickJsElement(daysList.get(i));
                break;
            }
        }
        for (int index = 0; index < subjectValues.size(); index++) {
            elementMethods.fillPressElement(subjectElement, subjectValues.get(index), Keys.ENTER);
        }
        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (hobbiesValues.contains(currentText)) {
                elementMethods.clickJsElement(hobbiesOptionsList.get(index));
            }
        }
        File file = new File(pathFile);
        elementMethods.fillElement(pictureElement, file.getAbsolutePath());
        elementMethods.fillElement(currentAddressElement, currentAddressValue);
        elementMethods.clickJsElement(stateElement);
        elementMethods.fillPressElement(stateInputElement, stateInputValue, Keys.ENTER);
        elementMethods.fillPressElement(cityInputElement, cityInputValue, Keys.ENTER);
        elementMethods.clickJsElement(submitElement);}


        public void validateFormValues (String firstNameValue, String lastNameValue, String emailValue,
                String genderValue, String mobileNumberValue, List < String > subjectValues,
                List < String > hobbiesValues, String pathFile, String currentAddressValue,
                String stateInputValue, String cityInputValue){

        elementMethods.waitVisibleElement(thankYouElement);
            Assert.assertEquals(thankYouElement.getText(), "Thanks for submitting the form");

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
            Assert.assertEquals(valuesList.get(4).getText(), "19 August,2024");

            String subjectValue =String.join(", ",subjectValues);
            Assert.assertEquals(valuesList.get(5).getText(), subjectValues);

            String hobbyValue =String.join(", ",hobbiesValues);
            Assert.assertEquals(valuesList.get(6).getText(), hobbiesValues);

            File file = new File(pathFile);
            Assert.assertEquals(valuesList.get(7).getText(), file.getName());
            Assert.assertEquals(valuesList.get(8).getText(), currentAddressValue);
            Assert.assertEquals(valuesList.get(9).getText(), stateInputValue +" "+ cityInputValue);

        }
    }

