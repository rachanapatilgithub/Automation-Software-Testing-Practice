package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class42_JavaScriptExecutorDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/date-picker");

        WebElement dateInput = driver.findElement(By.id("datePickerMonthYearInput"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '10/25/2026';", dateInput);

        System.out.println("Class 42 Completed: Date Set Directly via JavaScript Executor!");
        driver.quit();
    }
}