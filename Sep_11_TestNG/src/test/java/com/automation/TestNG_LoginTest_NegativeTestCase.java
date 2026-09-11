package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_LoginTest_NegativeTestCase {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void loginNegativeTest() {
        driver.findElement(By.id("email")).sendKeys("invalid@gmail.com");
        driver.findElement(By.id("password")).sendKeys("wrongpwd");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // VALIDATION: Failed login stays on Login page
        String actualTitle = driver.getTitle();
        String expectedTitle = "JavaByKiran | Log in";
        Assert.assertEquals(actualTitle, expectedTitle, "Negative test failed - user should not be logged in!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}