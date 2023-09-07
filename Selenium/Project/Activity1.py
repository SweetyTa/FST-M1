from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver.firefox import GeckoDriverManager
​
service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/jobs/")
    title = driver.getTitle();
    print(title)
    if title == "Alchemy Jobs – Job Board Application":
        print("title matched")
        driver.close()
    else:
        print("title  not matched")