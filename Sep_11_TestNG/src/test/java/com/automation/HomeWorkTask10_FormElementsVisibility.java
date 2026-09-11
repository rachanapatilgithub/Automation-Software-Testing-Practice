// File Name: HomeWorkTask10_FormElementsVisibility.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask10_FormElementsVisibility {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void verifyUIElementsPresence() {
        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        Assert.assertTrue(emailBox.isDisplayed(), "Email input is missing!");
        Assert.assertTrue(passwordBox.isDisplayed(), "Password input is missing!");
        Assert.assertTrue(submitButton.isDisplayed(), "Submit button is missing!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}