package com.automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask03_LinkCount {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        
        int totalLinks = allLinks.size();
        int withText = 0;
        int withoutText = 0;

        for (WebElement link : allLinks) {
            if (link.getText().trim().isEmpty()) {
                withoutText++;
            } else {
                withText++;
            }
        }
        
        System.out.println("Total links: " + totalLinks);
        System.out.println("Links with text: " + withText);
        System.out.println("Links without text: " + withoutText);
        
        driver.quit();
    }
}