package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

public class StudentRegistrationFormTests extends BaseTest{
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    @Test
    public void successfulRegistrationStudentTest(){
        studentRegistrationFormPage.openPage()
                .setName("Tom")
                .setLastName("Radle")
                .setEmail("dfd@mai.com")
                .setGender("Male")
                .setUserPhone("89045849850")
                .setDateOfBirth("23", "June", "2000")
                .setSubject("Maths")
                .setHobby("Sports")
                .uploadPhoto("/Users/olya/Sources/guruProject/src/test/resources/pictures/1.png")
                .setUserAddress("London")
                .setUserState("NCR")
                .setUserCity("Gurgaon")
                .clickSubmit()
                .checkSubmittingForm();
    }
}
