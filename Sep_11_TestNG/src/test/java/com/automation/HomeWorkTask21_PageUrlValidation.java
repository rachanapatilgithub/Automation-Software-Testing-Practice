// File Name: HomeWorkTask21_PageUrlValidation.java
package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask21_PageUrlValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void verifyPageUrl() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://javabykiran.com/liveproject/index.html", "URL verification failed!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}