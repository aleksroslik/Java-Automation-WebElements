package Tests.Basic;

import Pages.Basic.AlertsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlertsTest extends Base.BaseTest {

    AlertsPage alertsPage = new AlertsPage();

    @Test
    @DisplayName("Simple Alert test")
    public void simpleAlertTest() {
        driver.get(alertsPage.alertsPageUrl);
        driver.findElement(By.cssSelector(alertsPage.simpleAlertBtn)).click();
        driver.switchTo().alert().accept();
        String expectedText = driver.findElement(By.cssSelector(alertsPage.simpleAlertLabel)).getText();
        assertThat(expectedText).isEqualTo(alertsPage.simpleAlertLabelText);
    }

    @Test
    @DisplayName("Prompt Alert test")
    public void promptAlertTest() {
        driver.get(alertsPage.alertsPageUrl);
        driver.findElement(By.cssSelector(alertsPage.promptAlertBtn)).click();
        driver.switchTo().alert().sendKeys(alertsPage.promptTestText);
        driver.switchTo().alert().accept();
        String expectedText = driver.findElement(By.cssSelector(alertsPage.promptAlertLabel)).getText();
        assertThat(expectedText).isEqualTo(alertsPage.promptAlertLabelText);
    }

}
