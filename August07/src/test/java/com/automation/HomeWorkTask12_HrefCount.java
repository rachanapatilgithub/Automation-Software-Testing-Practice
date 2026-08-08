package com.automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask12_HrefCount {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        
        int hasHref = 0;
        int noHref = 0;

        for (WebElement link : allLinks) {
            String hrefValue = link.getAttribute("href");
            // Check if the attribute exists and isn't empty
            if (hrefValue != null && !hrefValue.isEmpty()) {
                hasHref++;
            } else {
                noHref++;
            }
        }
        
        System.out.println("Links with href: " + hasHref);
        System.out.println("Links without href: " + noHref);
        driver.quit();
    }
}