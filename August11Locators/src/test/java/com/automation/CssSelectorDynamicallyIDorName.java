package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;


public class CssSelectorDynamicallyIDorName {

    public static void main(String[] args) {

System.out.println("Starting CSSSelectorTestByUsingIDorName...");
        
        System.out.println("Opening Edge Driver...");
        WebDriver driver = new EdgeDriver();
        
        System.out.println("Maximizing the window...");
        driver.manage().window().maximize();
        
        System.out.println("Navigating to the Register page...");
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("Finding name box using CSS [name='name'] and typing 'kiran academy'...");
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("kiran academy");
        
        System.out.println("Finding mobile box using CSS [id='mobile'] and typing '123245657'...");
        driver.findElement(By.cssSelector("input[id='mobile']")).sendKeys("123245657");
        
        System.out.println("Finding the Submit button using CSS [type='submit'] and clicking it...");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        System.out.println("Mam's Program 1 Finished!");
    }
}