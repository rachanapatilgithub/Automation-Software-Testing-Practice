// File Name: HomeWorkTask48_UppercaseEmailLogin.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask48_UppercaseEmailLogin {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void uppercaseEmailTest() {
        driver.findElement(By.id("email")).sendKeys("KIRAN@GMAIL.COM");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("index.html"), "Positive test failed: Uppercase email allowed case-insensitive login.");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}