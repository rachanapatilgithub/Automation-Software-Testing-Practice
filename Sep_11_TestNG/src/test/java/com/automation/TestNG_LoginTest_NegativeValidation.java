package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_LoginTest_NegativeValidation {
    WebDriver driver;

    @BeforeMethod
    void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test
    void loginNegativeTest() {
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("invalid@gmail.com");

        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys("wrongpwd");

        WebElement signbutton = driver.findElement(By.xpath("//button[@type='submit']"));
        signbutton.click();

        // ASSERTION: Verify user remains on the Login page (URL should still contain "index.html")
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("index.html"), "Negative test failed: User was logged in with invalid credentials!");
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}