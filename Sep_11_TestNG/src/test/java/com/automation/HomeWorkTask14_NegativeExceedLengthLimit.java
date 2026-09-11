// File Name: HomeWorkTask14_NegativeExceedLengthLimit.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask14_NegativeExceedLengthLimit {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void exceedLengthLimitTest() {
        String longEmail = "a".repeat(300) + "@gmail.com";
        String longPassword = "p".repeat(300);

        driver.findElement(By.id("email")).sendKeys(longEmail);
        driver.findElement(By.id("password")).sendKeys(longPassword);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("index.html"), "Negative test failed: Boundary character overflow permitted login.");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}