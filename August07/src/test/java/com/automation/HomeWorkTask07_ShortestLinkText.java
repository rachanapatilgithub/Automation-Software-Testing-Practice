package com.automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask07_ShortestLinkText {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        
        String shortestText = null;
        
        for (WebElement link : allLinks) {
            String text = link.getText().trim();
            if (!text.isEmpty()) {
                // Initialize on the first non-empty text, then compare lengths
                if (shortestText == null || text.length() < shortestText.length()) {
                    shortestText = text;
                }
            }
        }
        
        System.out.println("Shortest Link Text: " + shortestText);
        driver.quit();
    }
}