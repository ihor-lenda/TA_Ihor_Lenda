package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HaveYouSayPage extends BasePage {
    private By howToShareWithBBC = By.xpath("//a[@href='/news/10725415']");

    public HaveYouSayPage(WebDriver driver) {
        super(driver);
    }

    public HowToSharePage clickHowToShareWithBBC() {
        driver.findElement(howToShareWithBBC).click();
        return new HowToSharePage(driver);
    }
}
