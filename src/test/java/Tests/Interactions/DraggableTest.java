package Tests.Interactions;

import Pages.Interactions.DraggablePage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.stream.Stream;

public class DraggableTest extends BaseTest {

    static DraggablePage draggablePage = new DraggablePage();

    @ParameterizedTest
    @MethodSource("coordinates")
    @DisplayName("Drag & Drop Box test")
    public void moveBoxToDifferentLocations(String dropBox, int x, int y) {
        driver.get(draggablePage.interactionsPageUrl);
        Actions action = new Actions(driver);
        WebElement box = driver.findElement(By.cssSelector(dropBox));
        action.dragAndDropBy(box, x, y).perform();
    }

    public static Stream<Arguments> coordinates() {
        return Stream.of(
                Arguments.of(draggablePage.dragAndDropBox, 950, 50),
                Arguments.of(draggablePage.dragAndDropBox, 945, 510),
                Arguments.of(draggablePage.dragAndDropBox, 450, 250),
                Arguments.of(draggablePage.dragAndDropBox, 90, 590)
        );
    }
}
