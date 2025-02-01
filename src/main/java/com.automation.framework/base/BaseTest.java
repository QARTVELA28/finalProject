package com.automation.framework.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.automation.framework.utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // Bypass Chrome security
        options.addArguments("--disable-extensions"); // Disable Chrome extensions
        options.addArguments("--disable-gpu"); // Avoid rendering issues
        options.addArguments("--no-sandbox"); // Required for some environments
        options.addArguments("--disable-dev-shm-usage"); // Helps in Docker containers

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
