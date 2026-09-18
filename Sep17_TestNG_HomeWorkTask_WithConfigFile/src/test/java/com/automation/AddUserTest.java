package com.automation;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddUserTest {

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
    public void addUserTest() {
        driver.get(p.getProperty("adduser.url"));
        
        driver.findElement(By.id("username")).sendKeys("Rachana");
        driver.findElement(By.id("mobile")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("rachana.user@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Test@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}