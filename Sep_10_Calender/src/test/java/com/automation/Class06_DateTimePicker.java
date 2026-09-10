package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class06_DateTimePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/date-picker");

        driver.findElement(By.id("dateAndTimePickerInput")).click();
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day--020')]")).click();
        driver.findElement(By.xpath("//li[text()='14:30']")).click();

        System.out.println("Class 06 Completed: Date & Time Picker");
        driver.quit();
    }
}