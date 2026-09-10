package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class45_PrimeNgDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://primeng.org/calendar");

        driver.findElement(By.xpath("(//p-calendar//input)[1]")).click();
        driver.findElement(By.xpath("//span[contains(@class,'p-ripple') and text()='12']")).click();

        System.out.println("Class 45 Completed: PrimeNG Calendar Handled!");
        driver.quit();
    }
}