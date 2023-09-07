import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Activity7 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/jobs/");
        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='site-title']/a")).getText(),
                "Alchemy Jobs", "Failed to navigate to Alchemy Jobs portal");

        //Navigate to Post a Job
        driver.findElement(By.xpath("//li/a[text()='Post a Job']")).click();

        //Sign in
        driver.findElement(By.xpath("//div[contains(@class,'sign-in')]/a")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).isDisplayed(),
                "Sign in is not successful");

        //Filling the form
        String jobTitle = "Test Specialist";
        driver.findElement(By.id("job_title")).sendKeys(jobTitle);
        driver.findElement(By.id("job_location")).sendKeys("Hyderabad");
        Select options = new Select(driver.findElement(By.id("job_type")));
        options.selectByVisibleText("Full Time");
        //driver.switchTo().frame(driver.findElement(By.id("job_description_ifr")));
       // Assert.assertTrue(driver.findElement(By.xpath("//html/body[contains(@class,'job_description')]")).isDisplayed());
        WebElement iframeid = driver.findElement(By.xpath("//iframe[@id='job_description_ifr']"));
        iframeid.sendKeys("Test");
        //driver.switchTo().defaultContent();
        driver.findElement(By.name("submit_job")).click();
      //  Assert.assertEquals(driver.findElement(By.xpath("//div[@class='job_listing_preview_title']/h2")).getText(), "Preview");

        //Submit Listing
        driver.findElement(By.id("job_preview_submit_button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='entry-content clear']")).getText().contains("Job listed successfully."));

        //Verify the job listing in Jobs page
        driver.findElement(By.xpath("//li/a[text()='Jobs']")).click();
        driver.findElement(By.id("search_keywords")).sendKeys(jobTitle);
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
        driver.quit();

    }

}
