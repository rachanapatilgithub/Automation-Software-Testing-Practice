// File Name: HomeWorkTask26_SubmitWithEnterKey.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask26_SubmitWithEnterKey {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void submitWithEnterKeyTest() {
        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys("123456");
        pwd.sendKeys(Keys.ENTER);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("index.html"), "Enter key submission failed to log in.");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}