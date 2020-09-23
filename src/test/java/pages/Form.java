package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Dictionary;
import java.util.Enumeration;


public class Form extends BasePage{
    public Form (WebDriver driver) {
        super(driver);
    }

     public HowToSharePage FillForm(Dictionary<String, String> values){
        Enumeration keys = values.keys();
        while (keys.hasMoreElements()) {
            driver.findElement(By.xpath("//*[@placeholder='" + keys.nextElement().toString() + "']")).sendKeys(values.get(values.keys().nextElement()));
        }
        return new HowToSharePage(driver);
    }

}
