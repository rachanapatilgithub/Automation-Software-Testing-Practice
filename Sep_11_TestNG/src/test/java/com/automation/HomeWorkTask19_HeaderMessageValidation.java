// File Name: HomeWorkTask19_HeaderMessageValidation.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask19_HeaderMessageValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void verifyHeaderMessage() {
        WebElement headerMessage = driver.findElement(By.className("login-box-msg"));
        String actualText = headerMessage.getText();
        Assert.assertEquals(actualText, "Sign in to start your session", "Login box message text mismatch!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}