package com.automation;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    Properties p;

    @BeforeMethod
    public void setUp() throws Exception {
        p = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");
        p.load(fis);

        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() {
        driver.get(p.getProperty("login.url"));
        
        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}