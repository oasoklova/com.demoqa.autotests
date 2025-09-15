package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            userGender = $("#genterWrapper"),
            userPhone = $("#userNumber"),
            userSubjectName = $("#subjectsInput"),
            userHobby = $("#hobbiesWrapper"),
            userAddress = $("#currentAddress"),
            userStateCityDropdown = $("#stateCity-wrapper"),
            userState = $("#state"),
            userCity = $("#city"),
            submitButton = $("#submit"),
            successfulForm = $(".modal-content"),
            birthDateField = $("#dateOfBirthInput"),
            uploadButton = $("#uploadPicture");

    public StudentRegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public StudentRegistrationFormPage setName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setGender(String sex) {
        userGender.$(byText(sex)).click();
        return this;
    }

    public StudentRegistrationFormPage setUserPhone(String value) {
        $(userPhone).setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setDateOfBirth(String day, String month, String year) {
        birthDateField.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public StudentRegistrationFormPage setSubject(String value) {
        userSubjectName.setValue(value).pressEnter();
        return this;
    }

    public StudentRegistrationFormPage setHobby(String value) {
        userHobby.$(byText(value)).click();
        return this;
    }

    public StudentRegistrationFormPage setUserAddress(String address) {
        userAddress.setValue(address);
        return this;
    }

    public StudentRegistrationFormPage setUserState(String value) {
        userState.scrollTo().click();
        userStateCityDropdown.$(byText("NCR")).click();
        return this;
    }

    public StudentRegistrationFormPage setUserCity(String value) {
        userCity.click();
        userStateCityDropdown.$(byText("Gurgaon")).click();
        return this;
    }

    public StudentRegistrationFormPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public StudentRegistrationFormPage checkSubmittingForm() {
        successfulForm.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public StudentRegistrationFormPage uploadPhoto(String url) {
        uploadButton.uploadFile(new File(url));
        return this;
    }
}