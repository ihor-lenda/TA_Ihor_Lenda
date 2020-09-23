package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HowToSharePage extends BasePage {
    public HowToSharePage(WebDriver driver) {
        super(driver);
    }

    private By tellUsYourStoryField = By.xpath("//textarea [@placeholder='Tell us your story. ']");
    private By nameInput = By.xpath("//input [@placeholder='Name']");
    private By emailInput = By.xpath("//input [@placeholder='Email address']");
    private By contactNumberInput = By.xpath("//input [@placeholder='Contact number ']");
    private By locationInput = By.xpath("//input [@placeholder='Location ']");
    private By iAmOver16Checkbox = By.xpath("//p[contains(text(), 'I am over 16 years old')]/ancestor::label/input");
    private By termsAgreementCheckbox = By.xpath("//p[contains(text(), 'I accept the')]/ancestor::label/input");
    private By submitButton = By.xpath("//button[contains(text(), 'Submit')]");
    private By mustBeAcceptedMessage = By.xpath("//div[contains(text(), 'must be accepted')]");
    private By nameCantBeBlankMessage = By.xpath("//div[contains(text(), \"Name can't be blank\")]");
    private By storyCantBeBlankMessage = By.xpath("//div[@class='long-text-input-container']/div[contains(text(), \"can't be blank\")]");


    public HowToSharePage typeToTellUsYourStoryField(String text) {
        driver.findElement(tellUsYourStoryField).sendKeys(text);
        return this;
    }

    public HowToSharePage typeToNameInput(String text) {
        driver.findElement(nameInput).sendKeys(text);
        return this;
    }

    public void typeToEmailInput(String text) {
        driver.findElement(emailInput).sendKeys(text);
    }

    public void typeToContactNumberInput(String text) {
        driver.findElement(contactNumberInput).sendKeys(text);
    }

    public void typeToLocationInput(String text) {
        driver.findElement(locationInput).sendKeys(text);
    }

    public HowToSharePage checkIAmOver16Checkbox() {
        driver.findElement(iAmOver16Checkbox).click();
        return this;
    }

    public HowToSharePage checkTermsAgreementCheckbox() {
        driver.findElement(termsAgreementCheckbox).click();
        return this;
    }

    public HowToSharePage clickSubmitButton() {
        driver.findElement(submitButton).click();
        return this;
    }

    public boolean isCheckboxErrorMessageDisplayed() {
        return driver.findElement(mustBeAcceptedMessage).isDisplayed();
    }

    public boolean isNameCantBeBlankMessageDisplayed() {
        return driver.findElement(nameCantBeBlankMessage).isDisplayed();
    }

    public boolean isStoryCantBeBlankMessageDisplayed() {
        return driver.findElement(storyCantBeBlankMessage).isDisplayed();
    }

    public Form gotoForm(){
        return new Form(driver);
    }

}
