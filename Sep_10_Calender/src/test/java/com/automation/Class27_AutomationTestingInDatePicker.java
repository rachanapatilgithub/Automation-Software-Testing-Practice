package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class27_AutomationTestingInDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.automationtesting.in/Datepicker.html");

        driver.findElement(By.id("datepicker1")).click();

        while (true) {
            String monthText = driver.findElement(By.className("ui-datepicker-title")).getText();
            if (monthText.contains("December")) {
                break;
            } else {
                driver.findElement(By.xpath("//span[text()='Next']")).click();
            }
        }

        driver.findElement(By.xpath("//a[text()='25']")).click();

        System.out.println("Class 27 Completed: Bootstrap Calendar Handled!");
        driver.quit();
    }
}