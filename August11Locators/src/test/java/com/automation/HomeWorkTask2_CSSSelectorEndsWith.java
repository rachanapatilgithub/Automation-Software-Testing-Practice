package com.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask2_CSSSelectorEndsWith {
    public static void main(String[] args) {
        System.out.println("Starting HomeWork Task 2: CSS Ends-With...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("Using CSS ($) to find name ending with 'ile'...");
        driver.findElement(By.cssSelector("input[name$='ile']")).sendKeys("Ends With Working");
    }
}