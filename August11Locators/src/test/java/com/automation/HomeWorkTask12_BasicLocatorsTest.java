package com.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask12_BasicLocatorsTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting HomeWork Task 12: Basic Locators (1-6)...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("LOCATOR 1: Finding the mobile box by ID...");
        driver.findElement(By.id("mobile")).sendKeys("11111");
        
        System.out.println("LOCATOR 2: Finding the name box by NAME...");
        driver.findElement(By.name("name")).sendKeys("Basic Name");
        
        System.out.println("LOCATOR 3: Finding the first input box by TAGNAME...");
        driver.findElement(By.tagName("input")).click();
        
        System.out.println("LOCATOR 4: Finding a box using CLASSNAME...");
        driver.findElement(By.className("form-control")).click();
        
        System.out.println("LOCATOR 5: Clicking a link using its exact full LINKTEXT...");
        driver.findElement(By.linkText("I already have a membership")).click();
        
        System.out.println("Waiting and going back...");
        Thread.sleep(2000);
        driver.navigate().back();
        
        System.out.println("LOCATOR 6: Clicking that same link using PARTIAL LINK TEXT...");
        driver.findElement(By.partialLinkText("already have a")).click();
    }
}