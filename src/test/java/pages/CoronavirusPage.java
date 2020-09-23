package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoronavirusPage extends BasePage {
    private By yourCoronavirusStoriesTab = By.xpath("//ul[@class='gs-o-list-ui--top-no-border nw-c-nav__secondary-sections']//a[@href='/news/have_your_say']");

    public CoronavirusPage(WebDriver driver) {
        super(driver);
    }

    public HaveYouSayPage clickYourCoronavirusStoriesTab() {
        driver.findElement(yourCoronavirusStoriesTab).click();
        return new HaveYouSayPage((driver));
    }


}
