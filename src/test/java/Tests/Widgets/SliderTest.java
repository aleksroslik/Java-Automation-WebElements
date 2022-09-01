package Tests.Widgets;

import Pages.Widgets.SliderPage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SliderTest extends BaseTest {

    static SliderPage sliderPage = new SliderPage();

    @BeforeEach
    public void goToPageUrl() {
        driver.get(sliderPage.sliderPageUrl);
    }

    @ParameterizedTest
    @MethodSource("data")
    @DisplayName("Slider test - Slider resets each time")
    public void sliderTestMoveWithReset(String sliderHandle, int x, int y, String expectedValue) {
        slideToLocation(sliderHandle, x, y, expectedValue);
    }

    @Test
    @DisplayName("Slider test - Slider moves left and right")
    public void sliderTestLeftAndRightMove() {
        driver.get(sliderPage.sliderPageUrl);
        slideToLocation(SliderPage.sliderHandle, 540, 215, "50");
        slideToLocation(SliderPage.sliderHandle, 320, 185, "80");
        slideToLocation(SliderPage.sliderHandle, -680, -20, "20");
        slideToLocation(SliderPage.sliderHandle, -350, -10, "0");
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(SliderPage.sliderHandle, 540, 215, "50"),
                Arguments.of(SliderPage.sliderHandle, 870, 215, "80"),
                Arguments.of(SliderPage.sliderHandle, 210, 215, "20"),
                Arguments.of(SliderPage.sliderHandle, -10, 215, "0")
        );
    }

    public void slideToLocation(String sliderHandle, int x, int y, String expectedValue) {
        Actions action = new Actions(driver);
        WebElement slider = driver.findElement(By.cssSelector(sliderHandle));
        action.dragAndDropBy(slider, x, y).perform();
        String actualValue = driver.findElement(By.cssSelector(sliderHandle)).getText();
        assertThat(actualValue).isEqualTo(expectedValue);
    }
}
