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

    public FormPage sendKeysName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    public FormPage sendKeysSurname(String surname) {
        lastName.sendKeys(surname);
        return this;
    }

    public FormPage sendKeysEmail(String emailAddress) {
        emailInput.sendKeys(emailAddress);
        return this;
    }

    public FormPage addAge(String age) {
        ageInput.sendKeys(age);
        return this;
    }

    public FormPage randomExperience() {
        getRandomElement(yearsOfExperience).click();
        return this;
    }

    public FormPage getRandomProfession() {
        getRandomElement(professions).click();
        return this;
    }

    public FormPage getRandomGender() {
        getRandomElement(gender).click();
        return this;
    }

    private WebElement getRandomElement(List<WebElement> elements) {
        Random years = new Random();
        int noOfElements = elements.size();
        int randomPick = years.nextInt(noOfElements);
        return elements.get(randomPick);
    }

    public FormPage selectOptionContinents(String value) {
        new Select(dropDownList).selectByVisibleText(value);
        return this;
    }

    public FormPage selectCommand(String value) {
        new Select(commandsSelection).selectByVisibleText(value);
        return this;
    }

    public FormPage uploadFile(String filePath) {
        fileToUpload.sendKeys(filePath);
        return this;
    }

    public FormPage additionalInfoInput (String info) {
        additionalInfo.sendKeys(info);
        return this;
    }

    public FormPage clickDownloadBtn() {
        testFileToDownloadBtn.click();
        return this;
    }

    public void clickSubmitBtn() {
        signInBtn.click();
    }

    public String getSuccessText () {
        return successMsgLabel.getText();
    }
}
