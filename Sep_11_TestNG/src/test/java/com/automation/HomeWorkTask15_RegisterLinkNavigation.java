// File Name: HomeWorkTask15_RegisterLinkNavigation.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask15_RegisterLinkNavigation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void registerLinkNavigationTest() {
        WebElement registerLink = driver.findElement(By.partialLinkText("Register"));
        registerLink.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("register.html"), "Link test failed: Did not navigate to register.html.");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}