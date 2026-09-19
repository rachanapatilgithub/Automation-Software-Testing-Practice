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

public class LoginTest extends BrowserSetup {
    Properties prop;
    String username;
    String password;

    @BeforeMethod
    public void setup() {
        startBrowser();
        prop = PropertiesRead.readProperties();
        driver.get(prop.getProperty("url"));
        username = ExcelSheetRead.getData(1, 0);
        password = ExcelSheetRead.getData(1, 1);
    }

    @Test
    public void validLoginTest() {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button")).click();
        
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "JavaByKiran | Dashboard");
        System.out.println("Login Successful");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
        System.out.println("Browser Closed");
    }
}