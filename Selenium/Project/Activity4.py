# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManager
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://alchemy.hguy.co/jobs/")
    # Find the Second heading on the page using xpath and find the text
    heading = driver.find_element(By.XPATH, "//h2[text()='Quia quis non']").text
    wait = WebDriverWait(driver, 10)
    assert (heading == 'Quia quis non')
    print("Second heading matches", heading)
    driver.close()
