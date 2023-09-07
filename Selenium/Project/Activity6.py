from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions
from pandas._testing.asserters import assert_equal


# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Initialize the wait object
    wait = WebDriverWait(driver, 10)  
    # Navigate to the URL
    driver.get("https://alchemy.hguy.co/jobs/")
    # Print the title of the page
    print("Page title is: ", driver.title)
    
    #maximize window
    driver.maximize_window();
    
    #wait for the jobs link and click on it
    wait.until(expected_conditions.visibility_of(driver.find_element(By.PARTIAL_LINK_TEXT,"Jobs")))
    driver.find_element(By.XPATH,"//a[@href='https://alchemy.hguy.co/jobs/jobs/']").click();
    
    #wait for the page to load
    wait.until(expected_conditions.visibility_of_element_located((By.CLASS_NAME,"entry-title")))
    
    #search for banking in the field and click on search
    driver.find_element(By.ID,"search_keywords").send_keys("Banking")
    
    driver.find_element(By.XPATH, "//input[@value='Search Jobs']").click();
    
    driver.implicitly_wait(1000)
    
    #wait for search results
    wait.until(expected_conditions.visibility_of_element_located((By.XPATH,"//li[contains(@class, 'post-7383')]")))
    
    #select the first job listed
    driver.find_element(By.XPATH,"//li[contains(@class, 'post-7383')]").click()
    
    #wait for the page to load
    wait.until(expected_conditions.visibility_of(driver.find_element(By.CLASS_NAME, "entry-title")))
    
    #get the page title
    jobpage_title= driver.find_element(By.CLASS_NAME,"entry-title").text
    
    #asert the page title
    assert (jobpage_title == 'Banking')
    print("Navigated to job titled "+jobpage_title)
    
    #click on apply button
    driver.find_element(By.CLASS_NAME,"application_button").click()
    
    #wait for the email link and get the email ID
    wait.until(expected_conditions.visibility_of(driver.find_element(By.CLASS_NAME, "job_application_email")))
    print("The job is applied to email ID "+driver.find_element(By.CLASS_NAME,"job_application_email").text)
    
    #click on email id to apply
    driver.find_element(By.CLASS_NAME,"job_application_email").click()
    
    driver.quit()
    
    
    
    
    
    
    
    
    
    
    
            