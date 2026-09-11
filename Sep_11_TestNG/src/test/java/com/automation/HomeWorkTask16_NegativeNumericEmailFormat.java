// File Name: HomeWorkTask16_NegativeNumericEmailFormat.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask16_NegativeNumericEmailFormat {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void numericEmailTest() {
        driver.findElement(By.id("email")).sendKeys("1234567890");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("index.html"), "Negative test failed: Purely numeric email string permitted login.");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}