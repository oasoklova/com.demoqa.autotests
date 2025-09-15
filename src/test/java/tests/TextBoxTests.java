package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends BaseTest {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    public void successFillTextBox() {
        textBoxPage.openTextBoxPage()
                .setFullName("Alex")
                .setEmail("fdg@gmail.com")
                .setUserCurrentAddress("London")
                .setUserPermanentAddress("London")
                .clickSubmitButton()
                .checkOutput("Alex", "fdg@gmail.com", "London");
    }

    @Test
    public void wrongEmailTest() {
        textBoxPage.openTextBoxPage()
                .setFullName("Alex")
                .setEmail("wrong")
                .setUserCurrentAddress("London")
                .setUserPermanentAddress("London")
                .clickSubmitButton()
                .checkErrorEmail();
    }
}