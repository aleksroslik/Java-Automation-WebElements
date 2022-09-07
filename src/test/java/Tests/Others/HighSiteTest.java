package Tests.Others;

import Pages.Others.HighSitePage;
import Tests.BaseTest;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HighSiteTest extends BaseTest {

    HighSitePage highSitePage = new HighSitePage();

    @Test
    @DisplayName("High site test")
    public void scrollToTest() throws IOException {
        driver.get(highSitePage.highSitePageUrl);
        scrollToElement(highSitePage.button);
        takeScreenshot();
    }

    public void scrollToElement(String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement button = driver.findElement(By.cssSelector(element));
        js.executeScript("arguments[0].scrollIntoView(true);", button);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
    }

    public void takeScreenshot() throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//src/main/resources/screenshot/screen.png"));
    }
}
