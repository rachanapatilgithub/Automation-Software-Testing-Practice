package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class04_DynamicMonthLoopCalendar {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        driver.findElement(By.id("datepicker")).click();

        while (true) {
            String monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
            if (monthYear.contains("December") && monthYear.contains("2026")) {
                break;
            }
            driver.findElement(By.xpath("//span[text()='Next']")).click();
        }

        driver.findElement(By.xpath("//a[text()='25']")).click();

        System.out.println("Class 04 Completed: Dynamic Month Loop Calendar");
        driver.quit();
    }
}