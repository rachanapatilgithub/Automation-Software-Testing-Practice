// File Name: HomeWorkTask22_SubmitButtonLabelValidation.java
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask22_SubmitButtonLabelValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void verifyButtonText() {
        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        String actualText = submitBtn.getText().trim();
        Assert.assertEquals(actualText, "Sign In", "Submit button label mismatch!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}