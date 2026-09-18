package com.automation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
       
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html"); 
    }

    @Test
    public void registerUserTest() {
     
        driver.findElement(By.xpath("//a[text()='Register a new membership']")).click();

      
        driver.findElement(By.id("name")).sendKeys("Rachana Patil");
        driver.findElement(By.id("mobile")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("rachana@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Rachana@123");

       
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @AfterMethod
    public void closeBrowser() {
      
        driver.quit();
    }
}