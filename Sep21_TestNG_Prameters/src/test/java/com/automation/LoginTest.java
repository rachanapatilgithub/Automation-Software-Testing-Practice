package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    // Locators
    By email = By.id("email");
    By password = By.id("password");
    By xpathBtnLogin = By.xpath("//button[contains(text(),'Sign In')]");

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // DataProvider with login credentials and expected roles
    @DataProvider(name = "logins")
    public Object[][] dataSetUserLoginCred() {
        return new Object[][] {
            { "kiran@gmail.com", "123456", "CEO" },
            { "admin@gmail.com", "12345", "admin" },
            { "user1@gmail.com", "111", "user1" },
            { "user2@gmail.com", "222", "user2" }
        };
    }

    // Test Method using DataProvider
    @Test(priority = 1, dataProvider = "logins")
    public void checkLogin(String username, String pass, String expectedRole) {
        
        driver.get("https://javabykiran.com/liveproject/index.html");
        
        String title1 = driver.getTitle(); // javabykiran | index
        
        driver.findElement(email).sendKeys(username);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(xpathBtnLogin).click();
        
        String title2 = driver.getTitle(); // javabykiran | Dashboard
        
        if (!title1.equals(title2)) {
            System.out.println("Login success for role: " + expectedRole);
        } else {
            System.out.println("Login failed for: " + username);
        }
        
        Assert.assertNotEquals(title1, title2, "Login navigation failed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}