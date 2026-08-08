package com.automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask06_LongestLinkText {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        
        String longestText = "";
        
        for (WebElement link : allLinks) {
            String text = link.getText().trim();
            // If current text length is greater than our stored longest text, update it
            if (text.length() > longestText.length()) {
                longestText = text;
            }
        }
        
        System.out.println("Longest Link Text: " + longestText);
        driver.quit();
    }
}