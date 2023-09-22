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
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ToDoListPage {
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page in Chrome
        driver.get("https://v1.training-support.net/selenium");

    }

    // Test method
    @Test
    public void scrollIntoTodo() {
        // Find heading on the page
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));

        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        //wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")));
        // Locate element
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }
    @Test
        public void addTasks() {
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("taskInput")));
        driver.findElement(AppiumBy.id("taskInput")).sendKeys("task1");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));
        driver.findElement(AppiumBy.id("taskInput")).sendKeys("task2");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));
        System.out.println("Tasks are added");

    }
    @Test
            public void getNumberOfTask() {
        WebElement result= (WebElement) driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[contains(@resource-id,'formula')]"));
        Assert.assertEquals(result.getText(), "2");

    }
    @Test
            public void clearList() {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List]"));
        System.out.println("List is cleared");
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
