package Tests.Widgets;

import Pages.Widgets.ProgressBarPage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBarTest extends BaseTest {

    ProgressBarPage progressBarPage = new ProgressBarPage();

    @Test
    @DisplayName("Progress bar test")
    public void progressBarTest() {
        driver.get(progressBarPage.progressPageUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        WebElement label = driver.findElement(By.cssSelector(progressBarPage.progressLabel));
        String expectedText = progressBarPage.labelText;
        wait.until(ExpectedConditions.textToBePresentInElement(label, expectedText));
    }
}
