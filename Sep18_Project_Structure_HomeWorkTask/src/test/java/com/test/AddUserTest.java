package com.test;

import static org.testng.Assert.assertEquals;
import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BrowserSetup;
import com.util.ExcelSheetRead;
import com.util.PropertiesRead;

public class AddUserTest extends BrowserSetup {
    Properties prop;
    String loginUsername;
    String loginPassword;

    @BeforeMethod
    public void setup() {
        startBrowser();
        prop = PropertiesRead.readProperties();
        loginUsername = ExcelSheetRead.getData(1, 0);
        loginPassword = ExcelSheetRead.getData(1, 1);
    }

    @Test
    public void validAddUserTest() {
        // Step 1: Login
        driver.get(prop.getProperty("url"));
        driver.findElement(By.id("email")).sendKeys(loginUsername);
        driver.findElement(By.id("password")).sendKeys(loginPassword);
        driver.findElement(By.xpath("//button")).click();

        // Step 2: Go to Add User page
        driver.get(prop.getProperty("userUrl"));
        driver.findElement(By.id("username")).sendKeys("RachanaTest");
        driver.findElement(By.id("mobile")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("testuser@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button")).click();

        System.out.println("Add User Test Successful");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
        System.out.println("Browser Closed");
    }
}