package Tests.Widgets;

import Pages.Widgets.MenuPage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MenuTest extends BaseTest {

    MenuPage menuPage = new MenuPage();

    @Test
    @DisplayName("Menu test")
    public void menuTest() {
        driver.get(menuPage.menuPageUrl);
        findElementOnTheList(menuPage.musicItem);
        findElementOnTheList(menuPage.jazzItem);
        findElementOnTheList(menuPage.modernItem);
    }

    private void findElementOnTheList(String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(element))));
        driver.findElement(By.cssSelector(element)).click();
    }
}
