package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class35_FlatpickrMultipleDates {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://flatpickr.js.org/examples/");

        driver.findElement(By.xpath("//input[@placeholder='Select Date..']")).click();
        driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day') and text()='10']")).click();
        driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day') and text()='20']")).click();

        System.out.println("Class 35 Completed: Flatpickr Multiple Dates Handled!");
        driver.quit();
    }
}