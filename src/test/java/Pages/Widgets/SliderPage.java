package Pages.Widgets;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class SliderPage {

    public String sliderPageUrl = "https://seleniumui.moderntester.pl/slider.php";

    public static String sliderHandle = "#custom-handle";

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(sliderHandle, 540, 215, "50"),
                Arguments.of(sliderHandle, 320, 185, "80"),
                Arguments.of(sliderHandle, -680, -20, "20"),
                Arguments.of(sliderHandle, -350, -10, "0")
        );
    }
}
