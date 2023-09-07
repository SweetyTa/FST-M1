package Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        driver.get("https://alchemy.hguy.co/jobs");
        String title = driver.getTitle();
        System.out.printf(title);
        if(title.equalsIgnoreCase(title)){
            System.out.printf("title matched");
        }
        else{
            System.out.printf("title not matched");
        }

        driver.close();
    }
}
