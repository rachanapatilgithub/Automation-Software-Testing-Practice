
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PracticeSite_JSExecuter_Scroll_Task1 {


    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/scrollbars");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Task: on page load the Hiding Button sits inside a scrollable box and is not
        //visible - scrollIntoView brings it into the visible area so it can be clicked
        WebElement hidingButton = driver.findElement(By.id("hidingButton"));

        js.executeScript("arguments[0].scrollIntoView();", hidingButton);

        hidingButton.click();

        driver.quit();
    }
}