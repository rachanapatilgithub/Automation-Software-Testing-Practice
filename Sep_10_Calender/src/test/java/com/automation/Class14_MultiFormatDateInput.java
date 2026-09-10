package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class14_MultiFormatDateInput {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/date-picker");

        WebElement input = driver.findElement(By.id("datePickerMonthYearInput"));
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.BACK_SPACE);
        input.sendKeys("05/12/2027");
        input.sendKeys(Keys.ENTER);

        System.out.println("Class 14 Completed: Alternative Date Format Passed");
        driver.quit();
    }
}