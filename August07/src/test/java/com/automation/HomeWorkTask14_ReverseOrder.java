package com.automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask14_ReverseOrder {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("--- Task 14: Reverse Order ---");
        
        // Traditional for-loop starting from the end of the list down to 0
        for (int i = allLinks.size() - 1; i >= 0; i--) {
            String text = allLinks.get(i).getText().trim();
            if (!text.isEmpty()) {
                System.out.println(text);
            }
        }
        driver.quit();
    }
}