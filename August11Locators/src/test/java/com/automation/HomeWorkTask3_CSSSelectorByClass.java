package com.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask3_CSSSelectorByClass {
    public static void main(String[] args) {
        System.out.println("Starting HomeWork Task 3: CSS By Class...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("Clicking inside a text box using the CSS class name '.form-control'...");
        driver.findElement(By.cssSelector(".form-control")).click();
    }
}