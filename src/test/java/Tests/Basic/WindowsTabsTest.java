package Tests.Basic;

import Pages.Basic.WindowsTabsPage;
import Tests.BaseTest;
import Tests.TableTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Set;

public class WindowsTabsTest extends BaseTest {

    WindowsTabsPage windowsTabsPage = new WindowsTabsPage();
    TableTest tableTest = new TableTest();

    @Test
    @DisplayName("Switching between new windows and tabs")
    public void switchTest(){
        driver.get(windowsTabsPage.tabsPageUrl);
        windowsTabsPage.mainWindowHandle = driver.getWindowHandle();
        btnClick(windowsTabsPage.newBrowserWindow);
        switchWindows();
        tableTest.searchForData();
        switchWindowsBack();
        btnClick(windowsTabsPage.newMsgWindow);
        switchWindows();
        String text = driver.findElement(By.cssSelector(windowsTabsPage.newMsgBody)).getText();
        System.out.println("\n" + text + "\n");
        switchWindowsBack();
        btnClick(windowsTabsPage.newBrowserTab);
        switchTabs();
        tableTest.searchForData();
        switchBackTabs();
    }

    public void btnClick(String button) {
        driver.findElement(By.cssSelector(button)).click();
    }

    public void switchWindows() {
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public void switchTabs() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void switchBackTabs() {
        driver.close();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void switchWindowsBack() {
        driver.close();
        driver.switchTo().window(windowsTabsPage.mainWindowHandle);
    }
}
