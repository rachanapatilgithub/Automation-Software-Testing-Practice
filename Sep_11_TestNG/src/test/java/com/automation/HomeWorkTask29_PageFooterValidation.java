// File Name: HomeWorkTask29_PageFooterValidation.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask29_PageFooterValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void verifyFooterText() {
        WebElement footer = driver.findElement(By.tagName("footer"));
        String footerText = footer.getText();

        Assert.assertTrue(footer.isDisplayed(), "Footer is not visible on page!");
        Assert.assertTrue(footerText.toLowerCase().contains("javabykiran"), "Footer text missing reference.");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}