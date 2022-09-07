package Pages.Interactions;

import org.openqa.selenium.WebElement;

import java.util.List;

public class SortablePage {

    public String sortablePageUrl = "https://seleniumui.moderntester.pl/sortable.php";

    public List<WebElement> sortItems;
    public String item = "//*[@id='sortable']/li";

    public String itemsList = "ul#sortable";
}
