package com.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask1_CSSSelectorStartsWith {
    public static void main(String[] args) {
        System.out.println("Starting HomeWork Task 1: CSS Starts-With...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("Using CSS (^) to find name starting with 'mobi'...");
        driver.findElement(By.cssSelector("input[name^='mobi']")).sendKeys("Starts With Working");
    }
}