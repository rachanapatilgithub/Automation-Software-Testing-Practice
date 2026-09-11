// File Name: HomeWorkTask25_RefreshClearsInputValidation.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask25_RefreshClearsInputValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void verifyRefreshClearsInputs() {
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("kiran@gmail.com");

        driver.navigate().refresh();

        emailInput = driver.findElement(By.id("email"));
        String emailValue = emailInput.getAttribute("value");

        Assert.assertEquals(emailValue, "", "Page refresh did not clear input field!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}