package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsPage extends BasePage {
    public NewsPage(WebDriver driver) {
        super(driver);
    }

    private By coronavirusTab = By.xpath("//ul[@class='gs-o-list-ui--top-no-border nw-c-nav__wide-sections']/li/a[@href='/news/coronavirus']");


    public void clickCoronavirusTab() {
        driver.findElement(coronavirusTab).click();
    }
}
