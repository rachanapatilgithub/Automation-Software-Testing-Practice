package com.automation;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask08_ArrayListLinks {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        // Create an ArrayList to store Strings
        ArrayList<String> linkTextsList = new ArrayList<>();
        
        for (WebElement link : allLinks) {
            String text = link.getText().trim();
            if (!text.isEmpty()) {
                linkTextsList.add(text); // Store it
            }
        }
        
        System.out.println("Links stored in ArrayList: " + linkTextsList);
        driver.quit();
    }
}