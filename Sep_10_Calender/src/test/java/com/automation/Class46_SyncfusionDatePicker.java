package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class46_SyncfusionDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://ej2.syncfusion.com/demos/datepicker/default/index.html");

        driver.findElement(By.xpath("//span[contains(@class,'e-date-icon')]")).click();
        driver.findElement(By.xpath("//td[contains(@class,'e-cell')]//span[text()='22']")).click();

        System.out.println("Class 46 Completed: Syncfusion Calendar Handled!");
        driver.quit();
    }
}