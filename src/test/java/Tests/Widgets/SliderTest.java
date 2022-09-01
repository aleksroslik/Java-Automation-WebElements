package Tests.Widgets;

import Pages.Widgets.SliderPage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SliderTest extends BaseTest {

    SliderPage sliderPage = new SliderPage();

    @Test
    @DisplayName("Slider test")
    public void sliderTest() {
        driver.get(sliderPage.sliderPageUrl);
        slideToLocation(sliderPage.sliderHandle, 540, 215, "50");
        slideToLocation(sliderPage.sliderHandle, 320, 185, "80");
        slideToLocation(sliderPage.sliderHandle, -680, -20, "20");
        slideToLocation(sliderPage.sliderHandle, -350, -10, "0");
    }

    public void slideToLocation(String sliderHandle, int x, int y, String expectedValue) {
        Actions action = new Actions(driver);
        WebElement slider = driver.findElement(By.cssSelector(sliderHandle));
        action.dragAndDropBy(slider, x, y).perform();
        String actualValue = driver.findElement(By.cssSelector(sliderHandle)).getText();
        assertThat(actualValue).isEqualTo(expectedValue);
    }
}
