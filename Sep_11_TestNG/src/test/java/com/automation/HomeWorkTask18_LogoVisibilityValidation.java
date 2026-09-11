// File Name: HomeWorkTask18_LogoVisibilityValidation.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask18_LogoVisibilityValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void verifyLogoDisplayed() {
        WebElement logo = driver.findElement(By.className("login-logo"));
        Assert.assertTrue(logo.isDisplayed(), "Validation failed: Application logo is not displayed!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}