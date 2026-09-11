package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_LoginTest {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void loginPositiveTest() {
        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // VALIDATION: Successful login redirects to Dashboard
        String actualTitle = driver.getTitle();
        String expectedTitle = "JavaByKiran | Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle, "Positive login failed!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}