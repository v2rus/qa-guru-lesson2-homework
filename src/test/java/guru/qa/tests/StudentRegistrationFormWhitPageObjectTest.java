package guru.qa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationFormWhitPageObjectTest extends TestBase {


    @Test
    void fillFormTest (){
        registrationPage.openPage();
        registrationPage.setFirstName("Nikolai");
        registrationPage.setLastName("Panevin");
        registrationPage.setEmail("panevin.n@gmail.com");
        registrationPage.clickGenderButton();
        registrationPage.setCellPhoneNumber("13337770000");
        registrationPage.setDateOfBirth();
        registrationPage.setSubject("Computer S");
        registrationPage.setHobbies("Sports");
        registrationPage.uploadFile("img/IMG_4016.PNG");
        registrationPage.setAddress("grove street 1");
        registrationPage.setState("NCR");
        registrationPage.setCity("Delhi");
        registrationPage.pressSubmit();

        registrationPage.checkResults();
    }
}
