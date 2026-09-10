package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class26_FormstoneDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/#dropdown-month-year");

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        driver.findElement(By.id("datepicker")).click();

        WebElement monthDropdown = driver.findElement(By.className("ui-datepicker-month"));
        monthDropdown.click();
        driver.findElement(By.xpath("//option[text()='Oct']")).click();
        driver.findElement(By.xpath("//a[text()='15']")).click();

        System.out.println("Class 26 Completed: JQuery Dropdown Calendar Handled!");
        driver.quit();
    }
}