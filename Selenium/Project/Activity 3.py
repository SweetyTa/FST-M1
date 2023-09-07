from requests import post
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/jobs/")
    img= driver.find_element(By.CSS_SELECTOR, "#post-16 > header > div > img")
    src= img.get_attribute("src")
    print("Url of the image is: ", src )
    driver.close()
