package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class03_SendKeysDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/date-picker");

        WebElement input = driver.findElement(By.id("datePickerMonthYearInput"));
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.BACK_SPACE);
        input.sendKeys("10/25/2026");
        input.sendKeys(Keys.ENTER);

        System.out.println("Class 03 Completed: Direct SendKeys Date Input");
        driver.quit();
    }
}