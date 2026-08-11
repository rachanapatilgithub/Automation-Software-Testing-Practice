package com.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask4_XPathByAttribute {
    public static void main(String[] args) {
        System.out.println("Starting HomeWork Task 4: XPath By Attribute...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("Typing email using exact XPath id...");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@email.com");
        
        System.out.println("Typing password using exact XPath name...");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
    }
}