package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class28_HyrtutorialsDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");

        driver.findElement(By.id("first_date_picker")).sendKeys("09/20/2026");

        driver.findElement(By.id("second_date_picker")).click();
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='18']")).click();

        System.out.println("Class 28 Completed: HYR Tutorials Multi-Calendar Handled!");
        driver.quit();
    }
}