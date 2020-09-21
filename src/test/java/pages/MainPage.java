package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }
    private By newsLinkInMenu = By.xpath("//div[@class='orb-nav-section orb-nav-links orb-nav-focus']/ul/li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']");
    private By signInPopup = By.xpath("//div[@class='sign_in-container']");
    private By exitSignInPopupButton = By.xpath("//button[@class='sign_in-exit']");

    public void clickNewsInMenu()
    {
        driver.findElement(newsLinkInMenu).click();
    }

    public void closeSignInPopup(){
        driver.findElement(exitSignInPopupButton).click();
    }
    public By signInPopupLocator() {
        return signInPopup;
    }

}
