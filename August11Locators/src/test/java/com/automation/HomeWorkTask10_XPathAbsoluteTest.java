package com.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask10_XPathAbsoluteTest {
    public static void main(String[] args) {
        System.out.println("Starting HomeWork Task 10: Absolute XPath...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("Using the full/absolute XPath to find the name box and typing 'Absolute Path'...");
        driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/input")).sendKeys("Absolute Path");
    }
}