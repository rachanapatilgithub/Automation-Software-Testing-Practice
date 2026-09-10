package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class19_ClearAndTypeDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/date-picker");

        WebElement input = driver.findElement(By.id("datePickerMonthYearInput"));
        input.clear();
        input.sendKeys("11/11/2026");

        System.out.println("Class 19 Completed: Clear and Type Executed");
        driver.quit();
    }
}