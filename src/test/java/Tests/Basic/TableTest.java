package Tests.Basic;

import Pages.Basic.TablePage;
import Tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableTest extends BaseTest {

    TablePage tablePage = new TablePage();

    @Test
    @DisplayName("Print Rank, Peak, Mountain Range for mountains higher than 4000 m")
    public void tableTest(){
        driver.get(tablePage.tablePageUrl);
        searchForData();
    }

    public void searchForData() {
        tablePage.rows = driver.findElements(By.cssSelector(tablePage.tableRows));
        for (WebElement row : tablePage.rows) {
            int rank = Integer.parseInt(row.findElement(By.cssSelector(tablePage.rank)).getText());
            String peak = row.findElements(By.cssSelector(tablePage.values)).get(0).getText();
            String mountainRange = row.findElements(By.cssSelector(tablePage.values)).get(1).getText();
            int height = Integer.parseInt(row.findElement(By.xpath(tablePage.height)).getText());
            if (height > 4000)
                System.out.println(rank + " " + peak + ", mountain range: " + mountainRange + ", height: " + height);
        }
    }
}
