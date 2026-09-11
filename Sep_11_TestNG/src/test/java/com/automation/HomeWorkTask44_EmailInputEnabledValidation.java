// File Name: HomeWorkTask44_EmailInputEnabledValidation.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask44_EmailInputEnabledValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void verifyEmailInputEnabled() {
        WebElement emailInput = driver.findElement(By.id("email"));
        Assert.assertTrue(emailInput.isEnabled(), "Email input is disabled!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}