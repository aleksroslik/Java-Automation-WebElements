package Tests.Widgets;

import Pages.Widgets.AccordionPage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AccordionTest extends BaseTest {

    AccordionPage accordionPage = new AccordionPage();

    @Test
    @DisplayName("Accordion test")
    public void accordionTest() throws InterruptedException {
        driver.get(accordionPage.accordionPageUrl);
        openSectionAndGetText(accordionPage.section1, accordionPage.section1Body);
        openSectionAndGetText(accordionPage.section2, accordionPage.section2Body);
        openSectionWithMultipleElementsAndGetText
                (accordionPage.section3,accordionPage.section3Par,accordionPage.section3List);
        openSectionWithMultipleElementsAndGetText
                (accordionPage.section4, accordionPage.section4Par1, accordionPage.section4Par2);
    }

    public void openSectionAndGetText(String section, String text) {
        driver.findElement(By.cssSelector(section)).click();
        String expectedText = driver.findElement(By.cssSelector(text)).getText();
        System.out.println(expectedText + "\n");
    }

    public void openSectionWithMultipleElementsAndGetText(String section, String element1, String element2)
            throws InterruptedException{
        driver.findElement(By.cssSelector(section)).click();
        String item1 = driver.findElement(By.xpath(element1)).getText();
        Thread.sleep(1000);
        String item2 = driver.findElement(By.xpath(element2)).getText();
        System.out.println(item1 + "\n" + item2 + "\n");
    }
}
