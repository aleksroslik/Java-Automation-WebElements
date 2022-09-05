package Tests.Basic;

import Pages.Basic.AlertsPage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlertsTest extends BaseTest {

    AlertsPage alertsPage = new AlertsPage();

    @BeforeEach
    void goToPage() {
        driver.get(alertsPage.alertsPageUrl);
    }

    @Test
    @DisplayName("Simple Alert test")
    public void simpleAlertTest() {
        alertButtonClick(alertsPage.simpleAlertBtn);
        acceptAlert();
        confirmLabelText(alertsPage.simpleAlertLabel, alertsPage.simpleAlertLabelText);
    }

    @Test
    @DisplayName("Prompt Alert test")
    public void promptAlertTest() {
        alertButtonClick(alertsPage.promptAlertBtn);
        sendKeysAlert(alertsPage.promptTestText);
        acceptAlert();
        confirmLabelText(alertsPage.promptAlertLabel, alertsPage.promptAlertLabelText);
    }

    @Test
    @DisplayName("Confirm Alert test")
    public void confirmAlertTest() {
        alertButtonClick(alertsPage.confirmAlertBtn);
        acceptAlert();
        confirmLabelText(alertsPage.confirmAlertLabel, alertsPage.confirmAlertLabelTextOK);
        alertButtonClick(alertsPage.confirmAlertBtn);
        dismissAlert();
        confirmLabelText(alertsPage.confirmAlertLabel, alertsPage.confirmAlertLabelTextCancel);
    }

    @Test
    @DisplayName("Delayed Alert test")
    public void delayedAlertTest() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        alertButtonClick(alertsPage.delayedAlertBtn);
        wait.until(ExpectedConditions.alertIsPresent());
        acceptAlert();
        confirmLabelText(alertsPage.delayedAlertLabel, alertsPage.delayedAlertLabelText);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void sendKeysAlert(String testText) {
        driver.switchTo().alert().sendKeys(testText);
    }

    public void alertButtonClick(String alertButton) {
        driver.findElement(By.cssSelector(alertButton)).click();
    }

    public void confirmLabelText(String label, String expectedText) {
        String actualText = driver.findElement(By.cssSelector(label)).getText();
        assertThat(actualText).isEqualTo(expectedText);
    }
}
