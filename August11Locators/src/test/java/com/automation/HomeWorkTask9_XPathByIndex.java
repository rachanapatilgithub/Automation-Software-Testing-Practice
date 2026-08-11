package com.automation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask9_XPathByIndex {
    public static void main(String[] args) {
        System.out.println("Starting HomeWork Task 9: XPath By Index...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("Finding the very first input box on the page using index [1]...");
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("First Box By Index");
    }
}