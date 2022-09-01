package Tests.Basic;

import Pages.Basic.FormPage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FormTest extends BaseTest {

    FormPage formPage = new FormPage();
    File file = new File("src/main/resources/testFile.txt");

    @BeforeEach
    void goToPage() {
        driver.get(formPage.formPageUrl);

    }

    @Test
    @DisplayName("Fill-in Form Success test")
    public void formTestSuccess() {
        sendKeys(formPage.firstNameInput, "Janina");
        sendKeys(formPage.lastNameInput, "Kowalska");
        sendKeys(formPage.emailInput, "email@email.com");
        formClick(formPage.genderRadioBtnFem);
        sendKeys(formPage.ageInput, "20");
        formClick(formPage.experienceRadioBtn3);
        formClick(formPage.professionCheckBoxAuto);
        selectOption(formPage.dropDownList, "Europe");
        selectOption(formPage.commandsSelection, "Wait Commands");
        sendKeys(formPage.file, file.getAbsolutePath());
        sendKeys(formPage.additionalInfo,"test");
        formClick(formPage.testFileToDownloadBtn);
        formClick(formPage.signInBtn);
        confirmLabelText(formPage.successMsgLabel, formPage.successMsgText);
    }

    public void sendKeys(String input, String value) {
        driver.findElement(By.cssSelector(input)).sendKeys(value);
    }

    public void formClick(String btn) {
        driver.findElement(By.cssSelector(btn)).click();
    }

    public void selectOption(String options, String value) {
        Select selection = new Select(driver.findElement(By.cssSelector(options)));
        selection.selectByVisibleText(value);
    }

    public void confirmLabelText(String label, String expectedText) {
        String actualText = driver.findElement(By.cssSelector(label)).getText();
        assertThat(actualText).isEqualTo(expectedText);
    }

}
