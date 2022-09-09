package Tests.Widgets;

import Pages.Widgets.DatePickerPage;
import Tests.Base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DatePickerTest extends BaseTest {

    DatePickerPage datePickerPage = new DatePickerPage();

    @Test
    @DisplayName("DatePicker test")
    public void datePickerTest() throws InterruptedException {
        driver.get(datePickerPage.datePickerUrl);
        dateInputClick();
        dateInputSendKeys(String.valueOf(Keys.ENTER));
        verifyDate("09/09/2022");
        dateInputClearAndClick();
        selectNextMonth();
        selectDay("1", 9);
        verifyDate("10/01/2022");
        dateInputClearAndClick();
        clickNextMonthInLoop("January");
        selectDay("31", 0);
        verifyDate("01/31/2023");
        dateInputClick();
        selectDay("31", 0);
        verifyDate("01/31/2023");
        dateInputClearAndClick();
        clickPrevMonthInLoop("August");
        selectRandomDay();
        dateInputClearAndClick();
        clickPrevToSelectedYearAndMonth("2021", "April");
        selectRandomDay();
    }

    private void dateInputClearAndClick() throws InterruptedException {
        driver.findElement(By.cssSelector(datePickerPage.dateInputBox)).clear();
        driver.findElement(By.cssSelector(datePickerPage.dateInputBox)).click();
        Thread.sleep(2000);
    }

    private void dateInputClick() {
        driver.findElement(By.cssSelector(datePickerPage.dateInputBox)).click();
    }

    private void dateInputSendKeys(String value) {
        driver.findElement(By.cssSelector(datePickerPage.dateInputBox)).sendKeys(value);
    }

    private void verifyDate(String date) {
        String actualDate = driver.findElement(By.cssSelector(datePickerPage.dateInputBox)).getAttribute("value");
        assertThat(actualDate).isEqualTo(date);
    }

    private void selectNextMonth() {
        driver.findElement(By.cssSelector(datePickerPage.monthNext)).click();
    }

    private void clickNextMonthInLoop(String selectedMonth) {
        while (true) {
            String monthPick = driver.findElement(By.cssSelector(datePickerPage.datePicker_month)).getText();
            if (monthPick.equals(selectedMonth)) {
                break;
            } else {
                driver.findElement(By.cssSelector(datePickerPage.monthNext)).click();
            }
        }
    }

    private void clickPrevMonthInLoop(String selectedMonth) {
        while (true) {
            String monthPick = driver.findElement(By.cssSelector(datePickerPage.datePicker_month)).getText();
            if (monthPick.equals(selectedMonth)) {
                break;
            } else {
                driver.findElement(By.cssSelector(datePickerPage.monthPrevious)).click();
            }
        }
    }

    private void clickPrevToSelectedYearAndMonth(String selectedYear, String selectedMonth) {
        while (true) {
            String pick = driver.findElement(By.cssSelector(datePickerPage.datePicker_year)).getText();
            String monthPick = driver.findElement(By.cssSelector(datePickerPage.datePicker_month)).getText();
            if (pick.equals(selectedYear) && monthPick.equals(selectedMonth)) {
                break;
            } else {
                driver.findElement(By.cssSelector(datePickerPage.monthPrevious)).click();
            }
        }
    }

    private void selectRandomDay() {
        datePickerPage.dateTable = driver.findElements(By.cssSelector(datePickerPage.dateList));
        getRandomElement(datePickerPage.dateTable).click();
        String chosenDate = driver.findElement(By.cssSelector(datePickerPage.dateInputBox)).getAttribute("value");
        System.out.println(chosenDate);
    }

    private WebElement getRandomElement(List<WebElement> elements) {
        Random dates = new Random();
        int noOfElements = elements.size();
        int randomPick = dates.nextInt(noOfElements);
        return elements.get(randomPick);
    }

    private void selectDay(String dayToSelect, int monthIndex) {
        List<WebElement> allDays =
                driver.findElements(By.cssSelector("td[data-month='"+monthIndex+"']"));
        for (WebElement day : allDays) {
            if (day.getText().equals(dayToSelect)) {
                day.click();
                break;
            }
        }
    }
}
