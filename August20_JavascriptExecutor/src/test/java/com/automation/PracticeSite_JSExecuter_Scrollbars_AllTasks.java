
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PracticeSite_JSExecuter_Scrollbars_AllTasks {


    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/scrollbars");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement hidingButton = driver.findElement(By.id("hidingButton"));

        //Task 1: the button is hidden inside a scrollable box on page load -
        //scrollIntoView brings it into the visible area, then click it
        js.executeScript("arguments[0].scrollIntoView();", hidingButton);
        hidingButton.click();

        //Task 2: highlight the button with a border so it's easy to spot
        js.executeScript("arguments[0].style.border='4px solid yellow'", hidingButton);
        System.out.println("Hiding button is now visible");

        //Task 3: change the button's background color
        js.executeScript("arguments[0].style.backgroundColor='yellow'", hidingButton);
        System.out.println("Background color changed");

        //Task 4: read the page title using JavaScript
        String title = (String) js.executeScript("return document.title");
        System.out.println("Page title: " + title);

        driver.quit();
    }
}