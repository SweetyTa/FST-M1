from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    wait =WebDriverWait(driver,20)
    driver.get("https://alchemy.hguy.co/jobs/")

    driver.find_element(By.XPATH,"//li[@id ='menu-item-26']/a[1]").click()
    wait.until(expected_conditions.element_to_be_clickable((By.CSS_SELECTOR,"a.button")))
    driver.find_element(By.CSS_SELECTOR,"a.button").click()
    wait.until(expected_conditions.visibility_of_element_located((By.ID,"user_login")))
    driver.find_element(By.ID,"user_login").send_keys("root")
    driver.find_element(By.ID,"user_pass").send_keys("pa$$w0rd")
    driver.find_element(By.ID,"wp-submit").click()
    driver.find_element(By.ID,"job_title").send_keys("Software tester-Virtual1")
    driver.find_element(By.ID,"job_description_ifr").send_keys("Software")
    driver.find_element(By.ID,"company_name").send_keys("IBM")
    driver.find_element(By.XPATH,"//input[@value = 'Preview']").click()
    driver.find_element(By.ID,"job_preview_submit_button").click()
    driver.find_element(By.XPATH,"//li[@id ='menu-item-24']/a[1]").click()
    driver.find_element(By.ID,"search_keywords").send_keys("virtual")
    driver.find_element(By.XPATH,"//input[@value = 'Search Jobs']").click()
    wait.until(expected_conditions.visibility_of_element_located((By.XPATH,"//h3[contains(text(),'Software tester-Virtual')]")))
    Actual = driver.find_element(By.XPATH,"//h3[contains(text(),'Software tester-Virtual')]").text
    Expected = "Virtual"
    if Actual.__contains__(Expected):
       print("Job Post Created Successfully")
       driver.quit()
