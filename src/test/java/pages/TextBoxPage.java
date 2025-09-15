package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private SelenideElement userName = $("#userName"),
            userEmail = $("#userEmail"),
            userCurrentAddress = $("#currentAddress"),
            userPermanentAddress = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputMessage = $("#output"),
            errorEmail = $(".field-error");

    public TextBoxPage openTextBoxPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage setFullName(String name) {
        userName.setValue(name);
        return this;
    }

    public TextBoxPage setEmail(String email) {
        userEmail.setValue(email);
        return this;
    }

    public TextBoxPage setUserCurrentAddress(String address) {
        userCurrentAddress.setValue(address);
        return this;
    }

    public TextBoxPage setUserPermanentAddress(String address) {
        userPermanentAddress.setValue(address);
        return this;
    }

    public TextBoxPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkOutput(String name, String email, String address) {
        outputMessage.shouldBe(visible);
        outputMessage.shouldHave(text(name));
        outputMessage.shouldHave(text(email));
        outputMessage.shouldHave(text(address));
        return this;
    }

    public TextBoxPage checkErrorEmail() {
        errorEmail.shouldBe(visible);
        return this;
    }
}