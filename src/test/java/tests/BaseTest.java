package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    private static final String HOME_PAGE_URL = "https://www.bbc.com/";

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public BasePage getBasePage() {
        return new BasePage(driver);
    }
    public MainPage getMainPage() {
        return new MainPage(driver);
    }
    public NewsPage getNewsPage() {
        return new NewsPage(driver);
    }
    public CoronavirusPage getCoronavirusPage() {
        return new CoronavirusPage(driver);
    }
    public HaveYouSayPage getHaveYouSayPage() {
        return new HaveYouSayPage(driver);
    }
    public HowToSharePage getHowToSharePage() {
        return new HowToSharePage(driver);
    }




}
