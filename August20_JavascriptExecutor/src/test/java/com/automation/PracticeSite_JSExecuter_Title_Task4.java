
package com.automation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PracticeSite_JSExecuter_Title_Task4 {


    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/scrollbars");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Task: read the page title using JavaScript instead of driver.getTitle()
        String title = (String) js.executeScript("return document.title");

        System.out.println("Page title: " + title);

        driver.quit();
    }
}