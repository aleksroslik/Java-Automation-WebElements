package Tests.Interactions;

import Pages.Interactions.ResizablePage;
import Tests.Base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResizableTest extends BaseTest {

    ResizablePage resizablePage = new ResizablePage();

    @Test
    @DisplayName("Resize test")
    public void changeSize() {
        driver.get(resizablePage.resizablePageUrl);
        changeBoxSize(resizablePage.grip, 28, 0);
        changeBoxSize(resizablePage.grip, 0, 28);
        changeBoxSize(resizablePage.grip, 28, 28);
    }

    private void changeBoxSize(String gripHandle, int x, int y) {
        Actions action = new Actions(driver);
        WebElement grip = driver.findElement(By.cssSelector(gripHandle));
        Point point = grip.getLocation();
        int x1 = point.getX();
        int y1 = point.getY();
        System.out.println("Size before: " + x1 + " " + y1);
        action.clickAndHold(grip).moveByOffset(x, y).release().build().perform();
        Point point2 = grip.getLocation();
        int x2 = point2.getX();
        int y2 = point2.getY();
        System.out.println("Size after: " + x2 + " " + y2);
    }
}
