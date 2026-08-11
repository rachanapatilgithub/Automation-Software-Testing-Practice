package com.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask6_XPathContains {
    public static void main(String[] args) {
        System.out.println("Starting HomeWork Task 6: XPath Contains...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("Typing in box where name contains 'mob'...");
        driver.findElement(By.xpath("//input[contains(@name,'mob')]")).sendKeys("Mobile Contains");
    }
}