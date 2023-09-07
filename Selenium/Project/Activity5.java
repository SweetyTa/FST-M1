package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class ProjectJavaActivity5 {

        public static void main(String[] args) {
            // Set up Firefox driver
            WebDriverManager.firefoxdriver().setup();
            // Create a new instance of the Firefox driver
            WebDriver driver = new FirefoxDriver();
            // Open the page
            driver.get("https://alchemy.hguy.co/jobs/");
            driver.findElement(By.linkText("Jobs")).click();
            // Print the title of the page
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String title = driver.getTitle();
            System.out.println("Jobs page title: " + title);
            Assert.assertEquals(title, "Jobs – Alchemy Jobs");
           String message = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
            System.out.println("Login title: " + message);
            Assert.assertEquals(message, "Jobs");
            // Close the browser
            driver.close();
        }
    }


