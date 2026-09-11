// File Name: HomeWorkTask46_PageSourceFormValidation.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask46_PageSourceFormValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void testPageSourceContainsForm() {
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("form"), "Page source missing form element.");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}