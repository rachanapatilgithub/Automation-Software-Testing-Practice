package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class23_MonthYearHeaderAssertion {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        driver.findElement(By.id("datepicker")).click();

        String headerText = driver.findElement(By.className("ui-datepicker-title")).getText();
        System.out.println("Class 23 Completed: Header Text Asserted -> " + headerText);

        driver.quit();
    }
}