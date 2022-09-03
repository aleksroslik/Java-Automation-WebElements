package Pages;

import org.openqa.selenium.WebElement;

import java.util.List;

public class TablePage {

    public String tablePageUrl = "https://seleniumui.moderntester.pl/";

    public String tableRows = "tbody tr";
    public List<WebElement> rows;
    public String height = "td[4]";
    public String values = "td";
    public String rank = "th";
}
