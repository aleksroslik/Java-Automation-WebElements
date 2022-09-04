package Tests.Widgets;

import Pages.Widgets.SliderPage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SliderTest extends BaseTest {

    static SliderPage sliderPage = new SliderPage();

    @ParameterizedTest
    @MethodSource("Pages.Widgets.SliderPage#data")
    @DisplayName("Slider test - Slider resets each time")
    public void sliderTestMoveWithReset(String sliderHandle, int x, String expectedValue) {
        driver.get(sliderPage.sliderPageUrl);
        slideToLocation(sliderHandle, x, expectedValue);
    }

    public void slideToLocation(String sliderHandle, int xTimes, String expectedValue) {
        WebElement slider = driver.findElement(By.cssSelector(sliderHandle));
        for (int i=0; i<xTimes; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        slider.sendKeys(Keys.ENTER);
        String actualValue = driver.findElement(By.cssSelector(sliderHandle)).getText();
        assertThat(actualValue).isEqualTo(expectedValue);
    }
}
