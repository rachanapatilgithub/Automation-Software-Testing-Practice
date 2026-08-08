package com.automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask15_FirstLastLink {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        
        if (!allLinks.isEmpty()) {
            // Get index 0 for first, and size-1 for last
            String firstLink = allLinks.get(0).getText();
            String lastLink = allLinks.get(allLinks.size() - 1).getText();
            
            System.out.println("First Link Text: " + firstLink);
            System.out.println("Last Link Text: " + lastLink);
        } else {
            System.out.println("No links found on the page.");
        }
        
        driver.quit();
    }
}