import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Activity2 {
    WebDriver driver;
    @BeforeTest
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @Test
    public void PageHeading(){
        String Actual_Heading = driver.findElement(By.xpath("//h1[text() = 'Welcome to Alchemy Jobs']")).getText();
        String Expected_Heading  = "Welcome to Alchemy Jobs";
        assertEquals(Actual_Heading,Expected_Heading);
        System.out.println("Heading of the Page is :" + Actual_Heading);
    }

    @AfterTest
    public void tear_down(){
        String Expected_Heading  = "Welcome to Alchemy Jobs";
        String Actual_Heading = driver.findElement(By.xpath("//h1[text() = 'Welcome to Alchemy Jobs']")).getText();
        if (Actual_Heading.equals(Expected_Heading)) {
            System.out.println("Heading is Matching hence closing the browser");
            driver.close();
        } else {
            System.out.println("Heading is not Matching");
        }
    }
}