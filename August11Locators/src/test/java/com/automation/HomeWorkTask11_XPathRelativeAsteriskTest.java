package com.automation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask11_XPathRelativeAsteriskTest {
    public static void main(String[] args) {
        System.out.println("Starting HomeWork Task 11: Relative XPath with Asterisk...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("Using Relative XPath with '*' wildcard to find ID 'name'...");
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Relative Asterisk");
    }
}