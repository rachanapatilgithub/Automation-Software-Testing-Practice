
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTask_AddUserTest {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://javabykiran.com/liveproject/index.html"); 
    }

    @Test
    public void addUserTest() {
       
        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

       
        driver.get("https://javabykiran.com/liveproject/pages/examples/add_user.html");

       
        driver.findElement(By.id("username")).sendKeys("Rachana");
        driver.findElement(By.id("mobile")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("rachana.user@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Test@123");

      
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}