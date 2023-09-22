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
import java.util.List;

public class GoogleTask {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test(priority = 0)
    public void addTask1() {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.xpath(
                        "//android.widget.EditText[@text='New task']"))
                .sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


   @Test(priority = 1)
    public void addTask2() {
                driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
       wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("add_task_title")));

       driver.findElement(AppiumBy.id(
                        "add_task_title"))
                .sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Test(priority = 2)
    public void addTask3() {

        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("add_task_title")));

        driver.findElement(AppiumBy.xpath(
                        "//android.widget.EditText[@text='New task']"))
                .sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("All tasks are created");


    }
    @Test(priority = 3)
        public void getNumberOfTask() {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("task_name")));

        List<WebElement> size= driver.findElements(AppiumBy.id("task_name"));
                    int no_of_tasks = size.size();
            Assert.assertEquals(no_of_tasks, 3);
    }

    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }

}