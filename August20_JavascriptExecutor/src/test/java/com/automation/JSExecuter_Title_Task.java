package com.automation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class JSExecuter_Title_Task {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://thekiranacademy.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String title = (String) js.executeScript("return document.title");

        System.out.println("Page title: " + title);

        driver.quit();
    }
}