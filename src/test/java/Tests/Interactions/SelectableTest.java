package Tests.Interactions;

import Pages.Interactions.SelectablePage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelectableTest extends BaseTest {

    SelectablePage selectablePage = new SelectablePage();

    @Test
    @DisplayName("Select multiple test")
    public void selectItems() {
        driver.get(selectablePage.selectablePageUrl);
        WebElement options = driver.findElement(By.cssSelector(selectablePage.options));
        Actions action = new Actions(driver);
        action.keyDown(options, Keys.CONTROL).perform();
        driver.findElement(By.cssSelector(selectablePage.option1)).click();
        driver.findElement(By.cssSelector(selectablePage.option3)).click();
        driver.findElement(By.cssSelector(selectablePage.option4)).click();
        String msg = driver.findElement(By.cssSelector(selectablePage.feedbackMsg)).getText();
        assertThat(msg).isEqualTo(selectablePage.expectedText);
    }
}
