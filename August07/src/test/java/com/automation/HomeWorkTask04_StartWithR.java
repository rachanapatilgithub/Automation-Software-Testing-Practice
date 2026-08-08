package com.automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask04_StartWithR {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("--- Task 4: Links starting with 'R' ---");
        
        for (WebElement link : allLinks) {
            String text = link.getText().trim();
            // Use startsWith to check the first letter
            if (text.startsWith("R")) {
                System.out.println(text);
            }
        }
        driver.quit();
    }
}