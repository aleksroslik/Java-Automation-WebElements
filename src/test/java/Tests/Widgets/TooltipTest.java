package Tests.Widgets;

import Pages.Widgets.TooltipPage;
import Tests.Base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TooltipTest extends BaseTest {

    TooltipPage tooltipPage = new TooltipPage();

    @Test
    @DisplayName("Tooltip message verification")
    public void toolTipMsg() {
        driver.get(tooltipPage.toolTipUrl);
        toolTipMsgTrigger(tooltipPage.ageInput, tooltipPage.toolTipBox);
    }

    private void toolTipMsgTrigger(String input, String box) {
        Actions action = new Actions(driver);
        WebElement tooltip = driver.findElement(By.cssSelector(input));
        action.moveToElement(tooltip).perform();
        Boolean display = driver.findElement(By.cssSelector(box)).isDisplayed();
        assertThat(display).isTrue();
        String actualText = driver.findElement(By.cssSelector(box)).getText();
        System.out.println(actualText);
    }
}
