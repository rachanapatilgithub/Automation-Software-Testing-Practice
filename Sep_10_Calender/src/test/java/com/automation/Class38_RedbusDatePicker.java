package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class38_RedbusDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.redbus.in/");

        driver.findElement(By.id("onward_cal")).click();
        driver.findElement(By.xpath("//span[contains(@class,'dayText') and text()='15']")).click();

        System.out.println("Class 38 Completed: RedBus DatePicker Handled!");
        driver.quit();
    }
}