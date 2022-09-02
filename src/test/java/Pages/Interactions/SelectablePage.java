package Pages.Interactions;

import org.openqa.selenium.WebDriver;

public class SelectablePage {
    
    public String selectablePageUrl = "https://seleniumui.moderntester.pl/selectable.php";
    public String feedbackMsg = "#feedback";
    public String options = "#selectable";
    public String option1 = "#selectable li:nth-child(1)";
    public String option3 = "#selectable li:nth-child(3)";
    public String option4 = "#selectable li:nth-child(4)";
    public String expectedText = "You've selected: #1 #3 #4.";
}
