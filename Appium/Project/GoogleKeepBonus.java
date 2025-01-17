package Projects;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class GoogleKeepBonus {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Test
    public void createNewNote(){
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("edit_note_text")));
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("testing appium");
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("sweety");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Reminder")));
        driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Later today']")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Later today']")).click();
        driver.findElement(AppiumBy.accessibilityId("Navigate up"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Today, 6:00 pm']")).click();
        //driver.findElement(AppiumBy.id("browse_note_interior_content")).click();
        //driver.findElement(AppiumBy.accessibilityId("Time reminder Today, 6:00 pm")).click();
        String reminder = driver.findElement(AppiumBy.accessibilityId("Time reminder Today, 6:00 pm")).getText();
        Assert.assertEquals(reminder, "Today, 6:00 pm");
    }
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}