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
    @DisplayName("Select multiple items test")
    public void selectMultipleItems() {
        driver.get(selectablePage.selectablePageUrl);
        keyDownWithControl(selectablePage.options);
        selectOption(selectablePage.option1);
        selectOption(selectablePage.option3);
        selectOption(selectablePage.option4);
        assertText(selectablePage.feedbackMsg, selectablePage.expectedText);
    }

    private void selectOption(String option) {
        driver.findElement(By.cssSelector(option)).click();
    }

    private void keyDownWithControl(String area) {
        WebElement options = driver.findElement(By.cssSelector(area));
        Actions action = new Actions(driver);
        action.keyDown(options, Keys.CONTROL).perform();
    }

    private void assertText(String actualMessage, String expectedText) {
        String actualMsg = driver.findElement(By.cssSelector(actualMessage)).getText();
        assertThat(actualMsg).isEqualTo(expectedText);
    }
}
