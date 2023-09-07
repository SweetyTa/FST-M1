package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.Assert;

public class projectActivity9final {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Open the page
        driver.get("https://alchemy.hguy.co/jobs/wp-admin/");
        WebElement userName= driver.findElement(By.id("user_login"));
        userName.sendKeys("root");
        WebElement password = driver.findElement(By.id("user_pass"));
        password.sendKeys("pa$$w0rd");
        WebElement loginButton= driver.findElement(By.id("wp-submit"));
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement jobLink = driver.findElement(By.xpath("//div[@class='wp-menu-name']/ancestor::div/ul/li[7]"));
        jobLink.click();
        WebElement addNew=driver.findElement(By.xpath("//*[text()='Add New']/ancestor::div/ul/li[7]/ul/li[3]"));
        addNew.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement position=driver.findElement(By.xpath("//textarea[@id='post-title-0']"));
        position.sendKeys("TestLead");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement email = driver.findElement(By.name("_application"));
        email.sendKeys("\"abhiram@cklabs.com\"");
        WebElement companyName = driver.findElement(By.name("_company_name"));
        companyName.sendKeys("IBM");
        WebElement companyWebsite = driver.findElement(By.id("_company_website"));
        companyWebsite.sendKeys("https://www.ibm.com");
        WebElement companyTagLine = driver.findElement(By.id("_company_tagline"));
        companyTagLine.sendKeys("IT Company");
        WebElement companyTwitter = driver.findElement(By.id("_company_twitter"));
        companyTwitter.sendKeys("@IBM");
        WebElement companyVideo = driver.findElement(By.id("_company_video"));
        companyVideo.sendKeys("https://www.ibm/video");
        WebElement jobExpiresDate = driver.findElement(By.name("_job_expires-datepicker"));
        jobExpiresDate.click();
        WebElement jobExpiryDate = driver.findElement(By.xpath("//a[text()='15']/ancestor::tr/td[5]"));
        jobExpiryDate.click();
        WebElement publishButton = driver.findElement(By.xpath("//button[text()='Publish…']"));
        publishButton.click();
        WebElement publishButtonFinal = driver.findElement(By.xpath("//button[text()='Publish']"));
        publishButtonFinal.click();
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Add Job ‹ Alchemy Jobs — WordPress");
        driver.quit();
    }
}
