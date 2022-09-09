package Tests.Basic;

import Pages.Basic.IFramePage;
import Tests.Base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class IFrameTest extends BaseTest {

    IFramePage iFramePage = new IFramePage();

    @BeforeEach
    void goToPage() {
        driver.get(iFramePage.iFrameUrl);
    }

    @Test
    @DisplayName("IFrame test")
    public void iFrameTest() {
        switchToIFrame("iframe1");
        fillInForm1("Jan", "Kowalski");
        switchToDefault();
        switchToIFrame("iframe2");
        fillInForm2("login", "password", 3, iFramePage.radioBtn3);
        switchToDefault();
        driver.findElement(By.cssSelector(iFramePage.navBtnBasic)).click();
    }

    private void switchToIFrame(String iFrame) {
        driver.switchTo().frame(iFrame);
    }

    private void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    private void fillInForm1(String firstName, String lastName) {
        driver.findElement(By.cssSelector(iFramePage.firstNameInput)).sendKeys(firstName);
        driver.findElement(By.cssSelector(iFramePage.lastNameInput)).sendKeys(lastName);
    }

    private void fillInForm2(String login, String password, int index, String radioButton){
        driver.findElement(By.cssSelector(iFramePage.loginInput)).sendKeys(login);
        driver.findElement(By.cssSelector(iFramePage.passwordInput)).sendKeys(password);
        driver.findElement(By.cssSelector(iFramePage.continentsDropDown)).click();
        Select continents = new Select(driver.findElement(By.cssSelector(iFramePage.continentsDropDown)));
        continents.selectByIndex(index);
        driver.findElement(By.cssSelector(radioButton)).click();
    }
}
