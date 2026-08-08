package com.automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask05_ContainsLogin {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("--- Task 5: Links containing 'Login' ---");
        
        for (WebElement link : allLinks) {
            String text = link.getText().trim();
            // Use contains to find the word anywhere in the text
            if (text.contains("Login")) {
                System.out.println(text);
            }
        }
        driver.quit();
    }
}