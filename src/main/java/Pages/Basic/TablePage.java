package Pages.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TablePage {

    public TablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String tablePageUrl = "https://seleniumui.moderntester.pl/";

    @FindBy(css = "tbody tr")
    private List<WebElement> allPeaks;

    public List<RowPage> getAllPeaks() {
        List<RowPage> allPeaksPo = new ArrayList<>();
        for (WebElement peak : allPeaks) {
            allPeaksPo.add(new RowPage(peak));
        }
        return allPeaksPo;
    }

    public void getData(String country, int height) {
        for (RowPage peakData : getAllPeaks()) {
            if (peakData.getState().contains(country) && peakData.getHeight() > height) {
                System.out.println(peakData.getRank() + ", " + peakData.getName() + ", " + peakData.getMountainRange());
            }
        }
    }
}
