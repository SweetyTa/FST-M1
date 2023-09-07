from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions
from pandas._testing.asserters import assert_equal

job_created = "Testing job"
# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Initialize the wait object
    wait = WebDriverWait(driver, 10)  
    # Navigate to the URL
    driver.get("https://alchemy.hguy.co/jobs/wp-admin")
    # Print the title of the page
    print("Page title is: ", driver.title)
    
    wait.until(expected_conditions.visibility_of_element_located((By.ID, "user_login")))
    
    driver.find_element(By.ID, "user_login").send_keys("root")
    driver.find_element(By.ID,"user_pass").send_keys("pa$$w0rd")
    
    driver.find_element(By.ID, "wp-submit").click()
    
    wait.until(expected_conditions.visibility_of_element_located((By.XPATH,"//*[@id='menu-posts-job_listing']/a/div[3]")))
    
    driver.find_element(By.XPATH, "//*[@id='menu-posts-job_listing']/a/div[3]").click()
    
    wait.until(expected_conditions.visibility_of_element_located((By.CLASS_NAME,"wp-heading-inline")))
    jobslist_page = driver.find_element(By.CLASS_NAME, "wp-heading-inline").text
    
    assert( jobslist_page == "Jobs")
    
    driver.find_element(By.CLASS_NAME,"page-title-action").click()
    
    
    wait.until(expected_conditions.visibility_of_element_located((By.XPATH, "//textarea[@id='post-title-0']")))
    driver.find_element(By.XPATH,"//textarea[@id='post-title-0']").send_keys(job_created)
    
    driver.find_element(By.ID,"_job_location").send_keys("Mysore")
    
    driver.find_element(By.ID,"_company_name").send_keys("IBM")
    
    driver.find_element(By.ID, "_company_tagline").send_keys("Indian Company")
    driver.implicitly_wait(10)
    
    driver.find_element(By.XPATH,"//button[contains(@class,'publish-button__button is-primary')]").click()
    
    wait.until(expected_conditions.visibility_of_element_located((By.XPATH,"//*[@id='editor']/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")))
    driver.find_element(By.XPATH,"//*[@id='editor']/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button").click()
    
    wait.until(expected_conditions.visibility_of_element_located((By.XPATH,"//*[@id='editor']/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")))
    driver.find_element(By.XPATH,"//*[@id='editor']/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a").click()
    
    wait.until(expected_conditions.visibility_of_element_located((By.CLASS_NAME, "entry-title")))
    
    jobcreated_title = driver.find_element(By.CLASS_NAME, "entry-title").text
    
    assert(jobcreated_title == job_created)
    
    driver.quit()
    
   
         
               