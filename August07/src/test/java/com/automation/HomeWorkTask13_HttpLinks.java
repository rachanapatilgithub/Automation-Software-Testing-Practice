package com.automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask13_HttpLinks {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("--- Task 13: HTTP Links ---");
        
        for (WebElement link : allLinks) {
            String hrefValue = link.getAttribute("href");
            // Null check is required to prevent NullPointerException
            if (hrefValue != null && hrefValue.startsWith("http")) {
                System.out.println(hrefValue);
            }
        }
        driver.quit();
    }
}