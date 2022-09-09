package Tests.Basic;

import Pages.Basic.FormPage;
import Tests.Base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FormTest extends BaseTest {

    File file = new File("src/main/resources/testFile.txt");

    @Test
    @DisplayName("Form Success test")
    public void formTestSuccess() {
        FormPage formPage = new FormPage(driver);
        driver.get(formPage.formPageUrl);
        formPage.sendKeysName("Janina")
                .sendKeysSurname("Kowalska")
                .sendKeysEmail("email@email.com")
                .getRandomGender()
                .addAge("20")
                .randomExperience()
                .getRandomProfession()
                .selectOptionContinents("Europe")
                .selectCommands("Wait Commands", "Switch Commands", driver)
                .uploadFile(file.getAbsolutePath())
                .additionalInfoInput("test")
                .clickDownloadBtn()
                .clickSubmitBtn();
        assertThat(formPage.getSuccessText()).isEqualTo("Form send with success");
    }
}
