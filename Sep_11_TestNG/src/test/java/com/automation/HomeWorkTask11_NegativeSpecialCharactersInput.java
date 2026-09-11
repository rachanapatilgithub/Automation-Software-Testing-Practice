// File Name: HomeWorkTask11_NegativeSpecialCharactersInput.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask11_NegativeSpecialCharactersInput {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void specialCharactersTest() {
        driver.findElement(By.id("email")).sendKeys("' OR '1'='1");
        driver.findElement(By.id("password")).sendKeys("<script>alert(1)</script>");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("index.html"), "Security Failure: Special characters permitted login.");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}