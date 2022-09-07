package Tests.Widgets;

import Pages.Widgets.SelectMenuPage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class SelectMenuTest extends BaseTest {

    SelectMenuPage selectMenuPage = new SelectMenuPage();

    @Test
    @DisplayName("Select menu test")
    public void selectMenuTest() {
        driver.get(selectMenuPage.selectMenuPageUrl);
        btnClick(selectMenuPage.speedBtn);
        getRandomSpeed();
        btnClick(selectMenuPage.fileBtn);
        selectItemByText(selectMenuPage.filesMenuItems, "Some unknown file");
        btnClick(selectMenuPage.numberBtn);
        selectOptionByIndex(selectMenuPage.numberMenu, 7);
        btnClick(selectMenuPage.titleBtn);
        getRandomTitle();
    }

    public void btnClick(String btn) {
        driver.findElement(By.cssSelector(btn)).click();
    }

    public void getRandomSpeed() {
        selectMenuPage.speed = driver.findElements(By.cssSelector(selectMenuPage.speedMenu));
        getRandomElement(selectMenuPage.speed).click();
    }

    public void getRandomTitle() {
        selectMenuPage.titles = driver.findElements(By.cssSelector(selectMenuPage.titleMenu));
        getRandomElement(selectMenuPage.titles).click();
    }

    public WebElement getRandomElement(List<WebElement> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public void selectOptionByIndex(String input, int xTimes) {
        WebElement numberList = driver.findElement(By.cssSelector(input));
        for (int i=0; i<xTimes; i++) {
            numberList.sendKeys(Keys.ARROW_DOWN);
        }
        numberList.sendKeys(Keys.ENTER);
    }

    public void selectItemByText(String itemsList, String text) {
        String textValue = null;
        selectMenuPage.files = driver.findElements(By.cssSelector(itemsList));
        for(int i=0; i<selectMenuPage.files.size(); i++) {
            WebElement myElement = selectMenuPage.files.get(i);
            textValue = myElement.getText();
            if(textValue.contentEquals(text)) {
                myElement.click();
                break;
            }
        }
        System.out.println("Selected value " + textValue);
    }
}
