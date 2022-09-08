package Tests.Widgets;

import Pages.Widgets.DatePickerPage;
import Tests.BaseTest;
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
        verifyDate("09/08/2022");
        dateInputClear();
        dateInputClick();
        selectNextMonth();
        pickDay(datePickerPage.dateOct);
        verifyDate("10/01/2022");
        dateInputClear();
        dateInputClick();
        clickNextMonthInLoop("January");
        pickDay(datePickerPage.dateJan);
        verifyDate("01/31/2023");
        dateInputClick();
        pickDay(datePickerPage.dateJan);
        verifyDate("01/31/2023");
        dateInputClear();
        dateInputClick();
        selectPreviousMonth();
        selectRandomDate();
        dateInputClear();
        dateInputClick();
        clickPreviousMonthInLoop("2021");
        selectRandomDate();
    }

    private void dateInputClick() throws InterruptedException {
        driver.findElement(By.cssSelector(datePickerPage.dateInputBox)).click();
        Thread.sleep(2000);
    }

    private void dateInputClear() {
        driver.findElement(By.cssSelector(datePickerPage.dateInputBox)).clear();
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

    private void selectPreviousMonth() {
        driver.findElement(By.cssSelector(datePickerPage.monthPrevious)).click();
    }

    private void pickDay(String day) {
        driver.findElement(By.xpath(day)).click();
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

    private void clickPreviousMonthInLoop(String selectedYear) {
        while (true) {
            String pick = driver.findElement(By.cssSelector(datePickerPage.datePicker_year)).getText();
            if (pick.equals(selectedYear)) {
                break;
            } else {
                driver.findElement(By.cssSelector(datePickerPage.monthPrevious)).click();
            }
        }
    }

    private void selectRandomDate() {
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
}
