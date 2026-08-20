
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PracticeSite_JSExecuter_Highlight_Task2 {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/scrollbars");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement hidingButton = driver.findElement(By.id("hidingButton"));

        //Task: scroll the hidden button into view first, then draw a yellow border
        //around it so it is easy to see exactly which element the script found
        js.executeScript("arguments[0].scrollIntoView();", hidingButton);

        js.executeScript("arguments[0].style.border='4px solid yellow'", hidingButton);

        System.out.println("Hiding button is now visible");

        driver.quit();
    }
}