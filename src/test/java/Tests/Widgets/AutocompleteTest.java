package Tests.Widgets;

import Pages.Widgets.AutocompletePage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AutocompleteTest extends BaseTest {

    AutocompletePage autocompletePage = new AutocompletePage();

    @Test
    @DisplayName("Autocomplete test")
    public void autocompleteTest() {
        driver.get(autocompletePage.autocompletePageUrl);
        sendKeys(autocompletePage.searchInput, "a");
        String results = driver.findElement(By.cssSelector(autocompletePage.resultList)).getText();
        System.out.println(results);
        selectOption(autocompletePage.searchInput, 3);
        getValueAndCompareText(autocompletePage.searchInput, autocompletePage.expectedText);
    }

    public void selectOption(String input, int xTimes) {
        WebElement resultList = driver.findElement(By.cssSelector(input));
        for (int i=0; i<xTimes; i++) {
            resultList.sendKeys(Keys.ARROW_DOWN);
        }
        resultList.sendKeys(Keys.TAB);
    }

    public void sendKeys(String input, String value) {
        driver.findElement(By.cssSelector(input)).sendKeys(value);
    }

    public void getValueAndCompareText(String input, String expVal){
        String actualValue = driver.findElement(By.cssSelector(input)).getAttribute("value");
        assertThat(actualValue).isEqualTo(expVal);
    }
}
