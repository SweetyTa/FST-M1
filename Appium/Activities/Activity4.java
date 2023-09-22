package activities;
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

public class Activity4 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.samsung.android.dialer");
        options.setAppActivity(".DialtactsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Test method
    @Test
    public void contactsTest() {
        // Find and click the add button
        driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();

        // Wait for elements to load
         wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text='Name']")));

        // Enter the details
       driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Name']")).sendKeys("Aaditya");


        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.samsung.android.app.contacts:id/titleText']")));

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.samsung.android.app.contacts:id/titleText']")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("9991438292");
        // Click Save

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Save']")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // Wait for contact to save
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Aaditya']")));

        // Assertion
        String contactName = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Aaditya']")).getText();
        Assert.assertEquals(contactName, "Aaditya");
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
