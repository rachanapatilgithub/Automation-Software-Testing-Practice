package com.automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask02_PrintLinkTextAndHref {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("--- Task 2: Text and Href ---");
        
        for (WebElement link : allLinks) {
            String text = link.getText();
            // getAttribute("href") fetches the background URL
            String url = link.getAttribute("href"); 
            System.out.println("Text: " + text + " | URL: " + url);
        }
        driver.quit();
    }
}