package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //locators and elements
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderButton = $("#gender-radio-1"),
            cellPhoneNumber = $("#userNumber"),
            calendarPicker = $("#dateOfBirthInput"),
            monthPicker = $(".react-datepicker__month-select"),
            yearPicker = $(".react-datepicker__year-select"),
            datePicker = $("[aria-label=\"Choose Sunday, January 1st, 1989\"]"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            statePicker = $("#state"),
            cityPicker = $("#city"),
            submitButton = $("#submit"),
    // test verification
            resultsVerification = $(".table-responsive");


    //actions
    public void openPage(){
        open("https://demoqa.com/automation-practice-form");
    }
    public void setFirstName(String fName){
        firstNameInput.setValue(fName);
    }
    public void setLastName(String lName){
        lastNameInput.setValue(lName);
    }
    public void setEmail (String email){
        emailInput.setValue(email);
    }
    public void clickGenderButton (){
        genderButton.parent().click();
    }
    public void setCellPhoneNumber(String pNumber){
        cellPhoneNumber.setValue(pNumber);
    }
    public void setDateOfBirth(){
        calendarPicker.click();
        monthPicker.selectOption(0);
        yearPicker.selectOption("1989");
        datePicker.click();
    }
    public void setSubject(String subjectText){
        subjectInput.setValue(subjectText).pressEnter();
    }
    public void setHobbies (String value){
        hobbiesInput.$(byText(value)).click();
    }
    public void uploadFile (String fileName){
        uploadInput.uploadFromClasspath(fileName);
    }
    public void setAddress (String address){
        addressInput.setValue(address);
    }
    public void setState (String state){
        statePicker.click();
        statePicker.$(byText(state)).click();
    }
    public void setCity (String city){
        cityPicker.click();
        cityPicker.$(byText(city)).click();
    }
    public void pressSubmit(){
        submitButton.click();
    }
    public void checkResults(){
        resultsVerification.$(byText("Student Name")).parent().shouldHave(text("Nikolai Panevin"));
        resultsVerification.$(byText("Student Email")).parent().shouldHave(text("panevin.n@gmail.com"));
        resultsVerification.$(byText("Gender")).parent().shouldHave(text("Male"));
        resultsVerification.$(byText("Mobile")).parent().shouldHave(text("1333777000"));
        resultsVerification.$(byText("Date of Birth")).parent().shouldHave(text("01 January,1989"));
        resultsVerification.$(byText("Subjects")).parent().shouldHave(text("Computer Science"));
        resultsVerification.$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        resultsVerification.$(byText("Picture")).parent().shouldHave(text("IMG_4016.PNG"));
        resultsVerification.$(byText("Address")).parent().shouldHave(text("grove street 1"));
        resultsVerification.$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }
}
