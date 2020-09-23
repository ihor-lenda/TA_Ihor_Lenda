package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage waitForElementVisibility(long timeout, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    public BasePage implicitlyWait(long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);//неявное ожидание 30 сек
        return this;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
