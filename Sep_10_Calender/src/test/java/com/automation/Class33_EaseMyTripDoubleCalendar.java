package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class33_EaseMyTripDoubleCalendar {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.easemytrip.com/");

        driver.findElement(By.id("ddate")).click();
        driver.findElement(By.xpath("//li[contains(@id,'18')]")).click();

        System.out.println("Class 33 Completed: EaseMyTrip Dual Calendar Handled!");
        driver.quit();
    }
}