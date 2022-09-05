package Pages.Widgets;

import org.openqa.selenium.WebElement;

import java.util.List;

public class DatePickerPage {

    public String datePickerUrl = "https://seleniumui.moderntester.pl/datepicker.php";

    public String dateInputBox = "#datepicker";
    public String monthNext = ".ui-datepicker-next.ui-corner-all";
    public String monthPrevious = ".ui-datepicker-prev.ui-corner-all";
    public String datePicker_month = "span.ui-datepicker-month";
    public String datePicker_year = "span.ui-datepicker-year";

    public String dateOct = "//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[7]";
    public String dateJan = "//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[3]";

    public String dateList = "tbody tr td";

    public List<WebElement> dateTable;
}
