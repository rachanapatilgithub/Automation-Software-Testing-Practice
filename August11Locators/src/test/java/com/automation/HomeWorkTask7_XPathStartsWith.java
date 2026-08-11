package com.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask7_XPathStartsWith {
    public static void main(String[] args) {
        System.out.println("Starting HomeWork Task 7: XPath Starts-With...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("Typing in the box where the name attribute STARTS WITH 'mobi'...");
        driver.findElement(By.xpath("//input[starts-with(@name,'mobi')]")).sendKeys("Starts With Working");
    }
}
