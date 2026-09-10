package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class43_BootstrapDateRangePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.daterangepicker.com/");

        driver.findElement(By.name("daterange")).click();
        driver.findElement(By.xpath("(//div[@class='drp-calendar left']//td[contains(@class,'available') and text()='10'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='drp-calendar right']//td[contains(@class,'available') and text()='20'])[1]")).click();
        driver.findElement(By.xpath("//button[text()='Apply']")).click();

        System.out.println("Class 43 Completed: Date Range Picker Handled!");
        driver.quit();
    }
}