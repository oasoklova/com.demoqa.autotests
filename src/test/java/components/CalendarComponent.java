package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement userMonth = $(".react-datepicker__month-select"),
            userYear = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {
        userMonth.selectOption(month);
        userYear.selectOption(year);
        $(getDatePikerSelector(day)).click();
    }

    private String getDatePikerSelector(String day) {
        return ".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)";
    }
}