package Tests.Interactions;

import Pages.Interactions.DraggablePage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DraggableTest extends BaseTest {

    static DraggablePage draggablePage = new DraggablePage();

    @Test
    @DisplayName("Drag Box test")
    public void moveBoxByOffSet() {
        driver.get(draggablePage.interactionsPageUrl);
        Actions action = new Actions(driver);
        WebElement box = driver.findElement(By.cssSelector(draggablePage.dragAndDropBox));
        Point point = box.getLocation();
        int x1 = point.getX();
        int y1 = point.getY();
        System.out.println(x1 + " " + y1);
        action.dragAndDropBy(box, 2*x1, 0).perform();
        action.dragAndDropBy(box, 0, 2*y1).perform();
        action.dragAndDropBy(box, -x1, -y1).perform();
        action.dragAndDropBy(box, -x1, y1).perform();
    }
}
