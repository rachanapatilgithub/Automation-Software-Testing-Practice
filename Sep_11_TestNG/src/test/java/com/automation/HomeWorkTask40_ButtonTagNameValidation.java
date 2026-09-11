// File Name: HomeWorkTask40_ButtonTagNameValidation.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask40_ButtonTagNameValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void verifyButtonTagName() {
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        String tagName = submitButton.getTagName();
        Assert.assertEquals(tagName.toLowerCase(), "button", "Element tag name mismatch!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}