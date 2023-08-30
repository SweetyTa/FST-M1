from selenium import webdriver
from selenium.webdriver import ActionChains, Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get(" https://v1.training-support.net/selenium/dynamic-controls")
    print("Page title is: ", driver.title)
    textbox=driver.find_element(By.ID, "dynamicText")
    print('Text box is disabled')
    textbox_toggle=driver.find_element(By.ID, "toggleInput")
    textbox_toggle.click()
    print('Textbox is enabled', textbox.is_enabled())
    textbox.send_keys("Testing selenium with Python")

