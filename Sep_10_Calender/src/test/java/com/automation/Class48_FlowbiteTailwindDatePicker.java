package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class48_FlowbiteTailwindDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://flowbite.com/docs/components/datepicker/");

        driver.findElement(By.xpath("(//input[@datepicker])[1]")).click();
        driver.findElement(By.xpath("//span[contains(@class,'datepicker-cell') and text()='16']")).click();

        System.out.println("Class 48 Completed: Flowbite Tailwind Datepicker Handled!");
        driver.quit();
    }
}