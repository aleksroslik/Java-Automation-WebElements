package Pages.Widgets;

import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectMenuPage {

    public String selectMenuPageUrl = "https://seleniumui.moderntester.pl/selectmenu.php";

    public String speedBtn = "#speed-button";
    public String fileBtn = "#files-button";
    public String numberBtn = "#number-button";
    public String titleBtn = "#salutation-button";

    public String filesMenuItems = "ul#files-menu li";
    public String numberMenu = "#number-menu";
    public String speedMenu = "#speed-menu";
    public String titleMenu = "#salutation-menu";

    public List<WebElement> speed;
    public List<WebElement> files;
    public List<WebElement> titles;
}
