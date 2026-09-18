package com.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTestPriority {

    WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html"); 
    }

    @Test(priority = 1)
    public void registerWithValidDataTest() {
        driver.findElement(By.id("name")).sendKeys("Rachana Patil");
        driver.findElement(By.id("mobile")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("rachana@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Rachana@123");
        
        driver.findElement(By.xpath("//*[@id=\"form\"]/div[5]/div/button")).click();
        
     
        Alert al = driver.switchTo().alert();
        al.accept();
    }

    @Test(priority = 2)
    public void registerWithEmptyNameTest() {
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        driver.findElement(By.id("name")).sendKeys("");
        driver.findElement(By.id("mobile")).sendKeys("1243442545");
        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123abc");
        
        driver.findElement(By.xpath("//*[@id=\"form\"]/div[5]/div/button")).click();

        Alert al = driver.switchTo().alert();
        al.accept();
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}