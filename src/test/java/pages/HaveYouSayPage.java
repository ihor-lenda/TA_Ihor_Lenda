package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HaveYouSayPage extends BasePage {
    public HaveYouSayPage(WebDriver driver) {
        super(driver);
    }

    private By howToShareWithBBC = By.xpath("//a[@href='/news/10725415']");

    public HowToSharePage clickHowToShareWithBBC() {
        driver.findElement(howToShareWithBBC).click();
        return new HowToSharePage(driver);
    }
}
