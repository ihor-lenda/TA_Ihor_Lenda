package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsPage extends BasePage {
    private final By exitSignInPopupButton = By.xpath("//button[@class='sign_in-exit']");
    private final By signInPopup = By.xpath("//div[@class='sign_in-container']");
    private By coronavirusTab = By.xpath("//ul[@class='gs-o-list-ui--top-no-border nw-c-nav__wide-sections']/li/a[@href='/news/coronavirus']");
    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public NewsPage closeSignInPopup() {
        driver.findElement(exitSignInPopupButton).click();
        return this;
    }

    public CoronavirusPage clickCoronavirusTab() {
        driver.findElement(coronavirusTab).click();
        return new CoronavirusPage(driver);
    }
}
