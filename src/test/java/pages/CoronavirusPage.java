package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoronavirusPage extends BasePage {
    public CoronavirusPage(WebDriver driver) {
        super(driver);
    }

    private By yourCoronavirusStoriesTab = By.xpath("//ul[@class='gs-o-list-ui--top-no-border nw-c-nav__secondary-sections']//a[@href='/news/have_your_say']");

    public void clickYourCoronavirusStoriesTab() {
        driver.findElement(yourCoronavirusStoriesTab).click();
    }


}
