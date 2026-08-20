package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWork_Task_Tutorialspoint_ScrollUp_Task {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.tutorialspoint.com/selenium/practice/scroll-top.php");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,2000)");

        Thread.sleep(1000);

        WebElement backToTopButton = driver.findElement(By.id("btn-back-to-top"));
        js.executeScript("arguments[0].click();", backToTopButton);

        System.out.println("Scrolled up");

        driver.quit();
    }
}