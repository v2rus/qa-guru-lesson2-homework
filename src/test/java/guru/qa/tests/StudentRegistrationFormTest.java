package guru.qa.tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class StudentRegistrationFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest (){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Nikolai");
        $("#lastName").setValue("Panevin");
        $("#userEmail").setValue("panevin.n@gmail.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("13337770000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(0);
        $(".react-datepicker__year-select").selectOption("1989");
        $("[aria-label=\"Choose Sunday, January 1st, 1989\"]").click();
        $("#subjectsInput").setValue("Computer S").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/IMG_4016.PNG");
        $("#currentAddress").setValue("grove street 1");
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Nikolai Panevin"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("panevin.n@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1333777000"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("01 January,1989"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Computer Science"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("IMG_4016.PNG"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("grove street 1"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }
}
