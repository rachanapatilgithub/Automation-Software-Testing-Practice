package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class37_AirIndiaDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.airindia.com/");

        driver.findElement(By.id("dp1")).click();
        driver.findElement(By.xpath("(//div[contains(@class,'bi-calendar-date') and not(contains(@class,'disabled'))])[5]")).click();

        System.out.println("Class 37 Completed: Air India Calendar Handled!");
        driver.quit();
    }
}