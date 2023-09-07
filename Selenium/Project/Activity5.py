# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://alchemy.hguy.co/jobs/")
# Find the "Jobs" button on the page using xpath and click it
    driver.find_element(By.LINK_TEXT, "Jobs").click()
# Print the title of the new page
    pageTitle = driver.title
    print("The page title is: ", pageTitle)
    wait = WebDriverWait(driver, 10)
    assert (pageTitle == 'Jobs – Alchemy Jobs')
    message = driver.find_element(By.XPATH, "//h1[@class='entry-title']").text
    print(message)
    assert(message == 'Jobs')



