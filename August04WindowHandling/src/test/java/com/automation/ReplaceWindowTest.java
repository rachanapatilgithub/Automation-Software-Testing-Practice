package com.automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ReplaceWindowTest {
	public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/window-operations/");
        
        System.out.println(driver.getWindowHandle());
        
        WebElement replacewindow = driver.findElement(By.xpath("//*[@id=\"post-1147\"]/div/p[5]/button"));
        
        replacewindow.click();
        
        driver.get("https://practice-automation.com/");
        
        String window = driver.getWindowHandle();
        
        System.out.println(window);
        
        System.out.println(driver.getCurrentUrl());
        
        driver.navigate().back();
        driver.navigate().forward();
        
    }
}

