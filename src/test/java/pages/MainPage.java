package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By newsLinkInMenu = By.xpath("//div[@class='orb-nav-section orb-nav-links orb-nav-focus']/ul/li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']");


    public NewsPage clickNewsInMenu() {
        driver.findElement(newsLinkInMenu).click();
        return new NewsPage(driver);
    }





}
