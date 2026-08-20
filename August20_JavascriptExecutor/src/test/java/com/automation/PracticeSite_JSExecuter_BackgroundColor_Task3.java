
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PracticeSite_JSExecuter_BackgroundColor_Task3 {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/scrollbars");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement hidingButton = driver.findElement(By.id("hidingButton"));

        //Task: scroll the hidden button into view first, then change its background
        //color so the element stands out on the page
        js.executeScript("arguments[0].scrollIntoView();", hidingButton);

        js.executeScript("arguments[0].style.backgroundColor='yellow'", hidingButton);

        System.out.println("Background color changed");

        driver.quit();
    }
}