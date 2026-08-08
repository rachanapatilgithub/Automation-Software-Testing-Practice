package com.automation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask10_DuplicateLinks {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        
        Set<String> seenTexts = new HashSet<>();
        Set<String> duplicateTexts = new HashSet<>();
        
        for (WebElement link : allLinks) {
            String text = link.getText().trim();
            if (!text.isEmpty()) {
                // If it can't be added to 'seen', it's a duplicate
                if (!seenTexts.add(text)) {
                    duplicateTexts.add(text);
                }
            }
        }
        
        System.out.println("Duplicate Link Texts: " + duplicateTexts);
        driver.quit();
    }
}