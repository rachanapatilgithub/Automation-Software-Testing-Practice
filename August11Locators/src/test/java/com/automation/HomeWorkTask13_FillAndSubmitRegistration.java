package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask13_FillAndSubmitRegistration {
    public static void main(String[] args) {
        
        System.out.println("--- STARTING REGISTRATION FORM TEST ---");
        
        System.out.println("1. Setting up Browser...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        
        System.out.println("2. Opening the JBK Registration Page...");
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("3. Filling out the 'Name' field...");
        driver.findElement(By.id("name")).sendKeys("Rahul Sharma");
        
        System.out.println("4. Filling out the 'Mobile' field...");
        driver.findElement(By.id("mobile")).sendKeys("9876543210");
        
        System.out.println("5. Filling out the 'Email' field...");
        driver.findElement(By.id("email")).sendKeys("rahul.sharma@example.com");
        
        System.out.println("6. Filling out the 'Password' field...");
        driver.findElement(By.id("password")).sendKeys("Test@1234");
        
        System.out.println("7. Clicking the 'Register' button...");
        // Using exact text XPath to find the button and click it
        driver.findElement(By.xpath("//button[text()='Register']")).click();
        
        System.out.println("--- REGISTRATION SUBMITTED SUCCESSFULLY! ---");
    }
}