// File Name: HomeWorkTask9_PageTitleValidation.java
package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask9_PageTitleValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void verifyPageTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "JavaByKiran | Log in";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}