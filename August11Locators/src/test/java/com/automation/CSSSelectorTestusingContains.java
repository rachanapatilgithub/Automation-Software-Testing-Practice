package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CSSSelectorTestusingContains {
    public static void main(String[] args) {
        
        System.out.println("Starting CSSSelectorTestusingContains...");
        
        System.out.println("Opening Edge Driver...");
        WebDriver driver = new EdgeDriver();
        
        System.out.println("Maximizing the window...");
        driver.manage().window().maximize();
        
        System.out.println("Navigating to the Register page...");
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("Finding element where name CONTAINS 'obi' and typing '513554'...");
        driver.findElement(By.cssSelector("input[name*='obi']")).sendKeys("513554");
        
        System.out.println("Mam's Program 2 Finished!");
    }
}