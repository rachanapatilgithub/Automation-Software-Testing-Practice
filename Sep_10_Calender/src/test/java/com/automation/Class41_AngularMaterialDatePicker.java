package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class41_AngularMaterialDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://material.angular.io/components/datepicker/overview");

        WebElement toggleBtn = driver.findElement(By.xpath("//button[@aria-label='Open calendar']"));
        toggleBtn.click();
        driver.findElement(By.xpath("//button[contains(@class,'mat-calendar-body-cell')]//span[text()=' 15 ']")).click();

        System.out.println("Class 41 Completed: Angular Material DatePicker Handled!");
        driver.quit();
    }
}