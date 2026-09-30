package com.automation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BrokenLinksTest {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/broken-links/");

        List<WebElement> allurls = driver.findElements(By.tagName("a"));

        System.out.println("No of Links Available on Page - " + allurls.size());
        System.out.println("------------ Links ------------");

        for (int i = 0; i < allurls.size(); i++) {

            WebElement alllinks = allurls.get(i);
            String brlinks = alllinks.getAttribute("href");

            URL ur = new URL(brlinks);

            HttpURLConnection conurl = (HttpURLConnection) ur.openConnection();
            conurl.connect();
            conurl.setConnectTimeout(2000);

            if (conurl.getResponseCode() >= 400) {
                System.out.println("Link - " + brlinks + " has Code - " + conurl.getResponseCode() 
                        + " " + conurl.getResponseMessage() + " - is Broken");
            } else {
                System.out.println("Link - " + brlinks + " has Code - " + conurl.getResponseCode() 
                        + " " + conurl.getResponseMessage() + " - is Broken");
            }
        }
    }
}