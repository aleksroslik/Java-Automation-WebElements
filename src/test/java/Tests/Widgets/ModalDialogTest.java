package Tests.Widgets;

import Pages.Widgets.ModalDialogPage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ModalDialogTest extends BaseTest {

    static ModalDialogPage modalDialogPage = new ModalDialogPage();

    @ParameterizedTest
    @MethodSource("data")
    @DisplayName("Modal dialog test")
    public void modalDialogTest(String name, String email, String password) {
        driver.get(modalDialogPage.modalPageUrl);
        modalDialogPage.rows = driver.findElements(By.cssSelector(modalDialogPage.tableRows));
        int initCount = modalDialogPage.rows.size();
        driver.findElement(By.cssSelector(modalDialogPage.createBtn)).click();
        WebElement modalContainer = driver.findElement(By.cssSelector(modalDialogPage.modal));
        sendKeys(modalDialogPage.nameInput, name);
        sendKeys(modalDialogPage.emailInput, email);
        sendKeys(modalDialogPage.passwordInput, password);
        modalContainer.findElement(By.cssSelector(modalDialogPage.confirmButton)).click();
        modalDialogPage.rows = driver.findElements(By.cssSelector(modalDialogPage.tableRows));
        int finalCount = modalDialogPage.rows.size();
        assertThat(finalCount).isEqualTo(initCount + 1);
    }

    private void sendKeys(String locator, String keys) {
        WebElement modalContainer = driver.findElement(By.cssSelector(modalDialogPage.modal));
        modalContainer.findElement(By.cssSelector(locator)).clear();
        modalContainer.findElement(By.cssSelector(locator)).sendKeys(keys);
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("Jan Kowalski", "Email@email.com", "password")
        );
    }
}
