package Tests.Interactions;

import Pages.Interactions.ResizablePage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResizableTest extends BaseTest {

    ResizablePage resizablePage = new ResizablePage();

    @Test
    @DisplayName("Resize test")
    public void changeSize() {
        driver.get(resizablePage.resizablePageUrl);
        changeBoxSize(resizablePage.grip, 10, 0);
        changeBoxSize(resizablePage.grip, 0, 10);
        changeBoxSize(resizablePage.grip, 10, 10);
    }

    private void changeBoxSize(String gripHandle, int x, int y) {
        Actions action = new Actions(driver);
        WebElement grip = driver.findElement(By.cssSelector(gripHandle));
        action.clickAndHold(grip).moveByOffset(x, y).release().build().perform();
    }
}
