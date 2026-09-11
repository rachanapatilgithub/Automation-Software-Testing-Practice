// File Name: HomeWorkTask37_FormActionAttributeValidation.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask37_FormActionAttributeValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void verifyFormActionAttribute() {
        WebElement formElement = driver.findElement(By.tagName("form"));
        String actionValue = formElement.getAttribute("action");

        Assert.assertNotNull(actionValue, "Form action attribute is missing!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}