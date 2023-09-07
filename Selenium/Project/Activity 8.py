from requests import post
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.remote.webelement import WebElement
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/jobs/wp-admin")
    username = driver.find_element(By.ID, "user_login")
    password = driver.find_element(By.ID, "user_pass")
    username.send_keys('root')
    password.send_keys('pa$$w0rd')
    driver.find_element(By.ID, 'wp-submit').click()

    homepage_dashboard = driver.find_element(By.XPATH, "//div[@class='wp-menu-name']")
    print("Homepage dashboard: ", homepage_dashboard.text)

    print("Login is successful")
    driver.close()
