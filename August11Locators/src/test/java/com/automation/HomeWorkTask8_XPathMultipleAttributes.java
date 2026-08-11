package com.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask8_XPathMultipleAttributes {
    public static void main(String[] args) {
        System.out.println("Starting HomeWork Task 8: XPath Multiple Attributes...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("Using two attributes (placeholder AND id) to find the password box...");
        driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys("DoubleCheck");
    }
}