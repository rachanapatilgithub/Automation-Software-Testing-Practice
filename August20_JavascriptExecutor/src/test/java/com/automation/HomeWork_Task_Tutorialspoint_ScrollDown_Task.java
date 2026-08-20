package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWork_Task_Tutorialspoint_ScrollDown_Task {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.tutorialspoint.com/selenium/practice/scroll-down.php");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement scrollDownButton = driver.findElement(By.cssSelector("a.scrollDown"));
        js.executeScript("arguments[0].click();", scrollDownButton);

        System.out.println("Scrolled down");

        Thread.sleep(1500);

        driver.quit();
    }
}