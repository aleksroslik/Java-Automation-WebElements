package Tests.Interactions;

import Pages.Interactions.DroppablePage;
import Tests.Base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DroppableTest extends BaseTest {

    DroppablePage droppablePage = new DroppablePage();

    @Test
    @DisplayName("Drop test")
    public void dragAndDropToALocation() {
        driver.get(droppablePage.droppablePageUrl);
        dragToLocation(droppablePage.dragBox, droppablePage.dropBox, droppablePage.successMessage);
    }

    private void dragToLocation(String startLocation, String targetLocation, String expectedValue) {
        Actions action = new Actions(driver);
        WebElement dragBox = driver.findElement(By.cssSelector(startLocation));
        WebElement dropBox = driver.findElement(By.cssSelector(targetLocation));
        action.dragAndDrop(dragBox, dropBox).perform();
        String actualValue = driver.findElement(By.cssSelector(targetLocation)).getText();
        assertThat(actualValue).isEqualTo(expectedValue);
    }
}
