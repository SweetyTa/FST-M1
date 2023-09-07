package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class ProjectActivity4 {

    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Open the page
        driver.get("https://alchemy.hguy.co/jobs/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String secondHeading = driver.findElement(By.xpath("//h2[text()='Quia quis non']")).getText();
        Assert.assertEquals(secondHeading, "Quia quis non");
        System.out.println("The second heading matches: " + secondHeading);
        driver.close();
    }
}