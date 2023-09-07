package Jobboard_project;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity3 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions builder = new Actions(driver);

        driver.get("https://alchemy.hguy.co/jobs/");
        WebElement img= driver.findElement(By.cssSelector("#post-16 > header > div > img"));
        String src = img.getAttribute("src");
        System.out.println("Url of the image is: " + src);
        driver.quit();
    }
}
