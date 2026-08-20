package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class JSExecuter_KiranAcademy_AllTasks {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://thekiranacademy.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Task 1: scroll the page down by a fixed amount
        js.executeScript("window.scrollBy(0,1000)");

        WebElement footer = driver.findElement(By.xpath("/html/body/footer/div[2]/span[1]"));

        //Task 2: scroll straight to the footer text and highlight it with a border
        js.executeScript("arguments[0].scrollIntoView();", footer);
        js.executeScript("arguments[0].style.border='4px solid yellow'", footer);
        System.out.println("Footer is visible");

        //Task 3: change the footer's background color
        js.executeScript("arguments[0].style.backgroundColor='yellow'", footer);
        System.out.println("Background color changed");

        //Task 4: read the page title using JavaScript
        String title = (String) js.executeScript("return document.title");
        System.out.println("Page title: " + title);

        driver.quit();
    }
}