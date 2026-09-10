package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class22_SelectWeekendDates {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/date-picker");

        driver.findElement(By.id("datePickerMonthYearInput")).click();
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day--weekend')]")).click();

        System.out.println("Class 22 Completed: Weekend Date Selected");
        driver.quit();
    }
}