package groupProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		 // Setup the Firefox driver(GeckoDriver)
	    WebDriverManager.firefoxdriver().setup();

	    // Create a new instance of the Firefox driver
	    WebDriver driver = new FirefoxDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    // Open the browser
	    driver.get("https://alchemy.hguy.co/jobs/");
	    
	    driver.manage().window().maximize();
	   
	    //wait for the jobs link object
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Jobs")));
	    
	    //locate jobs link and click
	    WebElement jobs_link = driver.findElement(By.linkText("Jobs"));
	    jobs_link.click();
	    
	    //wait for job search box
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_keywords")));
	   
	    //Assert the Jobs page title
	    WebElement jobspage_title = driver.findElement(By.className("entry-title"));
	    Assert.assertEquals(jobspage_title.getText().toString(), "Jobs");
	    
	    
	    //Locate job search box and enter keys
	    WebElement search_box = driver.findElement(By.id("search_keywords"));
	    search_box.sendKeys("Banking");
	    
	    //click on search button
	    driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
	    
	    //wait for the search results and click on the first job result
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("post-7383")));
	    driver.findElement(By.className("post-7383")).click();
	    
	    //wait for the job details page and assert the page title
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("entry-title")));
	    String job_title = driver.findElement(By.className("entry-title")).getText();
	    Assert.assertEquals(job_title, "Banking");
	    
	    
	    //click on apply job button
	    driver.findElement(By.className("application_button")).click();
	    
	    //wait for the email id and click on it 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("job_application_email")));
	    String email_id = driver.findElement(By.className("job_application_email")).getText();
	   
	    driver.findElement(By.className("job_application_email")).click();
	    
	    System.out.println("Applied job by sending to "+ email_id);
	    
	    driver.close();
	    
	    

	   

}
}
