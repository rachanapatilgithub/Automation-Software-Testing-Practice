package com.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask5_XPathByText {
    public static void main(String[] args) {
        System.out.println("Starting HomeWork Task 5: XPath By Text...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("Clicking the 'I already have a membership' link using exact text...");
        driver.findElement(By.xpath("//a[text()='I already have a membership']")).click();
    }
}
