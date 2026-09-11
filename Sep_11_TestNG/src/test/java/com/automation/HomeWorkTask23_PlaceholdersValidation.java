// File Name: HomeWorkTask23_PlaceholdersValidation.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask23_PlaceholdersValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void verifyPlaceholders() {
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        Assert.assertEquals(emailInput.getAttribute("placeholder"), "Email", "Email placeholder mismatch!");
        Assert.assertEquals(passwordInput.getAttribute("placeholder"), "Password", "Password placeholder mismatch!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}