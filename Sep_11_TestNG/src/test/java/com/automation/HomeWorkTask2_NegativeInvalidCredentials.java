// File Name: HomeWorkTask2_NegativeInvalidCredentials.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask2_NegativeInvalidCredentials {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void invalidCredentialsTest() {
        driver.findElement(By.id("email")).sendKeys("wronguser@gmail.com");
        driver.findElement(By.id("password")).sendKeys("invalid123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("index.html"), "Negative test failed: Invalid credentials permitted login.");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}