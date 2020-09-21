package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.assertEquals;

public class Task1 {



    @Test
    public void checkSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // Creates a new Chrome instance
        driver.get("https://www.bbc.com"); // Navigates to a page by address
        driver.close();
    }
    @Test (priority = 1)
    public void checkHeadlineArticleTitle() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // Creates a new Chrome instance
        driver.get("https://www.bbc.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//button[@class='sign_in-exit']")).click(); //closing the registration pop-up. Not necessary
        driver.findElement(By.xpath("//div[@class='orb-nav-section orb-nav-links orb-nav-focus']/ul/li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String headlineArticleTitle = driver.findElement(By.xpath("//div[@class='gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m']//h3[@class='gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text']")).getText();
        assertEquals(headlineArticleTitle, "Protesters defy heavy security in Belarus"); //actual value changes everyday, so test fails
    }
    @Test (priority = 2)
    public void checkSecondaryArticlesTitles() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // Creates a new Chrome instance
        driver.get("https://www.bbc.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='orb-nav-section orb-nav-links orb-nav-focus']/ul/li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> secondaryArticlesTitles = driver.findElements(By.xpath("//div[@class='gs-c-promo nw-c-promo gs-o-faux-block-link gs-u-pb gs-u-pb+@m nw-p-default gs-c-promo--inline gs-c-promo--stacked@m nw-u-w-auto gs-c-promo--flex']"));
        List<String> secondaryArticlesTitlesStrings = new ArrayList<>();
        for (int i =0; i < secondaryArticlesTitles.size(); i++)
        {
            secondaryArticlesTitlesStrings.add(i, secondaryArticlesTitles.get(i).getText());
        }
        List<String> expectedTitles = new ArrayList<>();
        expectedTitles.add("One dead, seven injured in UK stabbings");
        expectedTitles.add("Policeman killed in 'terrorist' attack in Tunisia");
        expectedTitles.add("French police launch manhunt for horse mutilators");
        expectedTitles.add("Mystery seeds prompt Amazon US policy change");
        expectedTitles.add("Man in box of ice breaks world record");
        assertEquals(secondaryArticlesTitlesStrings, expectedTitles); //actual value changes everyday, so test fails

    }
    @Test (priority = 3)
    public void searchHeadlineArticleCategory() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='orb-nav-section orb-nav-links orb-nav-focus']/ul/li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String headlineArticleCategory = driver.findElement(By.xpath("//*[@id='u8090827401965512']/div/div/div/div[1]/div/div/div[1]/ul/li[2]/a/span")).getText();
        driver.findElement(By.xpath("//*[@id='orb-search-q']")).sendKeys(headlineArticleCategory, ENTER);
        String headlineArticleTitle = driver.findElement(By.xpath("//*[@id='main-content']/div[3]/div/div/ul/li[2]/div/div[1]/div[1]/p[1]/a/span")).getText();
        assertEquals(headlineArticleTitle, "Cities of Europe"); //actual value changes everyday, so test fails

    }
    //BRANCH_TEST
}




