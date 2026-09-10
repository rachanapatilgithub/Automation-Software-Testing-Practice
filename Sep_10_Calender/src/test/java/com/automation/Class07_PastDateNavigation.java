package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class07_PastDateNavigation {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        driver.findElement(By.id("datepicker")).click();

        while (true) {
            String monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
            if (monthYear.contains("January") && monthYear.contains("2024")) {
                break;
            }
            driver.findElement(By.xpath("//span[text()='Prev']")).click();
        }

        driver.findElement(By.xpath("//a[text()='10']")).click();

        System.out.println("Class 07 Completed: Past Date Navigation Loop");
        driver.quit();
    }
}