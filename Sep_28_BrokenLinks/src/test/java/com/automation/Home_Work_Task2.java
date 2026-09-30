package com.automation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Home_Work_Task2 {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/broken-images/");

        List<WebElement> images = driver.findElements(By.tagName("img"));

        System.out.println("No of Images Available on Page - " + images.size());
        System.out.println("------------ Images ------------");

        for (int i = 0; i < images.size(); i++) {

            WebElement img = images.get(i);
            String imgUrl = img.getAttribute("src");

            if (imgUrl == null || imgUrl.isEmpty()) {
                continue;
            }

            try {
                URL ur = new URL(imgUrl);

                HttpURLConnection conurl = (HttpURLConnection) ur.openConnection();
                conurl.connect();
                conurl.setConnectTimeout(2000);

                if (conurl.getResponseCode() >= 400) {
                    System.out.println("Image - " + imgUrl + " has Code - " + conurl.getResponseCode() 
                            + " " + conurl.getResponseMessage() + " - is Broken");
                } else {
                    System.out.println("Image - " + imgUrl + " has Code - " + conurl.getResponseCode() 
                            + " " + conurl.getResponseMessage() + " - is Valid");
                }
            } catch (Exception e) {
                // Exception handling
            }
        }
        
        driver.quit();
    }
}