package Tests.Basic;

import Pages.Basic.FormPage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class FormTest extends BaseTest {

    File file = new File("src/main/resources/testFile.txt");


    @Test
    @DisplayName("Fill-in Form Success test")
    public void formTestSuccess() {
        FormPage formPage = new FormPage(driver);
        driver.get(formPage.formPageUrl);
        formPage.sendKeysName("Janina");
        formPage.sendKeysSurname("Kowalska");
        formPage.sendKeysEmail("email@email.com");
        formPage.getRandomGender();
        formPage.addAge("20");
        formPage.randomExperience();
        formPage.getRandomProfession();
        formPage.selectOptionContinents("Europe");
        formPage.selectCommand("Wait Commands");
        formPage.uploadFile(file.getAbsolutePath());
        formPage.additionalInfoInput("test");
        formPage.clickDownloadBtn();
        formPage.clickSubmitBtn();
        String actualText = formPage.getSuccessText();
        String expectedText = "Form send with success";
        assertThat(actualText).isEqualTo(expectedText);
    }
}
