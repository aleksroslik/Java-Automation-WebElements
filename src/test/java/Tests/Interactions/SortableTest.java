package Tests.Interactions;

import Pages.Interactions.SortablePage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SortableTest extends BaseTest {

    SortablePage sortablePage = new SortablePage();

    @Test
    @DisplayName("Sortable test 2")
    public void sortableTest2() throws InterruptedException {
        driver.get(sortablePage.sortablePageUrl);

        int items = driver.findElements(By.xpath(sortablePage.item)).size();

        List<Integer> numberSequence = new ArrayList<>();
        for (int i=1; i<=items; i++) {
            numberSequence.add(i);
        }
        Collections.shuffle(numberSequence);

        for (int i=0; i<items; i++) {
            int getIndex = numberSequence.get(i);
            WebElement itemToMove = driver.findElement(By.xpath("//*[@id='sortable']/li[" +getIndex+ "]"));
            WebElement locationToDrop = driver.findElements(By.xpath(sortablePage.item)).get(i);
            Actions actions = new Actions(driver);
            actions.dragAndDrop(itemToMove, locationToDrop).perform();
            Thread.sleep(2000);
        }

        List<Integer> actualValue = new ArrayList<>();
        for (int i = 0; i < items; i++) {
            int value = Integer.parseInt(driver.findElements(By.xpath(sortablePage.item)).get(i).getText().replace("Item ", ""));
            actualValue.add(value);
        }
        assertThat(actualValue).isEqualTo(numberSequence);
    }
}
