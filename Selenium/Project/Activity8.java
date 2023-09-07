package Jobboard_project;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Activity8 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions builder = new Actions(driver);

        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

        WebElement username=driver.findElement(By.id("user_login"));
        WebElement password=driver.findElement(By.id("user_pass"));
        username.sendKeys("root");
        password.sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();

        String homepage_dashboard = driver.findElement(By.xpath("//div[@class='wp-menu-name']")).getText();
        System.out.println("Homepage dashboard: " + homepage_dashboard);

        System.out.println("Login is successful");
        driver.close();

    }
}
