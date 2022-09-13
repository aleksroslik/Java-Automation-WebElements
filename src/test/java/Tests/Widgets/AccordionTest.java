package Tests.Widgets;

import Pages.Widgets.AccordionPage;
import Tests.Base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AccordionTest extends BaseTest {

    AccordionPage accordionPage = new AccordionPage();

    @Test
    @DisplayName("Accordion test")
    public void accordionTest() {
        driver.get(accordionPage.accordionPageUrl);
        openSectionAndGetText(accordionPage.section1, accordionPage.section1Body);
        openSectionAndGetText(accordionPage.section2, accordionPage.section2Body);
        openSectionAndGetText(accordionPage.section3, accordionPage.section3Body);
        openSectionAndGetText(accordionPage.section4, accordionPage.section4Body);
    }

    private void openSectionAndGetText(String section, String text) {
        driver.findElement(By.cssSelector(section)).click();
        String expectedText = driver.findElement(By.cssSelector(text)).getAttribute("textContent");
        System.out.println(expectedText);
    }
}
