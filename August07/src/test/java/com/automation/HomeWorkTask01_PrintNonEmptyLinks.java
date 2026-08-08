package com.automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask01_PrintNonEmptyLinks {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("--- Task 1: Non-Empty Links ---");
        
        for (WebElement link : allLinks) {
            String text = link.getText().trim();
            // Condition to check if text is not empty
            if (!text.isEmpty()) {
                System.out.println(text);
            }
        }
        driver.quit();
    }
}