package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWork_Task_Tutorialspoint_ScrollUpDown_Task {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://www.tutorialspoint.com/selenium/practice/scroll-down.php");

        WebElement scrollDownButton = driver.findElement(By.cssSelector("a.scrollDown"));
        js.executeScript("arguments[0].click();", scrollDownButton);

        Thread.sleep(1500);

        System.out.println("Scroll position after scroll down: " + js.executeScript("return document.documentElement.scrollTop"));

        driver.get("https://www.tutorialspoint.com/selenium/practice/scroll-top.php");

        js.executeScript("window.scrollBy(0,2000)");

        Thread.sleep(1000);

        WebElement backToTopButton = driver.findElement(By.id("btn-back-to-top"));
        js.executeScript("arguments[0].click();", backToTopButton);

        Thread.sleep(1500);

        System.out.println("Scroll position after scroll up: " + js.executeScript("return document.documentElement.scrollTop"));

        System.out.println("Page title: " + js.executeScript("return document.title"));

        driver.quit();
    }
}