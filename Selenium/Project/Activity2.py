from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/jobs/")
    Actual_Heading = driver.find_element(By.XPATH, "//h1[text() = 'Welcome to Alchemy Jobs']").text
    Expected_Heading = "Welcome to Alchemy Jobs"
    print("Heading of the Page is :", Actual_Heading)
    if Actual_Heading == Expected_Heading:
        print("Heading is Matching hence closing the browser")
        driver.close()
    else:
        print("Heading is not Matching")
