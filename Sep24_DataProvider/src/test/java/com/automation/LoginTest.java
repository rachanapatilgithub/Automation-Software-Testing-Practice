package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test(dataProvider = "logindata")
    public void login(String username, String password) {
        WebElement uname = driver.findElement(By.id("email"));
        uname.sendKeys(username);

        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys(password);

        WebElement signinbutton = driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button"));
        signinbutton.click();

        String url = driver.getCurrentUrl();
        if (url.contains("dashboard.html")) {
            System.out.println("Login SUCCESS - with " + username + " and " + password);
        } else {
            System.out.println("Login FAILED - with " + username + " and " + password);
        }
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider
    public Object[][] logindata() {
        Object[][] data = {
            { "kiran@gmail.com", "123456" },
            { "admin@gmail.com", "12345" },
            { "user1@gmail.com", "111" },
            { "user2@gmail.com", "222" }
        };
        return data;
    }
}