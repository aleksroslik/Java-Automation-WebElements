package Pages.Widgets;

import org.openqa.selenium.WebElement;

import java.util.List;

public class ModalDialogPage {

    public String modalPageUrl = "https://seleniumui.moderntester.pl/modal-dialog.php";

    public String createBtn = "#create-user";
    public String modal = ".ui-dialog.ui-corner-all";

    public String nameInput = "#name";
    public String emailInput = "#email";
    public String passwordInput = "#password";
    public String confirmButton = "button:nth-child(1)";
    public List<WebElement> rows;
    public String tableRows = "tbody tr";
}
