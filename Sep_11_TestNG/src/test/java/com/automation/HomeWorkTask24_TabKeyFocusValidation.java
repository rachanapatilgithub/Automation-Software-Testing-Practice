// File Name: HomeWorkTask24_TabKeyFocusValidation.java
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

public class HomeWorkTask24_TabKeyFocusValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void verifyTabKeyFocus() {
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("kiran@gmail.com");
        emailInput.sendKeys(Keys.TAB);

        WebElement activeElement = driver.switchTo().activeElement();
        WebElement passwordInput = driver.findElement(By.id("password"));

        Assert.assertEquals(activeElement, passwordInput, "Tab navigation did not focus password input!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}