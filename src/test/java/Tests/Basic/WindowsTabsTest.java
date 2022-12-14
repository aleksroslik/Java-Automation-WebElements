package Tests.Basic;

import Pages.Basic.TablePage;
import Pages.Basic.WindowsTabsPage;
import Tests.Base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class WindowsTabsTest extends BaseTest {

    WindowsTabsPage windowsTabsPage = new WindowsTabsPage();

    @Test
    @DisplayName("Switching between new windows and tabs")
    public void switchTest() {
        TablePage tablePage = new TablePage(driver);
        driver.get(windowsTabsPage.tabsPageUrl);
        windowsTabsPage.mainWindowHandle = driver.getWindowHandle();
        btnClick(windowsTabsPage.newBrowserWindow);
        switchWindows();
        tablePage.getData("Switzerland", 4000);
        switchWindowsBack();
        btnClick(windowsTabsPage.newMsgWindow);
        switchWindows();
        String text = driver.findElement(By.cssSelector(windowsTabsPage.newMsgBody)).getText();
        System.out.println("\n" + text + "\n");
        switchWindowsBack();
        btnClick(windowsTabsPage.newBrowserTab);
        switchTabs();
        tablePage.getData("Switzerland", 4000);
        switchBackTabs();
    }

    private void btnClick(String button) {
        driver.findElement(By.cssSelector(button)).click();
    }

    private void switchWindows() {
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    private void switchTabs() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    private void switchBackTabs() {
        driver.close();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    private void switchWindowsBack() {
        driver.close();
        driver.switchTo().window(windowsTabsPage.mainWindowHandle);
    }
}
