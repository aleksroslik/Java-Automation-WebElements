package Pages.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class FormPage {

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String formPageUrl = "https://seleniumui.moderntester.pl/form.php";

    @FindBy(id = "inputFirstName3")
    private WebElement firstName;

    @FindBy(id = "inputLastName3")
    private WebElement lastName;

    @FindBy(id = "inputEmail3")
    private WebElement emailInput;

    @FindBy(id = "inputAge3")
    private WebElement ageInput;

    @FindBy(id = "selectContinents")
    private WebElement dropDownList;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement commandsSelection;

    @FindBy(id = "chooseFile")
    private WebElement fileToUpload;

    @FindBy(id = "additionalInformations")
    private WebElement additionalInfo;

    @FindBy(className = "btn-secondary")
    private WebElement testFileToDownloadBtn;

    @FindBy(className = "btn-primary")
    private WebElement signInBtn;

    @FindBy(className = "success")
    private WebElement successMsgLabel;

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> gender;

    @FindBy(name="gridCheckboxProfession")
    private List<WebElement> professions;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearsOfExperience;

    public void sendKeysName(String name) {
        firstName.sendKeys(name);

    }

    public void sendKeysSurname(String surname) {
        lastName.sendKeys(surname);
    }

    public void sendKeysEmail(String emailAddress) {
        emailInput.sendKeys(emailAddress);
    }

    public void addAge(String age) {
        ageInput.sendKeys(age);
    }

    public void randomExperience() {
        getRandomElement(yearsOfExperience).click();
    }

    public void getRandomProfession() {
        getRandomElement(professions).click();
    }

    public void getRandomGender() {
        getRandomElement(gender).click();
    }

    private WebElement getRandomElement(List<WebElement> elements) {
        Random years = new Random();
        int noOfElements = elements.size();
        int randomPick = years.nextInt(noOfElements);
        return elements.get(randomPick);
    }

    public void selectOptionContinents(String value) {
        new Select(dropDownList).selectByVisibleText(value);
    }

    public void selectCommand(String value) {
        new Select(commandsSelection).selectByVisibleText(value);
    }

    public void uploadFile(String filePath) {
        fileToUpload.sendKeys(filePath);
    }

    public void additionalInfoInput (String info) {
        additionalInfo.sendKeys(info);
    }

    public void clickDownloadBtn() {
        testFileToDownloadBtn.click();
    }

    public void clickSubmitBtn() {
        signInBtn.click();
    }

    public String getSuccessText () {
        return successMsgLabel.getText();
    }
}
