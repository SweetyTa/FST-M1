from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from urllib3.util import wait
from webdriver_manager.firefox import GeckoDriverManager
service= FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get('https://v1.training-support.net/selenium/ajax')
    print("Tile is: ", driver.title)
    driver.find_element(By.CSS_SELECTOR,"button.violet").click()
    wait.until(expected_conditions.text)
    driver.find_element()

    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h1"), "HELLO!"))
    hello_text = driver.find_element(By.TAG_NAME, "h1").text
    driver.implicitly_wait(50)
    print(hello_text)

    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h3"), "I'm late!"))
    late_text = driver.find_element(By.TAG_NAME, "h3").text
    print(late_text)