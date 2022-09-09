package Tests.Basic;

import Pages.Basic.TablePage;
import Tests.Base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TableTest extends BaseTest {

    @Test
    @DisplayName("Table test")
    public void tableTest() {
        TablePage tablePage = new TablePage(driver);
        driver.get(tablePage.tablePageUrl);
        tablePage.getData("Switzerland", 4000);
    }
}
