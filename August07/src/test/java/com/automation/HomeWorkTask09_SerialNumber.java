package com.automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask09_SerialNumber {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("--- Task 9: Serial Numbers ---");
        
        int serialNumber = 1;
        for (WebElement link : allLinks) {
            String text = link.getText().trim();
            if (!text.isEmpty()) {
                // Print counter + text, then increment counter
                System.out.println(serialNumber + ". " + text);
                serialNumber++;
            }
        }
        driver.quit();
    }
}