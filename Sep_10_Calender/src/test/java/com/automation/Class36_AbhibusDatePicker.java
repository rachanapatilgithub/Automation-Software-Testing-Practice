package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class36_AbhibusDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.abhibus.com/");

        driver.findElement(By.xpath("//input[@placeholder='Onward Journey Date']")).click();
        driver.findElement(By.xpath("//span[text()='Tomorrow']")).click();

        System.out.println("Class 36 Completed: AbhiBus Calendar Selected!");
        driver.quit();
    }
}