package Tests.Widgets;

import Pages.Widgets.AutocompletePage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AutocompleteTest extends BaseTest {

    AutocompletePage autocompletePage = new AutocompletePage();

    @Test
    @DisplayName("Autocomplete test")
    public void autocompleteTest() {
        driver.get(autocompletePage.autocompletePageUrl);
        driver.findElement(By.cssSelector(autocompletePage.searchInput)).sendKeys("a");
        String results = driver.findElement(By.cssSelector(autocompletePage.resultList)).getText();
        System.out.println(results);
    }
}
