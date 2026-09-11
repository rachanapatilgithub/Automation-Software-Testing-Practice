// File Name: HomeWorkTask34_BrowserBackNavigationValidation.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask34_BrowserBackNavigationValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void testBrowserBackNavigation() {
        driver.findElement(By.id("email")).sendKeys("invalid@gmail.com");
        driver.findElement(By.id("password")).sendKeys("wrongpwd");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.navigate().back();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("index.html"), "Browser back state failed.");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}