package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWork_Task_InfiniteScroll {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/infinite-scroll");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        int countBefore = driver.findElements(By.className("jscroll-added")).size();
        System.out.println("Paragraphs loaded at start:");
        System.out.println(countBefore);

        for (int i = 1; i <= 3; i++) {

            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            Thread.sleep(2000);

            int countNow = driver.findElements(By.className("jscroll-added")).size();

            System.out.println("Paragraphs loaded after scroll " + i + ":");
            System.out.println(countNow);
        }

        driver.quit();
    }
}