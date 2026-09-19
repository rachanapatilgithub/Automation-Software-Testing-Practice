package com.test;

import static org.testng.Assert.assertEquals;
import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BrowserSetup;
import com.util.PropertiesRead;

public class RegisterTest extends BrowserSetup {
    Properties prop;

    @BeforeMethod
    public void setup() {
        startBrowser();
        prop = PropertiesRead.readProperties();
        driver.get(prop.getProperty("registerUrl"));
    }

    @Test
    public void validRegisterTest() {
        driver.findElement(By.id("name")).sendKeys("Rachana Patil");
        driver.findElement(By.id("mobile")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("rachana@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button")).click();
        
        System.out.println("Register Test Executed");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
        System.out.println("Browser Closed");
    }
}