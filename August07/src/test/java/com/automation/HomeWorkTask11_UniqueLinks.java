package com.automation;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask11_UniqueLinks {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        
        // LinkedHashSet removes duplicates but maintains insertion order
        Set<String> uniqueTexts = new LinkedHashSet<>();
        
        for (WebElement link : allLinks) {
            String text = link.getText().trim();
            if (!text.isEmpty()) {
                uniqueTexts.add(text);
            }
        }
        
        System.out.println("Unique Link Texts: ");
        for (String unique : uniqueTexts) {
            System.out.println(unique);
        }
        driver.quit();
    }
}